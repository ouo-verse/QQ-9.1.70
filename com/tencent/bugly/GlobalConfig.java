package com.tencent.bugly;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GlobalConfig {
    private static boolean inStandaloneMode = false;

    public static boolean isInStandaloneMode() {
        return inStandaloneMode;
    }

    public static void updateStandaloneMode(boolean z16) {
        inStandaloneMode = z16;
    }
}
