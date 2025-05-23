package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class n0<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final a1<TResult> f36413a = new a1<>();

    public void a(TResult tresult) {
        a1<TResult> a1Var = this.f36413a;
        synchronized (a1Var.f36352a) {
            if (!a1Var.f36353b) {
                a1Var.f36353b = true;
                a1Var.f36354c = tresult;
                a1Var.f36352a.notifyAll();
                a1Var.a();
            }
        }
    }

    public void a(Exception exc) {
        a1<TResult> a1Var = this.f36413a;
        synchronized (a1Var.f36352a) {
            if (!a1Var.f36353b) {
                a1Var.f36353b = true;
                a1Var.f36355d = exc;
                a1Var.f36352a.notifyAll();
                a1Var.a();
            }
        }
    }
}
