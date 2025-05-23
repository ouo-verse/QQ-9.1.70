package org.light.bean;

import java.io.Serializable;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TTCatFaceOriginDataModel implements Serializable {
    public float classifyConfidence;
    public String classifyName;
    public float confidence;
    public float[] eulerAngle = new float[3];
    public float[][] catFacePoint = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 20, 2);
}
