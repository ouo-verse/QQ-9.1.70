package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaFlexDirection {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);

    private final int mIntValue;

    YogaFlexDirection(int i3) {
        this.mIntValue = i3;
    }

    public static YogaFlexDirection fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return ROW_REVERSE;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i3);
                }
                return ROW;
            }
            return COLUMN_REVERSE;
        }
        return COLUMN;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
