package com.tencent.biz.richframework.video.rfw.player.exp;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.utils.c;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoFluencyExp9095 {
    private static final HashMap<String, String> FAKE_NAME;
    private static volatile boolean sExpose;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        FAKE_NAME = hashMap;
        hashMap.put("RFWVideoFluencyExp9095_A", "910_flu_A");
        hashMap.put("RFWVideoFluencyExp9095_B", "910_flu_B");
        hashMap.put("RFWVideoFluencyExp9095_C", "910_flu_C");
        hashMap.put("RFWVideoFluencyExp9095_D", "910_flu_D");
    }

    public static void addExpToQFSPlayerReport(JSONObject jSONObject) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcricle_ebable_fluency_exp_9080", true)) {
            return;
        }
        String expKey = getExpKey();
        if (jSONObject != null && !TextUtils.isEmpty(expKey)) {
            try {
                jSONObject.put("s19", expKey);
                QQVideoPlaySDKManager.addSuperGlobalReportData("param_bucket4", expKey);
            } catch (JSONException e16) {
                RFWLog.e("RFWVideoFluencyExp9095", RFWLog.USR, e16);
            }
        }
    }

    public static boolean enablePCDN() {
        return enablePCDNFlowPeakLowExpC();
    }

    private static boolean enablePCDNFlowPeakLowExpC() {
        boolean hitExpC = hitExpC();
        boolean g16 = c.g();
        RFWLog.d("RFWVideoFluencyExp9095", RFWLog.USR, "enablePCDNFlowPeakLowExpC:| hitC:" + hitExpC + "| isPeakLow:" + g16);
        if (!hitExpC || !g16) {
            return true;
        }
        return false;
    }

    public static long getActiveTimeMs() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_play_able_time_active", String.valueOf(5000L)));
        } catch (Exception unused) {
            RFWLog.d("RFWVideoFluencyExp9095", RFWLog.USR, "getActiveTimeMs error");
            return 5000L;
        }
    }

    public static String getCDNValue() {
        String expKey = getExpKey();
        HashMap<String, String> hashMap = FAKE_NAME;
        if (hashMap.containsKey(expKey)) {
            return hashMap.get(expKey);
        }
        return "";
    }

    public static String getExpKey() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("RFWVideoFluencyExp9095");
    }

    private static String getExpName() {
        return "RFWVideoFluencyExp9095";
    }

    private static String getTargetEXPKeyB() {
        return "RFWVideoFluencyExp9095_B";
    }

    private static String getTargetEXPKeyC() {
        return "RFWVideoFluencyExp9095_C";
    }

    private static String getTargetEXPKeyD() {
        return "RFWVideoFluencyExp9095_D";
    }

    public static boolean hitExpB() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcricle_ebable_fluency_exp_9080", true)) {
            return false;
        }
        if (getTargetEXPKeyB().equals(getExpKey()) || hitExpD()) {
            return true;
        }
        return false;
    }

    public static boolean hitExpC() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcricle_ebable_fluency_exp_9080", true)) {
            return false;
        }
        if (getTargetEXPKeyC().equals(getExpKey()) || hitExpD()) {
            return true;
        }
        return false;
    }

    private static boolean hitExpD() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcricle_ebable_fluency_exp_9080", true)) {
            return false;
        }
        return getTargetEXPKeyD().equals(getExpKey());
    }

    public static void onAccountChange() {
        sExpose = false;
    }

    public static void reportExpExposure() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcricle_ebable_fluency_exp_9080", true) && !sExpose) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure(getExpName());
            sExpose = true;
        }
    }
}
