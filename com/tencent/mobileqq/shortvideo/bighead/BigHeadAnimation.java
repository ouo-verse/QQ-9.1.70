package com.tencent.mobileqq.shortvideo.bighead;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BigHeadAnimation implements BigIAnimation {
    public float mMaxScale;
    public float mMinScale;
    public float mTimeCycle;
    private float scaleNumber = 0.0f;
    private long mStartTime = -1;
    private boolean mForward = true;

    public BigHeadAnimation() {
        setAnimationAttr(1.15f, 1.4f, 800.0f);
    }

    private void setAnimationAttr(float f16, float f17, float f18) {
        this.mMinScale = f16;
        this.mMaxScale = f17;
        this.mTimeCycle = f18;
        this.scaleNumber = f17 - f16;
    }

    @Override // com.tencent.mobileqq.shortvideo.bighead.BigIAnimation
    public float getCurrentScale(long j3) {
        float f16;
        if (this.mStartTime == -1) {
            this.mStartTime = j3;
        }
        float min = Math.min((((float) (j3 - this.mStartTime)) * 1.0f) / this.mTimeCycle, 1.0f);
        boolean z16 = this.mForward;
        if (z16) {
            f16 = this.mMinScale + (this.scaleNumber * min);
        } else {
            f16 = this.mMaxScale - (this.scaleNumber * min);
        }
        if (min >= 1.0f) {
            this.mStartTime = -1L;
            this.mForward = !z16;
        }
        return f16;
    }

    @Override // com.tencent.mobileqq.shortvideo.bighead.BigIAnimation
    public float getMaxScale() {
        return this.mMaxScale;
    }
}
