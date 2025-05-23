package com.tencent.luggage.wxa.tq;

import android.content.Context;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.IWebView;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface f {
    void clearAllWebViewCache(Context context, boolean z16);

    void clearClientCertPreferences(Runnable runnable);

    IWebView createWebView(WebView webView);

    String findAddress(String str);

    a getCookieManager();

    c getWebViewContextWrapper();

    d getWebViewCoreWrapper();

    e getWebViewDatabase(Context context);

    b getWebviewStorage();

    boolean hasInitedWebViewCore();

    boolean initWebviewCore(Context context, WebView.PreInitCallback preInitCallback);
}
