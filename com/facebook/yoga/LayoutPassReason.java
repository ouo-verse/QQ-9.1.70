package com.facebook.yoga;

/* loaded from: classes2.dex */
public enum LayoutPassReason {
    INITIAL(0),
    ABS_LAYOUT(1),
    STRETCH(2),
    MULTILINE_STRETCH(3),
    FLEX_LAYOUT(4),
    MEASURE(5),
    ABS_MEASURE(6),
    FLEX_MEASURE(7);

    private final int mIntValue;

    LayoutPassReason(int i3) {
        this.mIntValue = i3;
    }

    public static LayoutPassReason fromInt(int i3) {
        switch (i3) {
            case 0:
                return INITIAL;
            case 1:
                return ABS_LAYOUT;
            case 2:
                return STRETCH;
            case 3:
                return MULTILINE_STRETCH;
            case 4:
                return FLEX_LAYOUT;
            case 5:
                return MEASURE;
            case 6:
                return ABS_MEASURE;
            case 7:
                return FLEX_MEASURE;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i3);
        }
    }

    public int intValue() {
        return this.mIntValue;
    }
}
