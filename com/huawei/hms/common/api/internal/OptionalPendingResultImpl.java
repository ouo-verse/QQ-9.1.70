package com.huawei.hms.common.api.internal;

import android.os.Looper;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes2.dex */
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* renamed from: a, reason: collision with root package name */
    private final PendingResult<R> f36822a;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        this.f36822a = pendingResult;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        return this.f36822a.await();
    }

    @Override // com.huawei.hms.common.api.OptionalPendingResult
    public final R get() {
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hms.common.api.OptionalPendingResult
    public final boolean isDone() {
        return false;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback) {
        this.f36822a.setResultCallback(resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await(long j3, TimeUnit timeUnit) {
        return this.f36822a.await(j3, timeUnit);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        this.f36822a.setResultCallback(looper, resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback, long j3, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    public final void addStatusListener() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void cancel() {
    }
}
