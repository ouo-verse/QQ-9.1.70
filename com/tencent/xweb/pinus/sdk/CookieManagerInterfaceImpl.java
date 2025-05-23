package com.tencent.xweb.pinus.sdk;

import android.annotation.SuppressLint;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.ar.g0;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CookieManagerInterfaceImpl implements CookieManagerInterface {
    private static final String TAG = "CookieManagerInterfaceImpl";
    private g0 acceptCookieMethod;
    private g0 allowFileSchemeCookiesMethod;
    private g0 flushMethod;
    private g0 getCookieStringMethod;
    private g0 hasCookiesMethod;
    private final Object inner;
    private g0 removeAllCookieMethod;
    private g0 removeAllCookieValueCallbackBooleanMethod;
    private g0 removeExpiredCookieMethod;
    private g0 removeSessionCookieMethod;
    private g0 removeSessionCookieValueCallbackBooleanMethod;
    private g0 setAcceptCookiebooleanMethod;
    private g0 setAcceptFileSchemeCookiesbooleanMethod;
    private g0 setCookieStringStringMethod;
    private g0 setCookieStringStringValueCallbackBooleanMethod;

    public CookieManagerInterfaceImpl(Object obj) {
        this.inner = obj;
    }

    private synchronized g0 getAcceptCookieMethod() {
        g0 g0Var;
        g0Var = this.acceptCookieMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "acceptCookie", new Class[0]);
            this.acceptCookieMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getAllowFileSchemeCookiesMethod() {
        g0 g0Var;
        g0Var = this.allowFileSchemeCookiesMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "allowFileSchemeCookies", new Class[0]);
            this.allowFileSchemeCookiesMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getFlushMethod() {
        g0 g0Var;
        g0Var = this.flushMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, HippyQQPagView.FunctionName.FLUSH, new Class[0]);
            this.flushMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetCookieStringMethod() {
        g0 g0Var;
        g0Var = this.getCookieStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getCookie", String.class);
            this.getCookieStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getHasCookiesMethod() {
        g0 g0Var;
        g0Var = this.hasCookiesMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "hasCookies", new Class[0]);
            this.hasCookiesMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRemoveAllCookieMethod() {
        g0 g0Var;
        g0Var = this.removeAllCookieMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "removeAllCookie", new Class[0]);
            this.removeAllCookieMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRemoveAllCookieValueCallbackBooleanMethod() {
        g0 g0Var;
        g0Var = this.removeAllCookieValueCallbackBooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "removeAllCookie", ValueCallback.class);
            this.removeAllCookieValueCallbackBooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRemoveExpiredCookieMethod() {
        g0 g0Var;
        g0Var = this.removeExpiredCookieMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "removeExpiredCookie", new Class[0]);
            this.removeExpiredCookieMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRemoveSessionCookieMethod() {
        g0 g0Var;
        g0Var = this.removeSessionCookieMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "removeSessionCookie", new Class[0]);
            this.removeSessionCookieMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRemoveSessionCookieValueCallbackBooleanMethod() {
        g0 g0Var;
        g0Var = this.removeSessionCookieValueCallbackBooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "removeSessionCookie", ValueCallback.class);
            this.removeSessionCookieValueCallbackBooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAcceptCookiebooleanMethod() {
        g0 g0Var;
        g0Var = this.setAcceptCookiebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAcceptCookie", Boolean.TYPE);
            this.setAcceptCookiebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAcceptFileSchemeCookiesbooleanMethod() {
        g0 g0Var;
        g0Var = this.setAcceptFileSchemeCookiesbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAcceptFileSchemeCookies", Boolean.TYPE);
            this.setAcceptFileSchemeCookiesbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetCookieStringStringMethod() {
        g0 g0Var;
        g0Var = this.setCookieStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setCookie", String.class, String.class);
            this.setCookieStringStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetCookieStringStringValueCallbackBooleanMethod() {
        g0 g0Var;
        g0Var = this.setCookieStringStringValueCallbackBooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setCookie", String.class, String.class, ValueCallback.class);
            this.setCookieStringStringValueCallbackBooleanMethod = g0Var;
        }
        return g0Var;
    }

    @SuppressLint({"LongLogTag"})
    public static void handleRuntimeError(Exception exc) {
        Log.e(TAG, "This API is incompatible with the xweb pinus library");
        exc.printStackTrace();
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public boolean acceptCookie() {
        try {
            return ((Boolean) getAcceptCookieMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public boolean allowFileSchemeCookies() {
        try {
            return ((Boolean) getAllowFileSchemeCookiesMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void flush() {
        try {
            getFlushMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public String getCookie(String str) {
        try {
            return (String) getGetCookieStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public boolean hasCookies() {
        try {
            return ((Boolean) getHasCookiesMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeAllCookie() {
        try {
            getRemoveAllCookieMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeExpiredCookie() {
        try {
            getRemoveExpiredCookieMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeSessionCookie() {
        try {
            getRemoveSessionCookieMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void setAcceptCookie(boolean z16) {
        try {
            getSetAcceptCookiebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void setAcceptFileSchemeCookies(boolean z16) {
        try {
            getSetAcceptFileSchemeCookiesbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        try {
            getSetCookieStringStringValueCallbackBooleanMethod().a(str, str2, valueCallback);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeAllCookie(ValueCallback<Boolean> valueCallback) {
        try {
            getRemoveAllCookieValueCallbackBooleanMethod().a(valueCallback);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeSessionCookie(ValueCallback<Boolean> valueCallback) {
        try {
            getRemoveSessionCookieValueCallbackBooleanMethod().a(valueCallback);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void setCookie(String str, String str2) {
        try {
            getSetCookieStringStringMethod().a(str, str2);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }
}
