package com.gyailib.library;

/* loaded from: classes2.dex */
public class GYAssessPicQualityOption {
    public float deblurAvgScore;
    public int enableDeblur;
    public int enableDelogo;
    public int enableFace;

    public void setPicEnhanceOption(int i3, int i16, int i17, float f16) {
        this.enableDelogo = i3;
        this.enableDeblur = i16;
        this.enableFace = i17;
        this.deblurAvgScore = f16;
    }
}
