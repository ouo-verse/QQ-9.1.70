package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    Executor f36545a;

    /* renamed from: b, reason: collision with root package name */
    private OnCompleteListener<TResult> f36546b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f36547c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f36546b = onCompleteListener;
        this.f36545a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f36547c) {
            this.f36546b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.f36545a.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this.f36547c) {
                    if (d.this.f36546b != null) {
                        d.this.f36546b.onComplete(task);
                    }
                }
            }
        });
    }
}
