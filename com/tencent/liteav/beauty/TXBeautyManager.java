package com.tencent.liteav.beauty;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface TXBeautyManager {
    public static final int TXBeautyStyleNature = 1;
    public static final int TXBeautyStylePitu = 2;
    public static final int TXBeautyStyleSmooth = 0;

    void enableSharpnessEnhancement(boolean z16);

    void setBeautyLevel(float f16);

    void setBeautyStyle(int i3);

    int setChinLevel(float f16);

    int setEyeAngleLevel(float f16);

    int setEyeDistanceLevel(float f16);

    int setEyeLightenLevel(float f16);

    int setEyeScaleLevel(float f16);

    int setFaceBeautyLevel(float f16);

    int setFaceNarrowLevel(float f16);

    int setFaceShortLevel(float f16);

    int setFaceSlimLevel(float f16);

    int setFaceVLevel(float f16);

    void setFilter(Bitmap bitmap);

    void setFilterStrength(float f16);

    int setForeheadLevel(float f16);

    int setGreenScreenFile(String str);

    int setLipsThicknessLevel(float f16);

    void setMotionMute(boolean z16);

    void setMotionTmpl(String str);

    int setMouthShapeLevel(float f16);

    int setNosePositionLevel(float f16);

    int setNoseSlimLevel(float f16);

    int setNoseWingLevel(float f16);

    int setPounchRemoveLevel(float f16);

    void setRuddyLevel(float f16);

    int setSmileLinesRemoveLevel(float f16);

    int setToothWhitenLevel(float f16);

    void setWhitenessLevel(float f16);

    int setWrinkleRemoveLevel(float f16);
}
