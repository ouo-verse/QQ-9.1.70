package com.tencent.map.tools.net.http;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

/* loaded from: classes9.dex */
public class HttpProxy {
    private final boolean mIsForward;
    private final Proxy mProxy;
    private final String mProxyUrl;

    public HttpProxy(Proxy proxy, String str, boolean z16) {
        this.mProxy = proxy;
        this.mProxyUrl = str;
        this.mIsForward = z16;
    }

    public static Proxy getForwardProxy(HttpProxy httpProxy) {
        if (httpProxy != null && httpProxy.isForward()) {
            return httpProxy.getProxy();
        }
        return Proxy.NO_PROXY;
    }

    public static URL getProxyURL(HttpProxy httpProxy) throws MalformedURLException {
        if (httpProxy != null && !httpProxy.isForward()) {
            return new URL(httpProxy.getProxyUrl());
        }
        return null;
    }

    public Proxy getProxy() {
        return this.mProxy;
    }

    public String getProxyUrl() {
        return this.mProxyUrl;
    }

    public boolean isForward() {
        return this.mIsForward;
    }

    public String toString() {
        return "HttpProxy{mProxy=" + this.mProxy + ", mProxyUrl='" + this.mProxyUrl + "', mIsForward=" + this.mIsForward + '}';
    }
}
