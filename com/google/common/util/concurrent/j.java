package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    private static final Logger f35198c = Logger.getLogger(j.class.getName());

    /* renamed from: a, reason: collision with root package name */
    @NullableDecl
    @GuardedBy("this")
    private a f35199a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f35200b;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f35201a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f35202b;

        /* renamed from: c, reason: collision with root package name */
        @NullableDecl
        a f35203c;

        a(Runnable runnable, Executor executor, a aVar) {
            this.f35201a = runnable;
            this.f35202b = executor;
            this.f35203c = aVar;
        }
    }

    private static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e16) {
            f35198c.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e16);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.common.base.j.n(runnable, "Runnable was null.");
        com.google.common.base.j.n(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f35200b) {
                this.f35199a = new a(runnable, executor, this.f35199a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f35200b) {
                return;
            }
            this.f35200b = true;
            a aVar = this.f35199a;
            a aVar2 = null;
            this.f35199a = null;
            while (aVar != null) {
                a aVar3 = aVar.f35203c;
                aVar.f35203c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f35201a, aVar2.f35202b);
                aVar2 = aVar2.f35203c;
            }
        }
    }
}
