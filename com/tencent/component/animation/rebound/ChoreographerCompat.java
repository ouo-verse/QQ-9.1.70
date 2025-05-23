package com.tencent.component.animation.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ChoreographerCompat {
    private static final long ONE_FRAME_MILLIS = 17;
    private Choreographer mChoreographer;
    private Handler mHandler;
    private static final boolean IS_JELLYBEAN_OR_HIGHER = true;
    private static ChoreographerCompat __instance = new ChoreographerCompat();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class FrameCallback {
        private Choreographer.FrameCallback mFrameCallback;
        private Runnable mRunnable;

        public abstract void doFrame(long j3);

        @TargetApi(16)
        Choreographer.FrameCallback getFrameCallback() {
            if (this.mFrameCallback == null) {
                this.mFrameCallback = new Choreographer.FrameCallback() { // from class: com.tencent.component.animation.rebound.ChoreographerCompat.FrameCallback.1
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long j3) {
                        FrameCallback.this.doFrame(j3);
                    }
                };
            }
            return this.mFrameCallback;
        }

        Runnable getRunnable() {
            if (this.mRunnable == null) {
                this.mRunnable = new Runnable() { // from class: com.tencent.component.animation.rebound.ChoreographerCompat.FrameCallback.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameCallback.this.doFrame(System.nanoTime());
                    }
                };
            }
            return this.mRunnable;
        }
    }

    ChoreographerCompat() {
        if (IS_JELLYBEAN_OR_HIGHER) {
            this.mChoreographer = getChoreographer();
        } else {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
    }

    @TargetApi(16)
    private void choreographerPostFrameCallback(Choreographer.FrameCallback frameCallback) {
        this.mChoreographer.postFrameCallback(frameCallback);
    }

    @TargetApi(16)
    private void choreographerPostFrameCallbackDelayed(Choreographer.FrameCallback frameCallback, long j3) {
        this.mChoreographer.postFrameCallbackDelayed(frameCallback, j3);
    }

    @TargetApi(16)
    private void choreographerRemoveFrameCallback(Choreographer.FrameCallback frameCallback) {
        this.mChoreographer.removeFrameCallback(frameCallback);
    }

    @TargetApi(16)
    private Choreographer getChoreographer() {
        return Choreographer.getInstance();
    }

    public static ChoreographerCompat getInstance() {
        return __instance;
    }

    public void postFrameCallback(FrameCallback frameCallback) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerPostFrameCallback(frameCallback.getFrameCallback());
        } else {
            this.mHandler.postDelayed(frameCallback.getRunnable(), 0L);
        }
    }

    public void postFrameCallbackDelayed(FrameCallback frameCallback, long j3) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerPostFrameCallbackDelayed(frameCallback.getFrameCallback(), j3);
        } else {
            this.mHandler.postDelayed(frameCallback.getRunnable(), j3 + 17);
        }
    }

    public void removeFrameCallback(FrameCallback frameCallback) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerRemoveFrameCallback(frameCallback.getFrameCallback());
        } else {
            this.mHandler.removeCallbacks(frameCallback.getRunnable());
        }
    }
}
