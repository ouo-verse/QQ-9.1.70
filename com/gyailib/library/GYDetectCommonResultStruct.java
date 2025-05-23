package com.gyailib.library;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYDetectCommonResultStruct {
    public float height;
    public GYDetectCommonItemParams[] items;
    public float width;

    public void initStruct(float f16, float f17, int i3) {
        this.width = f16;
        this.height = f17;
        this.items = new GYDetectCommonItemParams[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            this.items[i16] = new GYDetectCommonItemParams();
        }
    }

    public void setItem(int i3, int i16, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, String str, String str2, float f16, int i17, float[] fArr5, float[] fArr6, int[] iArr, float[] fArr7, String[] strArr) {
        GYDetectCommonItemParams[] gYDetectCommonItemParamsArr = this.items;
        if (gYDetectCommonItemParamsArr != null && i3 < gYDetectCommonItemParamsArr.length) {
            GYDetectCommonItemParams gYDetectCommonItemParams = gYDetectCommonItemParamsArr[i3];
            gYDetectCommonItemParams.pointsCount = i16;
            gYDetectCommonItemParams.pointX = fArr;
            gYDetectCommonItemParams.pointY = fArr2;
            gYDetectCommonItemParams.heightMap = fArr3;
            gYDetectCommonItemParams.eulerAngle = fArr4;
            gYDetectCommonItemParams.classifyName = str;
            gYDetectCommonItemParams.classifyType = str2;
            gYDetectCommonItemParams.classifyConfidence = f16;
            gYDetectCommonItemParams.index = i17;
            gYDetectCommonItemParams.vVisible = fArr5;
            gYDetectCommonItemParams.vConfidence = fArr6;
            gYDetectCommonItemParams.vExtInt = iArr;
            gYDetectCommonItemParams.vExtFloat = fArr7;
            gYDetectCommonItemParams.vExtString = strArr;
        }
    }

    public void setItemBase(int i3, int i16, float f16, float f17, float f18, float f19, float f26, float f27, int i17, int i18) {
        GYDetectCommonItemParams[] gYDetectCommonItemParamsArr = this.items;
        if (gYDetectCommonItemParamsArr != null && i3 < gYDetectCommonItemParamsArr.length) {
            GYDetectCommonItemParams gYDetectCommonItemParams = gYDetectCommonItemParamsArr[i3];
            gYDetectCommonItemParams.itemId = i16;
            gYDetectCommonItemParams.frameX = f16;
            gYDetectCommonItemParams.frameY = f17;
            gYDetectCommonItemParams.frameW = f18;
            gYDetectCommonItemParams.frameH = f19;
            gYDetectCommonItemParams.frameConfidence = f26;
            gYDetectCommonItemParams.confidence = f27;
            gYDetectCommonItemParams.age = i17;
            gYDetectCommonItemParams.gender = i18;
        }
    }
}
