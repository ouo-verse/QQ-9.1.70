package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class EmptyPendingResult<R extends Result> extends PendingResult<R> {
    private R result;

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await() {
        return this.result;
    }

    public R getResult() {
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public boolean isCanceled() {
        return false;
    }

    public void setResult(R r16) {
        this.result = r16;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j3, TimeUnit timeUnit) {
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback, long j3, TimeUnit timeUnit) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void cancel() {
    }
}
