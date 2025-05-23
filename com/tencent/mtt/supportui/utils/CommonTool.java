package com.tencent.mtt.supportui.utils;

/* compiled from: P */
/* loaded from: classes21.dex */
public class CommonTool {
    public static boolean hasPositiveItem(float[] fArr) {
        if (fArr != null) {
            for (float f16 : fArr) {
                if (f16 > 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }
}
