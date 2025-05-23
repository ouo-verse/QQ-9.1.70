package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaWrap {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);

    private final int mIntValue;

    YogaWrap(int i3) {
        this.mIntValue = i3;
    }

    public static YogaWrap fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return WRAP_REVERSE;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i3);
            }
            return WRAP;
        }
        return NO_WRAP;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
