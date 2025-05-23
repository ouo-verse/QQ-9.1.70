package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.aspectj.lang.JoinPoint;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f35209a;

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantLock f35210b;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy(JoinPoint.SYNCHRONIZATION_LOCK)
    private a f35211c;

    /* compiled from: P */
    @Beta
    /* loaded from: classes2.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        @Weak
        final r f35212a;

        /* renamed from: b, reason: collision with root package name */
        final Condition f35213b;

        /* renamed from: c, reason: collision with root package name */
        @GuardedBy("monitor.lock")
        int f35214c = 0;

        /* renamed from: d, reason: collision with root package name */
        @NullableDecl
        @GuardedBy("monitor.lock")
        a f35215d;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(r rVar) {
            this.f35212a = (r) com.google.common.base.j.n(rVar, "monitor");
            this.f35213b = rVar.f35210b.newCondition();
        }

        public abstract boolean a();
    }

    public r() {
        this(false);
    }

    @GuardedBy(JoinPoint.SYNCHRONIZATION_LOCK)
    private boolean d(a aVar) {
        try {
            return aVar.a();
        } catch (Throwable th5) {
            f();
            throw th5;
        }
    }

    @GuardedBy(JoinPoint.SYNCHRONIZATION_LOCK)
    private void f() {
        for (a aVar = this.f35211c; aVar != null; aVar = aVar.f35215d) {
            aVar.f35213b.signalAll();
        }
    }

    @GuardedBy(JoinPoint.SYNCHRONIZATION_LOCK)
    private void g() {
        for (a aVar = this.f35211c; aVar != null; aVar = aVar.f35215d) {
            if (d(aVar)) {
                aVar.f35213b.signal();
                return;
            }
        }
    }

    public void b() {
        this.f35210b.lock();
    }

    public boolean c() {
        return this.f35210b.isHeldByCurrentThread();
    }

    public void e() {
        ReentrantLock reentrantLock = this.f35210b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                g();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public r(boolean z16) {
        this.f35211c = null;
        this.f35209a = z16;
        this.f35210b = new ReentrantLock(z16);
    }
}
