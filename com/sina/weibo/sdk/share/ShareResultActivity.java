package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ShareResultActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        try {
            intent = getIntent();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getIntExtra("start_flag", -1) == 0) {
            finish();
            return;
        }
        String action = intent.getAction();
        if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY".equals(action)) {
            intent.setClass(this, ShareTransActivity.class);
        } else if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY".equals(action)) {
            intent.setClass(this, ShareStoryActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
