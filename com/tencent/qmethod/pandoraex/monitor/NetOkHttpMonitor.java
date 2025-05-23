package com.tencent.qmethod.pandoraex.monitor;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class NetOkHttpMonitor {

    @VisibleForTesting
    public static NetOkHttpMonitor sInstance = new NetOkHttpMonitor();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static class OkHttpInterceptor implements Interceptor {
        static OkHttpInterceptor sInstance = new OkHttpInterceptor();

        OkHttpInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return NetOkHttpMonitor.getInstance().wrap(chain);
        }
    }

    @VisibleForTesting
    NetOkHttpMonitor() {
    }

    public static NetOkHttpMonitor getInstance() {
        return sInstance;
    }

    public static OkHttpClient inspectOkHttp(OkHttpClient.Builder builder) {
        if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.b()) {
            if (!builder.interceptors().contains(OkHttpInterceptor.sInstance)) {
                builder.addInterceptor(OkHttpInterceptor.sInstance);
            }
            return builder.build();
        }
        return builder.build();
    }

    com.tencent.qmethod.pandoraex.core.ext.netcap.l obtainOkHttpRecorder(Request request) {
        return new com.tencent.qmethod.pandoraex.core.ext.netcap.l(request);
    }

    Response wrap(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(request.url().host(), 2)) {
            obtainOkHttpRecorder(request);
            try {
                return chain.proceed(request);
            } catch (IOException e16) {
                throw e16;
            }
        }
        return chain.proceed(request);
    }
}
