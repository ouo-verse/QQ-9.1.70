package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
/* loaded from: classes23.dex */
public class FPSCalculator {
    private static final int CALL_INTERVAL = 500;
    private static final String TAG = "FPSCalculator";
    private static volatile FPSCalculator sInstance;
    private Choreographer mChoreographer;
    private Choreographer.FrameCallback mFPSMeasuringCallback;
    private Handler mHandler;
    private long mFrameStartTime = 0;
    private int mFramesRendered = 0;
    private boolean mEnable = false;
    private Vector<GetFPSListener> mListener = new Vector<>();
    private Object mLock = new Object();
    private Runnable mInitFPSRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.monitor.common.FPSCalculator.1
        @Override // java.lang.Runnable
        @TargetApi(16)
        public void run() {
            try {
                if (FPSCalculator.this.mChoreographer != null) {
                    FPSCalculator.this.mChoreographer.removeFrameCallback(FPSCalculator.this.mFPSMeasuringCallback);
                } else {
                    FPSCalculator.this.mChoreographer = Choreographer.getInstance();
                }
                FPSCalculator.this.mChoreographer.postFrameCallback(FPSCalculator.this.mFPSMeasuringCallback);
            } catch (Exception e16) {
                if (QMLog.isColorLevel()) {
                    QMLog.d(FPSCalculator.TAG, "Choreographer.getInstance", e16);
                }
            }
            FPSCalculator.this.mHandler.removeCallbacks(FPSCalculator.this.mInitFPSRunnable);
        }
    };
    private Runnable mFakeFPSRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.monitor.common.FPSCalculator.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (FPSCalculator.this.mLock) {
                for (int i3 = 0; i3 < FPSCalculator.this.mListener.size(); i3++) {
                    GetFPSListener getFPSListener = (GetFPSListener) FPSCalculator.this.mListener.get(i3);
                    FPSCalculator.this.mFrameStartTime = System.currentTimeMillis();
                    getFPSListener.onInfo(FPSCalculator.this.mFrameStartTime, 60.0d);
                }
            }
            FPSCalculator.this.mHandler.postDelayed(FPSCalculator.this.mFakeFPSRunnable, 500L);
        }
    };

    /* loaded from: classes23.dex */
    public interface GetFPSListener {
        void onInfo(long j3, double d16);
    }

    FPSCalculator() {
    }

    private void disable() {
        if (this.mEnable) {
            Choreographer choreographer = this.mChoreographer;
            if (choreographer != null) {
                choreographer.removeFrameCallback(this.mFPSMeasuringCallback);
                if (QMLog.isColorLevel()) {
                    QMLog.d(TAG, "removeFrameCallback ");
                }
            }
            this.mHandler.removeCallbacksAndMessages(Boolean.TRUE);
            this.mFrameStartTime = 0L;
            this.mFramesRendered = 0;
            this.mEnable = false;
            QMLog.d(TAG, "FPSCalculator set enable = false");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnFrame(long j3) {
        long nsToMs = nsToMs(j3);
        long j16 = this.mFrameStartTime;
        if (j16 <= 0) {
            this.mFrameStartTime = nsToMs;
        } else {
            long j17 = nsToMs - j16;
            this.mFramesRendered = this.mFramesRendered + 1;
            if (j17 > 500) {
                double d16 = (r2 * 1000) / j17;
                this.mFrameStartTime = nsToMs;
                this.mFramesRendered = 0;
                synchronized (this.mLock) {
                    for (int i3 = 0; i3 < this.mListener.size(); i3++) {
                        this.mListener.get(i3).onInfo(this.mFrameStartTime, d16);
                    }
                }
            }
        }
        this.mChoreographer.postFrameCallback(this.mFPSMeasuringCallback);
    }

    private void enable() {
        if (this.mEnable) {
            QMLog.d(TAG, "FPSCalculator is enable");
            return;
        }
        this.mEnable = true;
        QMLog.d(TAG, "FPSCalculator set enable = true");
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mFPSMeasuringCallback == null) {
            this.mFPSMeasuringCallback = new Choreographer.FrameCallback() { // from class: com.tencent.qqmini.sdk.monitor.common.FPSCalculator.3
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j3) {
                    FPSCalculator.this.doOnFrame(j3);
                }
            };
        }
        this.mHandler.post(this.mInitFPSRunnable);
    }

    public static FPSCalculator getInstance() {
        if (sInstance == null) {
            synchronized (FPSCalculator.class) {
                if (sInstance == null) {
                    sInstance = new FPSCalculator();
                }
            }
        }
        return sInstance;
    }

    private static long nsToMs(long j3) {
        return TimeUnit.NANOSECONDS.toMillis(j3);
    }

    public void addListener(GetFPSListener getFPSListener) {
        synchronized (this.mLock) {
            if (!this.mListener.contains(getFPSListener)) {
                this.mListener.add(getFPSListener);
            }
            if (this.mListener.size() > 0) {
                enable();
            }
        }
    }

    public boolean isObserved(GetFPSListener getFPSListener) {
        return this.mListener.contains(getFPSListener);
    }

    public void removeListener(GetFPSListener getFPSListener) {
        synchronized (this.mLock) {
            if (this.mListener.contains(getFPSListener)) {
                this.mListener.remove(getFPSListener);
            }
            if (this.mListener.size() <= 0) {
                disable();
            }
        }
    }
}
