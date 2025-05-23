package com.vivo.push.sdk;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.vivo.push.sdk.service.LinkProxyActivity;

/* loaded from: classes15.dex */
public class LinkProxyClientActivity extends LinkProxyActivity {
    @Override // com.vivo.push.sdk.service.LinkProxyActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.vivo.push.sdk.service.LinkProxyActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
