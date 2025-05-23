package com.tencent.mobileqq.webview.swift.injector;

import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface o {
    String a(AppRuntime appRuntime);

    void b(boolean z16, String str, long j3);

    long c(Intent intent, long j3);

    boolean d(Intent intent, boolean z16);

    void e(WebViewProvider webViewProvider, String str, long j3, AppRuntime appRuntime, String str2);

    void f(String str, long j3);

    void g(Intent intent, String str);

    void h(TouchWebView touchWebView, int i3, String str, String str2);

    boolean i(Intent intent, boolean z16);

    long j(Intent intent, long j3);

    void k(String str, long j3, String str2, String str3);

    void l(TouchWebView touchWebView, String str, boolean z16, int i3, long j3);

    void m(boolean z16, String str);

    void onDetectedBlankScreen(String str, int i3);
}
