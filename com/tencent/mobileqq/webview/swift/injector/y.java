package com.tencent.mobileqq.webview.swift.injector;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface y {
    boolean A(b.C8976b c8976b, View view);

    boolean B(WebViewProvider webViewProvider, int i3, Intent intent);

    void C(WebViewProvider webViewProvider);

    void a(WebViewProvider webViewProvider, String str, GeolocationPermissionsCallback geolocationPermissionsCallback);

    boolean b(WebViewProvider webViewProvider);

    void c(WebViewProvider webViewProvider, Bundle bundle);

    void d(WebViewProvider webViewProvider, Bundle bundle);

    void e(WebViewProvider webViewProvider);

    void f(WebViewProvider webViewProvider, Bundle bundle);

    void g(WebViewProvider webViewProvider);

    void h(WebViewProvider webViewProvider, Bundle bundle, TouchWebView touchWebView);

    boolean i(WebViewProvider webViewProvider, WebView webView, SslError sslError);

    boolean j(b.C8976b c8976b);

    void k(WebViewProvider webViewProvider);

    void l(WebViewProvider webViewProvider, Bundle bundle);

    void m(WebViewProvider webViewProvider, WebView webView, String str, Bitmap bitmap);

    void n(WebViewProvider webViewProvider, WebView webView, String str);

    void o(WebViewProvider webViewProvider, WebView webView, String str, Bitmap bitmap);

    void p(WebViewProvider webViewProvider, Bundle bundle);

    void q(WebViewProvider webViewProvider, WebView webView, String str);

    boolean r(WebViewProvider webViewProvider, WebView webView, String str);

    void s(WebViewProvider webViewProvider);

    boolean t(WebViewProvider webViewProvider, Intent intent);

    void u(View view, WebViewProvider webViewProvider);

    void v(WebViewProvider webViewProvider, View view);

    void w(WebViewProvider webViewProvider, Bundle bundle);

    void x(WebViewProvider webViewProvider, WebView webView, int i3, String str, String str2);

    boolean y(WebViewProvider webViewProvider, WebView webView, String str);

    boolean z(WebViewProvider webViewProvider, int i3, int i16, Intent intent);
}
