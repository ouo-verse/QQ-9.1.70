package com.tencent.qqlive.module.videoreport.task.base;

import android.support.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final String mBaseName;
    private final AtomicInteger mCount = new AtomicInteger(0);
    private final ThreadFactory mDefaultThreadFactory = Executors.defaultThreadFactory();

    public NamedThreadFactory(String str) {
        this.mBaseName = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.mDefaultThreadFactory.newThread(runnable);
        if (newThread != null) {
            newThread.setName(this.mBaseName + "-" + this.mCount.getAndIncrement());
        }
        return newThread;
    }
}
