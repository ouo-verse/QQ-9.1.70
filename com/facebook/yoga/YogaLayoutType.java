package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaLayoutType {
    LAYOUT(0),
    MEASURE(1),
    CACHED_LAYOUT(2),
    CACHED_MEASURE(3);

    private final int mIntValue;

    YogaLayoutType(int i3) {
        this.mIntValue = i3;
    }

    public static YogaLayoutType fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return CACHED_MEASURE;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i3);
                }
                return CACHED_LAYOUT;
            }
            return MEASURE;
        }
        return LAYOUT;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
