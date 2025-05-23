package com.tencent.richmediabrowser.view.recyclerview;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.richmediabrowser.animation.AnimateUtils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class OverScroller {
    public static int BOUNCE_DURANTION = 400;
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    public static final int FLING_MODE_NORMAL = 0;
    public static final int FLING_MODE_SLOW = 1;
    private static final int SCROLL_MODE = 0;
    private static final int SCROLL_MODE_NO_BACK = 2;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    public OverScroller(Context context) {
        this(context, null);
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        int i3 = this.mMode;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinishedForNoBack()) {
                        this.mScrollerX.finish();
                    }
                    if (!this.mScrollerY.mFinished && !this.mScrollerY.update() && !this.mScrollerY.continueWhenFinishedForNoBack()) {
                        this.mScrollerY.finish();
                    }
                }
            } else {
                if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinished()) {
                    this.mScrollerX.finish();
                }
                if (!this.mScrollerY.mFinished && !this.mScrollerY.update() && !this.mScrollerY.continueWhenFinished()) {
                    this.mScrollerY.finish();
                }
            }
        } else {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
            int i16 = this.mScrollerX.mDuration;
            if (currentAnimationTimeMillis < i16) {
                float f16 = ((float) currentAnimationTimeMillis) / i16;
                Interpolator interpolator = this.mInterpolator;
                if (interpolator == null) {
                    interpolation = AnimateUtils.viscousFluid(f16);
                } else {
                    interpolation = interpolator.getInterpolation(f16);
                }
                if (!this.mScrollerX.mFinished) {
                    this.mScrollerX.updateScroll(interpolation);
                }
                if (!this.mScrollerY.mFinished) {
                    this.mScrollerY.updateScroll(interpolation);
                }
            } else {
                abortAnimation();
            }
        }
        return true;
    }

    @Deprecated
    public void extendDuration(int i3) {
        this.mScrollerX.extendDuration(i3);
        this.mScrollerY.extendDuration(i3);
    }

    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        fling(i3, i16, i17, i18, i19, i26, i27, i28, 0, 0);
    }

    public final void forceFinished(boolean z16) {
        this.mScrollerX.mFinished = this.mScrollerY.mFinished = z16;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.mScrollerX.mCurrVelocity * this.mScrollerX.mCurrVelocity) + (this.mScrollerY.mCurrVelocity * this.mScrollerY.mCurrVelocity));
    }

    public float getCurrVelocityY() {
        return this.mScrollerY.mCurrVelocity;
    }

    public final int getCurrX() {
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return this.mScrollerY.mCurrentPosition;
    }

    @Deprecated
    public final int getDuration() {
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public final int getFinalX() {
        return this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return this.mScrollerY.mFinal;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public final int getStartX() {
        return this.mScrollerX.mStart;
    }

    public final int getStartY() {
        return this.mScrollerY.mStart;
    }

    public final boolean isFinished() {
        if (this.mScrollerX.mFinished && this.mScrollerY.mFinished) {
            return true;
        }
        return false;
    }

    public boolean isOverScrolled() {
        if ((!this.mScrollerX.mFinished && this.mScrollerX.mState != 0) || (!this.mScrollerY.mFinished && this.mScrollerY.mState != 0)) {
            return true;
        }
        return false;
    }

    public boolean isScrollingInDirection(float f16, float f17) {
        int i3 = this.mScrollerX.mFinal - this.mScrollerX.mStart;
        int i16 = this.mScrollerY.mFinal - this.mScrollerY.mStart;
        if (!isFinished() && Math.signum(f16) == Math.signum(i3) && Math.signum(f17) == Math.signum(i16)) {
            return true;
        }
        return false;
    }

    public void notifyHorizontalEdgeReached(int i3, int i16, int i17) {
        this.mScrollerX.notifyEdgeReached(i3, i16, i17);
    }

    public void notifyVerticalEdgeReached(int i3, int i16, int i17) {
        this.mScrollerY.notifyEdgeReached(i3, i16, i17);
    }

    @Deprecated
    public void setFinalX(int i3) {
        this.mScrollerX.setFinalPosition(i3);
    }

    @Deprecated
    public void setFinalY(int i3) {
        this.mScrollerY.setFinalPosition(i3);
    }

    public void setFlingMode(int i3) {
        this.mScrollerY.setFlingMode(i3);
    }

    public final void setFriction(float f16) {
        this.mScrollerX.setFriction(f16);
        this.mScrollerY.setFriction(f16);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public boolean springBack(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.mMode = 1;
        return this.mScrollerX.springback(i3, i17, i18) || this.mScrollerY.springback(i16, i19, i26);
    }

    public void startScroll(int i3, int i16, int i17, int i18) {
        startScroll(i3, i16, i17, i18, 250);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime));
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        fling(i3, i16, i17, i18, i19, i26, i27, i28, i29, i36, 1);
    }

    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        this.mMode = 0;
        this.mScrollerX.startScroll(i3, i17, i19);
        this.mScrollerY.startScroll(i16, i18, i19);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean z16) {
        this.mInterpolator = interpolator;
        this.mFlywheel = z16;
        this.mScrollerX = new SplineOverScroller();
        this.mScrollerY = new SplineOverScroller();
        SplineOverScroller.initFromContext(context);
    }

    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37) {
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        if (!this.mFlywheel || isFinished()) {
            i38 = i17;
        } else {
            float f16 = this.mScrollerX.mCurrVelocity;
            float f17 = this.mScrollerY.mCurrVelocity;
            i38 = i17;
            float f18 = i38;
            if (Math.signum(f18) == Math.signum(f16)) {
                i39 = i18;
                float f19 = i39;
                if (Math.signum(f19) == Math.signum(f17)) {
                    i47 = (int) (f19 + f17);
                    i48 = (int) (f18 + f16);
                    i46 = i37;
                    this.mMode = i46;
                    this.mScrollerX.fling(i3, i48, i19, i26, i29);
                    this.mScrollerY.fling(i16, i47, i27, i28, i36);
                }
                i46 = i37;
                i47 = i39;
                i48 = i38;
                this.mMode = i46;
                this.mScrollerX.fling(i3, i48, i19, i26, i29);
                this.mScrollerY.fling(i16, i47, i27, i28, i36);
            }
        }
        i39 = i18;
        i46 = i37;
        i47 = i39;
        i48 = i38;
        this.mMode = i46;
        this.mScrollerX.fling(i3, i48, i19, i26, i29);
        this.mScrollerY.fling(i16, i47, i27, i28, i36);
    }

    public boolean springBack(int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        this.mMode = 1;
        return this.mScrollerX.springback(i3, i17, i18, i27) || this.mScrollerY.springback(i16, i19, i26, i27);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class SplineOverScroller {
        private static final int BOUNCE = 3;
        private static final int CUBIC = 1;
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static float PHYSICAL_COEF = 0.0f;
        private static final int SCROLL = 4;
        private static final int SPLINE = 0;
        private static final float START_TENSION = 0.5f;
        private float mCurrVelocity;
        private int mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private int mFinal;
        private long mLastTime;
        private double mLastVelocity;
        private int mOver;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mStart;
        private long mStartTime;
        private float mTension;
        private int mVelocity;
        private static final float[] SPLINE_POSITION = new float[101];
        private static final float[] SPLINE_TIME = new float[101];
        private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private int mFlingMode = 0;
        private boolean mFinished = true;

        static {
            float f16;
            float f17;
            float f18;
            float f19;
            float f26;
            float f27;
            float f28;
            float f29;
            float f36;
            float f37;
            float f38 = 0.0f;
            float f39 = 0.0f;
            for (int i3 = 0; i3 < 100; i3++) {
                float f46 = i3 / 100.0f;
                float f47 = 1.0f;
                while (true) {
                    f16 = 2.0f;
                    f17 = ((f47 - f38) / 2.0f) + f38;
                    f18 = 3.0f;
                    f19 = 1.0f - f17;
                    f26 = f17 * 3.0f * f19;
                    f27 = f17 * f17 * f17;
                    float f48 = (((f19 * P1) + (f17 * P2)) * f26) + f27;
                    if (Math.abs(f48 - f46) < 1.0E-5d) {
                        break;
                    } else if (f48 > f46) {
                        f47 = f17;
                    } else {
                        f38 = f17;
                    }
                }
                SPLINE_POSITION[i3] = (f26 * ((f19 * 0.5f) + f17)) + f27;
                float f49 = 1.0f;
                while (true) {
                    f28 = ((f49 - f39) / f16) + f39;
                    f29 = 1.0f - f28;
                    f36 = f28 * f18 * f29;
                    f37 = f28 * f28 * f28;
                    float f56 = (((f29 * 0.5f) + f28) * f36) + f37;
                    if (Math.abs(f56 - f46) < 1.0E-5d) {
                        break;
                    }
                    if (f56 > f46) {
                        f49 = f28;
                    } else {
                        f39 = f28;
                    }
                    f16 = 2.0f;
                    f18 = 3.0f;
                }
                SPLINE_TIME[i3] = (f36 * ((f29 * P1) + (f28 * P2))) + f37;
            }
            float[] fArr = SPLINE_POSITION;
            SPLINE_TIME[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        SplineOverScroller() {
        }

        private void adjustDuration(int i3, int i16, int i17) {
            float abs = Math.abs((i17 - i3) / (i16 - i3));
            int i18 = (int) (abs * 100.0f);
            if (i18 < 100) {
                float f16 = i18 / 100.0f;
                int i19 = i18 + 1;
                float[] fArr = SPLINE_TIME;
                float f17 = fArr[i18];
                this.mDuration = (int) (this.mDuration * (f17 + (((abs - f16) / ((i19 / 100.0f) - f16)) * (fArr[i19] - f17))));
            }
        }

        private double getSplineDeceleration(int i3) {
            return Math.log((Math.abs(i3) * 0.35f) / (this.mFlingFriction * PHYSICAL_COEF));
        }

        private double getSplineFlingDistance(int i3) {
            double splineDeceleration = getSplineDeceleration(i3);
            float f16 = DECELERATION_RATE;
            return this.mFlingFriction * PHYSICAL_COEF * Math.exp((f16 / (f16 - 1.0d)) * splineDeceleration);
        }

        private int getSplineFlingDuration(int i3) {
            return (int) (Math.exp(getSplineDeceleration(i3) / (DECELERATION_RATE - 1.0d)) * 1000.0d);
        }

        static void initFromContext(Context context) {
            PHYSICAL_COEF = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        private void onEdgeReached() {
            float f16;
            long j3 = this.mStartTime;
            int i3 = this.mDuration;
            long j16 = j3 + i3;
            int i16 = this.mSplineDuration;
            int i17 = (int) ((i3 / i16) * 100.0f);
            if (i17 < 100) {
                int i18 = i17 + 1;
                float[] fArr = SPLINE_POSITION;
                f16 = (fArr[i18] - fArr[i17]) / ((i18 / 100.0f) - (i17 / 100.0f));
            } else {
                f16 = 0.0f;
            }
            float f17 = ((f16 * this.mSplineDistance) / i16) * 1000.0f;
            this.mCurrVelocity = f17;
            this.mDeceleration = (float) (((f17 - this.mLastVelocity) / (j16 - this.mLastTime)) * 1000.0d);
            bounce(this.mFinal, this.mOver, (int) f17, OverScroller.BOUNCE_DURANTION);
            this.mStartTime = j16;
            update();
        }

        private void onEdgeReachedNoBack() {
            float f16;
            long j3 = this.mStartTime;
            int i3 = this.mDuration;
            long j16 = j3 + i3;
            int i16 = this.mSplineDuration;
            int i17 = (int) ((i3 / i16) * 100.0f);
            if (i17 < 100) {
                int i18 = i17 + 1;
                float[] fArr = SPLINE_POSITION;
                f16 = (fArr[i18] - fArr[i17]) / ((i18 / 100.0f) - (i17 / 100.0f));
            } else {
                f16 = 0.0f;
            }
            float f17 = ((f16 * this.mSplineDistance) / i16) * 1000.0f;
            this.mCurrVelocity = f17;
            this.mDeceleration = (float) (((f17 - this.mLastVelocity) / (j16 - this.mLastTime)) * 1000.0d);
            this.mStartTime = j16;
        }

        private void startSpringback(int i3, int i16, int i17) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i3;
            this.mFinal = i16;
            this.mOver = i16 - i3;
            this.mDuration = OverScroller.BOUNCE_DURANTION;
        }

        void bounce(int i3, int i16, int i17, int i18) {
            float f16;
            float f17 = (i16 * 0.09606f) / (i18 * 1.0000001E-5f);
            if (i17 > 0) {
                f16 = 10.0f;
            } else {
                f16 = -10.0f;
            }
            if (Math.abs(i17) < f17) {
                f16 = (i17 * 10.0f) / f17;
            }
            this.mStart = i3;
            this.mFinal = i3;
            this.mVelocity = i17;
            this.mOver = i16;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i18;
            this.mTension = f16;
            this.mCurrentPosition = this.mStart;
            this.mState = 3;
        }

        boolean continueWhenFinished() {
            int i3 = this.mState;
            if (i3 != 0) {
                if (i3 == 1 || i3 == 3) {
                    return false;
                }
            } else {
                if (this.mDuration >= this.mSplineDuration) {
                    return false;
                }
                onEdgeReached();
            }
            update();
            return true;
        }

        boolean continueWhenFinishedForNoBack() {
            int i3 = this.mState;
            if (i3 == 0 || i3 == 1 || i3 == 3) {
                return false;
            }
            update();
            return true;
        }

        void extendDuration(int i3) {
            this.mDuration = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) + i3;
            this.mFinished = false;
        }

        void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        void fling(int i3, int i16, int i17, int i18, int i19) {
            double d16;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mOver = i19;
            this.mFinished = false;
            this.mVelocity = i16;
            this.mCurrVelocity = i16;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i3;
            this.mCurrentPosition = i3;
            if (i3 <= i18 && i3 >= i17) {
                this.mState = 0;
                if (i16 != 0) {
                    if (this.mFlingMode == 1) {
                        int splineFlingDuration = (getSplineFlingDuration(i16) * 3) / 2;
                        this.mSplineDuration = splineFlingDuration;
                        this.mDuration = splineFlingDuration;
                    } else {
                        int splineFlingDuration2 = getSplineFlingDuration(i16);
                        this.mSplineDuration = splineFlingDuration2;
                        this.mDuration = splineFlingDuration2;
                    }
                    this.mDeceleration = (float) (getSplineDeceleration(i16) * 1000.0d);
                    d16 = getSplineFlingDistance(i16);
                } else {
                    d16 = 0.0d;
                }
                int signum = (int) (d16 * Math.signum(r9));
                this.mSplineDistance = signum;
                int i26 = i3 + signum;
                this.mFinal = i26;
                if (i26 < i17) {
                    adjustDuration(this.mStart, i26, i17);
                    this.mFinal = i17;
                }
                int i27 = this.mFinal;
                if (i27 > i18) {
                    adjustDuration(this.mStart, i27, i18);
                    this.mFinal = i18;
                }
                this.mLastVelocity = i16;
                this.mLastTime = this.mStartTime;
                return;
            }
            if (i3 > i18) {
                i17 = i18;
            }
            startSpringback(i3, i17, i16);
        }

        void notifyEdgeReached(int i3, int i16, int i17) {
            int i18 = this.mState;
            if (i18 == 0) {
                if (i3 == i16) {
                    bounce(i16, i17, this.mVelocity, OverScroller.BOUNCE_DURANTION);
                    return;
                }
                adjustDuration(this.mStart, this.mFinal, this.mCurrentPosition - (i3 - i16));
                this.mOver = i17;
                this.mFinal = i16;
                onEdgeReached();
                return;
            }
            if (i18 == 4) {
                this.mCurrentPosition = 0;
                this.mFinal = 0;
                this.mFinished = true;
            }
        }

        void setFinalPosition(int i3) {
            this.mFinal = i3;
            this.mFinished = false;
        }

        void setFlingMode(int i3) {
            if (i3 == 0 || i3 == 1) {
                this.mFlingMode = i3;
            }
        }

        void setFriction(float f16) {
            this.mFlingFriction = f16;
        }

        boolean springback(int i3, int i16, int i17) {
            this.mFinished = true;
            this.mFinal = i3;
            this.mStart = i3;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i3 < i16) {
                startSpringback(i3, i16, 0);
            } else if (i3 > i17) {
                startSpringback(i3, i17, 0);
            }
            return !this.mFinished;
        }

        void startScroll(int i3, int i16, int i17) {
            this.mFinished = false;
            this.mStart = i3;
            this.mFinal = i3 + i16;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i17;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
            this.mState = 4;
        }

        boolean update() {
            float f16;
            double d16;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            int i3 = this.mDuration;
            if (currentAnimationTimeMillis > i3) {
                return false;
            }
            int i16 = this.mState;
            float f17 = 1.0f;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 3) {
                        d16 = 0.0d;
                    } else {
                        float f18 = (((float) currentAnimationTimeMillis) / i3) - 1.0f;
                        float f19 = this.mTension;
                        d16 = this.mOver * f18 * f18 * f18 * f18 * ((f18 * f19) + f19);
                    }
                } else {
                    d16 = AnimateUtils.viscousFluid(((float) currentAnimationTimeMillis) / i3) * this.mOver;
                }
            } else {
                int i17 = this.mSplineDuration;
                float f26 = ((float) currentAnimationTimeMillis) / i17;
                int i18 = (int) (f26 * 100.0f);
                if (i18 < 100) {
                    float f27 = i18 / 100.0f;
                    int i19 = i18 + 1;
                    float[] fArr = SPLINE_POSITION;
                    float f28 = fArr[i18];
                    f16 = (fArr[i19] - f28) / ((i19 / 100.0f) - f27);
                    f17 = f28 + ((f26 - f27) * f16);
                } else {
                    f16 = 0.0f;
                }
                int i26 = this.mSplineDistance;
                float f29 = ((f16 * i26) / i17) * 1000.0f;
                this.mCurrVelocity = f29;
                this.mDeceleration = (float) (((f29 - this.mLastVelocity) / (r0 - this.mLastTime)) * 1000.0d);
                d16 = f17 * i26;
            }
            this.mCurrentPosition = this.mStart + ((int) Math.round(d16));
            return true;
        }

        void updateScroll(float f16) {
            this.mCurrentPosition = this.mStart + Math.round(f16 * (this.mFinal - r0));
        }

        private void startSpringback(int i3, int i16, int i17, int i18) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i3;
            this.mFinal = i16;
            this.mOver = i16 - i3;
            this.mDuration = i18;
        }

        boolean springback(int i3, int i16, int i17, int i18) {
            this.mFinished = true;
            this.mFinal = i3;
            this.mStart = i3;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i3 < i16) {
                startSpringback(i3, i16, 0, i18);
            } else if (i3 > i17) {
                startSpringback(i3, i17, 0, i18);
            }
            return !this.mFinished;
        }
    }

    public OverScroller(Context context, Interpolator interpolator, float f16, float f17) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, float f16, float f17, boolean z16) {
        this(context, interpolator, z16);
    }

    public void fling(long j3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        fling(i3, i16, i17, i18, i19, i26, i27, i28, i29, i36);
        this.mScrollerX.mStartTime = j3;
        this.mScrollerY.mStartTime = j3;
    }
}
