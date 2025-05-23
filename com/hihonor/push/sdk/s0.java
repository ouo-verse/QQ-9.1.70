package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class s0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f36432a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f36433b;

    public s0(t0 t0Var, a1 a1Var) {
        this.f36433b = t0Var;
        this.f36432a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f36433b.f36438c) {
            k0<TResult> k0Var = this.f36433b.f36437b;
            if (k0Var != 0) {
                k0Var.a(this.f36432a);
            }
        }
    }
}
