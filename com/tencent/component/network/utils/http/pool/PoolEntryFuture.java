package com.tencent.component.network.utils.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class PoolEntryFuture<T> implements Future<T> {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private final Condition condition;
    private final Lock lock;
    private T result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PoolEntryFuture(Lock lock, FutureCallback<T> futureCallback) {
        this.lock = lock;
        this.condition = lock.newCondition();
        this.callback = futureCallback;
    }

    public boolean await(Date date) throws InterruptedException {
        boolean z16;
        this.lock.lock();
        try {
            if (!this.cancelled) {
                if (date != null) {
                    z16 = this.condition.awaitUntil(date);
                } else {
                    this.condition.await();
                    z16 = true;
                }
                if (!this.cancelled) {
                    return z16;
                }
                throw new InterruptedException("Operation interrupted");
            }
            throw new InterruptedException("Operation interrupted");
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        this.lock.lock();
        try {
            if (this.completed) {
                this.lock.unlock();
                return false;
            }
            this.completed = true;
            this.cancelled = true;
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.cancelled();
            }
            this.condition.signalAll();
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        try {
            return get(0L, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e16) {
            throw new ExecutionException(e16);
        }
    }

    protected abstract T getPoolEntry(long j3, TimeUnit timeUnit) throws IOException, InterruptedException, TimeoutException;

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    public void wakeup() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        T t16;
        this.lock.lock();
        try {
            try {
                if (this.completed) {
                    t16 = this.result;
                } else {
                    this.result = getPoolEntry(j3, timeUnit);
                    this.completed = true;
                    FutureCallback<T> futureCallback = this.callback;
                    if (futureCallback != null) {
                        futureCallback.completed(this.result);
                    }
                    t16 = this.result;
                }
                return t16;
            } catch (IOException e16) {
                this.completed = true;
                this.result = null;
                FutureCallback<T> futureCallback2 = this.callback;
                if (futureCallback2 != null) {
                    futureCallback2.failed(e16);
                }
                throw new ExecutionException(e16);
            }
        } finally {
            this.lock.unlock();
        }
    }
}
