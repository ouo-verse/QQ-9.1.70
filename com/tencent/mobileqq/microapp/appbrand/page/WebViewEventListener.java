package com.tencent.mobileqq.microapp.appbrand.page;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface WebViewEventListener {
    void onWebViewEvent(String str, String str2, String str3, String str4, int i3);

    String onWebViewNativeRequest(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3);
}
