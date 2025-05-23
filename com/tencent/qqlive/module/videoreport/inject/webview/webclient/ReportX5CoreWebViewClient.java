package com.tencent.qqlive.module.videoreport.inject.webview.webclient;

import android.graphics.Bitmap;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportX5CoreWebViewClient extends WebViewClient {
    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
        JsInjector.getInstance().onPageStarted(webView);
    }
}
