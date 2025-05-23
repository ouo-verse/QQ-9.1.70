package com.tencent.mobileqq.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.y;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface r extends y {
    String getCurrentUrl();

    CustomWebView getWebView();

    boolean isActivityResume();

    void showActionSheet();
}
