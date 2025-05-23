package com.tencent.xweb.pinus.sdk;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ar.f0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.pinus.PSCoreWrapper;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CookieManager implements CookieManagerInterface {
    private static final String TAG = "CookieManager";
    private static CookieManager sInstance;
    private static final Object sInstanceLock = new Object();
    private PSCoreWrapper coreWrapper;
    private Object inner;
    private CookieManagerInterface reflectInterface;

    CookieManager() {
        init();
    }

    public static CookieManager getInstance() {
        CookieManager cookieManager;
        synchronized (sInstanceLock) {
            if (sInstance == null) {
                sInstance = new CookieManager();
            }
            cookieManager = sInstance;
        }
        return cookieManager;
    }

    private void init() {
        PSCoreWrapper pSCoreWrapper = PSCoreWrapper.getInstance();
        this.coreWrapper = pSCoreWrapper;
        if (pSCoreWrapper == null) {
            return;
        }
        try {
            Object a16 = new f0(pSCoreWrapper.getBridgeClass(TAG), new Class[0]).a(new Object[0]);
            this.inner = a16;
            this.reflectInterface = new CookieManagerInterfaceImpl(a16);
        } catch (UnsupportedOperationException e16) {
            x0.a(TAG, "init error", e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public boolean acceptCookie() {
        return this.reflectInterface.acceptCookie();
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public boolean allowFileSchemeCookies() {
        return this.reflectInterface.allowFileSchemeCookies();
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void flush() {
        this.reflectInterface.flush();
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public String getCookie(String str) {
        return this.reflectInterface.getCookie(str);
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public boolean hasCookies() {
        return this.reflectInterface.hasCookies();
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeAllCookie() {
        this.reflectInterface.removeAllCookie();
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeExpiredCookie() {
        this.reflectInterface.removeExpiredCookie();
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeSessionCookie() {
        this.reflectInterface.removeSessionCookie();
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void setAcceptCookie(boolean z16) {
        this.reflectInterface.setAcceptCookie(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void setAcceptFileSchemeCookies(boolean z16) {
        this.reflectInterface.setAcceptFileSchemeCookies(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        this.reflectInterface.setCookie(str, str2, valueCallback);
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeAllCookie(ValueCallback<Boolean> valueCallback) {
        this.reflectInterface.removeAllCookie(valueCallback);
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void removeSessionCookie(ValueCallback<Boolean> valueCallback) {
        this.reflectInterface.removeSessionCookie(valueCallback);
    }

    @Override // com.tencent.xweb.pinus.sdk.CookieManagerInterface
    public void setCookie(String str, String str2) {
        this.reflectInterface.setCookie(str, str2);
    }
}
