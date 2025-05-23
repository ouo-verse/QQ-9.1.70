package com.tencent.qqlive.module.videoreport.task;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IThreadTaskInterceptor {
    boolean removePendingTask(Runnable runnable);

    boolean shouldInterceptTask(Runnable runnable);
}
