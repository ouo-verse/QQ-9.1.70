package com.tencent.libra.thread;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class LibraThreadPool extends BaseThreadPoolExecutor {
    protected static final int CPU_COUNT;
    protected static final int DEFAULT_MAX_POOL_SIZE;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraThreadPool");
    private Handler mErrorHandler;

    /* loaded from: classes7.dex */
    private class RFWRejectedExecutionHandler implements RejectedExecutionHandler {
        public RFWRejectedExecutionHandler() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            RFWLog.e(LibraThreadPool.TAG, RFWLog.USR, "rejectedExecution:" + runnable.getClass().getName());
            LibraThreadPool.this.getRejectExecutionHandler().post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        DEFAULT_MAX_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    public LibraThreadPool(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i3, i16, j3, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
        setRejectedExecutionHandler(new RFWRejectedExecutionHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getRejectExecutionHandler() {
        if (this.mErrorHandler == null) {
            LibraThreadExecutor.g();
            this.mErrorHandler = LibraThreadExecutor.createNewThreadHandler("RFWErrorHandlerThread", 10, null);
        }
        return this.mErrorHandler;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (InternalError e16) {
            RFWLog.e(TAG, RFWLog.USR, "RFWThreadPool execute InternalError:" + e16.getMessage(), e16);
        } catch (OutOfMemoryError e17) {
            RFWLog.e(TAG, RFWLog.USR, "RFWThreadPool execute OutOfMemoryError:" + e17.getMessage(), e17);
            getRejectExecutionHandler().post(runnable);
        }
    }
}
