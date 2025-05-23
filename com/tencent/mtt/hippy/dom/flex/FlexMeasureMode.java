package com.tencent.mtt.hippy.dom.flex;

/* compiled from: P */
/* loaded from: classes20.dex */
public enum FlexMeasureMode {
    UNDEFINED,
    EXACTLY,
    AT_MOST;

    public static FlexMeasureMode fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return AT_MOST;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i3);
            }
            return EXACTLY;
        }
        return UNDEFINED;
    }
}
