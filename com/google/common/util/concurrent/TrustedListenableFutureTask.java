package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.k;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public class TrustedListenableFutureTask<V> extends k.a<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> D;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<q<V>> {
        private final g<V> callable;

        TrustedFutureInterruptibleAsyncTask(g<V> gVar) {
            this.callable = (g) com.google.common.base.j.m(gVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(q<V> qVar, Throwable th5) {
            if (th5 == null) {
                TrustedListenableFutureTask.this.F(qVar);
            } else {
                TrustedListenableFutureTask.this.E(th5);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public q<V> runInterruptibly() throws Exception {
            return (q) com.google.common.base.j.o(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.callable = (Callable) com.google.common.base.j.m(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void afterRanInterruptibly(V v3, Throwable th5) {
            if (th5 == null) {
                TrustedListenableFutureTask.this.D(v3);
            } else {
                TrustedListenableFutureTask.this.E(th5);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String A() {
        InterruptibleTask<?> interruptibleTask = this.D;
        if (interruptibleTask != null) {
            return "task=[" + interruptibleTask + "]";
        }
        return super.A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public void q() {
        InterruptibleTask<?> interruptibleTask;
        super.q();
        if (H() && (interruptibleTask = this.D) != null) {
            interruptibleTask.interruptTask();
        }
        this.D = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask<?> interruptibleTask = this.D;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.D = null;
    }
}
