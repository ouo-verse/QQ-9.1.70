package com.tencent.qimei.av;

import android.graphics.Bitmap;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* compiled from: P */
/* loaded from: classes22.dex */
public class n extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f343185a;

    public n(p pVar) {
        this.f343185a = pVar;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        try {
            p pVar = this.f343185a;
            pVar.getClass();
            WebView webView2 = pVar.f343187a;
            String str2 = a.f343151a;
            webView2.evaluateJavascript("javascript:new Fingerprint().getNative()", null);
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
    }
}
