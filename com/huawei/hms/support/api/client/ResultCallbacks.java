package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    private static final String TAG = "ResultCallbacks";

    public abstract void onFailure(Status status);

    public abstract void onSuccess(R r16);

    @Override // com.huawei.hms.support.api.client.ResultCallback
    public final void onResult(R r16) {
        try {
            Status status = r16.getStatus();
            if (status.isSuccess()) {
                onSuccess(r16);
            } else {
                onFailure(status);
                if (r16 instanceof Releasable) {
                    ((Releasable) r16).release();
                }
            }
        } catch (Exception e16) {
            HMSLog.w(TAG, "Failed to release " + r16 + ", reason: " + e16);
        }
    }
}
