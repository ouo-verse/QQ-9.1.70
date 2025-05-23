package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
@Beta
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class k<V> extends m<V> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class a<V> extends k<V> implements AbstractFuture.g<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.q
        public final void c(Runnable runnable, Executor executor) {
            super.c(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z16) {
            return super.cancel(z16);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j3, timeUnit);
        }
    }

    k() {
    }
}
