package com.rookery.asyncHttpClient;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes3.dex */
class AsyncHttpRequest implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final AbstractHttpClient f61209d;

    /* renamed from: e, reason: collision with root package name */
    private final HttpContext f61210e;

    /* renamed from: f, reason: collision with root package name */
    private final HttpUriRequest f61211f;

    /* renamed from: h, reason: collision with root package name */
    private int f61212h;

    private void e() throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            try {
                this.f61209d.execute(this.f61211f, this.f61210e);
                Thread.currentThread().isInterrupted();
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Translator", 2, "[makeRequest]IOException:" + e16);
                }
                if (!Thread.currentThread().isInterrupted()) {
                    throw e16;
                }
            }
        }
    }

    private void f() throws ConnectException {
        HttpRequestRetryHandler httpRequestRetryHandler = this.f61209d.getHttpRequestRetryHandler();
        IOException e16 = null;
        boolean z16 = true;
        while (z16) {
            try {
                e();
                return;
            } catch (IOException e17) {
                e16 = e17;
                if (QLog.isColorLevel()) {
                    QLog.e("Translator", 2, "[makeRequestWithRetries]IOException:" + e16);
                }
                int i3 = this.f61212h + 1;
                this.f61212h = i3;
                z16 = httpRequestRetryHandler.retryRequest(e16, i3, this.f61210e);
            } catch (NullPointerException e18) {
                if (QLog.isColorLevel()) {
                    QLog.e("Translator", 2, "[makeRequestWithRetries]NullPointerException:" + e18);
                }
                IOException iOException = new IOException("NPE in HttpClient" + e18.getMessage());
                int i16 = this.f61212h + 1;
                this.f61212h = i16;
                z16 = httpRequestRetryHandler.retryRequest(iOException, i16, this.f61210e);
                e16 = iOException;
            } catch (SocketException | SocketTimeoutException | UnknownHostException unused) {
                return;
            }
        }
        ConnectException connectException = new ConnectException();
        connectException.initCause(e16);
        if (QLog.isColorLevel()) {
            QLog.e("Translator", 2, "[makeRequestWithRetries] end function. Execption:" + connectException);
            throw connectException;
        }
        throw connectException;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            f();
        } catch (IOException unused) {
        }
    }
}
