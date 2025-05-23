package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tenpay.sdk.download.HttpOp;
import mqq.app.MobileQQ;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.java_websocket.WebSocketImpl;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HttpChannel {
    static IPatchRedirector $redirector_;

    private static void a(HttpClient httpClient) {
        if (httpClient != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private static HttpPost b(String str) {
        HttpPost httpPost = new HttpPost(str);
        httpPost.addHeader("Accept", "*/*");
        httpPost.addHeader("User-Agent", "QdiskAndroid1.1.0");
        httpPost.addHeader("Accept-Language", "zh-CN");
        httpPost.addHeader("Referer", "http://udisk.qq.com/android");
        httpPost.addHeader(HttpHeader.RSP.CHARSET, "UTF-8");
        httpPost.addHeader("Pragma", "no-cache");
        httpPost.addHeader(FileUploadBase.CONTENT_TYPE, "application/json");
        return httpPost;
    }

    public static void c(HttpClient httpClient, int i3) {
        if (!NetworkUtils.isWifiAvailable(MobileQQ.sMobileQQ)) {
            int i16 = i3 * 5000;
            httpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(HttpOp.HTTP_READTIMEOUT + i16));
            httpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(i16 + 60000));
        } else {
            int i17 = i3 * 5000;
            httpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(i17 + 30000));
            httpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(i17 + HttpOp.HTTP_READTIMEOUT));
        }
    }

    public static DefaultHttpClient d() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        basicHttpParams.setParameter("http.connection.timeout", 30000);
        basicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(HttpOp.HTTP_READTIMEOUT));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), WebSocketImpl.DEFAULT_WSS_PORT));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    public static int e(String str, JSONObject jSONObject) {
        DefaultHttpClient d16 = d();
        c(d16, 1);
        HttpPost b16 = b(str);
        try {
            StringEntity stringEntity = new StringEntity(jSONObject.toString());
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            b16.setEntity(stringEntity);
            int statusCode = d16.execute(b16).getStatusLine().getStatusCode();
            a(d16);
            return statusCode;
        } catch (Exception unused) {
            a(d16);
            return -1;
        } catch (Throwable th5) {
            a(d16);
            throw th5;
        }
    }

    public static void f(String str, JSONObject jSONObject) {
        ThreadManagerV2.post(new Runnable(str, jSONObject) { // from class: com.tencent.mobileqq.weiyun.channel.HttpChannel.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f315141d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ JSONObject f315142e;

            {
                this.f315141d = str;
                this.f315142e = jSONObject;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) jSONObject);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    HttpChannel.e(this.f315141d, this.f315142e);
                }
            }
        }, 5, null, true);
    }
}
