package com.tencent.rfix.loader.utils;

import java.net.HttpURLConnection;

/* compiled from: P */
/* loaded from: classes25.dex */
public class CloseUtil {
    public static void disconnectQuietly(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
        }
    }
}
