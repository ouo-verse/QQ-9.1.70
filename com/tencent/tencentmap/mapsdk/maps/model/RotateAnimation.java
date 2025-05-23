package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
@Deprecated
/* loaded from: classes26.dex */
public class RotateAnimation extends BaseAnimation {
    public float mFromDegree;
    public float mPivoteX;
    public float mPivoteY;
    public float mPivoteZ;
    public float mToDegree;

    public RotateAnimation(float f16, float f17, float f18, float f19, float f26) {
        this.mFromDegree = f16;
        this.mToDegree = f17;
        this.mPivoteX = f18;
        this.mPivoteY = f19;
        this.mPivoteZ = f26;
    }
}
