package com.tencent.tdf.vsync;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.TDFJNI;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes26.dex */
public class FixedIntervalPipelineDriver implements IPipelineDriver {
    static IPatchRedirector $redirector_;
    private Handler mHandler;
    private long mInterval;
    private boolean mIsDriverStarted;
    private volatile boolean mIsPipelineDriverTaskFinished;
    private long mPipelineDriver;
    private Timer mTimer;

    /* loaded from: classes26.dex */
    class PipelineDriverRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private long mPipelineDriver;

        public PipelineDriverRunnable(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FixedIntervalPipelineDriver.this, Long.valueOf(j3));
            } else {
                this.mPipelineDriver = j3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TDFJNI.nativeOnDrive(this.mPipelineDriver);
                FixedIntervalPipelineDriver.this.mIsPipelineDriverTaskFinished = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class PipelineDriverTimerTask extends TimerTask {
        static IPatchRedirector $redirector_;
        private PipelineDriverRunnable mPipelineDriverRunnable;

        public PipelineDriverTimerTask(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FixedIntervalPipelineDriver.this, Long.valueOf(j3));
            } else {
                this.mPipelineDriverRunnable = new PipelineDriverRunnable(j3);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (FixedIntervalPipelineDriver.this.mIsPipelineDriverTaskFinished) {
                FixedIntervalPipelineDriver.this.mIsPipelineDriverTaskFinished = false;
                FixedIntervalPipelineDriver.this.mHandler.post(this.mPipelineDriverRunnable);
            }
        }
    }

    public FixedIntervalPipelineDriver(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.mInterval = 8L;
        this.mIsPipelineDriverTaskFinished = true;
        this.mIsDriverStarted = false;
        this.mTimer = new BaseTimer();
        this.mHandler = new Handler(Looper.getMainLooper());
        if (j3 > 0) {
            this.mInterval = j3;
        }
    }

    private void startDriver(long j3) {
        this.mPipelineDriver = j3;
        this.mTimer.cancel();
        BaseTimer baseTimer = new BaseTimer();
        this.mTimer = baseTimer;
        baseTimer.scheduleAtFixedRate(new PipelineDriverTimerTask(j3), 0L, this.mInterval);
    }

    @Override // com.tencent.tdf.vsync.IPipelineDriver
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.mIsDriverStarted) {
            startDriver(this.mPipelineDriver);
        }
    }

    @Override // com.tencent.tdf.vsync.IPipelineDriver
    public void start(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.mIsDriverStarted = true;
            startDriver(j3);
        }
    }

    @Override // com.tencent.tdf.vsync.IPipelineDriver
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mTimer.cancel();
        }
    }
}
