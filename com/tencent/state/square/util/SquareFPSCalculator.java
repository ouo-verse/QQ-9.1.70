package com.tencent.state.square.util;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.state.square.SquareBaseKt;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/* loaded from: classes26.dex */
public class SquareFPSCalculator {
    private static final String TAG = "FPSCalculator";
    private static volatile SquareFPSCalculator sInstance;
    private Choreographer mChoreographer;
    private Choreographer.FrameCallback mFPSMeasuringCallback;
    private Handler mHandler;
    private int callInterval = 500;
    private long mFrameStartTime = 0;
    private int mFramesRendered = 0;
    private boolean mEnable = false;
    private final Vector<SquareFPSListener> mListener = new Vector<>();
    private final Object mLock = new Object();
    private final Runnable mInitFPSRunnable = new Runnable() { // from class: com.tencent.state.square.util.SquareFPSCalculator.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (SquareFPSCalculator.this.mChoreographer != null) {
                    SquareFPSCalculator.this.mChoreographer.removeFrameCallback(SquareFPSCalculator.this.mFPSMeasuringCallback);
                } else {
                    SquareFPSCalculator.this.mChoreographer = Choreographer.getInstance();
                }
                SquareFPSCalculator.this.mChoreographer.postFrameCallback(SquareFPSCalculator.this.mFPSMeasuringCallback);
            } catch (Exception unused) {
            }
            SquareFPSCalculator.this.mHandler.removeCallbacks(SquareFPSCalculator.this.mInitFPSRunnable);
        }
    };
    private final Runnable mFakeFPSRunnable = new Runnable() { // from class: com.tencent.state.square.util.SquareFPSCalculator.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (SquareFPSCalculator.this.mLock) {
                for (int i3 = 0; i3 < SquareFPSCalculator.this.mListener.size(); i3++) {
                    SquareFPSListener squareFPSListener = (SquareFPSListener) SquareFPSCalculator.this.mListener.get(i3);
                    SquareFPSCalculator.this.mFrameStartTime = System.currentTimeMillis();
                    squareFPSListener.onInfo(SquareFPSCalculator.this.mFrameStartTime, 60.0d);
                }
            }
            SquareFPSCalculator.this.mHandler.postDelayed(SquareFPSCalculator.this.mFakeFPSRunnable, SquareFPSCalculator.this.callInterval);
        }
    };

    /* loaded from: classes26.dex */
    public interface SquareFPSListener {
        void onInfo(long j3, double d16);
    }

    SquareFPSCalculator() {
    }

    private void disable() {
        if (this.mEnable) {
            Choreographer choreographer = this.mChoreographer;
            if (choreographer != null) {
                choreographer.removeFrameCallback(this.mFPSMeasuringCallback);
                SquareBaseKt.getSquareLog().d(TAG, "removeFrameCallback ");
            }
            this.mHandler.removeCallbacksAndMessages(Boolean.TRUE);
            this.mFrameStartTime = 0L;
            this.mFramesRendered = 0;
            this.mEnable = false;
            SquareBaseKt.getSquareLog().d(TAG, "FPSCalculator set enable = false");
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
            if (j17 > this.callInterval) {
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
            SquareBaseKt.getSquareLog().d(TAG, "FPSCalculator is enable");
            return;
        }
        this.mEnable = true;
        SquareBaseKt.getSquareLog().d(TAG, "FPSCalculator set enable = true");
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mFPSMeasuringCallback == null) {
            this.mFPSMeasuringCallback = new Choreographer.FrameCallback() { // from class: com.tencent.state.square.util.a
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j3) {
                    SquareFPSCalculator.this.doOnFrame(j3);
                }
            };
        }
        this.mHandler.post(this.mInitFPSRunnable);
    }

    public static SquareFPSCalculator getInstance() {
        if (sInstance == null) {
            synchronized (SquareFPSCalculator.class) {
                if (sInstance == null) {
                    sInstance = new SquareFPSCalculator();
                }
            }
        }
        return sInstance;
    }

    private static long nsToMs(long j3) {
        return TimeUnit.NANOSECONDS.toMillis(j3);
    }

    public void addListener(SquareFPSListener squareFPSListener) {
        synchronized (this.mLock) {
            if (!this.mListener.contains(squareFPSListener)) {
                this.mListener.add(squareFPSListener);
            }
            enable();
        }
    }

    public boolean isObserved(SquareFPSListener squareFPSListener) {
        return this.mListener.contains(squareFPSListener);
    }

    public void removeListener(SquareFPSListener squareFPSListener) {
        synchronized (this.mLock) {
            this.mListener.remove(squareFPSListener);
            if (this.mListener.isEmpty()) {
                disable();
            }
        }
    }

    public void setInterval(int i3) {
        this.callInterval = i3;
    }
}
