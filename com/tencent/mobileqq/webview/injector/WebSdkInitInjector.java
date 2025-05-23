package com.tencent.mobileqq.webview.injector;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.swift.injector.w;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WebSdkInitInjector implements w {
    @Override // com.tencent.mobileqq.webview.swift.injector.w
    public void onInitFinish() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.injector.WebSdkInitInjector.1
            @Override // java.lang.Runnable
            public void run() {
                BaseApplication context = BaseApplication.getContext();
                int tbsSDKVersion = WebView.getTbsSDKVersion(context);
                int tbsVersionForCrash = QbSdk.getTbsVersionForCrash(context);
                CrashReport.putUserData(context, "TbsSdkVersion", String.valueOf(tbsSDKVersion));
                CrashReport.putUserData(context, "X5CoreVersion", String.valueOf(tbsVersionForCrash));
                QLog.d("IWebSdkInit", 1, "onInitFinish initCrashUserData:" + tbsSDKVersion + ":" + tbsVersionForCrash);
                t.j().d("tbs_core_version", Integer.valueOf(tbsVersionForCrash));
            }
        }, 64, null, true);
    }
}
