package com.tencent.component.animation.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

/* compiled from: P */
/* loaded from: classes5.dex */
abstract class AndroidSpringLooperFactory {

    /* compiled from: P */
    @TargetApi(16)
    /* loaded from: classes5.dex */
    private static class ChoreographerAndroidSpringLooper extends SpringLooper {
        private final Choreographer mChoreographer;
        private final Choreographer.FrameCallback mFrameCallback = new Choreographer.FrameCallback() { // from class: com.tencent.component.animation.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j3) {
                if (ChoreographerAndroidSpringLooper.this.mStarted && ChoreographerAndroidSpringLooper.this.mSpringSystem != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ChoreographerAndroidSpringLooper.this.mSpringSystem.loop(uptimeMillis - r0.mLastTime);
                    ChoreographerAndroidSpringLooper.this.mLastTime = uptimeMillis;
                    ChoreographerAndroidSpringLooper.this.mChoreographer.postFrameCallback(ChoreographerAndroidSpringLooper.this.mFrameCallback);
                }
            }
        };
        private long mLastTime;
        private boolean mStarted;

        public ChoreographerAndroidSpringLooper(Choreographer choreographer) {
            this.mChoreographer = choreographer;
        }

        public static ChoreographerAndroidSpringLooper create() {
            return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
        }

        @Override // com.tencent.component.animation.rebound.SpringLooper
        public void start() {
            if (this.mStarted) {
                return;
            }
            this.mStarted = true;
            this.mLastTime = SystemClock.uptimeMillis();
            this.mChoreographer.removeFrameCallback(this.mFrameCallback);
            this.mChoreographer.postFrameCallback(this.mFrameCallback);
        }

        @Override // com.tencent.component.animation.rebound.SpringLooper
        public void stop() {
            this.mStarted = false;
            this.mChoreographer.removeFrameCallback(this.mFrameCallback);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class LegacyAndroidSpringLooper extends SpringLooper {
        private final Handler mHandler;
        private long mLastTime;
        private final Runnable mLooperRunnable = new Runnable() { // from class: com.tencent.component.animation.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper.1
            @Override // java.lang.Runnable
            public void run() {
                if (LegacyAndroidSpringLooper.this.mStarted && LegacyAndroidSpringLooper.this.mSpringSystem != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    LegacyAndroidSpringLooper.this.mSpringSystem.loop(uptimeMillis - r2.mLastTime);
                    LegacyAndroidSpringLooper.this.mHandler.post(LegacyAndroidSpringLooper.this.mLooperRunnable);
                }
            }
        };
        private boolean mStarted;

        public LegacyAndroidSpringLooper(Handler handler) {
            this.mHandler = handler;
        }

        public static SpringLooper create() {
            return new LegacyAndroidSpringLooper(new Handler());
        }

        @Override // com.tencent.component.animation.rebound.SpringLooper
        public void start() {
            if (this.mStarted) {
                return;
            }
            this.mStarted = true;
            this.mLastTime = SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mLooperRunnable);
            this.mHandler.post(this.mLooperRunnable);
        }

        @Override // com.tencent.component.animation.rebound.SpringLooper
        public void stop() {
            this.mStarted = false;
            this.mHandler.removeCallbacks(this.mLooperRunnable);
        }
    }

    AndroidSpringLooperFactory() {
    }

    public static SpringLooper createSpringLooper() {
        return ChoreographerAndroidSpringLooper.create();
    }
}
