package com.tencent.biz.richframework.video.rfw.player.exp;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWLowDeviceAv1Exp {
    private static final HashMap<String, String> FAKE_NAME;
    private static volatile boolean sExpose;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        FAKE_NAME = hashMap;
        hashMap.put("exp_qfs_low_device_dis_av1_9120_A", "9120_LOW_DEV_A");
        hashMap.put("exp_qfs_low_device_dis_av1_9120_B", "9120_LOW_DEV_B");
    }

    public static void addExpToQFSPlayerReport(JSONObject jSONObject) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ebable_av1_low_device", true) || !QCircleVideoDeviceInfoUtils.isLowDevice()) {
            return;
        }
        String expName = getExpName();
        if (jSONObject != null && !TextUtils.isEmpty(expName)) {
            try {
                jSONObject.put("s11", expName);
                QQVideoPlaySDKManager.addSuperGlobalReportData("video_experiment_name_1", expName);
            } catch (JSONException e16) {
                RFWLog.e("RFWLowDeviceAv1Exp", RFWLog.USR, e16);
            }
        }
    }

    public static String getCDNValue() {
        String expName = getExpName();
        HashMap<String, String> hashMap = FAKE_NAME;
        if (hashMap.containsKey(expName)) {
            return hashMap.get(expName);
        }
        return "";
    }

    public static String getExpName() {
        if (!QCircleVideoDeviceInfoUtils.isLowDevice()) {
            return "";
        }
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("exp_qfs_low_device_dis_av1_9120");
    }

    public static boolean hitExpB() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ebable_av1_low_device", true)) {
            QLog.d("RFWLowDeviceAv1Exp", 1, "hitExpB switch close return false");
            return false;
        }
        if (!QCircleVideoDeviceInfoUtils.isLowDevice()) {
            return false;
        }
        String assignment = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("exp_qfs_low_device_dis_av1_9120");
        QLog.d("RFWLowDeviceAv1Exp", 1, "expName :" + assignment);
        return "exp_qfs_low_device_dis_av1_9120_B".equals(assignment);
    }

    public static void onAccountChange() {
        sExpose = false;
    }

    public static void reportExpExposure() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ebable_av1_low_device", true) && !sExpose) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_qfs_low_device_dis_av1_9120");
            sExpose = true;
        }
    }
}
