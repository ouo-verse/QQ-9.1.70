package com.huawei.hms.framework.common;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ThreadPoolExcutorEnhance extends BaseThreadPoolExecutor {
    public ThreadPoolExcutorEnhance(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i3, i16, j3, timeUnit, blockingQueue, threadFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof RunnableEnhance) {
            String parentName = ((RunnableEnhance) runnable).getParentName();
            int lastIndexOf = parentName.lastIndexOf(" -->");
            if (lastIndexOf != -1) {
                parentName = StringUtils.substring(parentName, lastIndexOf + 4);
            }
            String name = thread.getName();
            int lastIndexOf2 = name.lastIndexOf(" -->");
            if (lastIndexOf2 != -1) {
                name = StringUtils.substring(name, lastIndexOf2 + 4);
            }
            thread.setName(parentName + " -->" + name);
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.execute(new RunnableEnhance(runnable));
    }
}
