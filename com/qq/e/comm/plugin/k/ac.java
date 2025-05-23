package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ac {
    public static boolean a(Context context) {
        if (com.qq.e.comm.plugin.j.c.a("networkUtilUseAppContext", 1, 1)) {
            context = GDTADManager.getInstance().getAppContext();
        }
        if (context == null) {
            GDTLogger.e("NetworkUtilisNetworkConnected context is null");
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
                return false;
            }
        } catch (Throwable th5) {
            GDTLogger.e("isNetworkConnected", th5);
        }
        return false;
    }

    public static boolean b() {
        return a("preloadResNetwork");
    }

    public static String a() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && NetworkMonitor.getType(activeNetworkInfo) == 0) {
                return "" + NetworkMonitor.getNetworkType((TelephonyManager) appContext.getSystemService("phone"));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static HttpURLConnection a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection == null) {
            return null;
        }
        int integer = GDTADManager.getInstance().getSM().getInteger("httpRedirectMax", 3);
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        int i3 = 0;
        while (true) {
            if (i3 >= integer) {
                break;
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 302 || responseCode == 301 || responseCode == 303) {
                String headerField = httpURLConnection.getHeaderField("location");
                httpURLConnection.disconnect();
                httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
                httpURLConnection.setConnectTimeout(connectTimeout);
                httpURLConnection.setReadTimeout(readTimeout);
                i3++;
            } else if (responseCode == 200) {
                String contentType = httpURLConnection.getContentType();
                if (!TextUtils.isEmpty(contentType) && contentType.contains("image")) {
                    GDTLogger.d("HttpURLConnection url is image");
                    if (contentType.contains("image/webp")) {
                        GDTLogger.d("HttpURLConnection url is webp");
                        StatTracer.trackEvent(1320051, 1, (com.qq.e.comm.plugin.stat.b) null);
                    } else {
                        GDTLogger.d("HttpURLConnection url is not webp");
                        StatTracer.trackEvent(1320051, 2, (com.qq.e.comm.plugin.stat.b) null);
                    }
                }
            }
        }
        if (i3 != integer) {
            return httpURLConnection;
        }
        StatTracer.trackEvent(100322, integer, (com.qq.e.comm.plugin.stat.b) null);
        throw new IOException("HttpURLConnection exceed max redirect " + integer + " " + httpURLConnection.getURL());
    }

    public static boolean a(String str) {
        if ((com.qq.e.comm.plugin.j.c.a(str, NetworkType.WIFI.getPermValue()) & GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue()) > 0) {
            return false;
        }
        GDTLogger.i("\u5f53\u524d\u8bbe\u5907\u7684\u7f51\u7edc\u7c7b\u578b\u4e0d\u7b26\u5408\u9884\u52a0\u8f7d\u5e7f\u544a\u8d44\u6e90\u7684\u6761\u4ef6\uff0c\u8bf7\u5c1d\u8bd5WIFI\u73af\u5883\u3002\u5982\u4ecd\u6709\u95ee\u9898\u8bf7\u8054\u7cfb\u5ba2\u670d");
        return true;
    }
}
