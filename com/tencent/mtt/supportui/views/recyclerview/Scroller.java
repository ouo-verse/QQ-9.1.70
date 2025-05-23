package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes21.dex */
public class Scroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    public static final int ILLEGAL_DURING = Integer.MAX_VALUE;
    private static final int NB_SAMPLES = 100;
    private static final int SCROLL_MODE = 0;
    public static boolean mUseIphoneAlgorithm = true;
    private static float sViscousFluidNormalize;
    private static float sViscousFluidScale;
    private float mCurrVelocity;
    private int mCurrX;
    private int mCurrY;
    private float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private float mDistance;
    private int mDuration;
    private float mDurationReciprocal;
    private int mFinalX;
    private int mFinalY;
    private boolean mFinished;
    private boolean mFlywheel;
    public Interpolator mInterpolator;
    private boolean mIsUpOrLeft;
    private long mLastComputeTime;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private int mMode;
    private final float mPpi;
    private ScrollInterpolator mScrollInterpolator;
    private long mStartTime;
    private int mStartX;
    private int mStartY;
    private float mVelocity;
    private static float DECELERATION_RATE = (float) (Math.log(0.75d) / Math.log(0.9d));
    public static float ALPHA = 200.0f;
    private static float START_TENSION = 0.175f;
    private static float END_TENSION = 0.35f;
    private static final float[] SPLINE = new float[101];

    static {
        float f16;
        float f17;
        float f18 = 0.0f;
        for (int i3 = 0; i3 <= 100; i3++) {
            float f19 = i3 / 100.0f;
            float f26 = 1.0f;
            while (true) {
                float f27 = ((f26 - f18) / 2.0f) + f18;
                float f28 = 1.0f - f27;
                f16 = 3.0f * f27 * f28;
                f17 = f27 * f27 * f27;
                float f29 = (((f28 * START_TENSION) + (END_TENSION * f27)) * f16) + f17;
                if (Math.abs(f29 - f19) < 1.0E-5d) {
                    break;
                } else if (f29 > f19) {
                    f26 = f27;
                } else {
                    f18 = f27;
                }
            }
            SPLINE[i3] = f16 + f17;
        }
        SPLINE[100] = 1.0f;
        sViscousFluidScale = 8.0f;
        sViscousFluidNormalize = 1.0f;
        sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    }

    public Scroller(Context context) {
        this(context, null);
    }

    private float computeDeceleration(float f16) {
        return this.mPpi * 386.0878f * f16;
    }

    public static float viscousFluid(float f16) {
        float exp;
        float f17 = f16 * sViscousFluidScale;
        if (f17 < 1.0f) {
            exp = f17 - (1.0f - ((float) Math.exp(-f17)));
        } else {
            exp = 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
        }
        return exp * sViscousFluidNormalize;
    }

    public void abortAnimation() {
        this.mCurrX = this.mFinalX;
        this.mCurrY = this.mFinalY;
        this.mFinished = true;
    }

    public void clearVelocity() {
        this.mVelocity = 0.0f;
        this.mCurrVelocity = 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0083, code lost:
    
        if ((android.view.animation.AnimationUtils.currentAnimationTimeMillis() - r9.mStartTime) > 700) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
    
        com.tencent.mtt.supportui.views.recyclerview.Scroller.mUseIphoneAlgorithm = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d1, code lost:
    
        if ((android.view.animation.AnimationUtils.currentAnimationTimeMillis() - r9.mStartTime) > 700) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0147, code lost:
    
        if (r0 == r9.mFinalY) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean computeScrollOffset() {
        float interpolation;
        if (this.mFinished) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        int i3 = this.mDuration;
        if (i3 == Integer.MAX_VALUE) {
            if (this.mMode == 0 && Math.abs(System.currentTimeMillis() - this.mLastComputeTime) > 2) {
                this.mLastComputeTime = System.currentTimeMillis();
                if (this.mIsUpOrLeft) {
                    int i16 = this.mFinalX;
                    int i17 = i16 - this.mStartX;
                    int i18 = this.mFinalY - this.mStartY;
                    int i19 = this.mCurrX;
                    this.mCurrX = i19 - this.mScrollInterpolator.getStep(i19, i17, i16);
                    int i26 = this.mCurrY;
                    int step = i26 - this.mScrollInterpolator.getStep(i26, i18, this.mFinalY);
                    this.mCurrY = step;
                    if ((i17 == 0 && i18 == 0) || ((i18 != 0 && step <= this.mFinalY) || (i17 != 0 && this.mCurrX <= this.mFinalX))) {
                        this.mCurrX = this.mFinalX;
                        this.mCurrY = this.mFinalY;
                        this.mFinished = true;
                    }
                } else {
                    int i27 = this.mFinalX;
                    int i28 = i27 - this.mStartX;
                    int i29 = this.mFinalY - this.mStartY;
                    int i36 = this.mCurrX;
                    this.mCurrX = i36 + this.mScrollInterpolator.getStep(i36, i28, i27);
                    int i37 = this.mCurrY;
                    int step2 = i37 + this.mScrollInterpolator.getStep(i37, i29, this.mFinalY);
                    this.mCurrY = step2;
                    if ((i28 == 0 && i29 == 0) || ((i29 != 0 && step2 >= this.mFinalY) || (i28 != 0 && this.mCurrX >= this.mFinalX))) {
                        this.mCurrX = this.mFinalX;
                        this.mCurrY = this.mFinalY;
                        this.mFinished = true;
                    }
                }
            }
        } else {
            if (currentAnimationTimeMillis < i3) {
                int i38 = this.mMode;
                if (i38 != 0) {
                    if (i38 == 1) {
                        float f16 = currentAnimationTimeMillis / i3;
                        int i39 = (int) (f16 * 100.0f);
                        float f17 = i39 / 100.0f;
                        int i46 = i39 + 1;
                        float[] fArr = SPLINE;
                        float f18 = fArr[i39];
                        float f19 = (i46 / 100.0f) - f17;
                        float f26 = fArr[i46] - f18;
                        float f27 = f18 + (((f16 - f17) / f19) * f26);
                        this.mCurrVelocity = (((f26 / f19) * this.mDistance) / i3) * 1000.0f;
                        int round = this.mStartX + Math.round((this.mFinalX - r0) * f27);
                        this.mCurrX = round;
                        int min = Math.min(round, this.mMaxX);
                        this.mCurrX = min;
                        this.mCurrX = Math.max(min, this.mMinX);
                        int round2 = this.mStartY + Math.round(f27 * (this.mFinalY - r0));
                        this.mCurrY = round2;
                        int min2 = Math.min(round2, this.mMaxY);
                        this.mCurrY = min2;
                        int max = Math.max(min2, this.mMinY);
                        this.mCurrY = max;
                        if (this.mCurrX == this.mFinalX) {
                        }
                    }
                } else {
                    float f28 = currentAnimationTimeMillis * this.mDurationReciprocal;
                    Interpolator interpolator = this.mInterpolator;
                    if (interpolator == null) {
                        interpolation = viscousFluid(f28);
                    } else {
                        interpolation = interpolator.getInterpolation(f28);
                    }
                    this.mCurrX = this.mStartX + Math.round(this.mDeltaX * interpolation);
                    this.mCurrY = this.mStartY + Math.round(interpolation * this.mDeltaY);
                }
            } else {
                this.mCurrX = this.mFinalX;
                this.mCurrY = this.mFinalY;
            }
            this.mFinished = true;
        }
        return true;
    }

    public void extendDuration(int i3) {
        int timePassed = timePassed() + i3;
        this.mDuration = timePassed;
        this.mDurationReciprocal = 1.0f / timePassed;
        this.mFinished = false;
    }

    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        float f16;
        float f17 = i17;
        float f18 = i18;
        if (this.mFlywheel && !this.mFinished) {
            float currVelocity = getCurrVelocity();
            float f19 = this.mFinalX - this.mStartX;
            float f26 = this.mFinalY - this.mStartY;
            float sqrt = (float) Math.sqrt((f19 * f19) + (f26 * f26));
            float f27 = (f19 / sqrt) * currVelocity;
            float f28 = (f26 / sqrt) * currVelocity;
            if (Math.signum(f17) == Math.signum(f27) && Math.signum(f18) == Math.signum(f28)) {
                f17 += f27;
                f18 += f28;
            }
        }
        this.mMode = 1;
        this.mFinished = false;
        double d16 = f17;
        double d17 = f18;
        float sqrt2 = (float) Math.sqrt((d16 * d16) + (d17 * d17));
        this.mVelocity = sqrt2;
        double log = Math.log((START_TENSION * sqrt2) / ALPHA);
        this.mDuration = (int) (Math.exp(log / (DECELERATION_RATE - 1.0d)) * 1000.0d);
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i3;
        this.mStartY = i16;
        float f29 = 1.0f;
        if (sqrt2 == 0.0f) {
            f16 = 1.0f;
        } else {
            f16 = f17 / sqrt2;
        }
        if (sqrt2 != 0.0f) {
            f29 = f18 / sqrt2;
        }
        double d18 = ALPHA;
        float f36 = DECELERATION_RATE;
        float exp = (int) (d18 * Math.exp((f36 / (f36 - 1.0d)) * log));
        this.mDistance = (int) (Math.signum(sqrt2) * exp);
        this.mMinX = i19;
        this.mMaxX = i26;
        this.mMinY = i27;
        this.mMaxY = i28;
        int round = i3 + Math.round(f16 * exp);
        this.mFinalX = round;
        int min = Math.min(round, this.mMaxX);
        this.mFinalX = min;
        this.mFinalX = Math.max(min, this.mMinX);
        int round2 = Math.round(exp * f29) + i16;
        this.mFinalY = round2;
        int min2 = Math.min(round2, this.mMaxY);
        this.mFinalY = min2;
        this.mFinalY = Math.max(min2, this.mMinY);
    }

    public final void forceFinished(boolean z16) {
        this.mFinished = z16;
    }

    public float getCurrVelocity() {
        if (this.mMode == 1) {
            return this.mCurrVelocity;
        }
        return this.mVelocity - ((this.mDeceleration * timePassed()) / 2000.0f);
    }

    public final int getCurrX() {
        return this.mCurrX;
    }

    public final int getCurrY() {
        return this.mCurrY;
    }

    public final int getDuration() {
        return this.mDuration;
    }

    public final int getFinalX() {
        return this.mFinalX;
    }

    public final int getFinalY() {
        return this.mFinalY;
    }

    public final int getStartX() {
        return this.mStartX;
    }

    public final int getStartY() {
        return this.mStartY;
    }

    public final boolean isFinished() {
        return this.mFinished;
    }

    public boolean isFling() {
        if (this.mMode == 1) {
            return true;
        }
        return false;
    }

    public boolean isScrollingInDirection(float f16, float f17) {
        if (!this.mFinished && Math.signum(f16) == Math.signum(this.mFinalX - this.mStartX) && Math.signum(f17) == Math.signum(this.mFinalY - this.mStartY)) {
            return true;
        }
        return false;
    }

    public void setFinalX(int i3) {
        this.mFinalX = i3;
        this.mDeltaX = i3 - this.mStartX;
        this.mFinished = false;
    }

    public void setFinalY(int i3) {
        this.mFinalY = i3;
        this.mDeltaY = i3 - this.mStartY;
        this.mFinished = false;
    }

    public final void setFriction(float f16) {
        this.mDeceleration = computeDeceleration(f16);
    }

    public void startScroll(int i3, int i16, int i17, int i18) {
        startScroll(i3, i16, i17, i18, 250);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    }

    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        this.mMode = 0;
        this.mFinished = false;
        this.mDuration = i19;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i3;
        this.mStartY = i16;
        int i26 = i3 + i17;
        this.mFinalX = i26;
        int i27 = i16 + i18;
        this.mFinalY = i27;
        this.mDeltaX = i17;
        this.mDeltaY = i18;
        this.mCurrX = i3;
        this.mCurrY = i16;
        if (i3 == i26) {
            this.mIsUpOrLeft = i27 < i16;
            this.mScrollInterpolator.initVelocity(i27 - i16);
        } else if (i16 == i27) {
            this.mIsUpOrLeft = i26 < i3;
            this.mScrollInterpolator.initVelocity(i26 - i3);
        }
        this.mDurationReciprocal = 1.0f / this.mDuration;
    }

    public Scroller(Context context, Interpolator interpolator, boolean z16) {
        this.mIsUpOrLeft = false;
        this.mLastComputeTime = -1L;
        this.mScrollInterpolator = new ScrollInterpolator();
        this.mFinished = true;
        this.mInterpolator = interpolator;
        this.mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        this.mFlywheel = z16;
    }
}
