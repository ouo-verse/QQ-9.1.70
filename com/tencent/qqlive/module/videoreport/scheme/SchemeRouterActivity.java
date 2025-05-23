package com.tencent.qqlive.module.videoreport.scheme;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SchemeRouterActivity extends Activity {
    private static final String TAG = "Visual.SchemaRouterActivity";

    private void handleIntent(Intent intent) {
        if (!VideoReportInner.getInstance().isInit()) {
            Log.w(TAG, "handleIntent(), please initialize the sdk first\uff01");
            Toast.makeText(this, "\u8bf7\u5148\u521d\u59cb\u5316\u5927\u540cSDK", 0).show();
            finish();
            return;
        }
        SchemeRouterHelper.handleSchemeUrl(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        if (isTaskRoot()) {
            SchemeRouterHelper.startLaunchActivity(this);
        }
        super.finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(TAG, "onCreate");
        handleIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }
}
