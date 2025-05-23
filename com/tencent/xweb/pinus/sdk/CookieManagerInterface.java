package com.tencent.xweb.pinus.sdk;

import android.webkit.ValueCallback;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface CookieManagerInterface {
    boolean acceptCookie();

    boolean allowFileSchemeCookies();

    void flush();

    String getCookie(String str);

    boolean hasCookies();

    void removeAllCookie();

    void removeAllCookie(ValueCallback<Boolean> valueCallback);

    void removeExpiredCookie();

    void removeSessionCookie();

    void removeSessionCookie(ValueCallback<Boolean> valueCallback);

    void setAcceptCookie(boolean z16);

    void setAcceptFileSchemeCookies(boolean z16);

    void setCookie(String str, String str2);

    void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback);
}
