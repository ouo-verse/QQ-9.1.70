package com.tencent.component.animation.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Spring {
    private static int ID = 0;
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private static final double SOLVER_TIMESTEP_SEC = 0.001d;
    private final PhysicsState mCurrentState;
    private double mEndValue;
    private final String mId;
    private boolean mOvershootClampingEnabled;
    private final PhysicsState mPreviousState;
    private SpringConfig mSpringConfig;
    private final BaseSpringSystem mSpringSystem;
    private double mStartValue;
    private final PhysicsState mTempState;
    private boolean mWasAtRest = true;
    private double mRestSpeedThreshold = 0.005d;
    private double mDisplacementFromRestThreshold = 0.005d;
    private CopyOnWriteArraySet<SpringListener> mListeners = new CopyOnWriteArraySet<>();
    private double mTimeAccumulator = 0.0d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class PhysicsState {
        double position;
        double velocity;

        PhysicsState() {
        }

        /* synthetic */ PhysicsState(PhysicsState physicsState) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spring(BaseSpringSystem baseSpringSystem) {
        PhysicsState physicsState = null;
        this.mCurrentState = new PhysicsState(physicsState);
        this.mPreviousState = new PhysicsState(physicsState);
        this.mTempState = new PhysicsState(physicsState);
        if (baseSpringSystem != null) {
            this.mSpringSystem = baseSpringSystem;
            StringBuilder sb5 = new StringBuilder("spring:");
            int i3 = ID;
            ID = i3 + 1;
            sb5.append(i3);
            this.mId = sb5.toString();
            setSpringConfig(SpringConfig.defaultConfig);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    private double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.mEndValue - physicsState.position);
    }

    private void interpolate(double d16) {
        PhysicsState physicsState = this.mCurrentState;
        double d17 = physicsState.position * d16;
        PhysicsState physicsState2 = this.mPreviousState;
        double d18 = 1.0d - d16;
        physicsState.position = d17 + (physicsState2.position * d18);
        physicsState.velocity = (physicsState.velocity * d16) + (physicsState2.velocity * d18);
    }

    public Spring addListener(SpringListener springListener) {
        if (springListener != null) {
            this.mListeners.add(springListener);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void advance(double d16) {
        double d17;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean isAtRest = isAtRest();
        if (isAtRest && this.mWasAtRest) {
            return;
        }
        double d18 = MAX_DELTA_TIME_SEC;
        if (d16 <= MAX_DELTA_TIME_SEC) {
            d18 = d16;
        }
        this.mTimeAccumulator += d18;
        SpringConfig springConfig = this.mSpringConfig;
        double d19 = springConfig.tension;
        double d26 = springConfig.friction;
        PhysicsState physicsState = this.mCurrentState;
        double d27 = physicsState.position;
        double d28 = physicsState.velocity;
        PhysicsState physicsState2 = this.mTempState;
        double d29 = physicsState2.position;
        double d36 = physicsState2.velocity;
        while (true) {
            d17 = this.mTimeAccumulator;
            if (d17 < 0.001d) {
                break;
            }
            double d37 = d17 - 0.001d;
            this.mTimeAccumulator = d37;
            if (d37 < 0.001d) {
                PhysicsState physicsState3 = this.mPreviousState;
                physicsState3.position = d27;
                physicsState3.velocity = d28;
            }
            double d38 = this.mEndValue;
            double d39 = ((d38 - d29) * d19) - (d26 * d28);
            double d46 = d28 + (d39 * 0.001d * 0.5d);
            double d47 = ((d38 - (((d28 * 0.001d) * 0.5d) + d27)) * d19) - (d26 * d46);
            double d48 = d28 + (d47 * 0.001d * 0.5d);
            double d49 = ((d38 - (d27 + ((d46 * 0.001d) * 0.5d))) * d19) - (d26 * d48);
            double d56 = d27 + (d48 * 0.001d);
            double d57 = d28 + (d49 * 0.001d);
            d27 += (d28 + ((d46 + d48) * 2.0d) + d57) * 0.16666666666666666d * 0.001d;
            d28 += (d39 + ((d47 + d49) * 2.0d) + (((d38 - d56) * d19) - (d26 * d57))) * 0.16666666666666666d * 0.001d;
            d29 = d56;
            d36 = d57;
        }
        PhysicsState physicsState4 = this.mTempState;
        physicsState4.position = d29;
        physicsState4.velocity = d36;
        PhysicsState physicsState5 = this.mCurrentState;
        physicsState5.position = d27;
        physicsState5.velocity = d28;
        if (d17 > 0.0d) {
            interpolate(d17 / 0.001d);
        }
        if (!isAtRest() && (!this.mOvershootClampingEnabled || !isOvershooting())) {
            z16 = isAtRest;
        } else {
            if (d19 > 0.0d) {
                double d58 = this.mEndValue;
                this.mStartValue = d58;
                this.mCurrentState.position = d58;
            } else {
                double d59 = this.mCurrentState.position;
                this.mEndValue = d59;
                this.mStartValue = d59;
            }
            setVelocity(0.0d);
            z16 = true;
        }
        if (this.mWasAtRest) {
            this.mWasAtRest = false;
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            this.mWasAtRest = true;
            z18 = true;
        } else {
            z18 = false;
        }
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            SpringListener next = it.next();
            if (z17) {
                next.onSpringActivate(this);
            }
            next.onSpringUpdate(this);
            if (z18) {
                next.onSpringAtRest(this);
            }
        }
    }

    public boolean currentValueIsApproximately(double d16) {
        if (Math.abs(getCurrentValue() - d16) <= getRestDisplacementThreshold()) {
            return true;
        }
        return false;
    }

    public void destroy() {
        this.mListeners.clear();
        this.mSpringSystem.deregisterSpring(this);
    }

    public double getCurrentDisplacementDistance() {
        return getDisplacementDistanceForState(this.mCurrentState);
    }

    public double getCurrentValue() {
        return this.mCurrentState.position;
    }

    public double getEndValue() {
        return this.mEndValue;
    }

    public String getId() {
        return this.mId;
    }

    public double getRestDisplacementThreshold() {
        return this.mDisplacementFromRestThreshold;
    }

    public double getRestSpeedThreshold() {
        return this.mRestSpeedThreshold;
    }

    public SpringConfig getSpringConfig() {
        return this.mSpringConfig;
    }

    public double getStartValue() {
        return this.mStartValue;
    }

    public double getVelocity() {
        return this.mCurrentState.velocity;
    }

    public boolean isAtRest() {
        if (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold) {
            if (getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold || this.mSpringConfig.tension == 0.0d) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean isOvershootClampingEnabled() {
        return this.mOvershootClampingEnabled;
    }

    public boolean isOvershooting() {
        if (this.mSpringConfig.tension > 0.0d) {
            if (this.mStartValue >= this.mEndValue || getCurrentValue() <= this.mEndValue) {
                if (this.mStartValue > this.mEndValue && getCurrentValue() < this.mEndValue) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public Spring removeAllListeners() {
        this.mListeners.clear();
        return this;
    }

    public Spring removeListener(SpringListener springListener) {
        if (springListener != null) {
            this.mListeners.remove(springListener);
            return this;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }

    public Spring setAtRest() {
        PhysicsState physicsState = this.mCurrentState;
        double d16 = physicsState.position;
        this.mEndValue = d16;
        this.mTempState.position = d16;
        physicsState.velocity = 0.0d;
        return this;
    }

    public Spring setCurrentValue(double d16) {
        return setCurrentValue(d16, true);
    }

    public Spring setEndValue(double d16) {
        if (this.mEndValue == d16 && isAtRest()) {
            return this;
        }
        this.mStartValue = getCurrentValue();
        this.mEndValue = d16;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringEndStateChange(this);
        }
        return this;
    }

    public Spring setOvershootClampingEnabled(boolean z16) {
        this.mOvershootClampingEnabled = z16;
        return this;
    }

    public Spring setRestDisplacementThreshold(double d16) {
        this.mDisplacementFromRestThreshold = d16;
        return this;
    }

    public Spring setRestSpeedThreshold(double d16) {
        this.mRestSpeedThreshold = d16;
        return this;
    }

    public Spring setSpringConfig(SpringConfig springConfig) {
        if (springConfig != null) {
            this.mSpringConfig = springConfig;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public Spring setVelocity(double d16) {
        PhysicsState physicsState = this.mCurrentState;
        if (d16 == physicsState.velocity) {
            return this;
        }
        physicsState.velocity = d16;
        this.mSpringSystem.activateSpring(getId());
        return this;
    }

    public boolean systemShouldAdvance() {
        if (isAtRest() && wasAtRest()) {
            return false;
        }
        return true;
    }

    public boolean wasAtRest() {
        return this.mWasAtRest;
    }

    public Spring setCurrentValue(double d16, boolean z16) {
        this.mStartValue = d16;
        this.mCurrentState.position = d16;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z16) {
            setAtRest();
        }
        return this;
    }
}
