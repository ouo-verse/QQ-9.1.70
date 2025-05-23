package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f36470a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f36471b;

    public z0(n0 n0Var, Callable callable) {
        this.f36470a = n0Var;
        this.f36471b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f36470a.a((n0) this.f36471b.call());
        } catch (Exception e16) {
            this.f36470a.a(e16);
        }
    }
}
