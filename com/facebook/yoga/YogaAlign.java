package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaAlign {
    AUTO(0),
    FLEX_START(1),
    CENTER(2),
    FLEX_END(3),
    STRETCH(4),
    BASELINE(5),
    SPACE_BETWEEN(6),
    SPACE_AROUND(7);

    private final int mIntValue;

    YogaAlign(int i3) {
        this.mIntValue = i3;
    }

    public static YogaAlign fromInt(int i3) {
        switch (i3) {
            case 0:
                return AUTO;
            case 1:
                return FLEX_START;
            case 2:
                return CENTER;
            case 3:
                return FLEX_END;
            case 4:
                return STRETCH;
            case 5:
                return BASELINE;
            case 6:
                return SPACE_BETWEEN;
            case 7:
                return SPACE_AROUND;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i3);
        }
    }

    public int intValue() {
        return this.mIntValue;
    }
}
