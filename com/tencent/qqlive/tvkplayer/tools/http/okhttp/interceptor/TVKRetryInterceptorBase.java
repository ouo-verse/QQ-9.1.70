package com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.connection.RealCall;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TVKRetryInterceptorBase implements Interceptor {
    protected String mLogTag = "TVKRetryInterceptorBase";

    final void clearCancelTagIfNeeded(@NonNull Call call) {
        if (!call.getCanceled() || !(call instanceof RealCall)) {
            return;
        }
        try {
            RealCall realCall = (RealCall) call;
            Field declaredField = RealCall.class.getDeclaredField("canceled");
            declaredField.setAccessible(true);
            declaredField.set(realCall, Boolean.FALSE);
            TVKLogUtil.i(this.mLogTag, "change RealCall canceled to " + declaredField.get(realCall));
        } catch (Exception e16) {
            TVKLogUtil.e(this.mLogTag, e16, "failed to modify RealCall canceled");
        }
    }

    @NonNull
    public abstract Response executeWithRetry(@NonNull Interceptor.Chain chain, IOException iOException) throws IOException;

    @Override // okhttp3.Interceptor
    @NonNull
    public final Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        try {
            return chain.proceed(chain.request());
        } catch (IOException e16) {
            try {
                Response executeWithRetry = executeWithRetry(chain, e16);
                clearCancelTagIfNeeded(chain.call());
                return executeWithRetry;
            } catch (IOException unused) {
                throw e16;
            }
        }
    }
}
