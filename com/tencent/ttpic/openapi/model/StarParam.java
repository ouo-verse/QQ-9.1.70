package com.tencent.ttpic.openapi.model;

import android.graphics.Bitmap;

/* loaded from: classes27.dex */
public class StarParam {
    public static final int TYPE_BLUR = 0;
    public static final int TYPE_PARTICLE = 1;
    public String materialId;
    public Bitmap starBlurColorImage;
    public int starType = 0;
    public float starStrength = -1.0f;
    public float starBlurMaxScale = 1.0f;
    public float starBlurMinScale = 1.0f;
    public long starBlurScalePeriod = 1000;
    public float starMinThreshold = 0.0f;
    public float starMaxThreshold = 1.0f;
}
