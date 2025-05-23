package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.wx.api.IECWXAuthApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper;
import com.tencent.mobileqq.qwallet.jump.IWXQrcodePayApi;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneShareApi;
import mqq.app.AndroidOreoUtils;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WXEntryActivity extends Activity {
    static IPatchRedirector $redirector_;

    public WXEntryActivity() {
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
        requestWindowFeature(1);
        AndroidOreoUtils androidOreoUtils = new AndroidOreoUtils(this);
        if (Build.VERSION.SDK_INT == 26 && getApplicationInfo().targetSdkVersion >= 27 && androidOreoUtils.isTranslucentOrFloating()) {
            QLog.i("WXEntryActivity", 1, "onCreate fixOrientation when Oreo, result = " + androidOreoUtils.fixOrientation());
        }
        try {
            super.onCreate(bundle);
        } catch (Exception e16) {
            QLog.e("WXEntryActivity", 1, "onCreate : ", e16);
        }
        QLog.d("WXEntryActivity", 1, "onCreate : ");
        Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE");
        try {
            intent.putExtras(getIntent());
        } catch (Exception e17) {
            QLog.e("WXEntryActivity", 1, "get intent exception:", e17);
        }
        sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        try {
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).handleWXEntryActivityIntent(this, getIntent());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        try {
            ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).handleWXEntryIntent(getIntent());
        } catch (Throwable th6) {
            QLog.e("WXEntryActivity", 2, "IWXAuthApi.handleWXEntryIntent error = " + th6);
        }
        try {
            ((IWxShareHelperFromReadInjoy) QRoute.api(IWxShareHelperFromReadInjoy.class)).handleWXEntryActivityIntent(this, getIntent());
        } catch (Throwable th7) {
            QLog.e("WXEntryActivity", 2, "WxShareHelperFromReadInjoy.getInstance().handleWXEntryActivityIntent error = " + th7);
        }
        try {
            ((IWXMiniProgramHelper) QRoute.api(IWXMiniProgramHelper.class)).handleWXEntryActivityIntent(this, getIntent());
        } catch (Throwable th8) {
            QLog.e("WXEntryActivity", 2, "WXMiniProgramHelperImpl.getInstance().handleWXEntryActivityIntent error = " + th8);
        }
        try {
            ((IWXQrcodePayApi) QRoute.api(IWXQrcodePayApi.class)).handleWXEntryIntent(getIntent());
        } catch (Throwable th9) {
            QLog.e("WXEntryActivity", 2, "WXMiniProgramHelperImpl.getInstance().handleWXEntryActivityIntent error = " + th9);
        }
        try {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).handleWXEntryActivityIntent(this, getIntent());
        } catch (Throwable th10) {
            QLog.e("WXEntryActivity", 2, "WXShareHelperFromQQMiniApp.getInstance().handleWXEntryActivityIntent error = " + th10);
        }
        try {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).handleWXEntryActivityIntent(this, getIntent());
        } catch (Throwable th11) {
            QLog.e("WXEntryActivity", 2, "IWxMiniManager.handleWXEntryActivityIntent error = " + th11);
        }
        try {
            ((IECWXAuthApi) QRoute.api(IECWXAuthApi.class)).handleWXEntryIntent(getIntent());
        } catch (Throwable th12) {
            QLog.e("WXEntryActivity", 2, "IECWXAuthApi.handleWXEntryIntent error = " + th12);
        }
        try {
            finish();
        } catch (Exception e18) {
            QLog.e("WXEntryActivity", 1, "finish : ", e18);
        }
    }
}
