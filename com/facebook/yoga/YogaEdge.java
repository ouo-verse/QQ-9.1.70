package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaEdge {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);

    private final int mIntValue;

    YogaEdge(int i3) {
        this.mIntValue = i3;
    }

    public static YogaEdge fromInt(int i3) {
        switch (i3) {
            case 0:
                return LEFT;
            case 1:
                return TOP;
            case 2:
                return RIGHT;
            case 3:
                return BOTTOM;
            case 4:
                return START;
            case 5:
                return END;
            case 6:
                return HORIZONTAL;
            case 7:
                return VERTICAL;
            case 8:
                return ALL;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i3);
        }
    }

    public int intValue() {
        return this.mIntValue;
    }
}
