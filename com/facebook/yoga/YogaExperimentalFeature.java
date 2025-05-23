package com.facebook.yoga;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum YogaExperimentalFeature {
    WEB_FLEX_BASIS(0);

    private final int mIntValue;

    YogaExperimentalFeature(int i3) {
        this.mIntValue = i3;
    }

    public static YogaExperimentalFeature fromInt(int i3) {
        if (i3 == 0) {
            return WEB_FLEX_BASIS;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i3);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
