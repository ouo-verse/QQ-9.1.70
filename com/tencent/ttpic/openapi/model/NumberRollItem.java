package com.tencent.ttpic.openapi.model;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NumberRollItem {
    public float left = 0.0f;
    public float top = 0.0f;
    public float right = 0.0f;
    public float bottom = 0.0f;
    public float maxSpeed = 0.0f;
    public float speedUpTime = 0.0f;
    public float continueTime = 0.0f;
    public float stopTime = 0.0f;
    public int targetNumber = 0;
    public float currentPosition = 0.0f;

    public void calculateCurrentPosition(float f16) {
        float f17;
        float f18 = this.speedUpTime;
        if (f16 < f18) {
            this.currentPosition = (((this.maxSpeed * f16) * f16) / f18) * 0.5f;
        } else {
            float f19 = this.continueTime;
            if (f16 < f18 + f19) {
                float f26 = this.maxSpeed;
                this.currentPosition = (f18 * f26 * 0.5f) + ((f16 - f18) * f26);
            } else {
                float f27 = this.maxSpeed;
                float f28 = this.stopTime;
                float f29 = f27 * f28 * 0.5f;
                float f36 = ((((f18 * f27) * 0.5f) + (f19 * f27)) + f29) - ((int) r4);
                float f37 = this.targetNumber / 10.0f;
                if (f37 >= f36) {
                    f17 = f37 - f36;
                } else {
                    f17 = (f37 - f36) + 1.0f;
                }
                float f38 = (((f29 + f17) * 2.0f) / f27) - f28;
                float f39 = f28 - f38;
                if (f16 < f18 + f19 + f38) {
                    this.currentPosition = (f18 * f27 * 0.5f) + (f19 * f27) + (((f16 - f18) - f19) * f27);
                } else if (f16 < f18 + f19 + f28) {
                    float f46 = ((f16 - f18) - f19) - f38;
                    this.currentPosition = (f18 * f27 * 0.5f) + (f19 * f27) + (f38 * f27) + ((f27 + (((f39 - f46) / f39) * f27)) * f46 * 0.5f);
                } else {
                    this.currentPosition = (f18 * f27 * 0.5f) + (f19 * f27) + (f38 * f27) + (f39 * f27 * 0.5f);
                }
            }
        }
        this.currentPosition = this.currentPosition - ((int) r10);
    }
}
