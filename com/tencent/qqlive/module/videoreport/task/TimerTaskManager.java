package com.tencent.qqlive.module.videoreport.task;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.task.base.HandlerScheduledFuture;
import com.tencent.qqlive.module.videoreport.task.base.NamedThreadFactory;
import com.tencent.qqlive.module.videoreport.task.base.ScheduledHandlerExecutorService;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TimerTaskManager {
    private static final String TAG = "VR_TimerTaskManager";
    private static final String mIDPrefix = "VR_TimerTask_ID_";
    private ScheduledExecutorService mHandlerExecutor;
    private AtomicInteger mNextID;
    private ScheduledExecutorService mThreadExecutor;
    private ConcurrentHashMap<String, Future<?>> mWorkingGroup;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class SingletonHolder {
        private static TimerTaskManager mInstance = new TimerTaskManager();

        SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class WatcherRunnable implements Runnable {
        private boolean mIsPeriod;
        private String mKey;
        private Runnable mRunnable;

        WatcherRunnable(Runnable runnable, String str, boolean z16) {
            this.mRunnable = runnable;
            this.mKey = str;
            this.mIsPeriod = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mRunnable.run();
            } finally {
                if (!this.mIsPeriod) {
                    TimerTaskManager.this.mWorkingGroup.remove(this.mKey);
                }
            }
        }
    }

    private String addTimerTask(Runnable runnable, long j3, long j16, boolean z16) {
        boolean z17;
        ScheduledFuture<?> schedule;
        if (runnable == null) {
            if (!VideoReport.isDebugMode()) {
                return "";
            }
            throw new NullPointerException("runnable is null");
        }
        String str = mIDPrefix + this.mNextID.incrementAndGet();
        if (j16 > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        WatcherRunnable watcherRunnable = new WatcherRunnable(runnable, str, z17);
        if (z16) {
            schedule = this.mHandlerExecutor.scheduleAtFixedRate(watcherRunnable, j3, j16, TimeUnit.MILLISECONDS);
        } else if (j16 > 0) {
            schedule = this.mThreadExecutor.scheduleAtFixedRate(watcherRunnable, j3, j16, TimeUnit.MILLISECONDS);
        } else {
            schedule = this.mThreadExecutor.schedule(watcherRunnable, j3, TimeUnit.MILLISECONDS);
        }
        this.mWorkingGroup.put(str, schedule);
        return str;
    }

    public static TimerTaskManager getInstance() {
        return SingletonHolder.mInstance;
    }

    public String addAsyncTimerTask(Runnable runnable, long j3) {
        return addAsyncTimerTask(runnable, j3, -1L);
    }

    public String addUIThreadTimerTask(Runnable runnable, long j3) {
        return addUIThreadTimerTask(runnable, j3, -1L);
    }

    public void cancelTimerTask(String str) {
        Future<?> remove;
        if (!TextUtils.isEmpty(str) && (remove = this.mWorkingGroup.remove(str)) != null) {
            remove.cancel(!(remove instanceof HandlerScheduledFuture));
        }
    }

    public boolean isTaskInQueue(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mWorkingGroup.containsKey(str);
    }

    TimerTaskManager() {
        this.mWorkingGroup = new ConcurrentHashMap<>();
        this.mNextID = new AtomicInteger(0);
        this.mThreadExecutor = new BaseScheduledThreadPoolExecutor(4, new NamedThreadFactory(TAG), new ThreadPoolExecutor.AbortPolicy());
        this.mHandlerExecutor = new ScheduledHandlerExecutorService(Looper.getMainLooper());
    }

    public String addAsyncTimerTask(Runnable runnable, long j3, long j16) {
        return addTimerTask(runnable, j3, j16, false);
    }

    public String addUIThreadTimerTask(Runnable runnable, long j3, long j16) {
        return addTimerTask(runnable, j3, j16, true);
    }
}
