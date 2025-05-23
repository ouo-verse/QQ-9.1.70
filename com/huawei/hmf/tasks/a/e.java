package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* compiled from: P */
/* loaded from: classes2.dex */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f36550a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final int f36551b;

    /* renamed from: c, reason: collision with root package name */
    private final i<Void> f36552c;

    /* renamed from: d, reason: collision with root package name */
    private int f36553d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f36554e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f36555f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i3, i<Void> iVar) {
        this.f36551b = i3;
        this.f36552c = iVar;
    }

    private void a() {
        if (this.f36553d >= this.f36551b) {
            if (this.f36554e != null) {
                this.f36552c.a(new ExecutionException("a task failed", this.f36554e));
            } else if (this.f36555f) {
                this.f36552c.a();
            } else {
                this.f36552c.a((i<Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f36550a) {
            this.f36553d++;
            this.f36555f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f36550a) {
            this.f36553d++;
            this.f36554e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.f36550a) {
            this.f36553d++;
            a();
        }
    }
}
