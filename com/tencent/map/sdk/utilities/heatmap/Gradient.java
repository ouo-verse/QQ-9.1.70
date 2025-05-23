package com.tencent.map.sdk.utilities.heatmap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Gradient extends com.tencent.map.sdk.utilities.visualization.Gradient {
    public Gradient(int[] iArr, float[] fArr) {
        super(iArr, fArr);
    }

    public Gradient(int[] iArr, float[] fArr, int i3) {
        super(iArr, fArr, i3);
    }

    public Gradient(com.tencent.map.sdk.utilities.visualization.Gradient gradient) {
        super(gradient.mColors, gradient.mStartPoints, gradient.mColorMapSize);
    }
}
