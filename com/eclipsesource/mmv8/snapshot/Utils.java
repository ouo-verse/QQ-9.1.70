package com.eclipsesource.mmv8.snapshot;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Utils {
    Utils() {
    }

    public static boolean isInvalidFd(int i3) {
        if (i3 < 0) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }
}
