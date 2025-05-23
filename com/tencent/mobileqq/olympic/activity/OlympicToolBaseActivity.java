package com.tencent.mobileqq.olympic.activity;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OlympicToolBaseActivity extends AbsBaseWebViewActivity {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ScanBaseActivity";
    public AppInterface app;
    public QQAppInterface qqApp;
    public OlympicToolAppInterface toolApp;

    public OlympicToolBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Drawable getIconDrawable(String str, int i3) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = BaseAIOUtils.f(55.0f, getResources());
        obtain.mRequestWidth = BaseAIOUtils.f(55.0f, getResources());
        Drawable drawable = getResources().getDrawable(i3);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            return URLDrawable.getDrawable(str, obtain);
        } catch (Exception unused) {
            return obtain.mLoadingDrawable;
        }
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        updateAppRuntime();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, mqq.app.AppActivity
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (ScanTorchActivity.TAG.equals(getClass().getSimpleName())) {
            return "module_olympic";
        }
        return super.getModuleId();
    }

    public void launchOcr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onAccountChanged();
            updateAppRuntime();
        }
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void updateAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            this.qqApp = qQAppInterface;
            this.app = qQAppInterface;
        } else if (appRuntime instanceof OlympicToolAppInterface) {
            OlympicToolAppInterface olympicToolAppInterface = (OlympicToolAppInterface) appRuntime;
            this.toolApp = olympicToolAppInterface;
            this.app = olympicToolAppInterface;
        }
    }
}
