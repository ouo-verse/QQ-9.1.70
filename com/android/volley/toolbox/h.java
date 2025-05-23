package com.android.volley.toolbox;

import androidx.annotation.VisibleForTesting;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes.dex */
public class h extends com.android.volley.toolbox.a {

    /* renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f31420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a extends FilterInputStream {

        /* renamed from: d, reason: collision with root package name */
        private final HttpURLConnection f31421d;

        a(HttpURLConnection httpURLConnection) {
            super(h.j(httpURLConnection));
            this.f31421d = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f31421d.disconnect();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
    }

    public h() {
        this(null);
    }

    private void c(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(h(request, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private void d(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            c(httpURLConnection, request, body);
        }
    }

    @VisibleForTesting
    static List<com.android.volley.e> e(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.android.volley.e(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private static boolean i(int i3, int i16) {
        if (i3 != 4 && ((100 > i16 || i16 >= 200) && i16 != 204 && i16 != 304)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream j(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private HttpURLConnection k(URL url, Request<?> request) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection f16 = f(url);
        int timeoutMs = request.getTimeoutMs();
        f16.setConnectTimeout(timeoutMs);
        f16.setReadTimeout(timeoutMs);
        f16.setUseCaches(false);
        f16.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f31420a) != null) {
            ((HttpsURLConnection) f16).setSSLSocketFactory(sSLSocketFactory);
        }
        return f16;
    }

    @Override // com.android.volley.toolbox.a
    public f a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(request.getHeaders());
        HttpURLConnection k3 = k(new URL(url), request);
        try {
            for (String str : hashMap.keySet()) {
                k3.setRequestProperty(str, (String) hashMap.get(str));
            }
            l(k3, request);
            int responseCode = k3.getResponseCode();
            if (responseCode != -1) {
                if (!i(request.getMethod(), responseCode)) {
                    f fVar = new f(responseCode, e(k3.getHeaderFields()));
                    k3.disconnect();
                    return fVar;
                }
                return new f(responseCode, e(k3.getHeaderFields()), k3.getContentLength(), g(request, k3));
            }
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } catch (Throwable th5) {
            if (0 == 0) {
                k3.disconnect();
            }
            throw th5;
        }
    }

    protected HttpURLConnection f(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    protected InputStream g(Request<?> request, HttpURLConnection httpURLConnection) {
        return new a(httpURLConnection);
    }

    protected OutputStream h(Request<?> request, HttpURLConnection httpURLConnection, int i3) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    void l(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    c(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                d(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                d(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod(HttpOptions.METHOD_NAME);
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                d(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public h(b bVar) {
        this(bVar, null);
    }

    public h(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f31420a = sSLSocketFactory;
    }
}
