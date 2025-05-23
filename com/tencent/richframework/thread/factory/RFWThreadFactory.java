package com.tencent.richframework.thread.factory;

import androidx.annotation.CallSuper;
import com.tencent.richframework.thread.defend.RFWExceptionHandler;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWThreadFactory implements ThreadFactory {
    private final String mBaseName;
    private final AtomicInteger mCount = new AtomicInteger(0);
    private final ThreadFactory mDefaultThreadFactory = Executors.defaultThreadFactory();

    public RFWThreadFactory(String str) {
        this.mBaseName = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @CallSuper
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.mDefaultThreadFactory.newThread(runnable);
        newThread.setName(this.mBaseName + "-" + this.mCount.getAndIncrement() + "-" + newThread.getId());
        newThread.setUncaughtExceptionHandler(new RFWExceptionHandler());
        return newThread;
    }
}
