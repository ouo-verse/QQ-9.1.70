package com.tencent.mtt.hippy.modules.nativemodules;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippySettableFuture<T> implements Future<T> {
    private Exception mException;
    private final CountDownLatch mReadyLatch = new CountDownLatch(1);
    private T mResult;

    private void checkNotSet() {
        if (this.mReadyLatch.getCount() != 0) {
        } else {
            throw new RuntimeException("Result has already been set!");
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        this.mReadyLatch.await();
        if (this.mException == null) {
            return this.mResult;
        }
        throw new ExecutionException(this.mException);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (this.mReadyLatch.getCount() == 0) {
            return true;
        }
        return false;
    }

    public void set(T t16) {
        checkNotSet();
        this.mResult = t16;
        this.mReadyLatch.countDown();
    }

    public void setException(Exception exc) {
        checkNotSet();
        this.mException = exc;
        this.mReadyLatch.countDown();
    }

    @Override // java.util.concurrent.Future
    public T get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!this.mReadyLatch.await(j3, timeUnit)) {
            throw new TimeoutException("Timed out waiting for result");
        }
        if (this.mException == null) {
            return this.mResult;
        }
        throw new ExecutionException(this.mException);
    }
}
