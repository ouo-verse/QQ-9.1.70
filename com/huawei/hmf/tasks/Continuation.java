package com.huawei.hmf.tasks;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task) throws Exception;
}
