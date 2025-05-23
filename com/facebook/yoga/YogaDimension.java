package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaDimension {
    WIDTH(0),
    HEIGHT(1);

    private final int mIntValue;

    YogaDimension(int i3) {
        this.mIntValue = i3;
    }

    public static YogaDimension fromInt(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return HEIGHT;
            }
            throw new IllegalArgumentException("Unknown enum value: " + i3);
        }
        return WIDTH;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
