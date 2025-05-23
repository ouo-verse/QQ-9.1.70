package com.dataline.util;

import android.net.Proxy;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f32385a = Uri.parse("content://telephony/carriers/preferapn");

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f32386a;

        /* renamed from: b, reason: collision with root package name */
        public final int f32387b;

        a(String str, int i3) {
            this.f32386a = str;
            this.f32387b = i3;
        }
    }

    public static HttpClient a(boolean z16, boolean z17, int i3, int i16) {
        ClientConnectionManager singleClientConnManager;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i3);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i16);
        if (z17) {
            return new DefaultHttpClient(basicHttpParams);
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), WebSocketImpl.DEFAULT_WSS_PORT));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (z16) {
            singleClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        } else {
            singleClientConnManager = new SingleClientConnManager(basicHttpParams, schemeRegistry);
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(singleClientConnManager, basicHttpParams);
        defaultHttpClient.setRoutePlanner(new DefaultHttpRoutePlanner(singleClientConnManager.getSchemeRegistry()));
        return defaultHttpClient;
    }

    public static HttpClient b(boolean z16, int i3, int i16, int i17) {
        ClientConnectionManager singleClientConnManager;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i16);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i17);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i3));
        if (z16) {
            singleClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        } else {
            singleClientConnManager = new SingleClientConnManager(basicHttpParams, schemeRegistry);
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(singleClientConnManager, basicHttpParams);
        defaultHttpClient.setRoutePlanner(new DefaultHttpRoutePlanner(singleClientConnManager.getSchemeRegistry()));
        return defaultHttpClient;
    }

    public static String c() {
        if (AppNetConnInfo.getRecentNetworkInfo() == null) {
            return null;
        }
        if (AppNetConnInfo.isWifiConn()) {
            return "wifi";
        }
        if (!AppNetConnInfo.isMobileConn() || AppNetConnInfo.getCurrentAPN() == null) {
            return null;
        }
        return AppNetConnInfo.getCurrentAPN().toLowerCase();
    }

    public static a d() {
        if (g()) {
            String c16 = c();
            if (c16 != null) {
                if (c16.equalsIgnoreCase("cmwap")) {
                    return new a("10.0.0.172", 80);
                }
                if (c16.equalsIgnoreCase("3gwap")) {
                    return new a("10.0.0.172", 80);
                }
                if (c16.equalsIgnoreCase("uniwap")) {
                    return new a("10.0.0.172", 80);
                }
                if (c16.equalsIgnoreCase("ctwap")) {
                    return new a("10.0.0.200", 80);
                }
                return null;
            }
            return null;
        }
        String e16 = e();
        int f16 = f();
        if (!TextUtils.isEmpty(e16) && !"10.0.0.172".equals(e16) && !"10.0.0.200".equals(e16) && f16 >= 0) {
            return new a(e16, f16);
        }
        return null;
    }

    private static String e() {
        if (e.a() < 11) {
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    private static int f() {
        if (e.a() < 11) {
            return Proxy.getDefaultPort();
        }
        String property = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return -1;
    }

    public static boolean g() {
        return AppNetConnInfo.isMobileConn();
    }
}
