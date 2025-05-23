package com.tencent.mobileqq.intervideo.sixgodcontainer.proxyactivitys;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.view.MotionEvent;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes15.dex */
public class NowPluginDefaultProxyActivity extends Activity {
    static IPatchRedirector $redirector_;

    public NowPluginDefaultProxyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        QLog.i("NowPluginManager", 2, "\u5f02\u5e38\u5206\u652f\uff1a\u81ea\u52a8\u91cd\u542fNow\u63d2\u4ef6Activity\u7684\u573a\u666f\uff0cfinish\u4e0d\u505a\u4efb\u4f55\u5904\u7406 ");
        finish();
        SystemMethodProxy.killProcess(Process.myPid());
    }
}
