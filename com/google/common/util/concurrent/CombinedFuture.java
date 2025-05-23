package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<q<V>> {
        private final g<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public AsyncCallableInterruptibleTask(CombinedFuture combinedFuture, g<V> gVar, Executor executor) {
            super(combinedFuture, executor);
            this.callable = (g) com.google.common.base.j.m(gVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public q<V> runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return (q) com.google.common.base.j.o(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(q<V> qVar) {
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public CallableInterruptibleTask(CombinedFuture combinedFuture, Callable<V> callable, Executor executor) {
            super(combinedFuture, executor);
            this.callable = (Callable) com.google.common.base.j.m(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        V runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        void setValue(V v3) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        final /* synthetic */ CombinedFuture this$0;
        boolean thrownByExecute = true;

        public CombinedFutureInterruptibleTask(CombinedFuture combinedFuture, Executor executor) {
            this.listenerExecutor = (Executor) com.google.common.base.j.m(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void afterRanInterruptibly(T t16, Throwable th5) {
            if (th5 != null) {
                if (!(th5 instanceof ExecutionException)) {
                    if (th5 instanceof CancellationException) {
                        throw null;
                    }
                    throw null;
                }
                th5.getCause();
                throw null;
            }
            setValue(t16);
        }

        final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException unused) {
                if (!this.thrownByExecute) {
                } else {
                    throw null;
                }
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean isDone() {
            throw null;
        }

        abstract void setValue(T t16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class CombinedFutureRunningState extends AggregateFuture<Object, V>.RunningState {
        private CombinedFutureInterruptibleTask D;
        final /* synthetic */ CombinedFuture this$0;

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        void m() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.D;
            combinedFutureInterruptibleTask.getClass();
            combinedFutureInterruptibleTask.execute();
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        void p() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.D;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.interruptTask();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void r() {
            super.r();
            this.D = null;
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        void k(boolean z16, int i3, @NullableDecl Object obj) {
        }
    }
}
