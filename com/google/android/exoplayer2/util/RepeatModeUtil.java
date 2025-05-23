package com.google.android.exoplayer2.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class RepeatModeUtil {
    public static final int REPEAT_TOGGLE_MODE_ALL = 2;
    public static final int REPEAT_TOGGLE_MODE_NONE = 0;
    public static final int REPEAT_TOGGLE_MODE_ONE = 1;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface RepeatToggleModes {
    }

    RepeatModeUtil() {
    }

    public static int getNextRepeatMode(int i3, int i16) {
        for (int i17 = 1; i17 <= 2; i17++) {
            int i18 = (i3 + i17) % 3;
            if (isRepeatModeEnabled(i18, i16)) {
                return i18;
            }
        }
        return i3;
    }

    public static boolean isRepeatModeEnabled(int i3, int i16) {
        if (i3 == 0) {
            return true;
        }
        if (i3 != 1) {
            if (i3 == 2 && (i16 & 2) != 0) {
                return true;
            }
            return false;
        }
        if ((i16 & 1) != 0) {
            return true;
        }
        return false;
    }
}
