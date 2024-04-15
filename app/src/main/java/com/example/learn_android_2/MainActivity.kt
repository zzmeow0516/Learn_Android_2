package com.example.learn_android_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "mylog_MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //如果MainActivity在被销毁时的bundle不为空，则打印数据
        if (savedInstanceState != null) {
            val tempData1 = savedInstanceState.getString("tempData")
            Log.v(TAG, "tempData is $tempData1")
        }

        val buttonStartNormalActivity: Button = findViewById(R.id.startNormalActivity)
        buttonStartNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        val buttonStartDialogActivity: Button = findViewById(R.id.startDialogActivity)
        buttonStartDialogActivity.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "some words that we want to type"
        outState.putString("tempData", tempData)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }


    //activity1 -> activity2: activity1  onPause, onStop
    //activity2 back to activity1: activity1 onRestart, onStart, onResume
    //activity1 -> dialog activity3 : activity1 onPause(because activity1 have not been covered totally)
    //dialog activity 3 -> activity1: activity1 onResume
    //activity1 back to home : activity1 onPause, onStop, onDestroy
}