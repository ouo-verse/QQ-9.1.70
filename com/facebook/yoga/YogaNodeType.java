package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaNodeType {
    DEFAULT(0),
    TEXT(1);

    private final int mIntValue;

    YogaNodeType(int i3) {
        this.mIntValue = i3;
    }

    public static YogaNodeType fromInt(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return TEXT;
            }
            throw new IllegalArgumentException("Unknown enum value: " + i3);
        }
        return DEFAULT;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
