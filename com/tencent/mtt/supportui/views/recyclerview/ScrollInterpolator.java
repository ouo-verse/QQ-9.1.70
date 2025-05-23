package com.tencent.mtt.supportui.views.recyclerview;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ScrollInterpolator {
    private float mVelocity = 2500.0f;
    private float mPhysicsTimeStep = 0.008333334f;
    private float mSpringTightness = 7.0f;
    private float mSpringDampening = 15.0f;
    private float mMinStep = 1.5f;

    private float Spring(float f16, int i3, int i16, float f17, float f18) {
        float f19 = i3 - i16;
        if (f19 < 0.0f) {
            f19 = -f19;
        }
        return ((-f17) * f19) - (f18 * f16);
    }

    public int getStep(int i3, int i16, int i17) {
        if (i16 == 0) {
            return 0;
        }
        float Spring = this.mVelocity + (Spring(this.mVelocity, i3, i17, this.mSpringTightness, this.mSpringDampening) * this.mPhysicsTimeStep);
        this.mVelocity = Spring;
        float f16 = Spring / 50.0f;
        float f17 = this.mMinStep;
        if (f16 < f17) {
            f16 = f17;
        }
        return (int) f16;
    }

    public void initVelocity(int i3) {
        this.mVelocity = Math.abs(i3) * 8;
    }
}
