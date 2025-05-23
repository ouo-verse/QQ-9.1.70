package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final DynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition != Double.MAX_VALUE) {
            double d16 = this.mDampingRatio;
            if (d16 > 1.0d) {
                double d17 = this.mNaturalFreq;
                this.mGammaPlus = ((-d16) * d17) + (d17 * Math.sqrt((d16 * d16) - 1.0d));
                double d18 = this.mDampingRatio;
                double d19 = this.mNaturalFreq;
                this.mGammaMinus = ((-d18) * d19) - (d19 * Math.sqrt((d18 * d18) - 1.0d));
            } else if (d16 >= 0.0d && d16 < 1.0d) {
                this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0d - (d16 * d16));
            }
            this.mInitialized = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float f16, float f17) {
        float finalPosition = f16 - getFinalPosition();
        double d16 = this.mNaturalFreq;
        return (float) (((-(d16 * d16)) * finalPosition) - (((d16 * 2.0d) * this.mDampingRatio) * f17));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d16 = this.mNaturalFreq;
        return (float) (d16 * d16);
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float f16, float f17) {
        if (Math.abs(f17) < this.mVelocityThreshold && Math.abs(f16 - getFinalPosition()) < this.mValueThreshold) {
            return true;
        }
        return false;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float f16) {
        if (f16 >= 0.0f) {
            this.mDampingRatio = f16;
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float f16) {
        this.mFinalPosition = f16;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f16) {
        if (f16 > 0.0f) {
            this.mNaturalFreq = Math.sqrt(f16);
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValueThreshold(double d16) {
        double abs = Math.abs(d16);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicAnimation.MassState updateValues(double d16, double d17, long j3) {
        double cos;
        double d18;
        init();
        double d19 = j3 / 1000.0d;
        double d26 = d16 - this.mFinalPosition;
        double d27 = this.mDampingRatio;
        if (d27 > 1.0d) {
            double d28 = this.mGammaMinus;
            double d29 = this.mGammaPlus;
            double d36 = d26 - (((d28 * d26) - d17) / (d28 - d29));
            double d37 = ((d26 * d28) - d17) / (d28 - d29);
            d18 = (Math.pow(2.718281828459045d, d28 * d19) * d36) + (Math.pow(2.718281828459045d, this.mGammaPlus * d19) * d37);
            double d38 = this.mGammaMinus;
            double pow = d36 * d38 * Math.pow(2.718281828459045d, d38 * d19);
            double d39 = this.mGammaPlus;
            cos = pow + (d37 * d39 * Math.pow(2.718281828459045d, d39 * d19));
        } else if (d27 == 1.0d) {
            double d46 = this.mNaturalFreq;
            double d47 = d17 + (d46 * d26);
            double d48 = d26 + (d47 * d19);
            d18 = Math.pow(2.718281828459045d, (-d46) * d19) * d48;
            double pow2 = d48 * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d19);
            double d49 = this.mNaturalFreq;
            cos = (d47 * Math.pow(2.718281828459045d, (-d49) * d19)) + (pow2 * (-d49));
        } else {
            double d56 = 1.0d / this.mDampedFreq;
            double d57 = this.mNaturalFreq;
            double d58 = d56 * ((d27 * d57 * d26) + d17);
            double pow3 = Math.pow(2.718281828459045d, (-d27) * d57 * d19) * ((Math.cos(this.mDampedFreq * d19) * d26) + (Math.sin(this.mDampedFreq * d19) * d58));
            double d59 = this.mNaturalFreq;
            double d65 = this.mDampingRatio;
            double d66 = (-d59) * pow3 * d65;
            double pow4 = Math.pow(2.718281828459045d, (-d65) * d59 * d19);
            double d67 = this.mDampedFreq;
            double sin = (-d67) * d26 * Math.sin(d67 * d19);
            double d68 = this.mDampedFreq;
            cos = d66 + (pow4 * (sin + (d58 * d68 * Math.cos(d68 * d19))));
            d18 = pow3;
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (d18 + this.mFinalPosition);
        massState.mVelocity = (float) cos;
        return massState;
    }

    public SpringForce(float f16) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = f16;
    }
}
