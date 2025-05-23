package com.qzone.video.TVK_SDK.mediaplayer.http;

import android.util.Log;
import ap.d;
import ap.e;
import com.qzone.proxy.feedcomponent.model.TencentVideoModule;
import com.qzone.video.TVK_SDK.mediaplayer.vodcgi.f;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AsyncHttpRequest implements Runnable {
    private boolean C;
    private boolean D;
    private boolean E;
    private f F;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractHttpClient f59865d;

    /* renamed from: e, reason: collision with root package name */
    private final HttpContext f59866e;

    /* renamed from: f, reason: collision with root package name */
    private final HttpUriRequest f59867f;

    /* renamed from: h, reason: collision with root package name */
    private final e f59868h;

    /* renamed from: i, reason: collision with root package name */
    private final d f59869i;

    /* renamed from: m, reason: collision with root package name */
    private int f59870m;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, e eVar) {
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = null;
        this.f59865d = abstractHttpClient;
        this.f59866e = httpContext;
        this.f59867f = httpUriRequest;
        this.f59868h = eVar;
        this.f59869i = null;
        this.F = new f(eVar);
    }

    private void f() throws IOException {
        e eVar;
        if (isCancelled()) {
            return;
        }
        if (this.f59867f.getURI().getScheme() != null) {
            if (TencentVideoModule.v() == 1) {
                f fVar = this.F;
                if (fVar != null) {
                    fVar.g(this.f59867f, this.f59869i);
                    return;
                }
                return;
            }
            HttpResponse execute = this.f59865d.execute(this.f59867f, this.f59866e);
            if (isCancelled() || (eVar = this.f59868h) == null) {
                return;
            }
            eVar.f(execute);
            return;
        }
        throw new MalformedURLException("No valid URI scheme was provided");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0009 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g() throws IOException {
        IOException iOException;
        boolean retryRequest;
        e eVar;
        HttpRequestRetryHandler httpRequestRetryHandler = this.f59865d.getHttpRequestRetryHandler();
        IOException e16 = null;
        boolean z16 = true;
        while (z16) {
            try {
                try {
                    try {
                        f();
                        return;
                    } catch (IOException e17) {
                        e16 = e17;
                        try {
                            if (isCancelled()) {
                                return;
                            }
                            int i3 = this.f59870m + 1;
                            this.f59870m = i3;
                            z16 = httpRequestRetryHandler.retryRequest(e16, i3, this.f59866e);
                            if (z16) {
                            }
                        } catch (Exception e18) {
                            Log.e("AsyncHttpRequest", "Unhandled exception origin cause", e18);
                            throw new IOException("Unhandled exception: " + e18.getMessage());
                        }
                    }
                } catch (NullPointerException e19) {
                    iOException = new IOException("NPE in HttpClient: " + e19.getMessage());
                    int i16 = this.f59870m + 1;
                    this.f59870m = i16;
                    retryRequest = httpRequestRetryHandler.retryRequest(iOException, i16, this.f59866e);
                    IOException iOException2 = iOException;
                    z16 = retryRequest;
                    e16 = iOException2;
                    if (z16) {
                    }
                }
            } catch (UnknownHostException e26) {
                iOException = new IOException("UnknownHostException exception: " + e26.getMessage());
                if (this.f59870m > 0) {
                    int i17 = this.f59870m + 1;
                    this.f59870m = i17;
                    if (httpRequestRetryHandler.retryRequest(iOException, i17, this.f59866e)) {
                        retryRequest = true;
                        IOException iOException22 = iOException;
                        z16 = retryRequest;
                        e16 = iOException22;
                        if (z16 && (eVar = this.f59868h) != null) {
                            eVar.a(this.f59870m);
                        }
                    }
                }
                retryRequest = false;
                IOException iOException222 = iOException;
                z16 = retryRequest;
                e16 = iOException222;
                if (z16) {
                    eVar.a(this.f59870m);
                }
            }
        }
    }

    private synchronized void h() {
        if (!this.E && this.C && !this.D) {
            this.D = true;
            e eVar = this.f59868h;
            if (eVar != null) {
                eVar.i();
            }
        }
    }

    public boolean e() {
        return isCancelled() || this.E;
    }

    public boolean isCancelled() {
        if (this.C) {
            h();
        }
        return this.C;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        if (isCancelled()) {
            return;
        }
        e eVar2 = this.f59868h;
        if (eVar2 != null) {
            eVar2.k();
        }
        if (isCancelled()) {
            return;
        }
        try {
            g();
        } catch (IOException e16) {
            if (!isCancelled() && (eVar = this.f59868h) != null) {
                eVar.j(0, null, null, e16);
            } else {
                Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", e16);
            }
        }
        if (isCancelled()) {
            return;
        }
        e eVar3 = this.f59868h;
        if (eVar3 != null) {
            eVar3.g();
        }
        this.E = true;
    }

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, e eVar, d dVar) {
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = null;
        this.f59865d = abstractHttpClient;
        this.f59866e = httpContext;
        this.f59867f = httpUriRequest;
        this.f59868h = eVar;
        this.f59869i = dVar;
        this.F = new f(eVar);
    }
}
