package com.huawei.hmf.tasks;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ExecuteResult<TResult> {
    void cancel();

    void onComplete(Task<TResult> task);
}
