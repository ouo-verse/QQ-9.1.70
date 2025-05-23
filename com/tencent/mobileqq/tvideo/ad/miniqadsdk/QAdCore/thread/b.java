package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread;

import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface b extends Executor {
    void d(Runnable runnable);

    void executeDelay(Runnable runnable, long j3);

    void f(Runnable runnable);
}
