package org.apache.httpcore.impl.bootstrap;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class WorkerPoolExecutor extends BaseThreadPoolExecutor {
    private final Map<Worker, Boolean> workerSet;

    public WorkerPoolExecutor(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i3, i16, j3, timeUnit, blockingQueue, threadFactory);
        this.workerSet = new ConcurrentHashMap();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th5) {
        if (runnable instanceof Worker) {
            this.workerSet.remove(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof Worker) {
            this.workerSet.put((Worker) runnable, Boolean.TRUE);
        }
    }

    public Set<Worker> getWorkers() {
        return new HashSet(this.workerSet.keySet());
    }
}
