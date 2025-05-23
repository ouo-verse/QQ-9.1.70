package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f36891a;

    /* renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource<TResult> f36892b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f36891a = taskApiCall;
        this.f36892b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f36891a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.f36892b;
    }
}
