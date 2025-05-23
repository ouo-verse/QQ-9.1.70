package org.light.bean;

import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes29.dex */
public class PTBodyAttr implements Serializable {
    public float[][] bodyPoint = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 59, 2);
    public float classifyConfidence;
    public String classifyName;
    public float confidence;
}
