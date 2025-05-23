package com.tencent.biz.richframework.arthook.api;

import android.os.Build;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class RFWHookConfig {
    public static boolean debug = true;
    public static boolean debuggable;
    public static int sdkLevel;

    static {
        int i3 = Build.VERSION.SDK_INT;
        sdkLevel = i3;
        if (i3 == 30 && Build.VERSION.PREVIEW_SDK_INT > 0) {
            sdkLevel = 31;
        }
    }
}
