package com.tencent.qqlive.module.videoreport.inject.webview;

import android.support.annotation.RequiresApi;
import android.webkit.JsPromptResult;
import android.webkit.WebView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WebViewCompatHelper {
    public static void loadUrl(Object obj, String str) {
        if (obj instanceof WebView) {
            ((WebView) obj).loadUrl(str);
        } else if (obj instanceof com.tencent.smtt.sdk.WebView) {
            ((com.tencent.smtt.sdk.WebView) obj).loadUrl(str);
        }
    }

    @RequiresApi(api = 19)
    public static void onEvaluateJavascript(Object obj, String str) {
        if (obj instanceof WebView) {
            ((WebView) obj).evaluateJavascript(str, null);
        } else if (obj instanceof com.tencent.smtt.sdk.WebView) {
            ((com.tencent.smtt.sdk.WebView) obj).evaluateJavascript(str, null);
        }
    }

    public static void onJsConfirmResult(Object obj, String str) {
        if (obj instanceof JsPromptResult) {
            ((JsPromptResult) obj).confirm(str);
        } else if (obj instanceof com.tencent.smtt.export.external.interfaces.JsPromptResult) {
            ((com.tencent.smtt.export.external.interfaces.JsPromptResult) obj).confirm(str);
        }
    }
}
