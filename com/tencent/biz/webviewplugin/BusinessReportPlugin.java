package com.tencent.biz.webviewplugin;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class BusinessReportPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    public boolean f97295d = false;

    /* renamed from: e, reason: collision with root package name */
    private Handler f97296e = new Handler(Looper.getMainLooper());

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "JD_REPORT";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (j3 == 8) {
            q(str);
            return null;
        }
        return null;
    }

    public void p(String str) {
        this.f97295d = BusinessReporter.b(str);
    }

    public void q(final String str) {
        if (this.f97295d) {
            try {
                this.f97296e.post(new Runnable() { // from class: com.tencent.biz.webviewplugin.BusinessReportPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final String str2 = str;
                        final String url = BusinessReportPlugin.this.mRuntime.e().getUrl();
                        BusinessReportPlugin.this.postPluginAsyncTask(new Runnable() { // from class: com.tencent.biz.webviewplugin.BusinessReportPlugin.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BusinessReporter.e(BusinessReportPlugin.this.mRuntime.b(), str2, url);
                            }
                        });
                    }
                });
            } catch (Exception e16) {
                QLog.e("BusinessReporter", 1, "Report Error:" + e16);
            }
        }
    }
}
