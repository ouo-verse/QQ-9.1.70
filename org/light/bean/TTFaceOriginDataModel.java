package org.light.bean;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TTFaceOriginDataModel implements Serializable {
    public int cls;
    public float[] facePoint;
    public float[] facePointVisible;
    public float pitch;
    public float roll;
    public float yaw;

    public TTFaceOriginDataModel() {
        this.facePoint = new float[188];
        this.facePointVisible = new float[94];
    }

    public TTFaceOriginDataModel(float[] fArr, float[] fArr2, float f16, float f17, float f18) {
        this.facePoint = fArr;
        this.facePointVisible = fArr2;
        this.pitch = f16;
        this.yaw = f17;
        this.roll = f18;
    }
}
