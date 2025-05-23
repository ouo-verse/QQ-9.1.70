package com.tencent.ams.fusion.widget.animatorview.render.v2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
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
import com.tencent.ams.fusion.widget.animatorview.render.AnimatorRenderHandler;
import com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseAnimatorRenderV2<T extends View> implements Animator.AnimatorListener, IAnimatorRender {
    static IPatchRedirector $redirector_ = null;
    private static final long NANOS_PER_MS = 1000000;
    private static final String TAG = "BaseAnimatorRenderV2";
    private static final WeakReferenceList<View> mAnimatorViewList;
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
    private final AnimatorRenderHandler mRenderHandler;
    private final BaseAnimatorRenderV2<T>.RenderHandlerEventListener mRenderHandlerEventListener;
    private volatile boolean mRunning;
    protected boolean mShowFrameRate;
    private volatile boolean mSurfaceCreated;
    protected T mView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class RenderHandlerEventListener implements Choreographer.FrameCallback, AnimatorRenderHandler.EventListener {
        static IPatchRedirector $redirector_;
        private int mFps;
        private int mFrameCount;
        private long mLastFrameTimeNanos;
        private long mRenderStartTime;
        private long mStartFrameTimeNanos;

        RenderHandlerEventListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseAnimatorRenderV2.this);
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
                Logger.d(BaseAnimatorRenderV2.TAG, "computeFps() mFps: " + this.mFps + ", diffMs: " + j16);
                if (BaseAnimatorRenderV2.this.mFrameRateListener != null) {
                    BaseAnimatorRenderV2.this.mFrameRateListener.onFrameRate(this.mFps, j16);
                    return;
                }
                return;
            }
            this.mFrameCount++;
        }

        private void drawFrameRate(Canvas canvas) {
            BaseAnimatorRenderV2 baseAnimatorRenderV2 = BaseAnimatorRenderV2.this;
            if (baseAnimatorRenderV2.mEnableFrameRate && baseAnimatorRenderV2.mShowFrameRate && canvas != null) {
                try {
                    if (baseAnimatorRenderV2.mFrameRatePaint == null) {
                        BaseAnimatorRenderV2.this.mFrameRatePaint = new Paint();
                        BaseAnimatorRenderV2.this.mFrameRatePaint.setFlags(1);
                        BaseAnimatorRenderV2.this.mFrameRatePaint.setAntiAlias(true);
                        BaseAnimatorRenderV2.this.mFrameRatePaint.setColor(SupportMenu.CATEGORY_MASK);
                        BaseAnimatorRenderV2.this.mFrameRatePaint.setTextSize(20.0f);
                    }
                    canvas.drawText("fps:" + this.mFps, 10.0f, 50.0f, BaseAnimatorRenderV2.this.mFrameRatePaint);
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
            if (BaseAnimatorRenderV2.this.mRunning) {
                try {
                    try {
                    } catch (Throwable th5) {
                        try {
                            Logger.e(BaseAnimatorRenderV2.TAG, "unlockCanvasAndPost error.", th5);
                            BaseAnimatorRenderV2.this.mRunning = false;
                            if (0 != 0) {
                                BaseAnimatorRenderV2.this.unlockCanvasAndPost(null);
                            }
                        } catch (Throwable th6) {
                            if (0 != 0) {
                                try {
                                    BaseAnimatorRenderV2.this.unlockCanvasAndPost(null);
                                } catch (Throwable th7) {
                                    Logger.e(BaseAnimatorRenderV2.TAG, "unlock draw canvas error.", th7);
                                }
                            }
                            throw th6;
                        }
                    }
                } catch (Throwable th8) {
                    Logger.e(BaseAnimatorRenderV2.TAG, "unlock draw canvas error.", th8);
                }
                if (!BaseAnimatorRenderV2.this.isSurfaceValid()) {
                    return;
                }
                Canvas lockCanvas = BaseAnimatorRenderV2.this.lockCanvas();
                if (lockCanvas != null) {
                    if (BaseAnimatorRenderV2.this.mPaused) {
                        BaseAnimatorRenderV2.this.clearCanvas(lockCanvas);
                    } else {
                        BaseAnimatorRenderV2.this.drawFrame(lockCanvas, this.mRenderStartTime, j3);
                        drawFrameRate(lockCanvas);
                    }
                }
                if (lockCanvas != null) {
                    BaseAnimatorRenderV2.this.unlockCanvasAndPost(lockCanvas);
                }
                postFrameCallback();
                return;
            }
            removeFrameCallback();
            BaseAnimatorRenderV2.this.clearCanvas();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            long j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
                return;
            }
            if (!BaseAnimatorRenderV2.this.mSurfaceCreated) {
                return;
            }
            long j17 = this.mLastFrameTimeNanos;
            if (j17 > 0) {
                j16 = (j3 - j17) / 1000000;
            } else {
                j16 = 0;
            }
            if (AnimatorConfig.getMaxFrameRate() > 0 && j16 > 0 && j16 < 1000 / r4) {
                if (BaseAnimatorRenderV2.this.mRunning) {
                    postFrameCallback();
                }
            } else {
                this.mLastFrameTimeNanos = j3;
                renderFrame(j16);
                if (BaseAnimatorRenderV2.this.mEnableFrameRate) {
                    computeFps(j3);
                }
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.render.AnimatorRenderHandler.EventListener
        public void onPostFrameCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                Choreographer.getInstance().removeFrameCallback(this);
                Choreographer.getInstance().postFrameCallback(this);
            } catch (Throwable unused) {
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.render.AnimatorRenderHandler.EventListener
        public void onRemoveFrameCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                Choreographer.getInstance().removeFrameCallback(this);
            } catch (Throwable unused) {
            }
            BaseAnimatorRenderV2.this.mRenderHandler.removeEventListener(this);
            Logger.d(BaseAnimatorRenderV2.TAG, "onRemoveFrameCallback.");
        }

        public void reset() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            this.mStartFrameTimeNanos = 0L;
            this.mLastFrameTimeNanos = 0L;
            this.mFrameCount = 0;
            this.mFps = 0;
            this.mRenderStartTime = 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class WeakReferenceList<T> {
        static IPatchRedirector $redirector_;
        private final List<WeakReference<T>> list;

        public WeakReferenceList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.list = new CopyOnWriteArrayList();
            }
        }

        public void add(T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
            } else if (t16 != null) {
                this.list.add(new WeakReference<>(t16));
            }
        }

        public T get(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (T) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            WeakReference<T> weakReference = this.list.get(i3);
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public boolean isEmpty() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (this.list.isEmpty()) {
                return true;
            }
            for (WeakReference<T> weakReference : this.list) {
                if (weakReference != null && weakReference.get() == null) {
                    this.list.remove(weakReference);
                }
            }
            return this.list.isEmpty();
        }

        public boolean remove(T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16)).booleanValue();
            }
            for (WeakReference<T> weakReference : this.list) {
                if (weakReference != null) {
                    T t17 = weakReference.get();
                    if (t17 != null) {
                        if (t17.equals(t16)) {
                            this.list.remove(weakReference);
                            return true;
                        }
                    } else {
                        this.list.remove(weakReference);
                    }
                }
            }
            return false;
        }

        public int size() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.list.size();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49130);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            mAnimatorViewList = new WeakReferenceList<>();
        }
    }

    public BaseAnimatorRenderV2(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
            return;
        }
        this.mPaused = false;
        this.mIsUserStarted = false;
        this.mSurfaceCreated = false;
        this.mLayerList = new CopyOnWriteArrayList();
        this.mRenderHandler = AnimatorRenderHandler.getInstance();
        this.mRenderHandlerEventListener = new RenderHandlerEventListener();
        this.mMatrix = new Matrix();
        this.mView = t16;
        this.mIsInDebug = AnimatorUtils.isInDebug(t16.getContext());
        mAnimatorViewList.add(t16);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, canvas, Long.valueOf(j3), Long.valueOf(j16));
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
        Logger.i(TAG, "pauseAnimation");
        this.mRenderHandler.pause();
        this.mPaused = true;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender
    public void postTaskOnRenderThread(Runnable runnable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, runnable, Boolean.valueOf(z16));
        } else {
            if (runnable == null) {
                return;
            }
            this.mRenderHandler.postTaskOnRenderThread(runnable, z16);
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
            Logger.d(TAG, "surfaceCreated - startAnimation");
            resetAnimation();
            startAnimation();
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
        Logger.d(TAG, "renderDestroy");
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
        Logger.i(TAG, "resumeAnimation");
        this.mPaused = false;
        this.mRunning = true;
        this.mRenderHandler.resume();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.mEnableFrameRate = z16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setFrameRateListener(IFrameRateListener iFrameRateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) iFrameRateListener);
        } else {
            this.mFrameRateListener = iFrameRateListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setShowFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
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
            Logger.i(TAG, QZoneJsConstants.ACTION_START_ANIMATION);
            this.mRenderHandler.startRenderThread();
            this.mRenderHandler.sendEventPostFrameCallback();
            this.mRenderHandler.addEventListener(this.mRenderHandlerEventListener);
            this.mRunning = true;
            return;
        }
        Logger.w(TAG, "startAnimation - surface not created");
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            Logger.i(TAG, "stopAnimation");
            stopAnimation(true, true);
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
        WeakReferenceList<View> weakReferenceList = mAnimatorViewList;
        weakReferenceList.remove(this.mView);
        if (weakReferenceList.isEmpty()) {
            this.mRenderHandler.sendEventRemoveFrameCallback();
            Logger.i(TAG, "stopAnimation sendEventRemoveFrameCallback");
        }
        for (AnimatorLayer animatorLayer : this.mLayerList) {
            if (animatorLayer != null && (animator = animatorLayer.getAnimator()) != null) {
                animator.cancelAnimation();
                if (z17) {
                    animator.setAnimatorListener(null);
                }
            }
        }
        if (z17) {
            clearLayers();
        }
        this.mRunning = false;
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
