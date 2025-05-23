package com.tencent.av.utils;

import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes3.dex */
public class u {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        String f77181a;

        /* renamed from: b, reason: collision with root package name */
        String f77182b;

        /* renamed from: c, reason: collision with root package name */
        String f77183c;

        public a(String str, String str2, String str3) {
            this.f77181a = str;
            this.f77182b = str2;
            this.f77183c = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            String str = null;
            try {
                str = u.b(this.f77181a, this.f77182b, this.f77183c);
                if (QLog.isColorLevel()) {
                    QLog.i("SimpleHttpPostTask", 2, "SimpleHttpPostTask rsp = " + str);
                }
            } catch (ClientProtocolException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            return str;
        }
    }

    public static HttpClient a(boolean z16) {
        ClientConnectionManager singleClientConnManager;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 5000);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, "randchat");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), WebSocketImpl.DEFAULT_WSS_PORT));
        } catch (Exception unused) {
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

    public static String b(String str, String str2, String str3) throws ClientProtocolException, IOException {
        HttpClient httpClient;
        try {
            httpClient = a(false);
        } catch (Throwable th5) {
            th = th5;
            httpClient = null;
        }
        try {
            HttpPost httpPost = new HttpPost(str);
            httpPost.setEntity(new StringEntity(str2, "utf8"));
            httpPost.setHeader("Content-Type", "application/text");
            if (str3 != null) {
                httpPost.setHeader("Cookie", str3);
            }
            String entityUtils = EntityUtils.toString(httpClient.execute(httpPost).getEntity());
            httpClient.getConnectionManager().shutdown();
            return entityUtils;
        } catch (Throwable th6) {
            th = th6;
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
            throw th;
        }
    }
}
