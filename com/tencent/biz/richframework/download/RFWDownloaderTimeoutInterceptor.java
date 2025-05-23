package com.tencent.biz.richframework.download;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/richframework/download/RFWDownloaderTimeoutInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "download_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWDownloaderTimeoutInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        ConnectTimeout connectTimeout = (ConnectTimeout) request.tag(ConnectTimeout.class);
        if (connectTimeout != null) {
            chain = chain.withConnectTimeout(connectTimeout.getTime(), TimeUnit.SECONDS);
        }
        ReadTimeout readTimeout = (ReadTimeout) request.tag(ReadTimeout.class);
        if (readTimeout != null) {
            chain = chain.withReadTimeout(readTimeout.getTime(), TimeUnit.SECONDS);
        }
        WriteTimeout writeTimeout = (WriteTimeout) request.tag(WriteTimeout.class);
        if (writeTimeout != null) {
            chain = chain.withWriteTimeout(writeTimeout.getTime(), TimeUnit.SECONDS);
        }
        return chain.proceed(request);
    }
}
