package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

/* compiled from: P */
@DoNotStrip
/* loaded from: classes2.dex */
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);

    private final int mIntValue;

    YogaLogLevel(int i3) {
        this.mIntValue = i3;
    }

    @DoNotStrip
    public static YogaLogLevel fromInt(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                return FATAL;
                            }
                            throw new IllegalArgumentException("Unknown enum value: " + i3);
                        }
                        return VERBOSE;
                    }
                    return DEBUG;
                }
                return INFO;
            }
            return WARN;
        }
        return ERROR;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
