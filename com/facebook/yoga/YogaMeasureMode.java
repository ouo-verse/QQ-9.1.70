package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaMeasureMode {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    private final int mIntValue;

    YogaMeasureMode(int i3) {
        this.mIntValue = i3;
    }

    public static YogaMeasureMode fromInt(int i3) {
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

    public int intValue() {
        return this.mIntValue;
    }
}
