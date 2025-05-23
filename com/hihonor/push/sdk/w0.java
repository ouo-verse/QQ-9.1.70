package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class w0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f36451a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f36452b;

    public w0(x0 x0Var, a1 a1Var) {
        this.f36452b = x0Var;
        this.f36451a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f36452b.f36456c) {
            Object obj = this.f36452b.f36455b;
            if (obj != null) {
                this.f36451a.c();
                ((y0) obj).f36459a.countDown();
            }
        }
    }
}
