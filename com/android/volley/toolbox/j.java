package com.android.volley.toolbox;

import android.net.http.Headers;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.c;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
final class j {

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f31428a;

        /* renamed from: b, reason: collision with root package name */
        private final VolleyError f31429b;

        b(String str, VolleyError volleyError) {
            this.f31428a = str;
            this.f31429b = volleyError;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Request<?> request, b bVar) throws VolleyError {
        com.android.volley.j retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(bVar.f31429b);
            request.addMarker(String.format("%s-retry [timeout=%s]", bVar.f31428a, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e16) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", bVar.f31428a, Integer.valueOf(timeoutMs)));
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.android.volley.g b(Request<?> request, long j3, List<com.android.volley.e> list) {
        c.a cacheEntry = request.getCacheEntry();
        if (cacheEntry == null) {
            return new com.android.volley.g(304, (byte[]) null, true, j3, list);
        }
        return new com.android.volley.g(304, cacheEntry.f31317a, true, j3, e.a(list, cacheEntry));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(InputStream inputStream, int i3, c cVar) throws IOException {
        byte[] bArr;
        k kVar = new k(cVar, i3);
        try {
            bArr = cVar.a(1024);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    kVar.write(bArr, 0, read);
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            com.android.volley.k.e("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    cVar.b(bArr);
                    kVar.close();
                    throw th;
                }
            }
            byte[] byteArray = kVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                com.android.volley.k.e("Error occurred when closing InputStream", new Object[0]);
            }
            cVar.b(bArr);
            kVar.close();
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            bArr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(long j3, Request<?> request, byte[] bArr, int i3) {
        Object obj;
        if (com.android.volley.k.f31342b || j3 > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j3);
            if (bArr != null) {
                obj = Integer.valueOf(bArr.length);
            } else {
                obj = "null";
            }
            objArr[2] = obj;
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            com.android.volley.k.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b e(Request<?> request, IOException iOException, long j3, @Nullable f fVar, @Nullable byte[] bArr) throws VolleyError {
        if (iOException instanceof SocketTimeoutException) {
            return new b(com.tencent.mobileqq.msf.core.d.f247918u, new TimeoutError());
        }
        if (!(iOException instanceof MalformedURLException)) {
            if (fVar != null) {
                int d16 = fVar.d();
                com.android.volley.k.c("Unexpected response code %d for %s", Integer.valueOf(d16), request.getUrl());
                if (bArr != null) {
                    com.android.volley.g gVar = new com.android.volley.g(d16, bArr, false, SystemClock.elapsedRealtime() - j3, fVar.c());
                    if (d16 != 401 && d16 != 403) {
                        if (d16 >= 400 && d16 <= 499) {
                            throw new ClientError(gVar);
                        }
                        if (d16 >= 500 && d16 <= 599 && request.shouldRetryServerErrors()) {
                            return new b("server", new ServerError(gVar));
                        }
                        throw new ServerError(gVar);
                    }
                    return new b(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, new AuthFailureError(gVar));
                }
                return new b("network", new NetworkError());
            }
            if (request.shouldRetryConnectionErrors()) {
                return new b(Headers.CONN_DIRECTIVE, new NoConnectionError());
            }
            throw new NoConnectionError(iOException);
        }
        throw new RuntimeException("Bad URL " + request.getUrl(), iOException);
    }
}
