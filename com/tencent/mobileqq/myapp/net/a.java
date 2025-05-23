package com.tencent.mobileqq.myapp.net;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static ThreadSafeClientConnManager f252471a;

    /* renamed from: b, reason: collision with root package name */
    private static final Uri f252472b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73320);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f252471a = null;
            f252472b = Uri.parse("content://telephony/carriers/preferapn");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6, types: [org.apache.http.client.methods.HttpPost, org.apache.http.client.methods.HttpEntityEnclosingRequestBase] */
    public static HttpEntity a(String str, byte[] bArr, String str2, BasicHeader[] basicHeaderArr) throws HttpResponseException, IOException {
        HttpGet httpGet;
        String defaultHost;
        int defaultPort;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        if (str2.equals("POST")) {
            ?? httpPost = new HttpPost(str);
            httpPost.setEntity(new ByteArrayEntity(bArr));
            httpGet = httpPost;
        } else if (bArr != null) {
            httpGet = new HttpGet(str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + new String(bArr));
        } else {
            httpGet = new HttpGet(str);
        }
        if (basicHeaderArr != null) {
            for (BasicHeader basicHeader : basicHeaderArr) {
                httpGet.addHeader(basicHeader);
            }
        }
        if (f252471a == null) {
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), WebSocketImpl.DEFAULT_WSS_PORT));
            f252471a = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(f252471a, basicHttpParams);
        if (b() != null) {
            Proxy.getDefaultHost();
            Proxy.getDefaultPort();
            BaseApplication context = BaseApplication.getContext();
            if (context == null) {
                defaultHost = Proxy.getDefaultHost();
                defaultPort = Proxy.getDefaultPort();
            } else {
                String host = Proxy.getHost(context);
                int port = Proxy.getPort(context);
                if (host != null && host.trim().length() != 0 && port > 0) {
                    defaultPort = port;
                    defaultHost = host;
                } else {
                    defaultHost = Proxy.getDefaultHost();
                    defaultPort = Proxy.getDefaultPort();
                }
            }
            if (defaultHost == null || defaultHost.trim().length() == 0 || defaultPort <= 0) {
                b c16 = c();
                String str3 = c16.f252473a;
                defaultPort = c16.f252474b;
                defaultHost = str3;
            }
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(defaultHost, defaultPort));
        }
        HttpResponse execute = defaultHttpClient.execute(httpGet);
        int statusCode = execute.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            return execute.getEntity();
        }
        throw new HttpResponseException(statusCode);
    }

    public static InetSocketAddress b() {
        String defaultHost;
        int defaultPort;
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            defaultHost = Proxy.getDefaultHost();
            defaultPort = Proxy.getDefaultPort();
        } else {
            if (!AppNetConnInfo.isMobileConn()) {
                return null;
            }
            String host = Proxy.getHost(context);
            int port = Proxy.getPort(context);
            if (host == null || host.trim().length() == 0 || port <= 0) {
                defaultHost = Proxy.getDefaultHost();
                defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.trim().length() == 0 || defaultPort <= 0) {
                    b c16 = c();
                    host = c16.f252473a;
                    port = c16.f252474b;
                }
            }
            String str = host;
            defaultPort = port;
            defaultHost = str;
        }
        if (defaultHost == null || defaultHost.trim().length() <= 0) {
            return null;
        }
        return new InetSocketAddress(defaultHost, defaultPort);
    }

    @SuppressLint({"Range"})
    private static b c() {
        BaseApplication context = BaseApplication.getContext();
        b bVar = new b();
        try {
            try {
                Cursor query = ContactsMonitor.query(context.getContentResolver(), f252472b, null, null, null, null);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("proxy"));
                if (string != null) {
                    string.toLowerCase();
                }
                String string2 = query.getString(query.getColumnIndex("port"));
                String string3 = query.getString(query.getColumnIndex("apn"));
                if (string3 != null) {
                    string3.toLowerCase();
                }
                query.close();
                if (string3 != null && string3.startsWith("ctwap")) {
                    if (string != null && string.length() > 0 && Integer.valueOf(string2).intValue() < 0) {
                        bVar.f252473a = string;
                        bVar.f252474b = Integer.valueOf(string2).intValue();
                    } else {
                        bVar.f252473a = "10.0.0.200";
                        bVar.f252474b = 80;
                    }
                } else if (string3 != null && string3.startsWith("cmwap")) {
                    if (string != null && string.length() > 0 && Integer.valueOf(string2).intValue() < 0) {
                        bVar.f252473a = string;
                        bVar.f252474b = Integer.valueOf(string2).intValue();
                    } else {
                        bVar.f252473a = "10.0.0.172";
                        bVar.f252474b = 80;
                    }
                } else if (string3 != null && string3.startsWith("uniwap")) {
                    if (string != null && string.length() > 0 && Integer.valueOf(string2).intValue() < 0) {
                        bVar.f252473a = string;
                        bVar.f252474b = Integer.valueOf(string2).intValue();
                    } else {
                        bVar.f252473a = "10.0.0.172";
                        bVar.f252474b = 80;
                    }
                }
                return bVar;
            } catch (Exception e16) {
                e16.printStackTrace();
                return bVar;
            }
        } catch (Throwable unused) {
            return bVar;
        }
    }

    public static byte[] d(String str, byte[] bArr, String str2, BasicHeader[] basicHeaderArr) throws HttpResponseException, IOException {
        HttpEntity a16 = a(str, bArr, str2, basicHeaderArr);
        byte[] byteArray = EntityUtils.toByteArray(a16);
        a16.consumeContent();
        return byteArray;
    }
}
