package com.tencent.mtt.hippy.views.webview;

import android.webkit.JavascriptInterface;

/* compiled from: P */
/* loaded from: classes20.dex */
class HippyWebViewBridge {
    private final HippyWebView hippyView;

    public HippyWebViewBridge(HippyWebView hippyWebView) {
        this.hippyView = hippyWebView;
    }

    @JavascriptInterface
    public void postMessage(String str) {
        HippyWebView hippyWebView = this.hippyView;
        if (hippyWebView != null) {
            hippyWebView.postMessage(str);
        }
    }
}
