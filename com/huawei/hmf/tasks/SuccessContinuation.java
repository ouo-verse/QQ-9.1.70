package com.huawei.hmf.tasks;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult tresult) throws Exception;
}
