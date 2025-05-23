package com.github.luben.zstd;

import java.io.Closeable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: P */
/* loaded from: classes2.dex */
abstract class a implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater<a> f32912e = AtomicIntegerFieldUpdater.newUpdater(a.class, "d");

    /* renamed from: d, reason: collision with root package name */
    private volatile int f32913d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int i3;
        do {
            i3 = this.f32913d;
            if (i3 >= 0) {
                if (i3 == Integer.MAX_VALUE) {
                    throw new IllegalStateException("Shared lock overflow");
                }
            } else {
                throw new IllegalStateException("Closed");
            }
        } while (!f32912e.compareAndSet(this, i3, i3 + 1));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.f32913d == -1) {
                return;
            }
            if (f32912e.compareAndSet(this, 0, -1)) {
                d();
                return;
            }
            throw new IllegalStateException("Attempt to close while in use");
        }
    }

    abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        int i3;
        do {
            i3 = this.f32913d;
            if (i3 >= 0) {
                if (i3 == 0) {
                    throw new IllegalStateException("Shared lock underflow");
                }
            } else {
                throw new IllegalStateException("Closed");
            }
        } while (!f32912e.compareAndSet(this, i3, i3 - 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f32913d = 0;
    }
}
