package com.tencent.ams.fusion.widget.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.SystemClock;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class Animator {
    static IPatchRedirector $redirector_ = null;
    public static final float NOT_SET = Float.MIN_VALUE;
    public static final int PROGRESS_UPDATE_INTERVAL = 100;
    public static final int REPEAT_FOREVER = 0;
    protected static final String TAG = "Animator";
    protected AnimatorListener mAnimatorListener;
    protected final List<AnimatorListener> mAnimatorListenerList;
    protected AnimatorProgressListener mAnimatorProgressListener;
    protected long mDuration;
    private final Paint mGrayPaint;
    protected boolean mHasHandlerAnimationFinish;
    protected TimeInterpolator mInterpolator;
    protected long mIntervalStepTime;
    protected boolean mIsCancel;
    private boolean mIsGrayModeOn;
    protected long mLastUpdateProgressTime;
    private final AnimatorLayer mLayer;
    protected boolean mNeedResetMatrix;
    private Animator mParent;
    protected float mProgress;
    private int mRepeatCount;
    private int mRepeatIndex;
    protected long mRepeatInterval;
    protected int mRepeatMode;
    private long mStartDelay;
    protected long mStartTime;
    protected long mStepTime;
    protected String mTag;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AnimatorListener {
        void onAnimationFinish();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AnimatorProgressListener {
        void onAnimationProgressUpdate(float f16);

        int updateInterval();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface RenderPriority {
        public static final int HIGH = 1;
        public static final int LOW = 3;
        public static final int MEDIUM = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RepeatMode {
        public static final int RESTART = 1;
        public static final int REVERSE = 2;
    }

    public Animator(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayer);
            return;
        }
        this.mDuration = 0L;
        this.mStartDelay = 0L;
        this.mRepeatCount = 1;
        this.mRepeatIndex = 0;
        this.mRepeatMode = 1;
        this.mAnimatorListenerList = new ArrayList();
        this.mNeedResetMatrix = true;
        this.mGrayPaint = new Paint();
        this.mLayer = animatorLayer;
    }

    private void onDrawFrame(Canvas canvas, boolean z16, boolean z17) {
        AnimatorLayer layer = getLayer();
        if (layer == null) {
            return;
        }
        if (layer instanceof GroupLayer) {
            for (AnimatorLayer animatorLayer : ((GroupLayer) layer).getLayers()) {
                if (animatorLayer != null) {
                    onDrawLayer(canvas, animatorLayer, z16, z17);
                }
            }
            return;
        }
        onDrawLayer(canvas, layer, z16, z17);
    }

    public void addAnimatorListener(AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) animatorListener);
        } else if (animatorListener != null && !this.mAnimatorListenerList.contains(animatorListener)) {
            this.mAnimatorListenerList.add(animatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void assignParent(Animator animator) {
        this.mParent = animator;
    }

    public void cancelAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        } else {
            this.mIsCancel = true;
        }
    }

    public void clearCanvas(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) canvas);
        } else if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }

    public void drawAnimationByFrame(Canvas canvas, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            drawAnimationByFrame(canvas, j3, true);
        } else {
            iPatchRedirector.redirect((short) 3, this, canvas, Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawCanvas(Canvas canvas, AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas, (Object) animatorLayer);
            return;
        }
        try {
            animatorLayer.draw(canvas);
        } catch (Throwable th5) {
            Logger.e(TAG, "draw layer failed", th5);
        }
    }

    public AnimatorListener getAnimatorListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (AnimatorListener) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.mAnimatorListener;
    }

    public AnimatorProgressListener getAnimatorProgressListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (AnimatorProgressListener) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.mAnimatorProgressListener;
    }

    public long getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.mDuration;
    }

    public TimeInterpolator getInterpolator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (TimeInterpolator) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.mInterpolator;
    }

    public AnimatorLayer getLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mLayer;
    }

    public Animator getParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Animator) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mParent;
    }

    public float getProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Float) iPatchRedirector.redirect((short) 34, (Object) this)).floatValue();
        }
        return this.mProgress;
    }

    public int getRenderPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return 2;
    }

    public int getRepeatCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        int i3 = this.mRepeatCount;
        if (i3 < 0) {
            return 1;
        }
        return i3;
    }

    public int getRepeatIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mRepeatIndex;
    }

    public long getRepeatInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this)).longValue();
        }
        return this.mRepeatInterval;
    }

    public int getRepeatMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.mRepeatMode;
    }

    public long getStartDelay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.mStartDelay;
    }

    public long getStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this)).longValue();
        }
        return this.mStartTime;
    }

    public long getStepTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
        }
        return this.mStepTime;
    }

    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.mTag;
    }

    protected void handlerAnimationFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!this.mHasHandlerAnimationFinish) {
            Logger.i(TAG, "handlerAnimationFinish, mAnimatorListener: " + this.mAnimatorListener);
            AnimatorListener animatorListener = this.mAnimatorListener;
            if (animatorListener != null) {
                animatorListener.onAnimationFinish();
            }
            for (AnimatorListener animatorListener2 : this.mAnimatorListenerList) {
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationFinish();
                }
            }
            this.mHasHandlerAnimationFinish = true;
        }
    }

    protected void handlerAnimationProgressUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mAnimatorProgressListener != null && this.mStepTime - this.mLastUpdateProgressTime > r0.updateInterval()) {
            this.mAnimatorProgressListener.onAnimationProgressUpdate(getProgress());
            this.mLastUpdateProgressTime = this.mStepTime;
        }
    }

    public boolean isCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        return this.mIsCancel;
    }

    public boolean isFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        if (this.mProgress == 1.0f) {
            return true;
        }
        return false;
    }

    protected void onDrawLayer(Canvas canvas, AnimatorLayer animatorLayer, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, canvas, animatorLayer, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        onPostAnimation(canvas, animatorLayer, z16);
        if (z17) {
            drawCanvas(canvas, animatorLayer);
        }
    }

    protected abstract void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16);

    public void removeAnimatorListener(AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) animatorListener);
        } else if (animatorListener != null) {
            this.mAnimatorListenerList.remove(animatorListener);
        } else {
            this.mAnimatorListenerList.clear();
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        this.mStartTime = 0L;
        this.mIsCancel = false;
        this.mRepeatIndex = 0;
        this.mLastUpdateProgressTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetMatrix(AnimatorLayer animatorLayer, Matrix matrix) {
        if (matrix != null && animatorLayer != null && this.mNeedResetMatrix) {
            matrix.reset();
            matrix.preTranslate(animatorLayer.getX(), animatorLayer.getY());
        }
    }

    public void setAnimatorListener(AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) animatorListener);
        } else {
            this.mAnimatorListener = animatorListener;
        }
    }

    public void setAnimatorProgressListener(AnimatorProgressListener animatorProgressListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) animatorProgressListener);
        } else {
            this.mAnimatorProgressListener = animatorProgressListener;
        }
    }

    public Animator setDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Animator) iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
        this.mDuration = j3;
        return this;
    }

    public Animator setInterpolator(TimeInterpolator timeInterpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Animator) iPatchRedirector.redirect((short) 36, (Object) this, (Object) timeInterpolator);
        }
        if (timeInterpolator != null) {
            this.mInterpolator = timeInterpolator;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
        return this;
    }

    public Animator setPathInterpolator(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Animator) iPatchRedirector.redirect((short) 37, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        }
        try {
            setInterpolator(new PathInterpolator(f16, f17, f18, f19));
        } catch (Throwable unused) {
        }
        return this;
    }

    public Animator setRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Animator) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        this.mRepeatCount = i3;
        return this;
    }

    public Animator setRepeatInterval(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Animator) iPatchRedirector.redirect((short) 22, (Object) this, j3);
        }
        this.mRepeatInterval = j3;
        return this;
    }

    public Animator setRepeatMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Animator) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        this.mRepeatMode = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRepeatPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mStepTime = 0L;
        this.mProgress = 0.0f;
        this.mIntervalStepTime = 0L;
        this.mStartTime = 0L;
        this.mLastUpdateProgressTime = 0L;
    }

    public Animator setStartDelay(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Animator) iPatchRedirector.redirect((short) 15, (Object) this, j3);
        }
        this.mStartDelay = j3;
        return this;
    }

    public void setStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, j3);
        } else {
            this.mStartTime = j3;
        }
    }

    public void setStepTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, j3);
        } else {
            this.mStepTime = j3;
        }
    }

    public void setTag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
        } else {
            this.mTag = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldRepeat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        int i3 = this.mRepeatCount;
        if (i3 == 0 || this.mRepeatIndex < i3 - 1) {
            return true;
        }
        return false;
    }

    public void drawAnimationByFrame(Canvas canvas, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (this.mStartTime == 0) {
            setStartTime(SystemClock.elapsedRealtime());
        }
        if (!isCancel()) {
            if (AnimatorConfig.isRunOnOldRenderer()) {
                this.mStepTime = SystemClock.elapsedRealtime() - this.mStartTime;
            } else {
                this.mStepTime += j3;
            }
            long j16 = this.mDuration;
            if (j16 != 0) {
                this.mProgress = ((float) this.mStepTime) / ((float) j16);
            }
            if (this.mStepTime > getDuration()) {
                this.mStepTime = getDuration();
                this.mProgress = 1.0f;
            }
            if (isFinish() && shouldRepeat()) {
                long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) - this.mDuration;
                this.mIntervalStepTime = elapsedRealtime;
                if (elapsedRealtime > this.mRepeatInterval || elapsedRealtime < 0) {
                    setRepeatPlay();
                    this.mRepeatIndex++;
                }
            }
        }
        if (isFinish()) {
            onDrawFrame(canvas, true, z16);
            handlerAnimationFinish();
        } else {
            onDrawFrame(canvas, false, z16);
            handlerAnimationProgressUpdate();
        }
    }
}
