package com.google.common.util.concurrent;

/* compiled from: P */
/* loaded from: classes2.dex */
final class Callables$4 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.google.common.base.o f35122d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Runnable f35123e;

    @Override // java.lang.Runnable
    public void run() {
        boolean b16;
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        b16 = i.b((String) this.f35122d.get(), currentThread);
        try {
            this.f35123e.run();
        } finally {
            if (b16) {
                i.b(name, currentThread);
            }
        }
    }
}
