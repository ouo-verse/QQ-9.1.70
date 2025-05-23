package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.wx.api.IECWXAuthApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AndroidOreoUtils;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WXEntryActivityCompat extends Activity {
    static IPatchRedirector $redirector_;

    public WXEntryActivityCompat() {
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

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        }
        return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
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
        AndroidOreoUtils androidOreoUtils = new AndroidOreoUtils(this);
        if (Build.VERSION.SDK_INT == 26 && getApplicationInfo().targetSdkVersion >= 27 && androidOreoUtils.isTranslucentOrFloating()) {
            QLog.i("WXEntryActivityCompat", 1, "onCreate fixOrientation when Oreo, result = " + androidOreoUtils.fixOrientation());
        }
        try {
            requestWindowFeature(1);
            super.onCreate(bundle);
        } catch (Exception e16) {
            QLog.e("WXEntryActivityCompat", 1, "onCreate : ", e16);
        }
        QLog.d("WXEntryActivityCompat", 1, "onCreate : ");
        Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE");
        try {
            intent.putExtras(getIntent());
        } catch (Exception e17) {
            QLog.e("WXEntryActivityCompat", 1, "get intent exception:", e17);
        }
        sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        try {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).handleWXEntryActivityIntent(this, getIntent());
        } catch (Throwable th5) {
            QLog.e("WXEntryActivity", 2, "IWxMiniManager.handleWXEntryActivityIntent error = " + th5);
        }
        try {
            ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).handleWXEntryIntent(getIntent());
        } catch (Throwable th6) {
            QLog.e("WXEntryActivityCompat", 1, "IWXAuthApi.handleWXEntryIntent error = " + th6);
        }
        try {
            ((IECWXAuthApi) QRoute.api(IECWXAuthApi.class)).handleWXEntryIntent(getIntent());
        } catch (Throwable th7) {
            QLog.e("WXEntryActivityCompat", 1, "IWXAuthApi.handleWXEntryIntent error = " + th7);
        }
        try {
            finish();
        } catch (Exception e18) {
            QLog.e("WXEntryActivityCompat", 1, "finish : ", e18);
        }
    }
}
