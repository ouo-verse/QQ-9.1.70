package android.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes.dex */
public class AIOOverScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE = 0;
    private static final String TAG = "AIOOverScroller";
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SplineOverScroller {
        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static final int SPLINE = 0;
        private static final float START_TENSION = 0.5f;
        private float mCurrVelocity;
        private int mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private int mFinal;
        private int mOver;
        private float mPhysicalCoeff;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mStart;
        private long mStartTime;
        private int mVelocity;
        private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] SPLINE_POSITION = new float[101];
        private static final float[] SPLINE_TIME = new float[101];
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private int mState = 0;
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

        SplineOverScroller(Context context) {
            this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
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

        private void fitOnBounceCurve(int i3, int i16, int i17) {
            float f16 = (-i17) / this.mDeceleration;
            float f17 = i17;
            float sqrt = (float) Math.sqrt((((((f17 * f17) / 2.0f) / Math.abs(r1)) + Math.abs(i16 - i3)) * 2.0d) / Math.abs(this.mDeceleration));
            this.mStartTime -= (int) ((sqrt - f16) * 1000.0f);
            this.mStart = i16;
            this.mCurrentPosition = i16;
            this.mVelocity = (int) ((-this.mDeceleration) * sqrt);
        }

        private static float getDeceleration(int i3) {
            if (i3 > 0) {
                return -2000.0f;
            }
            return 2000.0f;
        }

        private double getSplineDeceleration(int i3) {
            return Math.log((Math.abs(i3) * 0.35f) / (this.mFlingFriction * this.mPhysicalCoeff));
        }

        private double getSplineFlingDistance(int i3) {
            double splineDeceleration = getSplineDeceleration(i3);
            float f16 = DECELERATION_RATE;
            return this.mFlingFriction * this.mPhysicalCoeff * Math.exp((f16 / (f16 - 1.0d)) * splineDeceleration);
        }

        private int getSplineFlingDuration(int i3) {
            return (int) (Math.exp(getSplineDeceleration(i3) / (DECELERATION_RATE - 1.0d)) * 1000.0d);
        }

        private void onEdgeReached() {
            int i3 = this.mVelocity;
            float f16 = i3 * i3;
            float abs = f16 / (Math.abs(this.mDeceleration) * 2.0f);
            float signum = Math.signum(this.mVelocity);
            int i16 = this.mOver;
            if (abs > i16) {
                this.mDeceleration = ((-signum) * f16) / (i16 * 2.0f);
                abs = i16;
            }
            this.mOver = (int) abs;
            this.mState = 2;
            int i17 = this.mStart;
            int i18 = this.mVelocity;
            if (i18 <= 0) {
                abs = -abs;
            }
            this.mFinal = i17 + ((int) abs);
            this.mDuration = -((int) ((i18 * 1000.0f) / this.mDeceleration));
        }

        private void startAfterEdge(int i3, int i16, int i17, int i18) {
            boolean z16;
            int i19;
            int i26;
            int i27;
            boolean z17 = true;
            if (i3 > i16 && i3 < i17) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            if (i3 > i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i19 = i17;
            } else {
                i19 = i16;
            }
            if ((i3 - i19) * i18 < 0) {
                z17 = false;
            }
            if (z17) {
                startBounceAfterEdge(i3, i19, i18);
                return;
            }
            if (getSplineFlingDistance(i18) > Math.abs(r4)) {
                if (z16) {
                    i26 = i16;
                } else {
                    i26 = i3;
                }
                if (z16) {
                    i27 = i3;
                } else {
                    i27 = i17;
                }
                fling(i3, i18, i26, i27, this.mOver);
                return;
            }
            startSpringback(i3, i19, i18);
        }

        private void startBounceAfterEdge(int i3, int i16, int i17) {
            int i18;
            if (i17 == 0) {
                i18 = i3 - i16;
            } else {
                i18 = i17;
            }
            this.mDeceleration = getDeceleration(i18);
            fitOnBounceCurve(i3, i16, i17);
            onEdgeReached();
        }

        private void startSpringback(int i3, int i16, int i17) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i3;
            this.mCurrentPosition = i3;
            this.mFinal = i16;
            int i18 = i3 - i16;
            this.mDeceleration = getDeceleration(i18);
            this.mVelocity = -i18;
            this.mOver = Math.abs(i18);
            this.mDuration = (int) (Math.sqrt((i18 * (-2.0d)) / this.mDeceleration) * 1000.0d);
        }

        boolean continueWhenFinished() {
            int i3 = this.mState;
            if (i3 != 0) {
                if (i3 == 1) {
                    return false;
                }
                if (i3 == 2) {
                    this.mStartTime += this.mDuration;
                    startSpringback(this.mFinal, this.mStart, 0);
                }
            } else {
                if (this.mDuration >= this.mSplineDuration) {
                    return false;
                }
                int i16 = this.mFinal;
                this.mStart = i16;
                this.mCurrentPosition = i16;
                int i17 = (int) this.mCurrVelocity;
                this.mVelocity = i17;
                this.mDeceleration = getDeceleration(i17);
                this.mStartTime += this.mDuration;
                onEdgeReached();
            }
            update();
            return true;
        }

        void extendDuration(int i3) {
            int currentAnimationTimeMillis = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) + i3;
            this.mSplineDuration = currentAnimationTimeMillis;
            this.mDuration = currentAnimationTimeMillis;
            this.mFinished = false;
        }

        void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        void fling(int i3, int i16, int i17, int i18, int i19) {
            double d16;
            this.mOver = i19;
            this.mFinished = false;
            this.mVelocity = i16;
            this.mCurrVelocity = i16;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i3;
            this.mCurrentPosition = i3;
            if (i3 <= i18 && i3 >= i17) {
                this.mState = 0;
                if (i16 != 0) {
                    int splineFlingDuration = getSplineFlingDuration(i16);
                    this.mSplineDuration = splineFlingDuration;
                    this.mDuration = splineFlingDuration;
                    d16 = getSplineFlingDistance(i16);
                } else {
                    d16 = 0.0d;
                }
                int signum = (int) (d16 * Math.signum(r0));
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
                    return;
                }
                return;
            }
            startAfterEdge(i3, i17, i18, i16);
        }

        void notifyEdgeReached(int i3, int i16, int i17) {
            if (this.mState == 0) {
                this.mOver = i17;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i3, i16, i16, (int) this.mCurrVelocity);
            }
        }

        void setFinalPosition(int i3) {
            this.mFinal = i3;
            this.mSplineDistance = i3 - this.mStart;
            this.mFinished = false;
        }

        void setFriction(float f16) {
            this.mFlingFriction = f16;
        }

        boolean springback(int i3, int i16, int i17) {
            this.mFinished = true;
            this.mFinal = i3;
            this.mStart = i3;
            this.mCurrentPosition = i3;
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
            this.mCurrentPosition = i3;
            this.mFinal = i3 + i16;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i17;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
        }

        boolean update() {
            float f16;
            float f17;
            double d16;
            try {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
                if (currentAnimationTimeMillis == 0) {
                    if (this.mDuration <= 0) {
                        return false;
                    }
                    return true;
                }
                int i3 = this.mDuration;
                if (currentAnimationTimeMillis > i3) {
                    return false;
                }
                int i16 = this.mState;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            d16 = 0.0d;
                        } else {
                            float f18 = ((float) currentAnimationTimeMillis) / 1000.0f;
                            int i17 = this.mVelocity;
                            float f19 = this.mDeceleration;
                            this.mCurrVelocity = i17 + (f19 * f18);
                            d16 = (i17 * f18) + (((f19 * f18) * f18) / 2.0f);
                        }
                    } else {
                        float f26 = ((float) currentAnimationTimeMillis) / i3;
                        float f27 = f26 * f26;
                        float signum = Math.signum(this.mVelocity);
                        int i18 = this.mOver;
                        this.mCurrVelocity = signum * i18 * 6.0f * ((-f26) + f27);
                        d16 = i18 * signum * ((3.0f * f27) - ((2.0f * f26) * f27));
                    }
                } else {
                    int i19 = this.mSplineDuration;
                    float f28 = ((float) currentAnimationTimeMillis) / i19;
                    int i26 = (int) (f28 * 100.0f);
                    if (i26 < 100) {
                        float f29 = i26 / 100.0f;
                        int i27 = i26 + 1;
                        float[] fArr = SPLINE_POSITION;
                        float f36 = fArr[i26];
                        f17 = (fArr[i27] - f36) / ((i27 / 100.0f) - f29);
                        f16 = f36 + ((f28 - f29) * f17);
                    } else {
                        f16 = 1.0f;
                        f17 = 0.0f;
                    }
                    int i28 = this.mSplineDistance;
                    this.mCurrVelocity = ((f17 * i28) / i19) * 1000.0f;
                    d16 = f16 * i28;
                }
                this.mCurrentPosition = this.mStart + ((int) Math.round(d16));
                return true;
            } catch (Exception e16) {
                com.tencent.aio.base.log.a.f69187b.e(AIOOverScroller.TAG, " e " + e16.getLocalizedMessage());
                return false;
            }
        }

        void updateScroll(float f16) {
            this.mCurrentPosition = this.mStart + Math.round(f16 * (this.mFinal - r0));
        }
    }

    public AIOOverScroller(Context context) {
        this(context, null);
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public boolean computeScrollOffset() {
        if (isFinished()) {
            return false;
        }
        int i3 = this.mMode;
        if (i3 != 0) {
            if (i3 == 1) {
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
                float interpolation = this.mInterpolator.getInterpolation(((float) currentAnimationTimeMillis) / i16);
                this.mScrollerX.updateScroll(interpolation);
                this.mScrollerY.updateScroll(interpolation);
            } else {
                abortAnimation();
            }
        }
        return true;
    }

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
        return (float) Math.hypot(this.mScrollerX.mCurrVelocity, this.mScrollerY.mCurrVelocity);
    }

    public final int getCurrX() {
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return this.mScrollerY.mCurrentPosition;
    }

    public final int getDuration() {
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public final int getFinalX() {
        return this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return this.mScrollerY.mFinal;
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

    public void setFinalX(int i3) {
        this.mScrollerX.setFinalPosition(i3);
    }

    public void setFinalY(int i3) {
        this.mScrollerY.setFinalPosition(i3);
    }

    public final void setFriction(float f16) {
        this.mScrollerX.setFriction(f16);
        this.mScrollerY.setFriction(f16);
    }

    void setInterpolator(Interpolator interpolator) {
        if (interpolator == null) {
            this.mInterpolator = new AIOScrollerInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
    }

    public boolean springBack(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.mMode = 1;
        boolean springback = this.mScrollerX.springback(i3, i17, i18);
        boolean springback2 = this.mScrollerY.springback(i16, i19, i26);
        if (springback || springback2) {
            return true;
        }
        return false;
    }

    public void startScroll(int i3, int i16, int i17, int i18) {
        startScroll(i3, i16, i17, i18, 250);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime));
    }

    public AIOOverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        int i37;
        int i38;
        int i39;
        int i46;
        if (!this.mFlywheel || isFinished()) {
            i37 = i17;
        } else {
            float f16 = this.mScrollerX.mCurrVelocity;
            float f17 = this.mScrollerY.mCurrVelocity;
            i37 = i17;
            float f18 = i37;
            if (Math.signum(f18) == Math.signum(f16)) {
                i38 = i18;
                float f19 = i38;
                if (Math.signum(f19) == Math.signum(f17)) {
                    i39 = (int) (f19 + f17);
                    i46 = (int) (f18 + f16);
                    this.mMode = 1;
                    this.mScrollerX.fling(i3, i46, i19, i26, i29);
                    this.mScrollerY.fling(i16, i39, i27, i28, i36);
                }
                i39 = i38;
                i46 = i37;
                this.mMode = 1;
                this.mScrollerX.fling(i3, i46, i19, i26, i29);
                this.mScrollerY.fling(i16, i39, i27, i28, i36);
            }
        }
        i38 = i18;
        i39 = i38;
        i46 = i37;
        this.mMode = 1;
        this.mScrollerX.fling(i3, i46, i19, i26, i29);
        this.mScrollerY.fling(i16, i39, i27, i28, i36);
    }

    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        this.mMode = 0;
        this.mScrollerX.startScroll(i3, i17, i19);
        this.mScrollerY.startScroll(i16, i18, i19);
    }

    public AIOOverScroller(Context context, Interpolator interpolator, boolean z16) {
        if (interpolator == null) {
            this.mInterpolator = new AIOScrollerInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
        this.mFlywheel = z16;
        this.mScrollerX = new SplineOverScroller(context);
        this.mScrollerY = new SplineOverScroller(context);
    }

    @Deprecated
    public AIOOverScroller(Context context, Interpolator interpolator, float f16, float f17) {
        this(context, interpolator, true);
    }

    @Deprecated
    public AIOOverScroller(Context context, Interpolator interpolator, float f16, float f17, boolean z16) {
        this(context, interpolator, z16);
    }
}
