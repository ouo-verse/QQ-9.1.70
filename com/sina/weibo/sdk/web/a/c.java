package com.sina.weibo.sdk.web.a;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.sina.weibo.sdk.web.WebActivity;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class c extends b {
    public c(WebActivity webActivity, com.sina.weibo.sdk.web.b.b bVar) {
        super(webActivity, null, bVar);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
    }
}
