package com.gyailib.library;

/* loaded from: classes2.dex */
public class GYAssessPicQualityInfo {
    public int detectOption;
    public int deviceParams;
    public int framesCnt;
    public float heightParams;
    public float kBps;
    public float secondsParams;
    public int typePrams = 0;
    public float widthParams;

    public void initStruct(float f16, float f17, float f18, float f19, int i3, int i16, int i17, int i18) {
        this.kBps = f16;
        this.widthParams = f17;
        this.heightParams = f18;
        this.secondsParams = f19;
        this.deviceParams = i3;
        this.typePrams = i16;
        this.framesCnt = i17;
        this.detectOption = i18;
    }

    public void setGYAssessPicQualityInfo(float f16, float f17, float f18, float f19, int i3, int i16, int i17, int i18) {
        this.kBps = f16;
        this.widthParams = f17;
        this.heightParams = f18;
        this.secondsParams = f19;
        this.deviceParams = i3;
        this.typePrams = i16;
        this.framesCnt = i17;
        this.detectOption = i18;
    }

    public void initStruct(float f16, float f17, float f18, float f19, int i3, int i16, int i17) {
        initStruct(f16, f17, f18, f19, i3, i16, i17, 0);
    }

    public void setGYAssessPicQualityInfo(float f16, float f17, float f18, float f19, int i3, int i16, int i17) {
        setGYAssessPicQualityInfo(f16, f17, f18, f19, i3, i16, i17, 0);
    }
}
