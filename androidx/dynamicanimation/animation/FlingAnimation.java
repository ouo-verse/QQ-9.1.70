package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        DragForce() {
        }

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f16, float f17) {
            return f17 * this.mFriction;
        }

        float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f16, float f17) {
            if (Math.abs(f17) < this.mVelocityThreshold) {
                return true;
            }
            return false;
        }

        void setFrictionScalar(float f16) {
            this.mFriction = f16 * DEFAULT_FRICTION;
        }

        void setValueThreshold(float f16) {
            this.mVelocityThreshold = f16 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        DynamicAnimation.MassState updateValueAndVelocity(float f16, float f17, long j3) {
            float f18 = (float) j3;
            this.mMassState.mVelocity = (float) (f17 * Math.exp((f18 / 1000.0f) * this.mFriction));
            DynamicAnimation.MassState massState = this.mMassState;
            float f19 = this.mFriction;
            massState.mValue = (float) ((f16 - (f17 / f19)) + ((f17 / f19) * Math.exp((f19 * f18) / 1000.0f)));
            DynamicAnimation.MassState massState2 = this.mMassState;
            if (isAtEquilibrium(massState2.mValue, massState2.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    float getAcceleration(float f16, float f17) {
        return this.mFlingForce.getAcceleration(f16, f17);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean isAtEquilibrium(float f16, float f17) {
        if (f16 < this.mMaxValue && f16 > this.mMinValue && !this.mFlingForce.isAtEquilibrium(f16, f17)) {
            return false;
        }
        return true;
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f16) {
        if (f16 > 0.0f) {
            this.mFlingForce.setFrictionScalar(f16);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void setValueThreshold(float f16) {
        this.mFlingForce.setValueThreshold(f16);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean updateValueAndVelocity(long j3) {
        DynamicAnimation.MassState updateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j3);
        float f16 = updateValueAndVelocity.mValue;
        this.mValue = f16;
        float f17 = updateValueAndVelocity.mVelocity;
        this.mVelocity = f17;
        float f18 = this.mMinValue;
        if (f16 < f18) {
            this.mValue = f18;
            return true;
        }
        float f19 = this.mMaxValue;
        if (f16 > f19) {
            this.mValue = f19;
            return true;
        }
        if (isAtEquilibrium(f16, f17)) {
            return true;
        }
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f16) {
        super.setMaxValue(f16);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f16) {
        super.setMinValue(f16);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f16) {
        super.setStartVelocity(f16);
        return this;
    }

    public <K> FlingAnimation(K k3, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k3, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
