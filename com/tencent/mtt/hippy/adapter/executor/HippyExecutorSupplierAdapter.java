package com.tencent.mtt.hippy.adapter.executor;

import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyExecutorSupplierAdapter {
    void destroyIfNeed();

    Executor getBackgroundTaskExecutor();

    Executor getDBExecutor();
}
