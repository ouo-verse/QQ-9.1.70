package com.tencent.tuxmeterqui.timepicker.number_picker;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Scroller {
    static IPatchRedirector $redirector_ = null;
    private static float DECELERATION_RATE = 0.0f;
    private static final int DEFAULT_DURATION = 250;
    private static final float END_TENSION = 1.0f;
    private static final int FLING_MODE = 1;
    private static final float INFLEXION = 0.35f;
    private static final int NB_SAMPLES = 100;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final int SCROLL_MODE = 0;
    private static final float[] SPLINE_POSITION;
    private static final float[] SPLINE_TIME;
    private static final float START_TENSION = 0.5f;
    private float mCurrVelocity;
    private int mCurrX;
    private int mCurrY;
    private float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private int mDistance;
    private int mDuration;
    private float mDurationReciprocal;
    private int mFinalX;
    private int mFinalY;
    private boolean mFinished;
    private float mFlingFriction;
    private boolean mFlywheel;
    private final Interpolator mInterpolator;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private int mMode;
    private float mPhysicalCoeff;
    private final float mPpi;
    private long mStartTime;
    private int mStartX;
    private int mStartY;
    private float mVelocity;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    static class ViscousFluidInterpolator implements Interpolator {
        static IPatchRedirector $redirector_ = null;
        private static final float VISCOUS_FLUID_NORMALIZE;
        private static final float VISCOUS_FLUID_OFFSET;
        private static final float VISCOUS_FLUID_SCALE = 8.0f;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14840);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            float viscousFluid = 1.0f / viscousFluid(1.0f);
            VISCOUS_FLUID_NORMALIZE = viscousFluid;
            VISCOUS_FLUID_OFFSET = 1.0f - (viscousFluid * viscousFluid(1.0f));
        }

        ViscousFluidInterpolator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static float viscousFluid(float f16) {
            float f17 = f16 * 8.0f;
            if (f17 < 1.0f) {
                return f17 - (1.0f - ((float) Math.exp(-f17)));
            }
            return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            float viscousFluid = VISCOUS_FLUID_NORMALIZE * viscousFluid(f16);
            if (viscousFluid > 0.0f) {
                return viscousFluid + VISCOUS_FLUID_OFFSET;
            }
            return viscousFluid;
        }
    }

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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14856);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        SPLINE_POSITION = new float[101];
        SPLINE_TIME = new float[101];
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

    public Scroller(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private float computeDeceleration(float f16) {
        return this.mPpi * 386.0878f * f16;
    }

    private double getSplineDeceleration(float f16) {
        return Math.log((Math.abs(f16) * 0.35f) / (this.mFlingFriction * this.mPhysicalCoeff));
    }

    private double getSplineFlingDistance(float f16) {
        double splineDeceleration = getSplineDeceleration(f16);
        float f17 = DECELERATION_RATE;
        return this.mFlingFriction * this.mPhysicalCoeff * Math.exp((f17 / (f17 - 1.0d)) * splineDeceleration);
    }

    private int getSplineFlingDuration(float f16) {
        return (int) (Math.exp(getSplineDeceleration(f16) / (DECELERATION_RATE - 1.0d)) * 1000.0d);
    }

    public void abortAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.mCurrX = this.mFinalX;
        this.mCurrY = this.mFinalY;
        this.mFinished = true;
    }

    public boolean computeScrollOffset() {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.mFinished) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        int i3 = this.mDuration;
        if (currentAnimationTimeMillis < i3) {
            int i16 = this.mMode;
            if (i16 != 0) {
                if (i16 == 1) {
                    float f18 = currentAnimationTimeMillis / i3;
                    int i17 = (int) (f18 * 100.0f);
                    if (i17 < 100) {
                        float f19 = i17 / 100.0f;
                        int i18 = i17 + 1;
                        float[] fArr = SPLINE_POSITION;
                        float f26 = fArr[i17];
                        f17 = (fArr[i18] - f26) / ((i18 / 100.0f) - f19);
                        f16 = f26 + ((f18 - f19) * f17);
                    } else {
                        f16 = 1.0f;
                        f17 = 0.0f;
                    }
                    this.mCurrVelocity = ((f17 * this.mDistance) / i3) * 1000.0f;
                    int round = this.mStartX + Math.round((this.mFinalX - r0) * f16);
                    this.mCurrX = round;
                    int min = Math.min(round, this.mMaxX);
                    this.mCurrX = min;
                    this.mCurrX = Math.max(min, this.mMinX);
                    int round2 = this.mStartY + Math.round(f16 * (this.mFinalY - r0));
                    this.mCurrY = round2;
                    int min2 = Math.min(round2, this.mMaxY);
                    this.mCurrY = min2;
                    int max = Math.max(min2, this.mMinY);
                    this.mCurrY = max;
                    if (this.mCurrX == this.mFinalX && max == this.mFinalY) {
                        this.mFinished = true;
                    }
                }
            } else {
                float interpolation = this.mInterpolator.getInterpolation(currentAnimationTimeMillis * this.mDurationReciprocal);
                this.mCurrX = this.mStartX + Math.round(this.mDeltaX * interpolation);
                this.mCurrY = this.mStartY + Math.round(interpolation * this.mDeltaY);
            }
        } else {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mFinished = true;
        }
        return true;
    }

    public void extendDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        int timePassed = timePassed() + i3;
        this.mDuration = timePassed;
        this.mDurationReciprocal = 1.0f / timePassed;
        this.mFinished = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29;
        int i36;
        float hypot;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
            return;
        }
        if (this.mFlywheel && !this.mFinished) {
            float currVelocity = getCurrVelocity();
            float f17 = this.mFinalX - this.mStartX;
            float f18 = this.mFinalY - this.mStartY;
            float hypot2 = (float) Math.hypot(f17, f18);
            float f19 = (f17 / hypot2) * currVelocity;
            float f26 = (f18 / hypot2) * currVelocity;
            i29 = i17;
            float f27 = i29;
            if (Math.signum(f27) == Math.signum(f19)) {
                i36 = i18;
                float f28 = i36;
                if (Math.signum(f28) == Math.signum(f26)) {
                    i29 = (int) (f27 + f19);
                    i36 = (int) (f28 + f26);
                }
                this.mMode = 1;
                this.mFinished = false;
                hypot = (float) Math.hypot(i29, i36);
                this.mVelocity = hypot;
                this.mDuration = getSplineFlingDuration(hypot);
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.mStartX = i3;
                this.mStartY = i16;
                float f29 = 1.0f;
                if (hypot != 0.0f) {
                    f16 = 1.0f;
                } else {
                    f16 = i29 / hypot;
                }
                if (hypot != 0.0f) {
                    f29 = i36 / hypot;
                }
                double splineFlingDistance = getSplineFlingDistance(hypot);
                this.mDistance = (int) (Math.signum(hypot) * splineFlingDistance);
                this.mMinX = i19;
                this.mMaxX = i26;
                this.mMinY = i27;
                this.mMaxY = i28;
                int round = i3 + ((int) Math.round(f16 * splineFlingDistance));
                this.mFinalX = round;
                int min = Math.min(round, this.mMaxX);
                this.mFinalX = min;
                this.mFinalX = Math.max(min, this.mMinX);
                int round2 = ((int) Math.round(splineFlingDistance * f29)) + i16;
                this.mFinalY = round2;
                int min2 = Math.min(round2, this.mMaxY);
                this.mFinalY = min2;
                this.mFinalY = Math.max(min2, this.mMinY);
            }
        } else {
            i29 = i17;
        }
        i36 = i18;
        this.mMode = 1;
        this.mFinished = false;
        hypot = (float) Math.hypot(i29, i36);
        this.mVelocity = hypot;
        this.mDuration = getSplineFlingDuration(hypot);
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i3;
        this.mStartY = i16;
        float f292 = 1.0f;
        if (hypot != 0.0f) {
        }
        if (hypot != 0.0f) {
        }
        double splineFlingDistance2 = getSplineFlingDistance(hypot);
        this.mDistance = (int) (Math.signum(hypot) * splineFlingDistance2);
        this.mMinX = i19;
        this.mMaxX = i26;
        this.mMinY = i27;
        this.mMaxY = i28;
        int round3 = i3 + ((int) Math.round(f16 * splineFlingDistance2));
        this.mFinalX = round3;
        int min3 = Math.min(round3, this.mMaxX);
        this.mFinalX = min3;
        this.mFinalX = Math.max(min3, this.mMinX);
        int round22 = ((int) Math.round(splineFlingDistance2 * f292)) + i16;
        this.mFinalY = round22;
        int min22 = Math.min(round22, this.mMaxY);
        this.mFinalY = min22;
        this.mFinalY = Math.max(min22, this.mMinY);
    }

    public final void forceFinished(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mFinished = z16;
        }
    }

    public float getCurrVelocity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        if (this.mMode == 1) {
            return this.mCurrVelocity;
        }
        return this.mVelocity - ((this.mDeceleration * timePassed()) / 2000.0f);
    }

    public final int getCurrX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mCurrX;
    }

    public final int getCurrY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mCurrY;
    }

    public final int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mDuration;
    }

    public final int getFinalX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mFinalX;
    }

    public final int getFinalY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mFinalY;
    }

    public final int getStartX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mStartX;
    }

    public final int getStartY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mStartY;
    }

    public final boolean isFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mFinished;
    }

    public boolean isScrollingInDirection(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (!this.mFinished && Math.signum(f16) == Math.signum(this.mFinalX - this.mStartX) && Math.signum(f17) == Math.signum(this.mFinalY - this.mStartY)) {
            return true;
        }
        return false;
    }

    public void setFinalX(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        this.mFinalX = i3;
        this.mDeltaX = i3 - this.mStartX;
        this.mFinished = false;
    }

    public void setFinalY(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        this.mFinalY = i3;
        this.mDeltaY = i3 - this.mStartY;
        this.mFinished = false;
    }

    public final void setFriction(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.mDeceleration = computeDeceleration(f16);
            this.mFlingFriction = f16;
        }
    }

    public void startScroll(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            startScroll(i3, i16, i17, i18, 250);
        } else {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    public int timePassed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    }

    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) interpolator);
    }

    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        this.mMode = 0;
        this.mFinished = false;
        this.mDuration = i19;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i3;
        this.mStartY = i16;
        this.mFinalX = i3 + i17;
        this.mFinalY = i16 + i18;
        this.mDeltaX = i17;
        this.mDeltaY = i18;
        this.mDurationReciprocal = 1.0f / this.mDuration;
    }

    public Scroller(Context context, Interpolator interpolator, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, interpolator, Boolean.valueOf(z16));
            return;
        }
        this.mFlingFriction = ViewConfiguration.getScrollFriction();
        this.mFinished = true;
        if (interpolator == null) {
            this.mInterpolator = new ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
        this.mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        this.mFlywheel = z16;
        this.mPhysicalCoeff = computeDeceleration(0.84f);
    }
}
