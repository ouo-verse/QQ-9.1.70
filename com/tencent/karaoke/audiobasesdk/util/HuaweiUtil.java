package com.tencent.karaoke.audiobasesdk.util;

import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HuaweiUtil {
    public static final String TAG = "HuaweiUtil";
    private static boolean mIsLoaded = false;

    static {
        try {
            System.loadLibrary("huawei_jni");
            mIsLoaded = true;
        } catch (Exception e16) {
            LogUtil.e(TAG, "System.loadLibrary failed", e16);
        } catch (UnsatisfiedLinkError e17) {
            LogUtil.e(TAG, "System.loadLibrary failed", e17);
        }
    }

    private native HuaWeiLibVersionInfo getHuaweiLibVersion(boolean z16);

    private boolean isHonorBrand() {
        String str = Build.BRAND;
        if (str != null) {
            str = str.toUpperCase();
        }
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR.equalsIgnoreCase(str);
    }

    private native boolean isSupportHuaWeiAutotune(boolean z16);

    private native void native_release();

    public HuaWeiLibVersionInfo getHuaweiLibVersionInfo() {
        return getHuaweiLibVersion(isHonorBrand());
    }

    public boolean isSupportHuaweiAutotune() {
        boolean isSupportHuaWeiAutotune = isSupportHuaWeiAutotune(isHonorBrand());
        LogUtil.i(TAG, "isSupportHuaweiAutotune: " + isSupportHuaWeiAutotune);
        return isSupportHuaWeiAutotune;
    }

    public void release() {
        if (mIsLoaded) {
            native_release();
        }
    }
}
