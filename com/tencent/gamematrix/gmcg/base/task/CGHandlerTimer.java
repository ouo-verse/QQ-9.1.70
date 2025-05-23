package com.tencent.gamematrix.gmcg.base.task;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGHandlerTimer {
    private Handler mHandler;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static abstract class TimerTask implements Runnable {
        private volatile boolean isCancelled;

        void cancel() {
            this.isCancelled = true;
        }

        public abstract void doRun();

        @Override // java.lang.Runnable
        public void run() {
            if (!this.isCancelled) {
                doRun();
            }
        }
    }

    public CGHandlerTimer() {
        this(new Handler(Looper.getMainLooper()));
    }

    public void cancel(TimerTask timerTask) {
        if (timerTask != null) {
            timerTask.cancel();
            this.mHandler.removeCallbacks(timerTask);
        }
    }

    public TimerTask schedule(final Runnable runnable, long j3, TimeUnit timeUnit) {
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer.1
            @Override // com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer.TimerTask
            public void doRun() {
                runnable.run();
            }
        };
        this.mHandler.postDelayed(timerTask, timeUnit.toMillis(j3));
        return timerTask;
    }

    public CGHandlerTimer(Handler handler) {
        this.mHandler = handler;
    }

    public TimerTask schedule(final Runnable runnable, long j3, final long j16, final TimeUnit timeUnit) {
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer.2
            @Override // com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer.TimerTask
            public void doRun() {
                runnable.run();
                CGHandlerTimer.this.mHandler.postDelayed(this, timeUnit.toMillis(j16));
            }
        };
        this.mHandler.postDelayed(timerTask, timeUnit.toMillis(j3));
        return timerTask;
    }
}
