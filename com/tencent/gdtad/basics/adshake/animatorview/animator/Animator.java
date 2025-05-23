package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.os.SystemClock;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.GroupLayer;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class Animator {
    public static final float NOT_SET = Float.MIN_VALUE;
    public static final int PROGRESS_UPDATE_INTERVAL = 100;
    public static final int REPEAT_FOREVER = 0;
    protected static final String TAG = "Animator";
    protected AnimatorListener mAnimatorListener;
    protected AnimatorProgressListener mAnimatorProgressListener;
    protected boolean mHasHandlerAnimationFinish;
    protected TimeInterpolator mInterpolator;
    protected long mIntervalStepTime;
    protected boolean mIsCancel;
    protected long mLastUpdateProgressTime;
    private final AnimatorLayer mLayer;
    private Animator mParent;
    protected float mProgress;
    protected long mRepeatInterval;
    protected long mStartTime;
    protected long mStepTime;
    protected String mTag;
    protected long mDuration = 0;
    private long mStartDelay = 0;
    private int mRepeatCount = 1;
    private int mRepeatIndex = 0;
    protected int mRepeatMode = 1;
    protected final List<AnimatorListener> mAnimatorListenerList = new ArrayList();
    protected boolean mNeedResetMatrix = true;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface AnimatorListener {
        void onAnimationFinish();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface AnimatorProgressListener {
        void onAnimationProgressUpdate(float f16);

        int updateInterval();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public @interface RenderPriority {
        public static final int HIGH = 1;
        public static final int LOW = 3;
        public static final int MEDIUM = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface RepeatMode {
        public static final int RESTART = 1;
        public static final int REVERSE = 2;
    }

    public Animator(AnimatorLayer animatorLayer) {
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
        if (animatorListener != null && !this.mAnimatorListenerList.contains(animatorListener)) {
            this.mAnimatorListenerList.add(animatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void assignParent(Animator animator) {
        this.mParent = animator;
    }

    public void cancelAnimation() {
        this.mIsCancel = true;
    }

    public void clearCanvas(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }

    public void drawAnimationByFrame(Canvas canvas, long j3) {
        drawAnimationByFrame(canvas, j3, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawCanvas(Canvas canvas, AnimatorLayer animatorLayer) {
        try {
            animatorLayer.draw(canvas);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "draw layer failed", th5);
        }
    }

    public AnimatorListener getAnimatorListener() {
        return this.mAnimatorListener;
    }

    public AnimatorProgressListener getAnimatorProgressListener() {
        return this.mAnimatorProgressListener;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public AnimatorLayer getLayer() {
        return this.mLayer;
    }

    public Animator getParent() {
        return this.mParent;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public int getRenderPriority() {
        return 2;
    }

    public int getRepeatCount() {
        int i3 = this.mRepeatCount;
        if (i3 < 0) {
            return 1;
        }
        return i3;
    }

    public int getRepeatIndex() {
        return this.mRepeatIndex;
    }

    public long getRepeatInterval() {
        return this.mRepeatInterval;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getStepTime() {
        return this.mStepTime;
    }

    public String getTag() {
        return this.mTag;
    }

    protected void handlerAnimationFinish() {
        if (!this.mHasHandlerAnimationFinish) {
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
        AnimatorProgressListener animatorProgressListener = this.mAnimatorProgressListener;
        if (animatorProgressListener != null && this.mStepTime - this.mLastUpdateProgressTime > 100) {
            animatorProgressListener.onAnimationProgressUpdate(getProgress());
            this.mLastUpdateProgressTime = this.mStepTime;
        }
    }

    public boolean isCancel() {
        return this.mIsCancel;
    }

    public boolean isFinish() {
        if (this.mProgress == 1.0f) {
            return true;
        }
        return false;
    }

    protected void onDrawLayer(Canvas canvas, AnimatorLayer animatorLayer, boolean z16, boolean z17) {
        onPostAnimation(canvas, animatorLayer, z16);
        if (z17) {
            drawCanvas(canvas, animatorLayer);
        }
    }

    protected abstract void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16);

    public void removeAnimatorListener(AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mAnimatorListenerList.remove(animatorListener);
        } else {
            this.mAnimatorListenerList.clear();
        }
    }

    public void reset() {
        this.mStartTime = 0L;
        this.mStepTime = 0L;
        this.mProgress = 0.0f;
        this.mIsCancel = false;
        this.mRepeatIndex = 0;
        this.mHasHandlerAnimationFinish = false;
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
        this.mAnimatorListener = animatorListener;
    }

    public void setAnimatorProgressListener(AnimatorProgressListener animatorProgressListener) {
        this.mAnimatorProgressListener = animatorProgressListener;
    }

    public Animator setDuration(long j3) {
        this.mDuration = j3;
        return this;
    }

    public Animator setInterpolator(TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            this.mInterpolator = timeInterpolator;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
        return this;
    }

    public Animator setPathInterpolator(float f16, float f17, float f18, float f19) {
        setInterpolator(new PathInterpolator(f16, f17, f18, f19));
        return this;
    }

    public Animator setRepeatCount(int i3) {
        this.mRepeatCount = i3;
        return this;
    }

    public Animator setRepeatInterval(long j3) {
        this.mRepeatInterval = j3;
        return this;
    }

    public Animator setRepeatMode(int i3) {
        this.mRepeatMode = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRepeatPlay() {
        this.mStepTime = 0L;
        this.mProgress = 0.0f;
        this.mIntervalStepTime = 0L;
        this.mStartTime = 0L;
    }

    public Animator setStartDelay(long j3) {
        this.mStartDelay = j3;
        return this;
    }

    public void setStartTime(long j3) {
        this.mStartTime = j3;
    }

    public void setStepTime(long j3) {
        this.mStepTime = j3;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldRepeat() {
        int i3 = this.mRepeatCount;
        if (i3 == 0 || this.mRepeatIndex < i3 - 1) {
            return true;
        }
        return false;
    }

    public void drawAnimationByFrame(Canvas canvas, long j3, boolean z16, boolean z17) {
        if (this.mStartTime == 0) {
            setStartTime(SystemClock.elapsedRealtime());
        }
        if (!isCancel()) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
            this.mStepTime = elapsedRealtime;
            long j16 = this.mDuration;
            if (j16 != 0) {
                this.mProgress = ((float) elapsedRealtime) / ((float) j16);
            }
            if (elapsedRealtime > getDuration()) {
                this.mStepTime = getDuration();
                this.mProgress = 1.0f;
            }
            if (isFinish() && shouldRepeat()) {
                long elapsedRealtime2 = (SystemClock.elapsedRealtime() - this.mStartTime) - this.mDuration;
                this.mIntervalStepTime = elapsedRealtime2;
                if (elapsedRealtime2 > this.mRepeatInterval) {
                    setRepeatPlay();
                    this.mRepeatIndex++;
                }
            }
        }
        if (z16) {
            clearCanvas(canvas);
        }
        if (isFinish()) {
            onDrawFrame(canvas, true, z17);
            handlerAnimationFinish();
        } else {
            onDrawFrame(canvas, false, z17);
            handlerAnimationProgressUpdate();
        }
    }
}
