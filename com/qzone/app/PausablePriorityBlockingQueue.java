package com.qzone.app;

import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes39.dex */
public class PausablePriorityBlockingQueue<T> extends PriorityBlockingQueue<T> {
    private static final long serialVersionUID = 3726077277740650698L;

    /* renamed from: d, reason: collision with root package name */
    private transient ReentrantLock f44420d;

    /* renamed from: e, reason: collision with root package name */
    private transient Condition f44421e;
    private boolean isPaused;
    private int timeout;

    public PausablePriorityBlockingQueue() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f44420d = reentrantLock;
        this.f44421e = reentrantLock.newCondition();
        this.timeout = 10000;
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QUEUE_PAUSE_TIMEOUT, 10000);
        this.timeout = config;
        QZLog.i("PausablePriorityBlockingQueue", 2, "PausablePriorityBlockingQueue timeout:", Integer.valueOf(config));
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    public T poll() {
        this.f44420d.lock();
        while (this.isPaused) {
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean await = this.f44421e.await(this.timeout, TimeUnit.MILLISECONDS);
                    if (!await) {
                        resume();
                    }
                    QZLog.i("PausablePriorityBlockingQueue", 1, "poll 1 receive signal:", Boolean.valueOf(await), ",wait:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms,", "timeout:", Integer.valueOf(this.timeout));
                } catch (InterruptedException e16) {
                    QZLog.e("PausablePriorityBlockingQueue", 1, e16, new Object[0]);
                }
            } finally {
                this.f44420d.unlock();
            }
        }
        return (T) super.poll();
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        this.f44420d.lock();
        while (this.isPaused) {
            try {
                try {
                    QZLog.i("PausablePriorityBlockingQueue", 1, "take receive signal:", Boolean.valueOf(this.f44421e.await(this.timeout, TimeUnit.MILLISECONDS)), ",wait:", Long.valueOf(System.currentTimeMillis() - System.currentTimeMillis()), "ms,", "timeout:", Integer.valueOf(this.timeout));
                } catch (InterruptedException e16) {
                    QZLog.e("PausablePriorityBlockingQueue", 1, e16, new Object[0]);
                }
            } finally {
                this.f44420d.unlock();
            }
        }
        return (T) super.take();
    }

    public void pause() {
        QZLog.i("PausablePriorityBlockingQueue", 2, "pause queue,\u963b\u585e\u83b7\u53d6\u4efb\u52a1\u961f\u5217\u7684\u4efb\u52a1");
        this.f44420d.lock();
        try {
            this.isPaused = true;
        } finally {
            this.f44420d.unlock();
        }
    }

    public void resume() {
        QZLog.i("PausablePriorityBlockingQueue", 2, "resume queue\uff0c\u6062\u590d\u4efb\u52a1\u961f\u5217");
        this.f44420d.lock();
        try {
            this.isPaused = false;
            this.f44421e.signalAll();
        } finally {
            this.f44420d.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public T poll(long j3, TimeUnit timeUnit) throws InterruptedException {
        this.f44420d.lock();
        while (this.isPaused) {
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean await = this.f44421e.await(this.timeout, TimeUnit.MILLISECONDS);
                    if (!await) {
                        QZLog.i("PausablePriorityBlockingQueue", 1, "\u8d85\u65f6\u7684\u60c5\u51b5\u4e0b\uff0c\u81ea\u52a8\u6062\u590d\u72b6\u6001");
                        resume();
                    }
                    QZLog.i("PausablePriorityBlockingQueue", 1, "poll 2 receive signal:", Boolean.valueOf(await), ",wait:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms,", "timeout:", Integer.valueOf(this.timeout));
                } catch (InterruptedException e16) {
                    QZLog.e("PausablePriorityBlockingQueue", 1, e16, new Object[0]);
                }
            } finally {
                this.f44420d.unlock();
            }
        }
        return (T) super.poll(j3, timeUnit);
    }
}
