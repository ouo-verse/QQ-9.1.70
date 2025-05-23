package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class t0<TResult> implements j0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public Executor f36436a;

    /* renamed from: b, reason: collision with root package name */
    public k0<TResult> f36437b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f36438c = new Object();

    public t0(Executor executor, k0<TResult> k0Var) {
        this.f36437b = k0Var;
        this.f36436a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        this.f36436a.execute(new s0(this, a1Var));
    }
}
