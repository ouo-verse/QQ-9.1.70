package org.apache.httpcore.concurrent;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;

    /* renamed from: ex, reason: collision with root package name */
    private volatile Exception f423544ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    private T getResult() throws ExecutionException {
        if (this.f423544ex == null) {
            if (!this.cancelled) {
                return this.result;
            }
            throw new CancellationException();
        }
        throw new ExecutionException(this.f423544ex);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.cancelled = true;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.cancelled();
            }
            return true;
        }
    }

    public boolean completed(T t16) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.result = t16;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.completed(t16);
            }
            return true;
        }
    }

    public boolean failed(Exception exc) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.f423544ex = exc;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.failed(exc);
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() throws InterruptedException, ExecutionException {
        while (!this.completed) {
            LockMethodProxy.wait(this);
        }
        return getResult();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j3);
        long currentTimeMillis = millis <= 0 ? 0L : System.currentTimeMillis();
        if (this.completed) {
            return getResult();
        }
        if (millis > 0) {
            long j16 = millis;
            do {
                wait(j16);
                if (this.completed) {
                    return getResult();
                }
                j16 = millis - (System.currentTimeMillis() - currentTimeMillis);
            } while (j16 > 0);
            throw new TimeoutException();
        }
        throw new TimeoutException();
    }

    @Override // org.apache.httpcore.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
