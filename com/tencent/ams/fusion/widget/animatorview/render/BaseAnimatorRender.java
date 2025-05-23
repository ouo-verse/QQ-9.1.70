package com.tencent.ams.fusion.widget.animatorview.render;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateListener;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseAnimatorRender<T extends View> implements Animator.AnimatorListener, IAnimatorRender {
    static IPatchRedirector $redirector_ = null;
    private static final int EVENT_POST_FRAME_CALLBACK = 1;
    private static final int EVENT_REMOVE_FRAME_CALLBACK = 2;
    private static final long NANOS_PER_MS = 1000000;
    private static final String TAG = "BaseAnimatorRender";
    private Animator.AnimatorListener mAnimatorListener;
    protected boolean mEnableFrameRate;
    private int mFinishedLayerCount;
    private IFrameRateListener mFrameRateListener;
    private Paint mFrameRatePaint;
    protected boolean mIsInDebug;
    private volatile boolean mIsUserStarted;
    private final List<AnimatorLayer> mLayerList;
    private final Matrix mMatrix;
    private volatile boolean mPaused;
    private BaseAnimatorRender<T>.RenderHandler mRenderHandler;
    private HandlerThread mRenderThread;
    private volatile boolean mRunning;
    protected boolean mShowFrameRate;
    private volatile boolean mSurfaceCreated;
    protected T mView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class RenderHandler extends Handler implements Choreographer.FrameCallback {
        static IPatchRedirector $redirector_;
        private int mFps;
        private int mFrameCount;
        private long mLastFrameTimeNanos;
        private long mRenderStartTime;
        private long mStartFrameTimeNanos;

        RenderHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseAnimatorRender.this, (Object) looper);
            }
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
                Logger.d(BaseAnimatorRender.TAG, "computeFps() mFps: " + this.mFps + ", diffMs: " + j16);
                if (BaseAnimatorRender.this.mFrameRateListener != null) {
                    BaseAnimatorRender.this.mFrameRateListener.onFrameRate(this.mFps, j16);
                    return;
                }
                return;
            }
            this.mFrameCount++;
        }

        private void drawFrameRate(Canvas canvas) {
            BaseAnimatorRender baseAnimatorRender = BaseAnimatorRender.this;
            if (baseAnimatorRender.mEnableFrameRate && baseAnimatorRender.mShowFrameRate && canvas != null) {
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
            if (this.mRenderStartTime == 0) {
                this.mRenderStartTime = SystemClock.elapsedRealtime();
            }
            if (BaseAnimatorRender.this.mRunning) {
                if (!BaseAnimatorRender.this.isSurfaceValid()) {
                    return;
                }
                try {
                    try {
                        Canvas lockCanvas = BaseAnimatorRender.this.lockCanvas();
                        if (lockCanvas != null) {
                            if (BaseAnimatorRender.this.mPaused) {
                                BaseAnimatorRender.this.clearCanvas(lockCanvas);
                            } else {
                                BaseAnimatorRender.this.drawFrame(lockCanvas, this.mRenderStartTime, j3);
                                drawFrameRate(lockCanvas);
                            }
                        }
                        if (lockCanvas != null) {
                            BaseAnimatorRender.this.unlockCanvasAndPost(lockCanvas);
                        }
                    } catch (Throwable th5) {
                        try {
                            Logger.e(BaseAnimatorRender.TAG, "unlockCanvasAndPost error.", th5);
                            BaseAnimatorRender.this.mRunning = false;
                            if (0 != 0) {
                                BaseAnimatorRender.this.unlockCanvasAndPost(null);
                            }
                        } catch (Throwable th6) {
                            if (0 != 0) {
                                try {
                                    BaseAnimatorRender.this.unlockCanvasAndPost(null);
                                } catch (Throwable th7) {
                                    Logger.e(BaseAnimatorRender.TAG, "unlock draw canvas error.", th7);
                                }
                            }
                            throw th6;
                        }
                    }
                } catch (Throwable th8) {
                    Logger.e(BaseAnimatorRender.TAG, "unlock draw canvas error.", th8);
                }
                postFrameCallback();
                return;
            }
            removeFrameCallback();
            BaseAnimatorRender.this.clearCanvas();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            long j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            if (!BaseAnimatorRender.this.mSurfaceCreated) {
                return;
            }
            long j17 = this.mLastFrameTimeNanos;
            if (j17 > 0) {
                j16 = (j3 - j17) / 1000000;
            } else {
                j16 = 0;
            }
            if (AnimatorConfig.getMaxFrameRate() > 0 && j16 > 0 && j16 < 1000 / r4) {
                if (BaseAnimatorRender.this.mRunning) {
                    postFrameCallback();
                }
            } else {
                this.mLastFrameTimeNanos = j3;
                renderFrame(j16);
                if (BaseAnimatorRender.this.mEnableFrameRate) {
                    computeFps(j3);
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    Logger.i(BaseAnimatorRender.TAG, "RenderHandler EVENT_REMOVE_FRAME_CALLBACK");
                    removeFrameCallback();
                    BaseAnimatorRender.this.clearCanvas();
                    return;
                }
                return;
            }
            postFrameCallback();
        }

        public void reset() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            this.mStartFrameTimeNanos = 0L;
            this.mLastFrameTimeNanos = 0L;
            this.mFrameCount = 0;
            this.mFps = 0;
            this.mRenderStartTime = 0L;
        }
    }

    public BaseAnimatorRender(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
            return;
        }
        this.mPaused = false;
        this.mIsUserStarted = false;
        this.mSurfaceCreated = false;
        this.mLayerList = new CopyOnWriteArrayList();
        this.mMatrix = new Matrix();
        this.mView = t16;
        this.mIsInDebug = AnimatorUtils.isInDebug(t16.getContext());
    }

    private void drawGroupLayerFrame(Canvas canvas, GroupLayer groupLayer, long j3, long j16) {
        Iterator<AnimatorLayer> it = groupLayer.getLayers().iterator();
        while (it.hasNext()) {
            Animator animator = it.next().getAnimator();
            if (animator != null && SystemClock.elapsedRealtime() - j3 >= animator.getStartDelay()) {
                animator.drawAnimationByFrame(canvas, j16, true);
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
            Logger.e(TAG, "animator can't be null! layer:" + animatorLayer);
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

    private synchronized void startRenderThread() {
        Logger.d(TAG, "startRender, render thread: " + this.mRenderThread);
        if (this.mRenderThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Animator-Render-Thread");
            baseHandlerThread.start();
            this.mRenderHandler = new RenderHandler(baseHandlerThread.getLooper());
            this.mRenderThread = baseHandlerThread;
            this.mRunning = true;
        }
        sendEventPostFrameCallback();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) animatorLayer);
        } else if (animatorLayer != null) {
            animatorLayer.setMatrix(this.mMatrix);
            animatorLayer.setAnimatorListener(this);
            animatorLayer.setAnimatorRender(this);
            this.mLayerList.add(animatorLayer);
        }
    }

    public boolean addLayerToGroupLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) animatorLayer)).booleanValue();
        }
        if (this.mLayerList.size() > 0) {
            AnimatorLayer animatorLayer2 = this.mLayerList.get(0);
            if (animatorLayer2 instanceof GroupLayer) {
                ((GroupLayer) animatorLayer2).addLayers(animatorLayer);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearCanvas() {
        Canvas canvas;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        Logger.d(TAG, "clearCanvas");
        if (!this.mSurfaceCreated) {
            Logger.w(TAG, "clearCanvas failed: surface destroyed");
            return;
        }
        if (!isSurfaceValid()) {
            Logger.w(TAG, "clearCanvas failed: surface invalid");
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

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        for (AnimatorLayer animatorLayer : this.mLayerList) {
            animatorLayer.clear();
            animatorLayer.setAnimatorRender(null);
        }
        this.mLayerList.clear();
    }

    protected void drawFrame(Canvas canvas, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, canvas, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        clearCanvas(canvas);
        Iterator<AnimatorLayer> it = this.mLayerList.iterator();
        while (it.hasNext()) {
            drawLayerFrame(canvas, it.next(), j3, j16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public List<AnimatorLayer> getLayerList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mLayerList;
    }

    protected abstract boolean isSurfaceValid();

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public boolean isUserStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mIsUserStarted;
    }

    protected abstract Canvas lockCanvas();

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.mFinishedLayerCount++;
        Logger.d(TAG, "onAnimationFinish finished count:" + this.mFinishedLayerCount);
        if (this.mFinishedLayerCount >= this.mLayerList.size()) {
            this.mFinishedLayerCount = 0;
            Animator.AnimatorListener animatorListener = this.mAnimatorListener;
            if (animatorListener != null) {
                animatorListener.onAnimationFinish();
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void pauseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Logger.d(TAG, "pauseAnimation");
        sendEventRemoveFrameCallback();
        this.mPaused = true;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender
    public void postTaskOnRenderThread(Runnable runnable, boolean z16) {
        HandlerThread handlerThread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, runnable, Boolean.valueOf(z16));
            return;
        }
        if (runnable != null && this.mRunning && this.mRenderHandler != null && (handlerThread = this.mRenderThread) != null && handlerThread.isAlive()) {
            if (z16) {
                this.mRenderHandler.postAtFrontOfQueue(runnable);
            } else {
                this.mRenderHandler.post(runnable);
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) animatorLayer);
        } else if (animatorLayer != null) {
            this.mLayerList.remove(animatorLayer);
            animatorLayer.setAnimatorRender(null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender
    public void renderChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            Logger.d(TAG, "renderChanged");
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender
    public void renderCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Logger.d(TAG, "renderCreate");
        this.mSurfaceCreated = true;
        if (this.mIsUserStarted) {
            resetAnimation();
            startAnimation();
            Logger.d(TAG, "surfaceCreated - startAnimation");
            return;
        }
        Logger.w(TAG, "surfaceCreated - user not started");
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender
    public void renderDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Logger.i(TAG, "renderDestroy");
        this.mSurfaceCreated = false;
        stopAnimation(true, false);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void resumeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Logger.d(TAG, "resumeAnimation");
        this.mPaused = false;
        this.mRunning = true;
        sendEventPostFrameCallback();
    }

    protected void sendEventPostFrameCallback() {
        HandlerThread handlerThread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (this.mRunning && this.mRenderHandler != null && (handlerThread = this.mRenderThread) != null && handlerThread.isAlive()) {
            this.mRenderHandler.sendEmptyMessage(1);
        }
    }

    protected void sendEventRemoveFrameCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        HandlerThread handlerThread = this.mRenderThread;
        if (handlerThread != null && handlerThread.isAlive() && this.mRenderHandler != null) {
            Logger.i(TAG, "sendEventRemoveFrameCallback()");
            this.mRenderHandler.sendEmptyMessage(2);
        }
        this.mRunning = false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) animatorListener);
        } else {
            this.mAnimatorListener = animatorListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setEnableFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.mEnableFrameRate = z16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setFrameRateListener(IFrameRateListener iFrameRateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) iFrameRateListener);
        } else {
            this.mFrameRateListener = iFrameRateListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setShowFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.mShowFrameRate = z16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mIsUserStarted = true;
        this.mFinishedLayerCount = 0;
        if (this.mSurfaceCreated) {
            startRenderThread();
            Logger.d(TAG, QZoneJsConstants.ACTION_START_ANIMATION);
        } else {
            Logger.w(TAG, "startAnimation - surface not created");
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            stopAnimation(true, true);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    protected abstract void unlockCanvasAndPost(Canvas canvas);

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public synchronized void stopAnimation(boolean z16, boolean z17) {
        Animator animator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Logger.i(TAG, "stopAnimation clearCanvas: " + z16 + ", isUserStop: " + z17);
        sendEventRemoveFrameCallback();
        for (AnimatorLayer animatorLayer : this.mLayerList) {
            if (animatorLayer != null && (animator = animatorLayer.getAnimator()) != null) {
                animator.cancelAnimation();
                if (z17) {
                    animator.setAnimatorListener(null);
                }
            }
        }
        this.mRunning = false;
        HandlerThread handlerThread = this.mRenderThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                handlerThread.join(100L);
            } catch (Throwable unused) {
            }
            this.mRenderThread = null;
        }
        this.mPaused = false;
        if (z17) {
            this.mIsUserStarted = false;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(int i3, AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) animatorLayer);
            return;
        }
        if (animatorLayer != null) {
            animatorLayer.setMatrix(this.mMatrix);
            if (i3 <= this.mLayerList.size() && i3 >= 0) {
                this.mLayerList.add(i3, animatorLayer);
            } else {
                this.mLayerList.add(animatorLayer);
            }
            animatorLayer.setAnimatorRender(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanvas(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }
}
