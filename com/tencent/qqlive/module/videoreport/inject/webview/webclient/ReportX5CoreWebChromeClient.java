package com.tencent.qqlive.module.videoreport.inject.webview.webclient;

import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportX5CoreWebChromeClient extends WebChromeClient {
    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onProgressChanged(WebView webView, int i3) {
        JsInjector.getInstance().onProgressChanged(webView, i3);
        super.onProgressChanged(webView, i3);
        JsInjector.getInstance().onProgressChanged(webView, i3);
    }
}
