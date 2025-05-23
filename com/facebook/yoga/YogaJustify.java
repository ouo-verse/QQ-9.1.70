package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaJustify {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);

    private final int mIntValue;

    YogaJustify(int i3) {
        this.mIntValue = i3;
    }

    public static YogaJustify fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                return SPACE_EVENLY;
                            }
                            throw new IllegalArgumentException("Unknown enum value: " + i3);
                        }
                        return SPACE_AROUND;
                    }
                    return SPACE_BETWEEN;
                }
                return FLEX_END;
            }
            return CENTER;
        }
        return FLEX_START;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
