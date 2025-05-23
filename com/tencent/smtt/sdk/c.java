package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.SystemWebChromeClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class c extends SystemWebChromeClient {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WebView webView, WebChromeClient webChromeClient) {
        super(webView, webChromeClient);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onHideCustomView() {
        this.f369032a.onHideCustomView();
    }

    @Override // com.tencent.smtt.sdk.SystemWebChromeClient, android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i3) {
        JsInjector.getInstance().onProgressChanged(webView, i3);
        super.onProgressChanged(webView, i3);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f369032a.onShowCustomView(view, new SystemWebChromeClient.b(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i3, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f369032a.onShowCustomView(view, i3, new SystemWebChromeClient.b(customViewCallback));
    }
}
