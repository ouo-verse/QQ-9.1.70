package com.tencent.qqmini.sdk.ui;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ui.MiniActivity;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InternalMiniActivity extends MiniActivity {
    @Override // com.tencent.qqmini.sdk.launcher.ui.MiniActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.MiniActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.MiniActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.MiniActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }
}
