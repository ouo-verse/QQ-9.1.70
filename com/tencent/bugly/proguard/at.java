package com.tencent.bugly.proguard;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class at {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f98106a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static at f98107b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f98108c;

    protected at() {
        this.f98108c = null;
        ScheduledExecutorService newScheduledThreadPool = ProxyExecutors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.at.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                BaseThread baseThread = new BaseThread(runnable);
                baseThread.setName("BuglyThread-" + at.f98106a.getAndIncrement());
                return baseThread;
            }
        });
        this.f98108c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            av.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized at a() {
        at atVar;
        synchronized (at.class) {
            if (f98107b == null) {
                f98107b = new at();
            }
            atVar = f98107b;
        }
        return atVar;
    }

    public final synchronized boolean b() {
        ScheduledExecutorService scheduledExecutorService = this.f98108c;
        if (scheduledExecutorService != null) {
            if (!scheduledExecutorService.isShutdown()) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void a(ScheduledExecutorService scheduledExecutorService) {
        this.f98108c = scheduledExecutorService;
    }

    public final synchronized boolean a(Runnable runnable, long j3) {
        if (!b()) {
            av.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j3 <= 0) {
            j3 = 0;
        }
        av.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j3), runnable.getClass().getName());
        try {
            this.f98108c.schedule(runnable, j3, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th5) {
            if (p.f98529c) {
                th5.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!b()) {
            av.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            av.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        av.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f98108c.execute(runnable);
            return true;
        } catch (Throwable th5) {
            if (p.f98529c) {
                th5.printStackTrace();
            }
            return false;
        }
    }
}
