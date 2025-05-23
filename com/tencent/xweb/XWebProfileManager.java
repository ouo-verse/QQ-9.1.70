package com.tencent.xweb;

import androidx.annotation.Nullable;

/* loaded from: classes27.dex */
public class XWebProfileManager {
    public static void forceEnableFrameCostProfile(boolean z16) {
        XWebProfilerController.getInstance().forceEnableFrameCostProfile(z16);
    }

    public static void forceFlushCategory(String str) {
        XWebProfilerController.getInstance().forceFlushCategory(str);
    }

    public static void initProfile() {
        XWebProfilerController.getInstance().initProfile();
    }

    public static void setAllKindsFpsProfileEnable(boolean z16) {
        XWebProfilerController.getInstance().setAllKindsFpsProfileEnable(z16);
    }

    public static boolean setProfileResultCallback(String str, @Nullable IProfileResultCallback iProfileResultCallback) {
        return XWebProfilerController.getInstance().setProfileResultCallback(str, iProfileResultCallback);
    }
}
