package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.k;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends k.a<V> implements Runnable {

    @NullableDecl
    q<? extends V> D;

    @NullableDecl
    Class<X> E;

    @NullableDecl
    F F;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, h<? super X, ? extends V>, q<? extends V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public q<? extends V> I(h<? super X, ? extends V> hVar, X x16) throws Exception {
            q<? extends V> apply = hVar.apply(x16);
            com.google.common.base.j.o(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", hVar);
            return apply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public void J(q<? extends V> qVar) {
            F(qVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, com.google.common.base.d<? super X, ? extends V>, V> {
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        void J(@NullableDecl V v3) {
            D(v3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @NullableDecl
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public V I(com.google.common.base.d<? super X, ? extends V> dVar, X x16) throws Exception {
            return dVar.apply(x16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String A() {
        String str;
        q<? extends V> qVar = this.D;
        Class<X> cls = this.E;
        F f16 = this.F;
        String A = super.A();
        if (qVar != null) {
            str = "inputFuture=[" + qVar + "], ";
        } else {
            str = "";
        }
        if (cls != null && f16 != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + f16 + "]";
        }
        if (A != null) {
            return str + A;
        }
        return null;
    }

    @NullableDecl
    @ForOverride
    abstract T I(F f16, X x16) throws Exception;

    @ForOverride
    abstract void J(@NullableDecl T t16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void q() {
        z(this.D);
        this.D = null;
        this.E = null;
        this.F = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class<X extends java.lang.Throwable>, F] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z16;
        boolean z17;
        Object obj;
        q<? extends V> qVar = this.D;
        Class<X> cls = this.E;
        F f16 = this.F;
        boolean z18 = true;
        if (qVar == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (cls == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z19 = z16 | z17;
        if (f16 != null) {
            z18 = false;
        }
        if (z18 | z19 | isCancelled()) {
            return;
        }
        ?? r36 = (Class<X>) null;
        this.D = null;
        try {
            obj = Futures.a(qVar);
            th = null;
        } catch (ExecutionException e16) {
            th = (Throwable) com.google.common.base.j.m(e16.getCause());
            obj = null;
            if (th == null) {
            }
        } catch (Throwable th5) {
            th = th5;
            obj = null;
            if (th == null) {
            }
        }
        if (th == null) {
            D(obj);
            return;
        }
        if (!s.a(th, cls)) {
            F(qVar);
            return;
        }
        try {
            Object I = I(f16, th);
            this.E = null;
            this.F = null;
            J(I);
        } catch (Throwable th6) {
            try {
                E(th6);
            } finally {
                this.E = null;
                this.F = null;
            }
        }
    }
}
