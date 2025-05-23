package com.tencent.qqlive.module.videoreport.inject.webview.webclient;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportWebChromeClient extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i3) {
        JsInjector.getInstance().onProgressChanged(webView, i3);
        super.onProgressChanged(webView, i3);
        JsInjector.getInstance().onProgressChanged(webView, i3);
    }
}
