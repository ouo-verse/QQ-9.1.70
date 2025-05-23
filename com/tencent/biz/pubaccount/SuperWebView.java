package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class SuperWebView extends QmX5Webview {
    static final String JAVASCRIPT_SCHEME = "javascript:";
    private static byte debugVerboseSwitch = -1;
    protected Intent mIntent;
    private boolean mIsForceLoadUrl;
    private ArrayList<String> mJsUrlsWaitingForLoad;
    private boolean mReadyForLoadJs;

    public SuperWebView(Context context) {
        super(context);
        this.mIntent = null;
        this.mIsForceLoadUrl = false;
        this.mReadyForLoadJs = false;
        this.mJsUrlsWaitingForLoad = new ArrayList<>();
        removeBuiltInJSInterface();
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void destroy() {
        super.destroy();
        if (MobileQQ.sProcessId != 7) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.k
                @Override // java.lang.Runnable
                public final void run() {
                    SwiftBrowserStatistics.d0();
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadData(String str, String str2, String str3) {
        super.loadData(str, str2, str3);
        readyForLoadJs();
    }

    @Override // com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        readyForLoadJs();
    }

    @Override // com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str) {
        com.tencent.mobileqq.webview.swift.utils.c.e(this.mIntent, str);
        if (this.mReadyForLoadJs) {
            if (str != null && str.startsWith("javascript:")) {
                super.evaluateJavascript(str.substring(11), null);
                return;
            }
            String url = getUrl();
            if (url != null && url.equals(str) && !this.mIsForceLoadUrl) {
                superReload();
                return;
            } else {
                superLoadUrl(str);
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("javascript:")) {
            this.mJsUrlsWaitingForLoad.add(str);
            if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                return;
            }
            QLog.d("SuperWebView", 1, "load javascript before load url.");
            return;
        }
        superLoadUrl(str);
        if (str.startsWith("http://") || str.startsWith("https://")) {
            readyForLoadJs();
        }
    }

    protected void printStackIfVerbose(String str) {
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            if (debugVerboseSwitch == -1) {
                debugVerboseSwitch = ((Boolean) t.j().b("debug_enable_verbose_log", Boolean.FALSE)).booleanValue() ? (byte) 1 : (byte) 0;
            }
            if (debugVerboseSwitch == 1) {
                QLog.d("SuperWebView", 1, str + " " + Log.getStackTraceString(new Throwable()));
            }
        }
    }

    public void readyForLoadJs() {
        this.mReadyForLoadJs = true;
        if (!this.mJsUrlsWaitingForLoad.isEmpty()) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.SuperWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = SuperWebView.this.mJsUrlsWaitingForLoad.iterator();
                    while (it.hasNext()) {
                        SuperWebView.super.evaluateJavascript(((String) it.next()).substring(11), null);
                    }
                    SuperWebView.this.mJsUrlsWaitingForLoad.clear();
                }
            }, 50L);
        }
    }

    public void removeBuiltInJSInterface() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
    }

    public void resetForReuse() {
        this.mReadyForLoadJs = false;
        this.mJsUrlsWaitingForLoad.clear();
    }

    public void setForceLoadUrl(boolean z16) {
        this.mIsForceLoadUrl = z16;
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void superLoadUrl(String str) {
        printStackIfVerbose("loadUrl() " + str);
        super.loadUrl(str);
    }

    public void superReload() {
        printStackIfVerbose("reload()");
        super.reload();
    }

    public void superLoadUrl(String str, Map<String, String> map) {
        printStackIfVerbose("loadUrl() " + str);
        super.loadUrl(str, map);
    }

    public SuperWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIntent = null;
        this.mIsForceLoadUrl = false;
        this.mReadyForLoadJs = false;
        this.mJsUrlsWaitingForLoad = new ArrayList<>();
        removeBuiltInJSInterface();
    }

    public SuperWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIntent = null;
        this.mIsForceLoadUrl = false;
        this.mReadyForLoadJs = false;
        this.mJsUrlsWaitingForLoad = new ArrayList<>();
        removeBuiltInJSInterface();
    }

    @Override // com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str, Map<String, String> map) {
        superLoadUrl(str, map);
        readyForLoadJs();
    }
}
