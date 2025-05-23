package com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKInvalidRespTransToExInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        if (proceed.isSuccessful()) {
            return proceed;
        }
        throw new ITVKHttpProcessor.InvalidResponseCodeException(proceed.code(), proceed.message());
    }
}
