package com.tencent.mobileqq.vas.util;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasColorUtil {
    public static int getColorWithAlpha(float f16, int i3) {
        return (Math.min(255, Math.max(0, (int) (f16 * 255.0f))) << 24) + (i3 & 16777215);
    }
}
