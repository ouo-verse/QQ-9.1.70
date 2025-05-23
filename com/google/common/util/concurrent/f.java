package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ab;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
abstract class f {

    /* renamed from: f, reason: collision with root package name */
    private static final b f35192f;

    /* renamed from: h, reason: collision with root package name */
    private static final Logger f35193h = Logger.getLogger(f.class.getName());

    /* renamed from: d, reason: collision with root package name */
    private volatile Set<Throwable> f35194d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f35195e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static abstract class b {
        b() {
        }

        abstract void a(f fVar, Set<Throwable> set, Set<Throwable> set2);

        abstract int b(f fVar);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<f, Set<Throwable>> f35196a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicIntegerFieldUpdater<f> f35197b;

        c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f35196a = atomicReferenceFieldUpdater;
            this.f35197b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.f.b
        void a(f fVar, Set<Throwable> set, Set<Throwable> set2) {
            com.google.common.util.concurrent.b.a(this.f35196a, fVar, set, set2);
        }

        @Override // com.google.common.util.concurrent.f.b
        int b(f fVar) {
            return this.f35197b.decrementAndGet(fVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class d extends b {
        d() {
            super();
        }

        @Override // com.google.common.util.concurrent.f.b
        void a(f fVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (fVar) {
                if (fVar.f35194d == set) {
                    fVar.f35194d = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.f.b
        int b(f fVar) {
            int i3;
            synchronized (fVar) {
                f.d(fVar);
                i3 = fVar.f35195e;
            }
            return i3;
        }
    }

    static {
        b dVar;
        Throwable th5 = null;
        byte b16 = 0;
        try {
            dVar = new c(AtomicReferenceFieldUpdater.newUpdater(f.class, Set.class, "d"), AtomicIntegerFieldUpdater.newUpdater(f.class, "e"));
        } catch (Throwable th6) {
            dVar = new d();
            th5 = th6;
        }
        f35192f = dVar;
        if (th5 != null) {
            f35193h.log(Level.SEVERE, "SafeAtomicHelper is broken!", th5);
        }
    }

    static /* synthetic */ int d(f fVar) {
        int i3 = fVar.f35195e;
        fVar.f35195e = i3 - 1;
        return i3;
    }

    abstract void e(Set<Throwable> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int f() {
        return f35192f.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Throwable> g() {
        Set<Throwable> set = this.f35194d;
        if (set == null) {
            Set<Throwable> c16 = ab.c();
            e(c16);
            f35192f.a(this, null, c16);
            return this.f35194d;
        }
        return set;
    }
}
