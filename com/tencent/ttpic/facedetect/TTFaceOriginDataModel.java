package com.tencent.ttpic.facedetect;

import java.io.Serializable;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TTFaceOriginDataModel implements Serializable {
    public float cls;
    public float[][] facePoint = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 94, 2);
    public float[] facePointVisible = new float[94];
    public float pitch;
    public float roll;
    public float yaw;
}
