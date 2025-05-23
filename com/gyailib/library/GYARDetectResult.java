package com.gyailib.library;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYARDetectResult {
    float[] cameraModelMatrix;
    float[] projectionMatrix;

    public void setData(float[] fArr, float[] fArr2) {
        this.cameraModelMatrix = fArr;
        this.projectionMatrix = fArr2;
    }
}
