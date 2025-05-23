package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaDisplay {
    FLEX(0),
    NONE(1);

    private final int mIntValue;

    YogaDisplay(int i3) {
        this.mIntValue = i3;
    }

    public static YogaDisplay fromInt(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return NONE;
            }
            throw new IllegalArgumentException("Unknown enum value: " + i3);
        }
        return FLEX;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
