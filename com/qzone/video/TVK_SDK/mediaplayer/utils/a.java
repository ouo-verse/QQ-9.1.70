package com.qzone.video.TVK_SDK.mediaplayer.utils;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {
    private static int b(int i3) {
        if (i3 > 0) {
            return (-10000) - i3;
        }
        return i3 - 11000;
    }

    public static int a(Throwable th5) {
        if (th5 != null) {
            if (th5 instanceof ConnectTimeoutException) {
                return -10003;
            }
            if (th5 instanceof SocketTimeoutException) {
                return -10004;
            }
            if (!(th5 instanceof UnknownHostException)) {
                if (th5 instanceof FileNotFoundException) {
                    return -10009;
                }
                if (th5 instanceof ConnectException) {
                    if (!th5.toString().contains("Network is unreachable")) {
                        return -10002;
                    }
                } else if (th5 instanceof HttpResponseException) {
                    try {
                        return b(((HttpResponseException) th5).getStatusCode());
                    } catch (Throwable unused) {
                    }
                } else {
                    if (th5 instanceof CircularRedirectException) {
                        return -10013;
                    }
                    if (th5 instanceof ClientProtocolException) {
                        return -10012;
                    }
                    if (th5 instanceof JSONException) {
                        return -11102;
                    }
                    if (th5 instanceof NoHttpResponseException) {
                        return -10014;
                    }
                }
            }
            return -10001;
        }
        return -11100;
    }
}
