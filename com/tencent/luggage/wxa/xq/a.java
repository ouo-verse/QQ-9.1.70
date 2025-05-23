package com.tencent.luggage.wxa.xq;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.WebView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements com.tencent.luggage.wxa.tq.a {

    /* renamed from: a, reason: collision with root package name */
    public CookieManager f145358a;

    public a() {
        try {
            this.f145358a = CookieManager.getInstance();
        } catch (Exception e16) {
            String stackTraceString = Log.getStackTraceString(e16);
            x0.f("SysCookieManagerWrapper", "Create sys cookie manager failed." + stackTraceString);
            com.tencent.luggage.wxa.wq.f.a(4, stackTraceString, WebView.WebViewKind.WV_KIND_SYS.ordinal(), com.tencent.luggage.wxa.ar.g.b());
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean acceptCookie() {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return false;
        }
        return cookieManager.acceptCookie();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean acceptThirdPartyCookies(WebView webView) {
        if (this.f145358a == null || webView == null || webView.getWebViewUI() == null || !(webView.getWebViewUI() instanceof android.webkit.WebView)) {
            return false;
        }
        return this.f145358a.acceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewUI());
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void flush() {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.flush();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public String getCookie(String str) {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return "";
        }
        return cookieManager.getCookie(str);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean hasCookies() {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return false;
        }
        return cookieManager.hasCookies();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeAllCookie() {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.removeAllCookie();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeAllCookies(ValueCallback valueCallback) {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.removeAllCookies(valueCallback);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeExpiredCookie() {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.removeExpiredCookie();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeSessionCookie() {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.removeSessionCookie();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeSessionCookies(ValueCallback valueCallback) {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.removeSessionCookies(valueCallback);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setAcceptCookie(boolean z16) {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.setAcceptCookie(z16);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setAcceptThirdPartyCookies(WebView webView, boolean z16) {
        if (this.f145358a == null) {
            return;
        }
        if (webView != null && webView.getWebViewUI() != null && (webView.getWebViewUI() instanceof android.webkit.WebView)) {
            this.f145358a.setAcceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewUI(), z16);
        } else {
            x0.c("SysCookieManagerWrapper", "setAcceptThirdPartyCookies, webview kind not match");
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setCookie(String str, String str2) {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.setCookie(str, str2);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setCookie(String str, String str2, ValueCallback valueCallback) {
        CookieManager cookieManager = this.f145358a;
        if (cookieManager == null) {
            return;
        }
        cookieManager.setCookie(str, str2, valueCallback);
    }
}
