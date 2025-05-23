package com.tencent.richframework.thread.pool;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.thread.RFWThreadPoolExecuteListener;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes25.dex */
public class RFWThreadPool extends BaseThreadPoolExecutor {
    protected static final int CPU_COUNT;
    public static final int DEFAULT_MAX_POOL_SIZE;
    private Handler mErrorHandler;
    private RFWThreadPoolExecuteListener mExecuteListener;

    /* loaded from: classes25.dex */
    private class RFWRejectedExecutionHandler implements RejectedExecutionHandler {
        public RFWRejectedExecutionHandler() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            RFWLog.e("RFWThreadPool", RFWLog.USR, "rejectedExecution:" + runnable.getClass().getName());
            RFWThreadPool.this.getRejectExecutionHandler().post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        DEFAULT_MAX_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    public RFWThreadPool(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i3, i16, j3, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
        setRejectedExecutionHandler(new RFWRejectedExecutionHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getRejectExecutionHandler() {
        if (this.mErrorHandler == null) {
            this.mErrorHandler = RFWThreadManager.createNewThreadHandler("RFWErrorHandlerThread", 10);
        }
        return this.mErrorHandler;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th5) {
        super.afterExecute(runnable, th5);
        RFWThreadPoolExecuteListener rFWThreadPoolExecuteListener = this.mExecuteListener;
        if (rFWThreadPoolExecuteListener != null) {
            rFWThreadPoolExecuteListener.afterExecute(this, runnable, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        RFWThreadPoolExecuteListener rFWThreadPoolExecuteListener = this.mExecuteListener;
        if (rFWThreadPoolExecuteListener != null) {
            rFWThreadPoolExecuteListener.beforeExecute(this, thread, runnable);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (InternalError e16) {
            RFWLog.e("RFWThreadPool", RFWLog.USR, "RFWThreadPool execute InternalError:" + e16.getMessage(), e16);
        } catch (OutOfMemoryError e17) {
            RFWLog.e("RFWThreadPool", RFWLog.USR, "RFWThreadPool execute OutOfMemoryError:" + e17.getMessage(), e17);
            getRejectExecutionHandler().post(runnable);
        }
    }

    public void setExecuteListener(RFWThreadPoolExecuteListener rFWThreadPoolExecuteListener) {
        this.mExecuteListener = rFWThreadPoolExecuteListener;
    }
}
