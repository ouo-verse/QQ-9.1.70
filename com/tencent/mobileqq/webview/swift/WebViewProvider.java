package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.annotation.Keep;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import mqq.app.AppRuntime;

/* loaded from: classes20.dex */
public interface WebViewProvider extends com.tencent.mobileqq.webviewplugin.r, b.f, b.e, com.tencent.mobileqq.webviewplugin.e, af, com.tencent.mobileqq.webviewplugin.s {
    void doOnBackEvent();

    AppRuntime getAppRuntime();

    WebBrowserViewContainerKt getContentView();

    @Keep
    Context getContext();

    Intent getIntent();

    Resources getResource();

    String getUin();

    String getUrlFromIntent();

    boolean isDestroyed();

    boolean isNightMode();

    void setCurUrl(String str);

    void setWebView(TouchWebView touchWebView);
}
