package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested;
    private float mPendingPosition;
    private SpringForce mSpring;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    private void sanityCheck() {
        SpringForce springForce = this.mSpring;
        if (springForce != null) {
            double finalPosition = springForce.getFinalPosition();
            if (finalPosition <= this.mMaxValue) {
                if (finalPosition >= this.mMinValue) {
                    return;
                } else {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public void animateToFinalPosition(float f16) {
        if (isRunning()) {
            this.mPendingPosition = f16;
            return;
        }
        if (this.mSpring == null) {
            this.mSpring = new SpringForce(f16);
        }
        this.mSpring.setFinalPosition(f16);
        start();
    }

    public boolean canSkipToEnd() {
        if (this.mSpring.mDampingRatio > 0.0d) {
            return true;
        }
        return false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    float getAcceleration(float f16, float f17) {
        return this.mSpring.getAcceleration(f16, f17);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean isAtEquilibrium(float f16, float f17) {
        return this.mSpring.isAtEquilibrium(f16, f17);
    }

    public SpringAnimation setSpring(SpringForce springForce) {
        this.mSpring = springForce;
        return this;
    }

    public void skipToEnd() {
        if (canSkipToEnd()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.mRunning) {
                    this.mEndRequested = true;
                    return;
                }
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void start() {
        sanityCheck();
        this.mSpring.setValueThreshold(getValueThreshold());
        super.start();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean updateValueAndVelocity(long j3) {
        if (this.mEndRequested) {
            float f16 = this.mPendingPosition;
            if (f16 != Float.MAX_VALUE) {
                this.mSpring.setFinalPosition(f16);
                this.mPendingPosition = Float.MAX_VALUE;
            }
            this.mValue = this.mSpring.getFinalPosition();
            this.mVelocity = 0.0f;
            this.mEndRequested = false;
            return true;
        }
        if (this.mPendingPosition != Float.MAX_VALUE) {
            this.mSpring.getFinalPosition();
            long j16 = j3 / 2;
            DynamicAnimation.MassState updateValues = this.mSpring.updateValues(this.mValue, this.mVelocity, j16);
            this.mSpring.setFinalPosition(this.mPendingPosition);
            this.mPendingPosition = Float.MAX_VALUE;
            DynamicAnimation.MassState updateValues2 = this.mSpring.updateValues(updateValues.mValue, updateValues.mVelocity, j16);
            this.mValue = updateValues2.mValue;
            this.mVelocity = updateValues2.mVelocity;
        } else {
            DynamicAnimation.MassState updateValues3 = this.mSpring.updateValues(this.mValue, this.mVelocity, j3);
            this.mValue = updateValues3.mValue;
            this.mVelocity = updateValues3.mVelocity;
        }
        float max = Math.max(this.mValue, this.mMinValue);
        this.mValue = max;
        float min = Math.min(max, this.mMaxValue);
        this.mValue = min;
        if (!isAtEquilibrium(min, this.mVelocity)) {
            return false;
        }
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        return true;
    }

    public <K> SpringAnimation(K k3, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k3, floatPropertyCompat);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public <K> SpringAnimation(K k3, FloatPropertyCompat<K> floatPropertyCompat, float f16) {
        super(k3, floatPropertyCompat);
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
        this.mSpring = new SpringForce(f16);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void setValueThreshold(float f16) {
    }
}
