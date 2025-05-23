package androidx.constraintlayout.motion.utils;

import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* compiled from: P */
/* loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {
    private boolean mBackwards = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f16) {
        float f17 = this.mStage1Duration;
        if (f16 <= f17) {
            float f18 = this.mStage1Velocity;
            return (f18 * f16) + ((((this.mStage2Velocity - f18) * f16) * f16) / (f17 * 2.0f));
        }
        int i3 = this.mNumberOfStages;
        if (i3 == 1) {
            return this.mStage1EndPosition;
        }
        float f19 = f16 - f17;
        float f26 = this.mStage2Duration;
        if (f19 < f26) {
            float f27 = this.mStage1EndPosition;
            float f28 = this.mStage2Velocity;
            return f27 + (f28 * f19) + ((((this.mStage3Velocity - f28) * f19) * f19) / (f26 * 2.0f));
        }
        if (i3 == 2) {
            return this.mStage2EndPosition;
        }
        float f29 = f19 - f26;
        float f36 = this.mStage3Duration;
        if (f29 < f36) {
            float f37 = this.mStage2EndPosition;
            float f38 = this.mStage3Velocity;
            return (f37 + (f38 * f29)) - (((f38 * f29) * f29) / (f36 * 2.0f));
        }
        return this.mStage3EndPosition;
    }

    private void setup(float f16, float f17, float f18, float f19, float f26) {
        if (f16 == 0.0f) {
            f16 = 1.0E-4f;
        }
        this.mStage1Velocity = f16;
        float f27 = f16 / f18;
        float f28 = (f27 * f16) / 2.0f;
        if (f16 < 0.0f) {
            float sqrt = (float) Math.sqrt((f17 - ((((-f16) / f18) * f16) / 2.0f)) * f18);
            if (sqrt < f19) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f16;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                float f29 = (sqrt - f16) / f18;
                this.mStage1Duration = f29;
                this.mStage2Duration = sqrt / f18;
                this.mStage1EndPosition = ((f16 + sqrt) * f29) / 2.0f;
                this.mStage2EndPosition = f17;
                this.mStage3EndPosition = f17;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f16;
            this.mStage2Velocity = f19;
            this.mStage3Velocity = f19;
            float f36 = (f19 - f16) / f18;
            this.mStage1Duration = f36;
            float f37 = f19 / f18;
            this.mStage3Duration = f37;
            float f38 = ((f16 + f19) * f36) / 2.0f;
            float f39 = (f37 * f19) / 2.0f;
            this.mStage2Duration = ((f17 - f38) - f39) / f19;
            this.mStage1EndPosition = f38;
            this.mStage2EndPosition = f17 - f39;
            this.mStage3EndPosition = f17;
            return;
        }
        if (f28 >= f17) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f16;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f17;
            this.mStage1Duration = (2.0f * f17) / f16;
            return;
        }
        float f46 = f17 - f28;
        float f47 = f46 / f16;
        if (f47 + f27 < f26) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f16;
            this.mStage2Velocity = f16;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f46;
            this.mStage2EndPosition = f17;
            this.mStage1Duration = f47;
            this.mStage2Duration = f27;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f18 * f17) + ((f16 * f16) / 2.0f));
        float f48 = (sqrt2 - f16) / f18;
        this.mStage1Duration = f48;
        float f49 = sqrt2 / f18;
        this.mStage2Duration = f49;
        if (sqrt2 < f19) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f16;
            this.mStage2Velocity = sqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f48;
            this.mStage2Duration = f49;
            this.mStage1EndPosition = ((f16 + sqrt2) * f48) / 2.0f;
            this.mStage2EndPosition = f17;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f16;
        this.mStage2Velocity = f19;
        this.mStage3Velocity = f19;
        float f56 = (f19 - f16) / f18;
        this.mStage1Duration = f56;
        float f57 = f19 / f18;
        this.mStage3Duration = f57;
        float f58 = ((f16 + f19) * f56) / 2.0f;
        float f59 = (f57 * f19) / 2.0f;
        this.mStage2Duration = ((f17 - f58) - f59) / f19;
        this.mStage1EndPosition = f58;
        this.mStage2EndPosition = f17 - f59;
        this.mStage3EndPosition = f17;
    }

    public void config(float f16, float f17, float f18, float f19, float f26, float f27) {
        boolean z16;
        this.mStartPosition = f16;
        if (f16 > f17) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mBackwards = z16;
        if (z16) {
            setup(-f18, f16 - f17, f26, f27, f19);
        } else {
            setup(f18, f17 - f16, f26, f27, f19);
        }
    }

    public void debug(String str, String str2, float f16) {
        String str3;
        Log.v(str, str2 + " ===== " + this.mType);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        if (this.mBackwards) {
            str3 = "backwards";
        } else {
            str3 = "forward ";
        }
        sb5.append(str3);
        sb5.append(" time = ");
        sb5.append(f16);
        sb5.append("  stages ");
        sb5.append(this.mNumberOfStages);
        Log.v(str, sb5.toString());
        Log.v(str, str2 + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition);
        if (this.mNumberOfStages > 1) {
            Log.v(str, str2 + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition);
        }
        if (this.mNumberOfStages > 2) {
            Log.v(str, str2 + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition);
        }
        float f17 = this.mStage1Duration;
        if (f16 <= f17) {
            Log.v(str, str2 + "stage 0");
            return;
        }
        int i3 = this.mNumberOfStages;
        if (i3 == 1) {
            Log.v(str, str2 + "end stage 0");
            return;
        }
        float f18 = f16 - f17;
        float f19 = this.mStage2Duration;
        if (f18 < f19) {
            Log.v(str, str2 + " stage 1");
            return;
        }
        if (i3 == 2) {
            Log.v(str, str2 + "end stage 1");
            return;
        }
        if (f18 - f19 < this.mStage3Duration) {
            Log.v(str, str2 + " stage 2");
            return;
        }
        Log.v(str, str2 + " end stage 2");
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        float calcY = calcY(f16);
        this.mLastPosition = f16;
        if (this.mBackwards) {
            return this.mStartPosition - calcY;
        }
        return this.mStartPosition + calcY;
    }

    public float getVelocity(float f16) {
        float f17 = this.mStage1Duration;
        if (f16 <= f17) {
            float f18 = this.mStage1Velocity;
            return f18 + (((this.mStage2Velocity - f18) * f16) / f17);
        }
        int i3 = this.mNumberOfStages;
        if (i3 == 1) {
            return 0.0f;
        }
        float f19 = f16 - f17;
        float f26 = this.mStage2Duration;
        if (f19 < f26) {
            float f27 = this.mStage2Velocity;
            return f27 + (((this.mStage3Velocity - f27) * f19) / f26);
        }
        if (i3 == 2) {
            return this.mStage2EndPosition;
        }
        float f28 = f19 - f26;
        float f29 = this.mStage3Duration;
        if (f28 < f29) {
            float f36 = this.mStage3Velocity;
            return f36 - ((f28 * f36) / f29);
        }
        return this.mStage3EndPosition;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }
}
