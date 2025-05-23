package com.tencent.luggage.wxa.tq;

import android.util.Log;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.s;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.pinus.PinusWebFactory;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {
    public static d a(WebView.WebViewKind webViewKind) {
        f b16 = b(webViewKind);
        if (b16 == null) {
            x0.c("XWebViewProviderWrapper", "Get core failed, provider is null.");
            return null;
        }
        return b16.getWebViewCoreWrapper();
    }

    public static f b(WebView.WebViewKind webViewKind) {
        if (webViewKind == WebView.WebViewKind.WV_KIND_SYS) {
            return com.tencent.luggage.wxa.xq.c.a();
        }
        if (webViewKind == WebView.WebViewKind.WV_KIND_PINUS) {
            return PinusWebFactory.getInstance();
        }
        return null;
    }

    public static d a() {
        return a(WebView.getCurrentModuleWebCoreType());
    }

    public static Object a(int i3, Object[] objArr) {
        try {
            d a16 = a();
            if (a16 == null) {
                x0.c("XWebViewProviderWrapper", "Invoke current runtime failed, core is null.");
                return null;
            }
            return a16.invokeRuntimeChannel(i3, objArr);
        } catch (Throwable th5) {
            th5.printStackTrace();
            x0.c("XWebViewProviderWrapper", "Invoke current runtime failed. [cmd:" + i3 + "][params:" + Arrays.toString(objArr) + "]");
            return null;
        }
    }

    public static void b(int i3, Object[] objArr) {
        try {
            d a16 = a();
            if (a16 == null) {
                x0.c("XWebViewProviderWrapper", "Invoke current runtime native failed, core is null.");
            } else {
                a16.invokeNativeChannel(i3, objArr);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            x0.c("XWebViewProviderWrapper", "Invoke current runtime native failed. [cmd:" + i3 + "][params:" + Arrays.toString(objArr) + "]");
        }
    }

    public static IWebView a(WebView.WebViewKind webViewKind, WebView webView) {
        f b16;
        x0.a("XWebViewProviderWrapper", "getWebView, try to create webview type = " + webViewKind);
        s c16 = s.c("CREATE_WEBVIEW", webViewKind);
        c16.g();
        IWebView iWebView = null;
        try {
            b16 = b(webViewKind);
        } catch (Throwable th5) {
            n0.a(webViewKind);
            String stackTraceString = Log.getStackTraceString(th5);
            s.a(stackTraceString);
            x0.a("XWebViewProviderWrapper", "getWebView, create webview error:" + stackTraceString);
            com.tencent.luggage.wxa.wq.f.a(2, stackTraceString, webViewKind.ordinal());
        }
        if (b16 == null) {
            x0.a("XWebViewProviderWrapper", "getWebView, provider not exist");
            return null;
        }
        iWebView = b16.createWebView(webView);
        if (iWebView != null) {
            x0.a("XWebViewProviderWrapper", "getWebView, create webview success");
            c16.f();
        } else {
            x0.a("XWebViewProviderWrapper", "getWebView, create webview failed");
        }
        return iWebView;
    }
}
