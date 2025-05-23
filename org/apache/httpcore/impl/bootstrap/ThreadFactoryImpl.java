package org.apache.httpcore.impl.bootstrap;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes29.dex */
class ThreadFactoryImpl implements ThreadFactory {
    private final AtomicLong count;
    private final ThreadGroup group;
    private final String namePrefix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadFactoryImpl(String str, ThreadGroup threadGroup) {
        this.namePrefix = str;
        this.group = threadGroup;
        this.count = new AtomicLong();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new BaseThread(this.group, runnable, this.namePrefix + "-" + this.count.incrementAndGet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadFactoryImpl(String str) {
        this(str, null);
    }
}
