package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
abstract class o<V> implements q<V> {

    /* renamed from: d, reason: collision with root package name */
    private static final Logger f35204d = Logger.getLogger(o.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a<V> extends AbstractFuture.h<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Throwable th5) {
            E(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<V> extends o<V> {

        /* renamed from: f, reason: collision with root package name */
        static final b<Object> f35205f = new b<>(null);

        /* renamed from: e, reason: collision with root package name */
        @NullableDecl
        private final V f35206e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(@NullableDecl V v3) {
            this.f35206e = v3;
        }

        @Override // com.google.common.util.concurrent.o, java.util.concurrent.Future
        public V get() {
            return this.f35206e;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f35206e + "]]";
        }
    }

    o() {
    }

    @Override // com.google.common.util.concurrent.q
    public void c(Runnable runnable, Executor executor) {
        com.google.common.base.j.n(runnable, "Runnable was null.");
        com.google.common.base.j.n(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e16) {
            f35204d.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e16);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j3, TimeUnit timeUnit) throws ExecutionException {
        com.google.common.base.j.m(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
