package com.tencent.gamecenter.wadl.sdk.common.b.j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c extends LinkedBlockingQueue<Runnable> {

    /* renamed from: a, reason: collision with root package name */
    private e f107041a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f107042b;

    public c() {
        this.f107041a = null;
        this.f107042b = null;
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Runnable take() {
        e eVar = this.f107041a;
        if (eVar == null || !eVar.a()) {
            return (Runnable) super.take();
        }
        e eVar2 = this.f107041a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return poll(eVar2.getKeepAliveTime(timeUnit), timeUnit);
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        Integer num = this.f107042b;
        if (num != null) {
            return num.intValue();
        }
        return super.remainingCapacity();
    }

    public c(int i3) {
        super(i3);
        this.f107041a = null;
        this.f107042b = null;
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Runnable poll(long j3, TimeUnit timeUnit) {
        e eVar;
        Runnable runnable = (Runnable) super.poll(j3, timeUnit);
        if (runnable == null && (eVar = this.f107041a) != null) {
            eVar.c();
        }
        return runnable;
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean offer(Runnable runnable) {
        e eVar = this.f107041a;
        if (eVar != null && eVar.getPoolSize() != this.f107041a.getMaximumPoolSize() && this.f107041a.b() >= this.f107041a.getPoolSize() && this.f107041a.getPoolSize() < this.f107041a.getMaximumPoolSize()) {
            return false;
        }
        return super.offer(runnable);
    }

    public boolean a(Runnable runnable, long j3, TimeUnit timeUnit) {
        if (this.f107041a.isShutdown()) {
            throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        return super.offer(runnable, j3, timeUnit);
    }
}
