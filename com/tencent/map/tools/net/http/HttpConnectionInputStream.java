package com.tencent.map.tools.net.http;

import com.tencent.mapsdk.internal.ku;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HttpConnectionInputStream extends InputStream {
    private final HttpURLConnection mConnection;
    private final InputStream mProxyInputStream;

    public HttpConnectionInputStream(HttpURLConnection httpURLConnection) throws IOException {
        this.mConnection = httpURLConnection;
        this.mProxyInputStream = httpURLConnection.getInputStream();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        ku.a((Closeable) this.mProxyInputStream);
        this.mConnection.disconnect();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.mProxyInputStream.read();
    }
}
