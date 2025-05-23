package com.tencent.libra.extension.gif;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes7.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f118745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() throws InterruptedException {
        while (!this.f118745a) {
            LockMethodProxy.wait(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        this.f118745a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c() {
        boolean z16 = this.f118745a;
        this.f118745a = true;
        if (!z16) {
            notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(boolean z16) {
        if (z16) {
            c();
        } else {
            b();
        }
    }
}
