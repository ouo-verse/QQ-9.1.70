package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class x0<TResult> implements j0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public Executor f36454a;

    /* renamed from: b, reason: collision with root package name */
    public m0<TResult> f36455b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f36456c = new Object();

    public x0(Executor executor, m0<TResult> m0Var) {
        this.f36455b = m0Var;
        this.f36454a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        if (a1Var.e()) {
            a1Var.d();
            this.f36454a.execute(new w0(this, a1Var));
        }
    }
}
