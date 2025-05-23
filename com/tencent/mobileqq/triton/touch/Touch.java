package com.tencent.mobileqq.triton.touch;

/* compiled from: P */
/* loaded from: classes19.dex */
public class Touch {
    public int identifier;
    public float screenX;
    public float screenY;

    public Touch(int i3, float f16, float f17) {
        this.identifier = i3;
        this.screenX = f16;
        this.screenY = f17;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public void setLocation(float f16, float f17) {
        this.screenX = f16;
        this.screenY = f17;
    }
}
