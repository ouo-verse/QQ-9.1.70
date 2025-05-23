package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Looper;
import android.util.Printer;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLooperHungDetector implements Printer {
    private static final String LOG_PREFIX_DISPATCHING = ">>>>> Dispatching";
    private static final String LOG_PREFIX_FINISHED = "<<<<< Finished";
    private final IOnLooperStunkCallback mCallback;
    private ScheduledFuture<?> mFuture = null;
    private final Thread mTargetThread;
    private final long mTimeoutMs;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IOnLooperStunkCallback {
        void onLooperStunk(String str);
    }

    TVKLooperHungDetector(Thread thread, long j3, IOnLooperStunkCallback iOnLooperStunkCallback) {
        this.mTargetThread = thread;
        this.mTimeoutMs = j3;
        this.mCallback = iOnLooperStunkCallback;
    }

    private void activateDetectionTask(final String str) {
        deactivateDetectionTask();
        this.mFuture = TVKThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                TVKLooperHungDetector.this.lambda$activateDetectionTask$0(str);
            }
        }, this.mTimeoutMs, TimeUnit.MILLISECONDS);
    }

    private void deactivateDetectionTask() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(true);
        this.mFuture = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$activateDetectionTask$0(String str) {
        StringBuilder sb5 = new StringBuilder("UNRESPONSIVE THREAD: " + this.mTargetThread + ". Enter log: " + str + ". Stack trace:\n");
        for (StackTraceElement stackTraceElement : this.mTargetThread.getStackTrace()) {
            sb5.append(stackTraceElement.toString());
            sb5.append("\n");
        }
        this.mCallback.onLooperStunk(sb5.toString());
    }

    public static void registerLooper(Looper looper, long j3, IOnLooperStunkCallback iOnLooperStunkCallback) {
        if (looper != null && iOnLooperStunkCallback != null) {
            looper.setMessageLogging(new TVKLooperHungDetector(looper.getThread(), j3, iOnLooperStunkCallback));
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (str == null) {
            return;
        }
        if (str.startsWith(LOG_PREFIX_DISPATCHING)) {
            activateDetectionTask(str);
        } else if (str.startsWith(LOG_PREFIX_FINISHED)) {
            deactivateDetectionTask();
        }
    }
}
