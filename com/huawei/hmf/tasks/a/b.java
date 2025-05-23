package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private OnCanceledListener f36538a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f36539b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f36540c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f36538a = onCanceledListener;
        this.f36539b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f36540c) {
            this.f36538a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.f36539b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this.f36540c) {
                        if (b.this.f36538a != null) {
                            b.this.f36538a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
