package com.tencent.liteav.base.util;

import android.graphics.PointF;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f {
    public static boolean a(float f16, float f17) {
        return Math.abs(f16 - f17) < 1.0E-6f;
    }

    public static float[] a(List<PointF> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        float[] fArr = new float[size * 2];
        for (int i3 = 0; i3 < size; i3++) {
            PointF pointF = list.get(i3);
            int i16 = i3 * 2;
            fArr[i16] = pointF.x;
            fArr[i16 + 1] = pointF.y;
        }
        return fArr;
    }
}
