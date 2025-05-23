package com.tencent.vas.update.module.thread;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThreadManager {
    private static final int MAX_RUNNING_THREAD = 5;
    private static final int MAX_TIMER_THREAD = 2;
    private static final String TAG = "VasUpdate_ThreadManager";
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_TIMER = 2;
    public static ThreadManager sInstance;
    private ScheduledExecutorService mRunnerExecutor;
    private ScheduledExecutorService mTimerExecutor;

    ThreadManager() {
        try {
            this.mRunnerExecutor = new BaseScheduledThreadPoolExecutor(5, new CommonThreadFactory("vas_update_system_download"));
            this.mTimerExecutor = new BaseScheduledThreadPoolExecutor(2, new CommonThreadFactory("vas_update_system_timer"));
        } catch (Throwable th5) {
            VasUpdateWrapper.getLog().e(ThreadManagerV2.TAG, "new fixed thread pool failed: " + th5.getMessage(), th5);
            this.mRunnerExecutor = new BaseScheduledThreadPoolExecutor(5, new CommonThreadFactory("vas_update_system_exp"));
            this.mTimerExecutor = new BaseScheduledThreadPoolExecutor(2, new CommonThreadFactory("vas_update_system_timer"));
        }
    }

    public static synchronized ThreadManager getInstance() {
        ThreadManager threadManager;
        synchronized (ThreadManager.class) {
            if (sInstance == null) {
                synchronized (ThreadManager.class) {
                    if (sInstance == null) {
                        sInstance = new ThreadManager();
                    }
                }
            }
            threadManager = sInstance;
        }
        return threadManager;
    }

    public void onDestory() {
        this.mRunnerExecutor.shutdownNow();
        this.mTimerExecutor.shutdownNow();
        sInstance = null;
    }

    public void post(int i3, Runnable runnable) {
        if (i3 == 1) {
            post(runnable);
        } else {
            this.mTimerExecutor.submit(runnable);
        }
    }

    public ScheduledFuture postDelay(int i3, Runnable runnable, long j3) {
        ScheduledExecutorService scheduledExecutorService;
        if (i3 == 2) {
            scheduledExecutorService = this.mTimerExecutor;
        } else {
            scheduledExecutorService = this.mRunnerExecutor;
        }
        return scheduledExecutorService.schedule(runnable, j3, TimeUnit.MILLISECONDS);
    }

    public void post(Runnable runnable) {
        try {
            this.mRunnerExecutor.submit(runnable);
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "post exception", th5);
        }
    }
}
