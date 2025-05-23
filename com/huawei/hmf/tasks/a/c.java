package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class c extends CancellationToken {

    /* renamed from: a, reason: collision with root package name */
    public final List<Runnable> f36542a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Object f36543b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f36544c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f36544c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.f36543b) {
            if (this.f36544c) {
                runnable.run();
            } else {
                this.f36542a.add(runnable);
            }
        }
        return this;
    }
}
