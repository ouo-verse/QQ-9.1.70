package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class f<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private OnFailureListener f36556a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f36557b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f36558c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Executor executor, OnFailureListener onFailureListener) {
        this.f36556a = onFailureListener;
        this.f36557b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f36558c) {
            this.f36556a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            this.f36557b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (f.this.f36558c) {
                        if (f.this.f36556a != null) {
                            f.this.f36556a.onFailure(task.getException());
                        }
                    }
                }
            });
        }
    }
}
