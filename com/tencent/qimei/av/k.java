package com.tencent.qimei.av;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f343180a;

    public k(m mVar) {
        this.f343180a = mVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        try {
            m mVar = this.f343180a;
            mVar.getClass();
            String str2 = a.f343151a;
            webView.evaluateJavascript("javascript:new Fingerprint().getNative()", new j(mVar));
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
    }
}
