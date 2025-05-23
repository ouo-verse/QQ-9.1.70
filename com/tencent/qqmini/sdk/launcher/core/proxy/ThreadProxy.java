package com.tencent.qqmini.sdk.launcher.core.proxy;

/* loaded from: classes23.dex */
public interface ThreadProxy {
    void runComputationTask(Runnable runnable);

    void runIOTask(Runnable runnable);

    void runNetTask(Runnable runnable);
}
