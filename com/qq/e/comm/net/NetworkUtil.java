package com.qq.e.comm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NetworkUtil {
    public static HttpURLConnection followRedirect(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection == null) {
            return null;
        }
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        int i3 = 0;
        while (i3 < 3) {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 302 && responseCode != 301 && responseCode != 303) {
                break;
            }
            String headerField = httpURLConnection.getHeaderField("location");
            httpURLConnection.disconnect();
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            httpURLConnection.setConnectTimeout(connectTimeout);
            httpURLConnection.setReadTimeout(readTimeout);
            i3++;
        }
        if (i3 != 3) {
            return httpURLConnection;
        }
        throw new IOException("HttpURLConnection exceed max redirect 3 " + httpURLConnection.getURL());
    }

    public static String getNativeCellNetworkType() {
        NetworkInfo networkInfo;
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo != null && NetworkMonitor.getType(networkInfo) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService("phone");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(NetworkMonitor.getNetworkType(telephonyManager));
                return sb5.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th5) {
                GDTLogger.e("isNetworkConnected", th5);
            }
        }
        return false;
    }
}
