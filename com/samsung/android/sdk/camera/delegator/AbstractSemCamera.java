package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import android.os.Build;
import com.samsung.android.sep.camera.SemCamera;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AbstractSemCamera {
    public static final String SEM_FEATURE_SAMSUNG_EXPERIENCE_MOBILE = "com.samsung.feature.samsung_experience_mobile";

    public static String getSEPClientVersion() {
        return SemCamera.getInstance().getSEPClientVersion();
    }

    public static int getSepPlatformVersion(Context context) {
        if (isSemAvailable(context) && Build.VERSION.SEM_PLATFORM_INT >= 80100) {
            return Build.VERSION.SEM_PLATFORM_INT;
        }
        return -1;
    }

    private static final boolean isSemAvailable(Context context) {
        if (context != null && context.getPackageManager().hasSystemFeature(SEM_FEATURE_SAMSUNG_EXPERIENCE_MOBILE)) {
            return true;
        }
        return false;
    }

    public abstract int checkAvailability(Context context);

    public abstract boolean isFeatureEnabled(Context context, String str, int i3);
}
