package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaUnit {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);

    private final int mIntValue;

    YogaUnit(int i3) {
        this.mIntValue = i3;
    }

    public static YogaUnit fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return AUTO;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i3);
                }
                return PERCENT;
            }
            return POINT;
        }
        return UNDEFINED;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
