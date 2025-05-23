package com.tencent.qqlive.module.videoreport.inject.webview.webclient;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportWebViewClient extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
        JsInjector.getInstance().onPageStarted(webView);
    }
}
