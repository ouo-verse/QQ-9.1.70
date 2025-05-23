package com.tencent.luggage.wxa.n0;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f135056a;

    public synchronized void a() {
        while (!this.f135056a) {
            LockMethodProxy.wait(this);
        }
    }

    public synchronized boolean b() {
        boolean z16;
        z16 = this.f135056a;
        this.f135056a = false;
        return z16;
    }

    public synchronized boolean c() {
        if (this.f135056a) {
            return false;
        }
        this.f135056a = true;
        notifyAll();
        return true;
    }
}
