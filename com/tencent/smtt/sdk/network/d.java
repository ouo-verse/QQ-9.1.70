package com.tencent.smtt.sdk.network;

import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: P */
/* loaded from: classes23.dex */
class d extends HttpsURLConnection {
    public d(URL url) throws IOException {
        super(url);
        String str = "Intercept by default, url:" + url.toString();
        try {
            String url2 = url.toString();
            if (InterceptConfig.getPrintImplicitInterceptInfoForTest() && !g.a().d(url2)) {
                f.b(Log.getStackTraceString(new Exception(str)));
            }
        } catch (Throwable unused) {
        }
        throw new e(str);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public String getCipherSuite() {
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getLocalCertificates() {
        return null;
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return null;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
    }
}
