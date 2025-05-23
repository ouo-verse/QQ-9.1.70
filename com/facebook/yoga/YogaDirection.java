package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaDirection {
    INHERIT(0),
    LTR(1),
    RTL(2);

    private final int mIntValue;

    YogaDirection(int i3) {
        this.mIntValue = i3;
    }

    public static YogaDirection fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return RTL;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i3);
            }
            return LTR;
        }
        return INHERIT;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
