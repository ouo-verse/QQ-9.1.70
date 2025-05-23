package com.tencent.xnet;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class ClassifierXnet {
    public native boolean Classifier(Bitmap bitmap, int[] iArr, String[] strArr, float[] fArr, float[] fArr2, int i3, int i16);

    public native boolean ClassifierFeatureExtractor(Bitmap bitmap, int[] iArr, String[] strArr, float[] fArr, float[] fArr2, int i3, float[] fArr3, int i16);

    public native boolean FeatureExtractor(Bitmap bitmap, float[] fArr, int i3);

    public native boolean GetFeaturemapSize(int[] iArr);

    public native boolean GetOuputsize(int[] iArr);

    public native boolean Init(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public native boolean Uninit();
}
