package com.tencent.ams.fusion.widget.animatorview.render;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class OldBaseAnimatorRender<T> implements Animator.AnimatorListener, IAnimatorRender {
    static IPatchRedirector $redirector_ = null;
    private static final int FRAME_STEP = 10;
    private static final int JOIN_TIME_OUT_MS = 100;
    private static final String TAG = "OldBaseAnimatorRender";
    private Animator.AnimatorListener mAnimatorListener;
    private volatile boolean mClearCanvasWhenStop;
    private int mFinishedLayerCount;
    private volatile boolean mIsUserStarted;
    private List<AnimatorLayer> mLayerList;
    private final Matrix mMatrix;
    private volatile boolean mPaused;
    private int mPerFrameCost;
    private final byte[] mRenderLock;
    private volatile Thread mRenderThread;
    private volatile boolean mRunning;
    private volatile boolean mSurfaceCreated;
    protected T mView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public final class RenderThread extends BaseThread {
        static IPatchRedirector $redirector_;

        RenderThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) OldBaseAnimatorRender.this);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Logger.d(OldBaseAnimatorRender.TAG, "render thread run start.");
            long currentTimeMillis = System.currentTimeMillis();
            while (OldBaseAnimatorRender.this.mRunning) {
                synchronized (OldBaseAnimatorRender.this.mRenderLock) {
                    Canvas canvas = null;
                    try {
                        canvas = OldBaseAnimatorRender.this.lockCanvas();
                        if (canvas != null) {
                            if (OldBaseAnimatorRender.this.mPaused) {
                                OldBaseAnimatorRender.this.clearCanvas(canvas);
                            } else {
                                OldBaseAnimatorRender.this.onDrawFrame(canvas, currentTimeMillis);
                            }
                        }
                        if (canvas != null) {
                            try {
                                OldBaseAnimatorRender.this.unlockCanvasAndPost(canvas);
                            } finally {
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            Logger.e(OldBaseAnimatorRender.TAG, "unlockCanvasAndPost error.", th5);
                            OldBaseAnimatorRender.this.mRunning = false;
                            if (canvas != null) {
                                try {
                                    OldBaseAnimatorRender.this.unlockCanvasAndPost(canvas);
                                } catch (Throwable th6) {
                                    Logger.e(OldBaseAnimatorRender.TAG, "unlock draw canvas error.", th6);
                                }
                            }
                        } finally {
                        }
                    }
                }
                try {
                    Thread.sleep(OldBaseAnimatorRender.this.mPerFrameCost);
                } catch (InterruptedException unused) {
                }
            }
            if (OldBaseAnimatorRender.this.mClearCanvasWhenStop) {
                OldBaseAnimatorRender.this.clearCanvas();
            }
            Logger.d(OldBaseAnimatorRender.TAG, "render thread run finish.");
        }

        /* synthetic */ RenderThread(OldBaseAnimatorRender oldBaseAnimatorRender, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldBaseAnimatorRender, (Object) anonymousClass1);
        }
    }

    public OldBaseAnimatorRender(T t16) {
        this(t16, 10);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
    }

    private void onDrawGroupLayerFrame(Canvas canvas, GroupLayer groupLayer, long j3) {
        Iterator<AnimatorLayer> it = groupLayer.getLayers().iterator();
        while (it.hasNext()) {
            Animator animator = it.next().getAnimator();
            if (animator != null && System.currentTimeMillis() - j3 >= animator.getStartDelay()) {
                animator.drawAnimationByFrame(canvas, this.mPerFrameCost, true);
            }
        }
    }

    private void onDrawLayerFrame(Canvas canvas, AnimatorLayer animatorLayer, long j3) {
        Animator animator = animatorLayer.getAnimator();
        if (animator == null) {
            if (animatorLayer instanceof GroupLayer) {
                onDrawGroupLayerFrame(canvas, (GroupLayer) animatorLayer, j3);
                return;
            }
            Logger.e(TAG, "animator can't be null! layer:" + animatorLayer);
            return;
        }
        if (System.currentTimeMillis() - j3 >= animator.getStartDelay()) {
            animator.drawAnimationByFrame(canvas, this.mPerFrameCost);
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

    private void startRenderThread() {
        Logger.d(TAG, "startRender, render thread: " + this.mRenderThread);
        if (this.mRenderThread == null || !this.mRenderThread.isAlive()) {
            this.mRenderThread = new RenderThread(this, null);
            this.mRunning = true;
            this.mRenderThread.start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) animatorLayer);
        } else if (animatorLayer != null) {
            animatorLayer.setMatrix(this.mMatrix);
            this.mLayerList.add(animatorLayer);
            animatorLayer.setAnimatorListener(this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public synchronized void clearCanvas() {
        Canvas canvas;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Logger.d(TAG, "clearCanvas");
        if (!this.mSurfaceCreated) {
            Logger.w(TAG, "clearCanvas failed: surface destroyed");
            return;
        }
        try {
            canvas = lockCanvas();
            if (canvas != null) {
                try {
                    clearCanvas(canvas);
                } catch (Throwable unused) {
                    if (canvas != null) {
                        try {
                            unlockCanvasAndPost(canvas);
                        } catch (Throwable th5) {
                            th = th5;
                            str = TAG;
                            str2 = "clearCanvas unlock draw canvas error.";
                            Logger.e(str, str2, th);
                        }
                    }
                }
            }
            if (canvas != null) {
                try {
                    unlockCanvasAndPost(canvas);
                } catch (Throwable th6) {
                    th = th6;
                    str = TAG;
                    str2 = "clearCanvas unlock draw canvas error.";
                    Logger.e(str, str2, th);
                }
            }
        } catch (Throwable unused2) {
            canvas = null;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.mLayerList.clear();
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

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public boolean isUserStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
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

    protected void onDrawFrame(Canvas canvas, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, canvas, Long.valueOf(j3));
            return;
        }
        clearCanvas(canvas);
        Iterator<AnimatorLayer> it = this.mLayerList.iterator();
        while (it.hasNext()) {
            onDrawLayerFrame(canvas, it.next(), j3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void pauseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Logger.d(TAG, "pauseAnimation");
        this.mPaused = true;
        clearCanvas();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender
    public void postTaskOnRenderThread(Runnable runnable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, runnable, Boolean.valueOf(z16));
        } else {
            Logger.w(TAG, "postTaskOnRenderThread failed: not support");
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) animatorLayer);
        } else if (animatorLayer != null) {
            this.mLayerList.remove(animatorLayer);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender
    public void renderChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            Logger.d(TAG, "renderChanged");
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender
    public void renderCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Logger.d(TAG, "renderDestroy");
        this.mSurfaceCreated = false;
        stopAnimation(true, false);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void resumeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            Logger.d(TAG, "pauseAnimation");
            this.mPaused = false;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) animatorListener);
        } else {
            this.mAnimatorListener = animatorListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mIsUserStarted = true;
        if (this.mSurfaceCreated) {
            startRenderThread();
            Logger.d(TAG, "startAnimation: " + this.mRenderThread);
            return;
        }
        Logger.w(TAG, "startAnimation - surface not created");
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            stopAnimation(true, true);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    protected abstract void unlockCanvasAndPost(Canvas canvas);

    public OldBaseAnimatorRender(T t16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, i3);
            return;
        }
        this.mRenderLock = new byte[0];
        this.mPaused = false;
        this.mIsUserStarted = false;
        this.mSurfaceCreated = false;
        this.mLayerList = new CopyOnWriteArrayList();
        this.mMatrix = new Matrix();
        this.mView = t16;
        this.mPerFrameCost = i3;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation(boolean z16, boolean z17) {
        Animator animator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Logger.d(TAG, "stopAnimation clearCanvas: " + z16);
        for (AnimatorLayer animatorLayer : this.mLayerList) {
            if (animatorLayer != null && (animator = animatorLayer.getAnimator()) != null) {
                animator.cancelAnimation();
                if (z17) {
                    animator.setAnimatorListener(null);
                }
            }
        }
        this.mClearCanvasWhenStop = z16;
        this.mRunning = false;
        if (this.mRenderThread == null) {
            Logger.w(TAG, "render thread has been stopped.");
            return;
        }
        try {
            this.mRenderThread.join(100L);
        } catch (Throwable unused) {
        }
        this.mRenderThread = null;
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanvas(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }
}
