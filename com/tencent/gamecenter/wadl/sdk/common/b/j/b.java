package com.tencent.gamecenter.wadl.sdk.common.b.j;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f107037d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f107038a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f107039b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private final String f107040c;

    public b(String str) {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f107038a = threadGroup;
        this.f107040c = str + "_" + f107037d.getAndIncrement() + "_thread_";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        BaseThread baseThread = new BaseThread(this.f107038a, runnable, this.f107040c + this.f107039b.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        try {
            baseThread.setPriority(5);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return baseThread;
    }
}
