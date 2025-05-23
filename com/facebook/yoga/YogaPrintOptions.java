package com.facebook.yoga;

/* loaded from: classes2.dex */
public enum YogaPrintOptions {
    LAYOUT(1),
    STYLE(2),
    CHILDREN(4);

    private final int mIntValue;

    YogaPrintOptions(int i3) {
        this.mIntValue = i3;
    }

    public static YogaPrintOptions fromInt(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 4) {
                    return CHILDREN;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i3);
            }
            return STYLE;
        }
        return LAYOUT;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
