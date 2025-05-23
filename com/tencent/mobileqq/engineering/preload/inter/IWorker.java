package com.tencent.mobileqq.engineering.preload.inter;

import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IWorker<T> {
    void doPreLoad();

    void onRemove();

    void removeListener(OnTaskListener<T> onTaskListener);

    void setListener(OnTaskListener<T> onTaskListener);

    void setThreadPoolExecutor(ExecutorService executorService);
}
