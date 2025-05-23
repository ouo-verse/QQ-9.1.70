package com.tencent.qqnt.http.okhttp3;

import android.os.SystemClock;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.RealInterceptorChain;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006H\u0014J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/http/okhttp3/b;", "Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Request;", Const.BUNDLE_KEY_REQUEST, "Lokhttp3/OkHttpClient;", "client", "", "Lokhttp3/Protocol;", "b", "Lokhttp3/Dns;", "a", "Lokhttp3/Address;", "createAddress", "", "Lokhttp3/Interceptor;", "buildInterceptors", "interceptors", "Lokhttp3/internal/http/RealInterceptorChain;", "buildInterceptorChain", "Lkotlin/Function0;", "", "block", "asyncCallScope", "originalRequest", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;)V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends RealCall {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull OkHttpClient client, @NotNull Request originalRequest) {
        super(client, originalRequest, false);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) client, (Object) originalRequest);
        }
    }

    private final Dns a() {
        com.tencent.qqnt.http.api.a c16;
        com.tencent.qqnt.http.api.b b16 = c.b(this);
        if (b16 != null && (c16 = b16.c()) != null) {
            return new a(c16);
        }
        return getClient().dns();
    }

    private final List<Protocol> b(Request request, OkHttpClient client) {
        List<Protocol> listOf;
        if (request.url().getIsHttps()) {
            Object tag = request.tag(com.tencent.qqnt.http.api.b.class);
            Intrinsics.checkNotNull(tag);
            if (((com.tencent.qqnt.http.api.b) tag).f()) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
                return listOf;
            }
        }
        return client.protocols();
    }

    @Override // okhttp3.internal.connection.RealCall
    public void asyncCallScope(@NotNull Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        com.tencent.qqnt.http.api.impl.c a16 = c.a(this);
        if (a16 != null) {
            a16.c(Long.valueOf(SystemClock.uptimeMillis()));
        }
        String str = "NTHttp " + getOriginalRequest().url().redact();
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            block.invoke();
        } finally {
            currentThread.setName(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // okhttp3.internal.connection.RealCall
    @NotNull
    public RealInterceptorChain buildInterceptorChain(@NotNull List<? extends Interceptor> interceptors) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RealInterceptorChain) iPatchRedirector.redirect((short) 4, (Object) this, (Object) interceptors);
        }
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        RealInterceptorChain buildInterceptorChain = super.buildInterceptorChain(interceptors);
        com.tencent.qqnt.http.api.b b16 = c.b(this);
        if (b16 != null) {
            Integer m3 = b16.m();
            if (m3 != null) {
                buildInterceptorChain.withReadTimeout(m3.intValue(), TimeUnit.MILLISECONDS);
            }
            Integer y16 = b16.y();
            if (y16 != null) {
                buildInterceptorChain.withWriteTimeout(y16.intValue(), TimeUnit.MILLISECONDS);
            }
            Integer b17 = b16.b();
            if (b17 != null) {
                buildInterceptorChain.withConnectTimeout(b17.intValue(), TimeUnit.MILLISECONDS);
            }
        }
        return buildInterceptorChain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // okhttp3.internal.connection.RealCall
    @NotNull
    public List<Interceptor> buildInterceptors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return super.buildInterceptors();
    }

    @Override // okhttp3.internal.connection.RealCall
    @NotNull
    protected Address createAddress(@NotNull Request request) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Address) iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
        }
        Intrinsics.checkNotNullParameter(request, "request");
        HttpUrl url = request.url();
        SocketFactory socketFactory = (SocketFactory) request.tag(SocketFactory.class);
        if (socketFactory == null) {
            socketFactory = getClient().socketFactory();
        }
        SocketFactory socketFactory2 = socketFactory;
        if (url.getIsHttps()) {
            SSLSocketFactory sSLSocketFactory2 = (SSLSocketFactory) request.tag(SSLSocketFactory.class);
            if (sSLSocketFactory2 == null) {
                sSLSocketFactory2 = getClient().sslSocketFactory();
            }
            HostnameVerifier hostnameVerifier2 = (HostnameVerifier) request.tag(HostnameVerifier.class);
            if (hostnameVerifier2 == null) {
                hostnameVerifier2 = getClient().hostnameVerifier();
            }
            sSLSocketFactory = sSLSocketFactory2;
            hostnameVerifier = hostnameVerifier2;
            certificatePinner = getClient().certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(url.host(), url.port(), a(), socketFactory2, sSLSocketFactory, hostnameVerifier, certificatePinner, getClient().proxyAuthenticator(), getClient().proxy(), b(request, getClient()), getClient().connectionSpecs(), getClient().proxySelector());
    }
}
