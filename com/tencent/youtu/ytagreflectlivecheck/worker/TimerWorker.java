package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class TimerWorker {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CloudFaceCountDownTimer";
    private boolean mCancelled;
    private final long mCountdownInterval;
    private final long mMillisInFuture;
    private long mStopTimeInFuture;
    private Timer mTimer;
    private TimerTask mTimerTask;

    public TimerWorker(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.mCancelled = false;
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[TimerWorker.TimerWorker] mCountDownTimer");
        this.mMillisInFuture = j3;
        this.mCountdownInterval = j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueTimerJudge() {
        if (this.mCancelled) {
            return;
        }
        long elapsedRealtime = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.mTimer.cancel();
            onFinish();
        } else if (elapsedRealtime >= this.mCountdownInterval) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            onTick(elapsedRealtime);
            long elapsedRealtime3 = (elapsedRealtime2 + this.mCountdownInterval) - SystemClock.elapsedRealtime();
            while (elapsedRealtime3 < 0) {
                elapsedRealtime3 += this.mCountdownInterval;
            }
        }
    }

    public final synchronized void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mCancelled = true;
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mTimerTask = null;
        }
    }

    public abstract void onFinish();

    public abstract void onTick(long j3);

    public final synchronized TimerWorker start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TimerWorker) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        this.mCancelled = false;
        if (this.mMillisInFuture <= 0) {
            onFinish();
            return this;
        }
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
        this.mTimer = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TimerWorker.this);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (!TimerWorker.this.mCancelled) {
                    TimerWorker.this.continueTimerJudge();
                }
            }
        };
        this.mTimerTask = timerTask;
        this.mTimer.schedule(timerTask, 0L, this.mCountdownInterval);
        return this;
    }
}
