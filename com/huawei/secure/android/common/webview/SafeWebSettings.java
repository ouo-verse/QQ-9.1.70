package com.huawei.secure.android.common.webview;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SafeWebSettings {
    public static void disableContentAccess(WebSettings webSettings) {
        webSettings.setAllowContentAccess(false);
    }

    public static void disableFileCrossAccess(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
    }

    public static void disableGeolocation(WebSettings webSettings) {
        webSettings.setGeolocationEnabled(false);
    }

    public static void disableMixedContentMode(WebSettings webSettings) {
        webSettings.setMixedContentMode(1);
    }

    public static void initWebviewAndSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        disableFileCrossAccess(settings);
        removeUnSafeJavascriptImpl(webView);
        disablePasswordStorage(settings);
        disableGeolocation(settings);
        disableMixedContentMode(settings);
        disableContentAccess(settings);
    }

    public static void removeUnSafeJavascriptImpl(WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    public static void disablePasswordStorage(WebSettings webSettings) {
    }
}
