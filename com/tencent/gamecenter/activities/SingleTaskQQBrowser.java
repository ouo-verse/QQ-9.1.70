package com.tencent.gamecenter.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SingleTaskQQBrowser extends QQBrowserActivity {
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        getIntent().putExtra("from_single_task", true);
        QLog.d("SingleTaskQQBrowser", 1, "WebViewSwitchAio singleTask doOnCreate");
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if (r4.equals(r3) != false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doOnNewIntent(Intent intent) {
        QLog.d("SingleTaskQQBrowser", 1, "WebViewSwitchAio singleTask doOnNewIntent");
        boolean z16 = false;
        boolean booleanExtra = intent.getBooleanExtra("force_no_reload", false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("url");
            WebView hostWebView = getHostWebView();
            if (hostWebView != null) {
                String url = hostWebView.getUrl();
                if (!TextUtils.isEmpty(url)) {
                }
            }
            if (z16) {
                intent.putExtra("from_single_task", true);
                super.doOnNewIntent(intent);
                return;
            }
            return;
        }
        z16 = booleanExtra;
        if (z16) {
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
