package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class v0<TResult> implements j0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public Executor f36446a;

    /* renamed from: b, reason: collision with root package name */
    public l0 f36447b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f36448c = new Object();

    public v0(Executor executor, l0 l0Var) {
        this.f36447b = l0Var;
        this.f36446a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        if (!a1Var.e()) {
            a1Var.d();
            this.f36446a.execute(new u0(this, a1Var));
        }
    }
}
