package com.tencent.xweb;

import android.webkit.ValueCallback;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CookieManager implements com.tencent.luggage.wxa.tq.a {

    /* renamed from: b, reason: collision with root package name */
    public static CookieManager f384893b;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.tq.a f384894a;

    public static synchronized CookieManager getInstance() {
        CookieManager cookieManager;
        synchronized (CookieManager.class) {
            if (f384893b == null) {
                f384893b = new CookieManager();
            }
            cookieManager = f384893b;
        }
        return cookieManager;
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean acceptCookie() {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            return aVar.acceptCookie();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean acceptThirdPartyCookies(WebView webView) {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            return aVar.acceptThirdPartyCookies(webView);
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void flush() {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.flush();
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public String getCookie(String str) {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            return aVar.getCookie(str);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean hasCookies() {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            return aVar.hasCookies();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.tq.a
    @Deprecated
    public void removeAllCookie() {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.removeAllCookie();
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeAllCookies(@Nullable ValueCallback<Boolean> valueCallback) {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.removeAllCookies(valueCallback);
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    @Deprecated
    public void removeExpiredCookie() {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.removeExpiredCookie();
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    @Deprecated
    public void removeSessionCookie() {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.removeSessionCookie();
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeSessionCookies(@Nullable ValueCallback<Boolean> valueCallback) {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.removeSessionCookies(valueCallback);
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public synchronized void setAcceptCookie(boolean z16) {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.setAcceptCookie(z16);
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setAcceptThirdPartyCookies(WebView webView, boolean z16) {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.setAcceptThirdPartyCookies(webView, z16);
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setCookie(String str, String str2) {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.setCookie(str, str2);
        }
    }

    public void setCookieManagerWrapper(com.tencent.luggage.wxa.tq.a aVar) {
        this.f384894a = aVar;
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setCookie(String str, String str2, @Nullable ValueCallback<Boolean> valueCallback) {
        com.tencent.luggage.wxa.tq.a aVar = this.f384894a;
        if (aVar != null) {
            aVar.setCookie(str, str2, valueCallback);
        }
    }
}
