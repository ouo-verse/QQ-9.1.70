package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.c.e;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class d extends b {
    public d(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void m(String str) {
        k(str);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle g16 = e.g(str);
        if (g16 != null) {
            String string = g16.getString("code");
            String string2 = g16.getString("msg");
            if ("0".equals(string)) {
                j(string2);
            } else {
                k(string2);
            }
        } else {
            k("bundle is null!!!");
        }
        com.sina.weibo.sdk.web.a aVar = this.aF;
        if (aVar == null) {
            return true;
        }
        aVar.t();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void t() {
        l("cancel share!!!");
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final boolean v() {
        l("cancel share!!!");
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    @TargetApi(21)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (TextUtils.isEmpty(uri) || !uri.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle g16 = e.g(uri);
        if (g16 != null) {
            String string = g16.getString("code");
            String string2 = g16.getString("msg");
            if (TextUtils.isEmpty(string)) {
                l("code is null!!!");
            } else if ("0".equals(string)) {
                j(string2);
            } else {
                k(string2);
            }
        } else {
            k("bundle is null!!!");
        }
        com.sina.weibo.sdk.web.a aVar = this.aF;
        if (aVar == null) {
            return true;
        }
        aVar.t();
        return true;
    }
}
