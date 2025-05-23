package com.tencent.qmethod.pandoraex.monitor;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NetHttpMonitor {
    static final String TAG = "NetHttpMonitor";

    @VisibleForTesting
    public static NetHttpMonitor sInstance = new NetHttpMonitor();

    @VisibleForTesting
    NetHttpMonitor() {
    }

    public static NetHttpMonitor getInstance() {
        return sInstance;
    }

    public static URLConnection openConnection(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(url.getHost(), 3)) {
                return getInstance().wrap(openConnection);
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return openConnection;
    }

    URLConnection wrap(URLConnection uRLConnection) {
        String url = uRLConnection.getURL().toString();
        if (uRLConnection instanceof HttpsURLConnection) {
            return new com.tencent.qmethod.pandoraex.core.ext.netcap.i(url, (HttpsURLConnection) uRLConnection);
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return new com.tencent.qmethod.pandoraex.core.ext.netcap.h(url, (HttpURLConnection) uRLConnection);
        }
        return uRLConnection;
    }
}
