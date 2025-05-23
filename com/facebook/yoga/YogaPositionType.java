package com.facebook.yoga;

/* loaded from: classes2.dex */
public enum YogaPositionType {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);

    private final int mIntValue;

    YogaPositionType(int i3) {
        this.mIntValue = i3;
    }

    public static YogaPositionType fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return ABSOLUTE;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i3);
            }
            return RELATIVE;
        }
        return STATIC;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
