package com.tencent.mobileqq.vas.pendant.drawable;

import android.os.Build;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;

/* loaded from: classes20.dex */
public class PendantGreySwitch {
    private static final String TAG = "PendantGreySwitch";
    static boolean isSupportAvif = true;
    private static Boolean useUpgradePendantState;

    public static long getTestPendantId() {
        if (!isSupportAvifImage()) {
            return -1L;
        }
        ToggleProxy toggleProxy = VasToggle.FEATURE_TEST_PENDANT_ID;
        if (!toggleProxy.isEnable(false)) {
            return -1L;
        }
        String stringData = toggleProxy.getStringData("-1");
        try {
            return Long.parseLong(stringData);
        } catch (NumberFormatException unused) {
            QLog.w(TAG, 1, "parseLong failed: " + stringData);
            return -1L;
        }
    }

    public static boolean isSupportAvifImage() {
        boolean z16;
        if (AppSetting.isDebugVersion()) {
            return isSupportAvif;
        }
        ToggleProxy toggleProxy = VasToggle.FEATURE_AVIF;
        if (toggleProxy.isEnable(false) && Build.VERSION.SDK_INT >= Integer.valueOf(toggleProxy.getStringData("0")).intValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isEnable = VasToggle.FEATURE_PENDANT_SUPPORT_AVIF.isEnable(false);
        if (!z16 || !isEnable) {
            return false;
        }
        return true;
    }
}
