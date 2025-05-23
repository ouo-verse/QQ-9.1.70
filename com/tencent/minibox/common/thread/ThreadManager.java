package com.tencent.minibox.common.thread;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.proxy.ExecutorProxy;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class ThreadManager {
    private static final int MAX_RUNNING_THREAD = 4;
    private static final String TAG = "ThreadManager";
    private static final String THREAD_NAME_PREFIX = "minibox";
    private static volatile ThreadManager sInstance;
    private ExecutorProxy mExecutor;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public static class MyExecutorProxy implements ExecutorProxy {
        private final ScheduledExecutorService innerExecutorImpl = ProxyExecutors.newScheduledThreadPool(4, new a("minibox"));

        MyExecutorProxy() {
        }

        @Override // com.tencent.minibox.proxy.ExecutorProxy
        public void execute(@NonNull Runnable runnable) {
            this.innerExecutorImpl.execute(runnable);
        }

        @Override // com.tencent.minibox.proxy.ExecutorProxy
        public void executeDelay(@NonNull Runnable runnable, long j3) {
            this.innerExecutorImpl.schedule(runnable, j3, TimeUnit.MILLISECONDS);
        }
    }

    ThreadManager() {
    }

    private void ensureExecutor() {
        if (this.mExecutor == null) {
            this.mExecutor = new MyExecutorProxy();
        }
    }

    public static ThreadManager get() {
        if (sInstance == null) {
            synchronized (ThreadManager.class) {
                if (sInstance == null) {
                    sInstance = new ThreadManager();
                }
            }
        }
        return sInstance;
    }

    public void execute(Runnable runnable) {
        try {
            ensureExecutor();
            this.mExecutor.execute(runnable);
        } catch (Throwable th5) {
            LogUtils.e("ThreadManager", "start: failed ---> ", th5);
        }
    }

    public void executeDelay(Runnable runnable, long j3) {
        try {
            ensureExecutor();
            this.mExecutor.executeDelay(runnable, j3);
        } catch (Throwable th5) {
            LogUtils.e("ThreadManager", "start: failed ---> ", th5);
        }
    }

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public void setExecutorProxy(ExecutorProxy executorProxy) {
        if (executorProxy != null) {
            this.mExecutor = executorProxy;
        }
    }
}
