package com.tencent.luggage.wxa.tq;

import android.webkit.ValueCallback;
import com.tencent.xweb.WebView;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {
    boolean acceptCookie();

    boolean acceptThirdPartyCookies(WebView webView);

    void flush();

    String getCookie(String str);

    boolean hasCookies();

    void removeAllCookie();

    void removeAllCookies(ValueCallback valueCallback);

    void removeExpiredCookie();

    void removeSessionCookie();

    void removeSessionCookies(ValueCallback valueCallback);

    void setAcceptCookie(boolean z16);

    void setAcceptThirdPartyCookies(WebView webView, boolean z16);

    void setCookie(String str, String str2);

    void setCookie(String str, String str2, ValueCallback valueCallback);
}
