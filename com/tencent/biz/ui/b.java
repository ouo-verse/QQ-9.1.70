package com.tencent.biz.ui;

import android.graphics.Bitmap;
import com.tencent.biz.common.util.k;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends WebViewClient {

    /* renamed from: b, reason: collision with root package name */
    protected WebViewPluginEngine f97016b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f97017c = true;

    public b(WebViewPluginEngine webViewPluginEngine) {
        this.f97016b = webViewPluginEngine;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(CustomWebView.TAG_WEBVIEW_CHECK, 2, "CustomWebView loadUrl url:" + str);
        }
        super.onLoadResource(webView, str);
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        WebViewPluginEngine webViewPluginEngine = this.f97016b;
        if (webViewPluginEngine != null) {
            webViewPluginEngine.s(str, 8589934594L, null);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
        WebViewPluginEngine webViewPluginEngine = this.f97016b;
        if (webViewPluginEngine != null) {
            webViewPluginEngine.s(str, 8589934593L, null);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(CustomWebView.TAG_WEBVIEW_CHECK, 2, "CustomWebViewClient onReceivedError errorCode:" + i3 + ", description:" + str + ", failingUrl:" + str2);
        }
        WebViewPluginEngine webViewPluginEngine = this.f97016b;
        if (webViewPluginEngine != null) {
            webViewPluginEngine.q(str2, 8589934595L, i3);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebViewPluginEngine webViewPluginEngine = this.f97016b;
        if (webViewPluginEngine != null) {
            try {
                return (WebResourceResponse) webViewPluginEngine.r(str, 8L);
            } catch (Exception e16) {
                QLog.e(CustomWebView.TAG_WEBVIEW_CHECK, 1, "shouldInterceptRequest error:" + e16.toString());
            }
        }
        return null;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        this.f97017c = webResourceRequest.isForMainFrame();
        boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
        this.f97017c = true;
        return shouldOverrideUrlLoading;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewPluginEngine webViewPluginEngine = this.f97016b;
        if (webViewPluginEngine != null && webViewPluginEngine.S(str, this.f97017c)) {
            return true;
        }
        if (str != null && ((str.startsWith("http") || str.startsWith("data:")) && !str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
            CustomWebView.addContextLog(k.f(str, new String[0]));
        }
        return false;
    }
}
