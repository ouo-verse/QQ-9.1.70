package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class h<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private OnSuccessListener<TResult> f36563a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f36564b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f36565c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f36563a = onSuccessListener;
        this.f36564b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f36565c) {
            this.f36563a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() && !task.isCanceled()) {
            this.f36564b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (h.this.f36565c) {
                        if (h.this.f36563a != null) {
                            h.this.f36563a.onSuccess(task.getResult());
                        }
                    }
                }
            });
        }
    }
}
