package com.tencent.mobileqq.webview.swift.injector;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface a {
    void a(QBaseActivity qBaseActivity);

    WebResourceResponse b(String str);

    boolean c(String str);

    void d(int i3, int i16, Intent intent, TouchWebView touchWebView);

    void e(QBaseActivity qBaseActivity);

    void onCreate(Activity activity);
}
