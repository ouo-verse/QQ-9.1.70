package com.tencent.xweb.pinus;

import android.webkit.ValueCallback;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.a;
import com.tencent.xweb.WebAddress;
import com.tencent.xweb.WebView;
import com.tencent.xweb.pinus.sdk.CookieManager;
import java.net.URISyntaxException;

/* loaded from: classes27.dex */
public class PinusCookieManagerWrapper implements a {
    private static final String TAG = "PinusCookieManagerWrapper";
    private final CookieManager mCookieManager = CookieManager.getInstance();

    private static String fixupUrl(String str) throws URISyntaxException {
        return new WebAddress(str).toString();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean acceptCookie() {
        return this.mCookieManager.acceptCookie();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean acceptThirdPartyCookies(WebView webView) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void flush() {
        this.mCookieManager.flush();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public String getCookie(String str) {
        try {
            return this.mCookieManager.getCookie(fixupUrl(str));
        } catch (URISyntaxException e16) {
            x0.a(TAG, "getCookie, Unable to get cookies due to error parsing URL: " + str, e16);
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public boolean hasCookies() {
        return this.mCookieManager.hasCookies();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeAllCookie() {
        x0.d(TAG, "removeAllCookie");
        this.mCookieManager.removeAllCookie();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeAllCookies(@Nullable ValueCallback<Boolean> valueCallback) {
        this.mCookieManager.removeAllCookie(valueCallback);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeExpiredCookie() {
        this.mCookieManager.removeExpiredCookie();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeSessionCookie() {
        this.mCookieManager.removeSessionCookie();
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void removeSessionCookies(@Nullable ValueCallback<Boolean> valueCallback) {
        this.mCookieManager.removeSessionCookie(valueCallback);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setAcceptCookie(boolean z16) {
        x0.d(TAG, "setAcceptCookie:" + z16);
        this.mCookieManager.setAcceptCookie(z16);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setAcceptThirdPartyCookies(WebView webView, boolean z16) {
        x0.d(TAG, "setAcceptThirdPartyCookies:" + z16);
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setCookie(String str, String str2) {
        try {
            this.mCookieManager.setCookie(fixupUrl(str), str2);
        } catch (URISyntaxException e16) {
            x0.a(TAG, "setCookie, Not setting cookie due to error parsing URL: " + str, e16);
        }
    }

    @Override // com.tencent.luggage.wxa.tq.a
    public void setCookie(String str, String str2, @Nullable ValueCallback<Boolean> valueCallback) {
        try {
            this.mCookieManager.setCookie(fixupUrl(str), str2, valueCallback);
        } catch (URISyntaxException e16) {
            x0.a(TAG, "setCookie, Not setting cookie due to error parsing URL: " + str, e16);
        }
    }
}
