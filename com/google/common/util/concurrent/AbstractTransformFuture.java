package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.k;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractTransformFuture<I, O, F, T> extends k.a<O> implements Runnable {

    @NullableDecl
    q<? extends I> D;

    @NullableDecl
    F E;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, h<? super I, ? extends O>, q<? extends O>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public q<? extends O> J(h<? super I, ? extends O> hVar, @NullableDecl I i3) throws Exception {
            q<? extends O> apply = hVar.apply(i3);
            com.google.common.base.j.o(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", hVar);
            return apply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public void K(q<? extends O> qVar) {
            F(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, com.google.common.base.d<? super I, ? extends O>, O> {
        TransformFuture(q<? extends I> qVar, com.google.common.base.d<? super I, ? extends O> dVar) {
            super(qVar, dVar);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        void K(@NullableDecl O o16) {
            D(o16);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @NullableDecl
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public O J(com.google.common.base.d<? super I, ? extends O> dVar, @NullableDecl I i3) {
            return dVar.apply(i3);
        }
    }

    AbstractTransformFuture(q<? extends I> qVar, F f16) {
        this.D = (q) com.google.common.base.j.m(qVar);
        this.E = (F) com.google.common.base.j.m(f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> q<O> I(q<I> qVar, com.google.common.base.d<? super I, ? extends O> dVar, Executor executor) {
        com.google.common.base.j.m(dVar);
        TransformFuture transformFuture = new TransformFuture(qVar, dVar);
        qVar.c(transformFuture, MoreExecutors.b(executor, transformFuture));
        return transformFuture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String A() {
        String str;
        q<? extends I> qVar = this.D;
        F f16 = this.E;
        String A = super.A();
        if (qVar != null) {
            str = "inputFuture=[" + qVar + "], ";
        } else {
            str = "";
        }
        if (f16 != null) {
            return str + "function=[" + f16 + "]";
        }
        if (A != null) {
            return str + A;
        }
        return null;
    }

    @NullableDecl
    @ForOverride
    abstract T J(F f16, @NullableDecl I i3) throws Exception;

    @ForOverride
    abstract void K(@NullableDecl T t16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void q() {
        z(this.D);
        this.D = null;
        this.E = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z16;
        q<? extends I> qVar = this.D;
        F f16 = this.E;
        boolean isCancelled = isCancelled();
        boolean z17 = true;
        if (qVar == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z18 = isCancelled | z16;
        if (f16 != null) {
            z17 = false;
        }
        if (z18 | z17) {
            return;
        }
        this.D = null;
        if (qVar.isCancelled()) {
            F(qVar);
            return;
        }
        try {
            try {
                Object J = J(f16, Futures.a(qVar));
                this.E = null;
                K(J);
            } catch (Throwable th5) {
                try {
                    E(th5);
                } finally {
                    this.E = null;
                }
            }
        } catch (Error e16) {
            E(e16);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e17) {
            E(e17);
        } catch (ExecutionException e18) {
            E(e18.getCause());
        }
    }
}
