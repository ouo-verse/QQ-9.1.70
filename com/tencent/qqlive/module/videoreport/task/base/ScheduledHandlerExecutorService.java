package com.tencent.qqlive.module.videoreport.task.base;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ScheduledHandlerExecutorService implements ScheduledExecutorService {
    private Handler mHandler;
    private BlockingQueue<HandlerScheduledFuture> mWorkQueue = new LinkedBlockingDeque();
    private volatile boolean mIsStopped = false;

    public ScheduledHandlerExecutorService(Looper looper) {
        this.mHandler = new Handler(looper);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        schedule(runnable, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.mIsStopped;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.mIsStopped;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j3, TimeUnit timeUnit) {
        if (this.mIsStopped) {
            return null;
        }
        HandlerScheduledFuture handlerScheduledFuture = new HandlerScheduledFuture(runnable, this.mHandler, timeUnit.convert(j3, TimeUnit.MILLISECONDS), 0L);
        this.mWorkQueue.add(handlerScheduledFuture);
        this.mHandler.postAtTime(handlerScheduledFuture, handlerScheduledFuture.setNextRunTime());
        return handlerScheduledFuture;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j3, long j16, TimeUnit timeUnit) {
        if (this.mIsStopped) {
            return null;
        }
        if (j16 > 0) {
            Handler handler = this.mHandler;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            HandlerScheduledFuture handlerScheduledFuture = new HandlerScheduledFuture(runnable, handler, timeUnit.convert(j3, timeUnit2), timeUnit.convert(j16, timeUnit2));
            this.mWorkQueue.add(handlerScheduledFuture);
            this.mHandler.postAtTime(handlerScheduledFuture, handlerScheduledFuture.setNextRunTime());
            return handlerScheduledFuture;
        }
        return schedule(runnable, j3, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j3, long j16, TimeUnit timeUnit) {
        if (this.mIsStopped) {
            return null;
        }
        if (j16 > 0) {
            Handler handler = this.mHandler;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            HandlerScheduledFuture handlerScheduledFuture = new HandlerScheduledFuture(runnable, handler, timeUnit.convert(j3, timeUnit2), timeUnit.convert(j16, timeUnit2));
            this.mWorkQueue.add(handlerScheduledFuture);
            this.mHandler.postAtTime(handlerScheduledFuture, handlerScheduledFuture.setNextRunTime());
            return handlerScheduledFuture;
        }
        return schedule(runnable, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        for (HandlerScheduledFuture handlerScheduledFuture : this.mWorkQueue) {
            if (handlerScheduledFuture != null) {
                handlerScheduledFuture.cancel(false);
            }
        }
        this.mWorkQueue.clear();
        this.mIsStopped = true;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        shutdown();
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Runnable runnable, T t16) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j3, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j3, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return schedule(callable, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return schedule(runnable, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j3, TimeUnit timeUnit) {
        if (this.mIsStopped) {
            return null;
        }
        HandlerScheduledFuture handlerScheduledFuture = new HandlerScheduledFuture(callable, this.mHandler, timeUnit.convert(j3, TimeUnit.MILLISECONDS), 0L);
        this.mWorkQueue.add(handlerScheduledFuture);
        this.mHandler.postAtTime(handlerScheduledFuture, handlerScheduledFuture.setNextRunTime());
        return handlerScheduledFuture;
    }
}
