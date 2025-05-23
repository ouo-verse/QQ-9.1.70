package com.tencent.mtt.hippy.dom.flex;

/* compiled from: P */
/* loaded from: classes20.dex */
public class k {
    public static boolean a(float f16, float f17) {
        if (!Float.isNaN(f16) && !Float.isNaN(f17)) {
            if (Math.abs(f17 - f16) < 1.0E-5f) {
                return true;
            }
            return false;
        }
        if (Float.isNaN(f16) && Float.isNaN(f17)) {
            return true;
        }
        return false;
    }
}
