package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.o;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Futures extends n {

    /* compiled from: P */
    /* renamed from: com.google.common.util.concurrent.Futures$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Future f35129d;

        @Override // java.lang.Runnable
        public void run() {
            this.f35129d.cancel(false);
        }
    }

    /* compiled from: P */
    /* renamed from: com.google.common.util.concurrent.Futures$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    final class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImmutableList f35130d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f35131e;

        @Override // java.lang.Runnable
        public void run() {
            a.a(null, this.f35130d, this.f35131e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class CallbackListener<V> implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final Future<V> f35132d;

        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                Futures.a(this.f35132d);
                throw null;
            } catch (Error | RuntimeException unused) {
                throw null;
            } catch (ExecutionException e16) {
                e16.getCause();
                throw null;
            }
        }

        public String toString() {
            return com.google.common.base.f.b(this).g(null).toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.h<V> implements Runnable {
        private q<V> D;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public String A() {
            q<V> qVar = this.D;
            if (qVar != null) {
                return "delegate=[" + qVar + "]";
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public void q() {
            this.D = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            q<V> qVar = this.D;
            if (qVar != null) {
                F(qVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class a<T> {
        static /* synthetic */ void a(a aVar, ImmutableList immutableList, int i3) {
            throw null;
        }
    }

    @CanIgnoreReturnValue
    public static <V> V a(Future<V> future) throws ExecutionException {
        com.google.common.base.j.w(future.isDone(), "Future was expected to be done: %s", future);
        return (V) v.a(future);
    }

    public static <V> q<V> b(Throwable th5) {
        com.google.common.base.j.m(th5);
        return new o.a(th5);
    }

    public static <V> q<V> c(@NullableDecl V v3) {
        if (v3 == null) {
            return o.b.f35205f;
        }
        return new o.b(v3);
    }

    @Beta
    public static <I, O> q<O> d(q<I> qVar, com.google.common.base.d<? super I, ? extends O> dVar, Executor executor) {
        return AbstractTransformFuture.I(qVar, dVar, executor);
    }
}
