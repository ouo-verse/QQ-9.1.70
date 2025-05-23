package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaOverflow {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);

    private final int mIntValue;

    YogaOverflow(int i3) {
        this.mIntValue = i3;
    }

    public static YogaOverflow fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return SCROLL;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i3);
            }
            return HIDDEN;
        }
        return VISIBLE;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
