package com.tencent.oskplayer.util;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class Assertions {
    Assertions() {
    }

    public static void checkArgument(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String checkNotEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T t16) {
        t16.getClass();
        return t16;
    }

    public static void checkState(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalStateException();
        }
    }
}
