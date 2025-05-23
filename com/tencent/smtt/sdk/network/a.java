package com.tencent.smtt.sdk.network;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* compiled from: P */
/* loaded from: classes23.dex */
class a extends URLStreamHandler {

    /* renamed from: a, reason: collision with root package name */
    private b f369455a;

    public a(b bVar) {
        this.f369455a = bVar;
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url) throws IOException {
        return openConnection(url, null);
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if (this.f369455a.shouldIntercept(url)) {
            return new d(url);
        }
        return this.f369455a.openConnection(url, proxy);
    }
}
