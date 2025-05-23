package com.huawei.hms.framework.common;

import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public class ScheduledThreadPoolExecutorEnhance extends BaseScheduledThreadPoolExecutor {
    private static final String TAG = "ScheduledThreadPoolExec";

    public ScheduledThreadPoolExecutorEnhance(int i3, ThreadFactory threadFactory) {
        super(i3, threadFactory);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof RunnableScheduledFutureEnhance) {
            String parentName = ((RunnableScheduledFutureEnhance) runnable).getParentName();
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

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new RunnableScheduledFutureEnhance(super.decorateTask(runnable, runnableScheduledFuture));
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new RunnableScheduledFutureEnhance(super.decorateTask(callable, runnableScheduledFuture));
    }
}
