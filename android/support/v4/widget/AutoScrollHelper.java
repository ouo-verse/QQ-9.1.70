package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    private boolean mAnimating;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private boolean mNeedsCancel;
    private boolean mNeedsReset;
    private Runnable mRunnable;
    private final View mTarget;
    private final ClampedScroller mScroller = new ClampedScroller();
    private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    private float[] mRelativeEdges = {0.0f, 0.0f};
    private float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mRelativeVelocity = {0.0f, 0.0f};
    private float[] mMinimumVelocity = {0.0f, 0.0f};
    private float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ClampedScroller {
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;
        private long mStartTime = Long.MIN_VALUE;
        private long mStopTime = -1;
        private long mDeltaTime = 0;
        private int mDeltaX = 0;
        private int mDeltaY = 0;

        private float getValueAt(long j3) {
            long j16 = this.mStartTime;
            if (j3 < j16) {
                return 0.0f;
            }
            long j17 = this.mStopTime;
            if (j17 >= 0 && j3 >= j17) {
                float f16 = this.mStopValue;
                return (1.0f - f16) + (f16 * AutoScrollHelper.constrain(((float) (j3 - j17)) / this.mEffectiveRampDown, 0.0f, 1.0f));
            }
            return AutoScrollHelper.constrain(((float) (j3 - j16)) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
        }

        private float interpolateValue(float f16) {
            return ((-4.0f) * f16 * f16) + (f16 * 4.0f);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
                long j3 = currentAnimationTimeMillis - this.mDeltaTime;
                this.mDeltaTime = currentAnimationTimeMillis;
                float f16 = ((float) j3) * interpolateValue;
                this.mDeltaX = (int) (this.mTargetVelocityX * f16);
                this.mDeltaY = (int) (f16 * this.mTargetVelocityY);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            float f16 = this.mTargetVelocityX;
            return (int) (f16 / Math.abs(f16));
        }

        public int getVerticalDirection() {
            float f16 = this.mTargetVelocityY;
            return (int) (f16 / Math.abs(f16));
        }

        public boolean isFinished() {
            if (this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + this.mEffectiveRampDown) {
                return true;
            }
            return false;
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (currentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(currentAnimationTimeMillis);
            this.mStopTime = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i3) {
            this.mRampDownDuration = i3;
        }

        public void setRampUpDuration(int i3) {
            this.mRampUpDuration = i3;
        }

        public void setTargetVelocity(float f16, float f17) {
            this.mTargetVelocityX = f16;
            this.mTargetVelocityY = f17;
        }

        public void start() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis;
            this.mStopTime = -1L;
            this.mDeltaTime = currentAnimationTimeMillis;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AutoScrollHelper.this.mAnimating) {
                return;
            }
            if (AutoScrollHelper.this.mNeedsReset) {
                AutoScrollHelper.this.mNeedsReset = false;
                AutoScrollHelper.this.mScroller.start();
            }
            ClampedScroller clampedScroller = AutoScrollHelper.this.mScroller;
            if (clampedScroller.isFinished() || !AutoScrollHelper.this.shouldAnimate()) {
                AutoScrollHelper.this.mAnimating = false;
                return;
            }
            if (AutoScrollHelper.this.mNeedsCancel) {
                AutoScrollHelper.this.mNeedsCancel = false;
                AutoScrollHelper.this.cancelTargetTouch();
            }
            clampedScroller.computeScrollDelta();
            AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
            ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
        }
    }

    public AutoScrollHelper(View view) {
        this.mTarget = view;
        float f16 = Resources.getSystem().getDisplayMetrics().density;
        float f17 = (int) ((1575.0f * f16) + 0.5f);
        setMaximumVelocity(f17, f17);
        float f18 = (int) ((f16 * 315.0f) + 0.5f);
        setMinimumVelocity(f18, f18);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTargetTouch() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }

    private float computeTargetVelocity(int i3, float f16, float f17, float f18) {
        float edgeValue = getEdgeValue(this.mRelativeEdges[i3], f17, this.mMaximumEdges[i3], f16);
        if (edgeValue == 0.0f) {
            return 0.0f;
        }
        float f19 = this.mRelativeVelocity[i3];
        float f26 = this.mMinimumVelocity[i3];
        float f27 = this.mMaximumVelocity[i3];
        float f28 = f19 * f18;
        if (edgeValue > 0.0f) {
            return constrain(edgeValue * f28, f26, f27);
        }
        return -constrain((-edgeValue) * f28, f26, f27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float constrain(float f16, float f17, float f18) {
        return f16 > f18 ? f18 : f16 < f17 ? f17 : f16;
    }

    private float constrainEdgeValue(float f16, float f17) {
        if (f17 == 0.0f) {
            return 0.0f;
        }
        int i3 = this.mEdgeType;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2 && f16 < 0.0f) {
                return f16 / (-f17);
            }
        } else if (f16 < f17) {
            if (f16 >= 0.0f) {
                return 1.0f - (f16 / f17);
            }
            if (this.mAnimating && i3 == 1) {
                return 1.0f;
            }
        }
        return 0.0f;
    }

    private float getEdgeValue(float f16, float f17, float f18, float f19) {
        float interpolation;
        float constrain = constrain(f16 * f17, 0.0f, f18);
        float constrainEdgeValue = constrainEdgeValue(f17 - f19, constrain) - constrainEdgeValue(f19, constrain);
        if (constrainEdgeValue < 0.0f) {
            interpolation = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
        } else {
            if (constrainEdgeValue <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
        }
        return constrain(interpolation, -1.0f, 1.0f);
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldAnimate() {
        ClampedScroller clampedScroller = this.mScroller;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        if ((verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection))) {
            return true;
        }
        return false;
    }

    private void startAnimating() {
        int i3;
        if (this.mRunnable == null) {
            this.mRunnable = new ScrollAnimationRunnable();
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (!this.mAlreadyDelayed && (i3 = this.mActivationDelay) > 0) {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, i3);
        } else {
            this.mRunnable.run();
        }
        this.mAlreadyDelayed = true;
    }

    public abstract boolean canTargetScrollHorizontally(int i3);

    public abstract boolean canTargetScrollVertically(int i3);

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            requestStop();
            if (!this.mExclusive && this.mAnimating) {
                return true;
            }
        }
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        this.mScroller.setTargetVelocity(computeTargetVelocity(0, motionEvent.getX(), view.getWidth(), this.mTarget.getWidth()), computeTargetVelocity(1, motionEvent.getY(), view.getHeight(), this.mTarget.getHeight()));
        if (!this.mAnimating && shouldAnimate()) {
            startAnimating();
        }
        return !this.mExclusive ? false : false;
    }

    public abstract void scrollTargetBy(int i3, int i16);

    public AutoScrollHelper setActivationDelay(int i3) {
        this.mActivationDelay = i3;
        return this;
    }

    public AutoScrollHelper setEdgeType(int i3) {
        this.mEdgeType = i3;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z16) {
        if (this.mEnabled && !z16) {
            requestStop();
        }
        this.mEnabled = z16;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z16) {
        this.mExclusive = z16;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f16, float f17) {
        float[] fArr = this.mMaximumEdges;
        fArr[0] = f16;
        fArr[1] = f17;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f16, float f17) {
        float[] fArr = this.mMaximumVelocity;
        fArr[0] = f16 / 1000.0f;
        fArr[1] = f17 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f16, float f17) {
        float[] fArr = this.mMinimumVelocity;
        fArr[0] = f16 / 1000.0f;
        fArr[1] = f17 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int i3) {
        this.mScroller.setRampDownDuration(i3);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int i3) {
        this.mScroller.setRampUpDuration(i3);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f16, float f17) {
        float[] fArr = this.mRelativeEdges;
        fArr[0] = f16;
        fArr[1] = f17;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f16, float f17) {
        float[] fArr = this.mRelativeVelocity;
        fArr[0] = f16 / 1000.0f;
        fArr[1] = f17 / 1000.0f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int constrain(int i3, int i16, int i17) {
        return i3 > i17 ? i17 : i3 < i16 ? i16 : i3;
    }
}
