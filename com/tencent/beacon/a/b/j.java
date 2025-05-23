package com.tencent.beacon.a.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f77611a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f77612b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar, Runnable runnable) {
        this.f77612b = kVar;
        this.f77611a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicInteger atomicInteger;
        try {
            this.f77611a.run();
        } catch (Throwable th5) {
            atomicInteger = k.f77615e;
            if (atomicInteger.addAndGet(1) < 100) {
                i.e().a("599", "[task] run occur error!", th5);
            }
            com.tencent.beacon.base.util.e.a(th5.getMessage());
            com.tencent.beacon.base.util.c.a(th5);
        }
    }
}
