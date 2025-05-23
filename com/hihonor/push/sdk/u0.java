package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class u0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f36442a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v0 f36443b;

    public u0(v0 v0Var, a1 a1Var) {
        this.f36443b = v0Var;
        this.f36442a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f36443b.f36448c) {
            l0 l0Var = this.f36443b.f36447b;
            if (l0Var != null) {
                this.f36442a.b();
                ((y0) l0Var).f36459a.countDown();
            }
        }
    }
}
