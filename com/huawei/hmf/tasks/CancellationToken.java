package com.huawei.hmf.tasks;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract CancellationToken register(Runnable runnable);
}
