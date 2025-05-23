package com.tencent.luggage.wxa.n3;

import cooperation.qzone.remote.ServiceConst;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.tls.OkHostnameVerifier;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static OkHttpClient f135232a;

    /* renamed from: b, reason: collision with root package name */
    public static OkHttpClient f135233b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile OkHttpClient f135234c;

    /* renamed from: d, reason: collision with root package name */
    public static final Interceptor f135235d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static final MediaType f135236e = MediaType.parse("application/json;");

    /* renamed from: f, reason: collision with root package name */
    public static final MediaType f135237f = MediaType.parse("image/png");

    /* renamed from: g, reason: collision with root package name */
    public static final HostnameVerifier f135238g = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Interceptor {
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl.Builder newBuilder = request.url().newBuilder();
            com.tencent.luggage.wxa.o3.l lVar = com.tencent.luggage.wxa.o3.l.f136139a;
            lVar.c();
            if (com.tencent.luggage.wxa.s3.f.f140021a.i() || lVar.c()) {
                newBuilder.addQueryParameter(ServiceConst.PARA_SESSION_ID, j.f135199a.a("", com.tencent.luggage.wxa.s3.f.c(), 1));
            }
            return chain.proceed(request.newBuilder().url(newBuilder.build()).build());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (com.tencent.luggage.wxa.tn.e.f141559a) {
                return true;
            }
            return OkHostnameVerifier.INSTANCE.verify(str, sSLSession);
        }
    }

    public static synchronized OkHttpClient cgiClient() {
        synchronized (p.class) {
            OkHttpClient okHttpClient = f135233b;
            if (okHttpClient != null) {
                return okHttpClient;
            }
            OkHttpClient build = rawClient().newBuilder().addInterceptor(f135235d).build();
            f135233b = build;
            return build;
        }
    }

    public static synchronized OkHttpClient get() {
        OkHttpClient okHttpClient;
        synchronized (p.class) {
            if (f135232a == null) {
                f135232a = new OkHttpClient.Builder().hostnameVerifier(f135238g).protocols(Arrays.asList(Protocol.HTTP_1_1, Protocol.HTTP_2)).build();
            }
            okHttpClient = f135232a;
        }
        return okHttpClient;
    }

    public static synchronized OkHttpClient longConnectClient() {
        OkHttpClient okHttpClient;
        synchronized (p.class) {
            if (f135234c == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                f135234c = builder.connectTimeout(35L, timeUnit).readTimeout(35L, timeUnit).hostnameVerifier(f135238g).build();
            }
            okHttpClient = f135234c;
        }
        return okHttpClient;
    }

    public static synchronized OkHttpClient rawClient() {
        OkHttpClient okHttpClient;
        synchronized (p.class) {
            okHttpClient = get();
        }
        return okHttpClient;
    }
}
