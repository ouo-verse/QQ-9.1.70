package com.tencent.tmassistantbase.network;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.r;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes26.dex */
public abstract class PostHttpRequest {
    public static String REQUEST_SERVER_URL = "https://masdkv6.3g.qq.com";
    private static final String TAG = "PostHttpRequest";

    /* loaded from: classes26.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f380427a;

        a(byte[] bArr) {
            this.f380427a = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(PostHttpRequest.REQUEST_SERVER_URL).openConnection();
                SSLContext a16 = c.a();
                if (a16 != null) {
                    httpsURLConnection.setSSLSocketFactory(a16.getSocketFactory());
                    httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                }
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.addRequestProperty("User-Agent", "AssistantDownloader");
                httpsURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
                httpsURLConnection.setConnectTimeout(30000);
                httpsURLConnection.setReadTimeout(30000);
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(this.f380427a);
                outputStream.flush();
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode == 200) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    if (inputStream != null) {
                        byte[] a17 = b.a(inputStream);
                        if (a17 != null && a17.length > 4) {
                            PostHttpRequest.this.onFinished(this.f380427a, a17, 0);
                            return;
                        }
                        r.a(PostHttpRequest.TAG, ">sendRequest data:" + a17);
                        return;
                    }
                    PostHttpRequest.this.onFinished(this.f380427a, null, 604);
                    r.a(PostHttpRequest.TAG, ">sendRequest entity == null");
                    return;
                }
                r.a(PostHttpRequest.TAG, ">sendRequest StatusCode not ok:" + responseCode);
                PostHttpRequest.this.onFinished(this.f380427a, null, responseCode);
            } catch (ConnectException e16) {
                r.a(PostHttpRequest.TAG, "connect failed ConnectException:", e16);
                PostHttpRequest.this.onFinished(this.f380427a, null, 1);
            } catch (SocketTimeoutException e17) {
                r.a(PostHttpRequest.TAG, "connect failed SocketTimeoutException:", e17);
                PostHttpRequest.this.onFinished(this.f380427a, null, 602);
            } catch (ConnectTimeoutException e18) {
                r.a(PostHttpRequest.TAG, "connect failed ConnectTimeoutException:", e18);
                PostHttpRequest.this.onFinished(this.f380427a, null, 601);
            } catch (Throwable th5) {
                r.a(PostHttpRequest.TAG, "connect failed Throwable:", th5);
                PostHttpRequest.this.onFinished(this.f380427a, null, 604);
            }
        }
    }

    protected abstract void onFinished(byte[] bArr, byte[] bArr2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sendRequest(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            new BaseThread(new a(bArr), e.b.f380465c.name()).start();
            return true;
        } catch (OutOfMemoryError unused) {
            r.a(TAG, "<sendRequest>low memory!");
            return false;
        }
    }
}
