package com.tencent.gdtad.basics.adshake.animatorview.render;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.GroupLayer;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class BaseAnimatorRender<T extends View> implements IAnimatorRender, Animator.AnimatorListener {
    private static final int EVENT_POST_FRAME_CALLBACK = 1;
    private static final int EVENT_REMOVE_FRAME_CALLBACK = 2;
    private static final long NANOS_PER_MS = 1000000;
    private static final String TAG = "BaseAnimatorRender";
    private Animator.AnimatorListener mAnimatorListener;
    private int mFinishedLayerCount;
    private Paint mFrameRatePaint;
    private BaseAnimatorRender<T>.RenderHandler mRenderHandler;
    private volatile boolean mRunning;
    protected T mView;
    private volatile boolean mPaused = false;
    private volatile boolean mIsUserStarted = false;
    private volatile boolean mSurfaceCreated = false;
    private final List<AnimatorLayer> mLayerList = new CopyOnWriteArrayList();
    private final Matrix mMatrix = new Matrix();
    protected boolean mIsInDebug = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class RenderHandler extends Handler implements Choreographer.FrameCallback {
        private int mFps;
        private int mFrameCount;
        private long mLastFrameTimeNanos;
        private long mStartFrameTimeNanos;

        RenderHandler(Looper looper) {
            super(looper);
        }

        private void computeFps(long j3) {
            if (this.mStartFrameTimeNanos == 0) {
                this.mStartFrameTimeNanos = j3;
            }
            long j16 = (j3 - this.mStartFrameTimeNanos) / 1000000;
            if (j16 > 500) {
                this.mFps = (int) ((this.mFrameCount * 1000) / j16);
                this.mFrameCount = 0;
                this.mStartFrameTimeNanos = 0L;
                return;
            }
            this.mFrameCount++;
        }

        private void drawFrameRate(Canvas canvas) {
            BaseAnimatorRender baseAnimatorRender = BaseAnimatorRender.this;
            if (baseAnimatorRender.mIsInDebug && canvas != null) {
                try {
                    if (baseAnimatorRender.mFrameRatePaint == null) {
                        BaseAnimatorRender.this.mFrameRatePaint = new Paint();
                        BaseAnimatorRender.this.mFrameRatePaint.setFlags(1);
                        BaseAnimatorRender.this.mFrameRatePaint.setAntiAlias(true);
                        BaseAnimatorRender.this.mFrameRatePaint.setColor(SupportMenu.CATEGORY_MASK);
                        BaseAnimatorRender.this.mFrameRatePaint.setTextSize(20.0f);
                    }
                    canvas.drawText("fps:" + this.mFps, 10.0f, 50.0f, BaseAnimatorRender.this.mFrameRatePaint);
                } catch (Throwable unused) {
                }
            }
        }

        private void postFrameCallback() {
            try {
                Choreographer.getInstance().removeFrameCallback(this);
                Choreographer.getInstance().postFrameCallback(this);
            } catch (Throwable unused) {
            }
        }

        private void removeFrameCallback() {
            try {
                Choreographer.getInstance().removeFrameCallback(this);
            } catch (Throwable unused) {
            }
        }

        private void renderFrame(long j3) {
            Canvas lockCanvas;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (BaseAnimatorRender.this.mRunning) {
                Canvas canvas = null;
                try {
                    try {
                        lockCanvas = BaseAnimatorRender.this.lockCanvas();
                        if (lockCanvas != null) {
                            try {
                                if (BaseAnimatorRender.this.mPaused) {
                                    BaseAnimatorRender.this.clearCanvas(lockCanvas);
                                } else {
                                    BaseAnimatorRender.this.drawFrame(lockCanvas, elapsedRealtime, j3);
                                    drawFrameRate(lockCanvas);
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                canvas = lockCanvas;
                                try {
                                    QLog.d(BaseAnimatorRender.TAG, 1, "unlockCanvasAndPost error.", th);
                                    BaseAnimatorRender.this.mRunning = false;
                                    if (canvas != null) {
                                        BaseAnimatorRender.this.unlockCanvasAndPost(canvas);
                                    }
                                    postFrameCallback();
                                    return;
                                } catch (Throwable th6) {
                                    if (canvas != null) {
                                        try {
                                            BaseAnimatorRender.this.unlockCanvasAndPost(canvas);
                                        } catch (Throwable th7) {
                                            QLog.d(BaseAnimatorRender.TAG, 1, "unlock draw canvas error.", th7);
                                        }
                                    }
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                    if (lockCanvas != null) {
                        BaseAnimatorRender.this.unlockCanvasAndPost(lockCanvas);
                    }
                } catch (Throwable th9) {
                    QLog.d(BaseAnimatorRender.TAG, 1, "unlock draw canvas error.", th9);
                }
                postFrameCallback();
                return;
            }
            removeFrameCallback();
            BaseAnimatorRender.this.clearCanvas();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            if (!BaseAnimatorRender.this.mSurfaceCreated) {
                return;
            }
            long j16 = this.mLastFrameTimeNanos;
            long j17 = 0;
            if (j16 > 0) {
                j17 = (j3 - j16) / 1000000;
            }
            this.mLastFrameTimeNanos = j3;
            renderFrame(j17);
            if (BaseAnimatorRender.this.mIsInDebug) {
                computeFps(j3);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    removeFrameCallback();
                    BaseAnimatorRender.this.clearCanvas();
                    return;
                }
                return;
            }
            postFrameCallback();
        }

        public void reset() {
            this.mStartFrameTimeNanos = 0L;
            this.mLastFrameTimeNanos = 0L;
            this.mFrameCount = 0;
            this.mFps = 0;
        }
    }

    public BaseAnimatorRender(T t16) {
        this.mView = t16;
    }

    private void drawGroupLayerFrame(Canvas canvas, GroupLayer groupLayer, long j3, long j16) {
        clearCanvas(canvas);
        Iterator<AnimatorLayer> it = groupLayer.getLayers().iterator();
        while (it.hasNext()) {
            Animator animator = it.next().getAnimator();
            if (animator != null && SystemClock.elapsedRealtime() - j3 >= animator.getStartDelay()) {
                animator.drawAnimationByFrame(canvas, j16, false, true);
            }
        }
    }

    private void drawLayerFrame(Canvas canvas, AnimatorLayer animatorLayer, long j3, long j16) {
        Animator animator = animatorLayer.getAnimator();
        if (animator == null) {
            if (animatorLayer instanceof GroupLayer) {
                drawGroupLayerFrame(canvas, (GroupLayer) animatorLayer, j3, j16);
                return;
            }
            QLog.d(TAG, 1, "animator can't be null! layer:" + animatorLayer);
            return;
        }
        if (SystemClock.elapsedRealtime() - j3 >= animator.getStartDelay()) {
            animator.drawAnimationByFrame(canvas, j16);
        }
    }

    private void resetAnimation() {
        Animator animator;
        for (AnimatorLayer animatorLayer : this.mLayerList) {
            if (animatorLayer != null && (animator = animatorLayer.getAnimator()) != null) {
                animator.reset();
            }
        }
    }

    private synchronized void startRender() {
        QLog.d(TAG, 1, "startRender, render: " + this.mRenderHandler);
        if (this.mRenderHandler == null) {
            this.mRenderHandler = new RenderHandler(ThreadManagerV2.getQQCommonThreadLooper());
            this.mRunning = true;
        }
        sendEventPostFrameCallback();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        if (animatorLayer != null) {
            animatorLayer.setMatrix(this.mMatrix);
            this.mLayerList.add(animatorLayer);
            animatorLayer.setAnimatorListener(this);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void clearCanvas() {
        Canvas canvas;
        QLog.d(TAG, 1, "clearCanvas");
        if (!this.mSurfaceCreated) {
            QLog.d(TAG, 1, "clearCanvas failed: surface destroyed");
            return;
        }
        try {
            canvas = lockCanvas();
            if (canvas != null) {
                try {
                    clearCanvas(canvas);
                } catch (Throwable unused) {
                    if (canvas == null) {
                        return;
                    }
                    unlockCanvasAndPost(canvas);
                }
            }
            if (canvas == null) {
                return;
            }
        } catch (Throwable unused2) {
            canvas = null;
        }
        try {
            unlockCanvasAndPost(canvas);
        } catch (Throwable unused3) {
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void clearLayers() {
        Iterator<AnimatorLayer> it = this.mLayerList.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.mLayerList.clear();
    }

    protected void drawFrame(Canvas canvas, long j3, long j16) {
        Iterator<AnimatorLayer> it = this.mLayerList.iterator();
        while (it.hasNext()) {
            drawLayerFrame(canvas, it.next(), j3, j16);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public boolean isUserStarted() {
        return this.mIsUserStarted;
    }

    protected abstract Canvas lockCanvas();

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        this.mFinishedLayerCount++;
        QLog.d(TAG, 1, "onAnimationFinish finished count:" + this.mFinishedLayerCount);
        if (this.mFinishedLayerCount >= this.mLayerList.size()) {
            this.mFinishedLayerCount = 0;
            Animator.AnimatorListener animatorListener = this.mAnimatorListener;
            if (animatorListener != null) {
                animatorListener.onAnimationFinish();
            }
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void pauseAnimation() {
        QLog.d(TAG, 1, "pauseAnimation");
        sendEventRemoveFrameCallback();
        this.mPaused = true;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        if (animatorLayer != null) {
            this.mLayerList.remove(animatorLayer);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.render.IAnimatorRender
    public void renderChanged() {
        QLog.d(TAG, 1, "renderChanged");
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.render.IAnimatorRender
    public void renderCreate() {
        this.mSurfaceCreated = true;
        if (this.mIsUserStarted) {
            resetAnimation();
            startAnimation();
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.render.IAnimatorRender
    public void renderDestroy() {
        QLog.d(TAG, 1, "renderDestroy");
        this.mSurfaceCreated = false;
        stopAnimation(true, false);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void resumeAnimation() {
        QLog.d(TAG, 1, "pauseAnimation");
        this.mPaused = false;
        sendEventPostFrameCallback();
    }

    protected void sendEventPostFrameCallback() {
        BaseAnimatorRender<T>.RenderHandler renderHandler;
        if (this.mRunning && (renderHandler = this.mRenderHandler) != null) {
            renderHandler.sendEmptyMessage(1);
        }
    }

    protected void sendEventRemoveFrameCallback() {
        BaseAnimatorRender<T>.RenderHandler renderHandler = this.mRenderHandler;
        if (renderHandler != null) {
            renderHandler.sendEmptyMessage(2);
        }
        this.mRunning = false;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.mAnimatorListener = animatorListener;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void startAnimation() {
        this.mIsUserStarted = true;
        this.mFinishedLayerCount = 0;
        if (this.mSurfaceCreated) {
            startRender();
            QLog.d(TAG, 1, "startAnimation: " + this.mRenderHandler);
            return;
        }
        QLog.d(TAG, 1, "startAnimation - surface not created");
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void stopAnimation() {
        stopAnimation(true, true);
    }

    protected abstract void unlockCanvasAndPost(Canvas canvas);

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void stopAnimation(boolean z16, boolean z17) {
        Animator animator;
        QLog.d(TAG, 1, "stopAnimation clearCanvas: " + z16);
        sendEventRemoveFrameCallback();
        for (AnimatorLayer animatorLayer : this.mLayerList) {
            if (animatorLayer != null && (animator = animatorLayer.getAnimator()) != null) {
                animator.cancelAnimation();
                animator.setAnimatorListener(null);
            }
        }
        this.mRunning = false;
        BaseAnimatorRender<T>.RenderHandler renderHandler = this.mRenderHandler;
        if (renderHandler != null) {
            renderHandler.removeCallbacksAndMessages(null);
            this.mRenderHandler = null;
        }
        this.mPaused = false;
        if (z17) {
            this.mIsUserStarted = false;
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void addLayer(int i3, AnimatorLayer animatorLayer) {
        if (animatorLayer != null) {
            animatorLayer.setMatrix(this.mMatrix);
            if (i3 <= this.mLayerList.size() && i3 >= 0) {
                this.mLayerList.add(i3, animatorLayer);
            } else {
                this.mLayerList.add(animatorLayer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanvas(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }
}
