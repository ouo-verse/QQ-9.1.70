package com.tencent.mobileqq.vashealth.huaweistep;

import android.os.Build;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HuaweiStepHelper {
    public static final String HUAWEI_SYSTEM_NAME = "HUAWEI";
    private static final String TAG = "HuaweiStepHelper";

    public static int getCacheStep() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        int decodeInt = from.decodeInt("huawei_step_cache_data_key", 0);
        if (!isTodayStep(from.decodeLong("huawei_step_cache_date_key", 0L))) {
            return 0;
        }
        return decodeInt;
    }

    public static boolean isInHuaWeiSystemWhiteList() {
        boolean z16;
        if (!DeviceInfoMonitor.getModel().contains("HUAWEI") && !Build.MANUFACTURER.contains("HUAWEI")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 || !isMcEnable()) {
            return false;
        }
        return true;
    }

    private static boolean isMcEnable() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105899", false);
        QLog.d(TAG, 2, "isHuaWeiSdkWhiteList: " + isSwitchOn);
        return isSwitchOn;
    }

    public static boolean isTodayStep(long j3) {
        if (j3 > SSOHttpUtils.d() && j3 < SSOHttpUtils.c()) {
            return true;
        }
        return false;
    }

    public static void saveStepData(int i3) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeInt("huawei_step_cache_data_key", i3);
        from.encodeLong("huawei_step_cache_date_key", NetConnInfoCenter.getServerTimeMillis());
    }
}
