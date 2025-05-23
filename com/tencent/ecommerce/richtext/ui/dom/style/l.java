package com.tencent.ecommerce.richtext.ui.dom.style;

/* compiled from: P */
/* loaded from: classes5.dex */
public class l {
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
