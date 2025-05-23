package com.tencent.liteav.videobase.utils;

import android.graphics.PointF;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.List;

@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class PerspectiveTransformMatrixCalculator {
    public static float[] getPerspectiveTransformMatrix(List<PointF> list, List<PointF> list2) {
        return nativeGetPerspectiveTransformMatrix(com.tencent.liteav.base.util.f.a(list), com.tencent.liteav.base.util.f.a(list2));
    }

    public static native float[] nativeGetPerspectiveTransformMatrix(float[] fArr, float[] fArr2);
}
