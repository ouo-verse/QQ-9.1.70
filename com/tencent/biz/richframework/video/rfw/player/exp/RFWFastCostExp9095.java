package com.tencent.biz.richframework.video.rfw.player.exp;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWFastCostExp9095 {
    private static final String EXP_NAME;
    private static final HashMap<String, String> FAKE_NAME;
    private static volatile boolean sExpose;

    static {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (AppSetting.isGrayVersion()) {
            str = "exp_xsj_player_fast_play_9095_pcdn_gray";
        } else {
            str = "exp_xsj_player_fast_play_9095_pcdn";
        }
        EXP_NAME = str;
        HashMap<String, String> hashMap = new HashMap<>();
        FAKE_NAME = hashMap;
        String str7 = str + "_A";
        if (AppSetting.isGrayVersion()) {
            str2 = "9095_COST_AG";
        } else {
            str2 = "9095_R_COST_A";
        }
        hashMap.put(str7, str2);
        String str8 = str + "_B";
        if (AppSetting.isGrayVersion()) {
            str3 = "9095_COST_BG";
        } else {
            str3 = "9095_R_COST_B";
        }
        hashMap.put(str8, str3);
        String str9 = str + "_C";
        if (AppSetting.isGrayVersion()) {
            str4 = "9095_COST_CG";
        } else {
            str4 = "9095_R_COST_C";
        }
        hashMap.put(str9, str4);
        String str10 = str + "_D";
        if (AppSetting.isGrayVersion()) {
            str5 = "9095_COST_DG";
        } else {
            str5 = "9095_R_COST_D";
        }
        hashMap.put(str10, str5);
        String str11 = str + "_E";
        if (AppSetting.isGrayVersion()) {
            str6 = "9095_COST_EG";
        } else {
            str6 = "9095_R_COST_E";
        }
        hashMap.put(str11, str6);
    }

    public static void addExpToQFSPlayerReport(JSONObject jSONObject) {
        String expName = getExpName();
        if (jSONObject != null && !TextUtils.isEmpty(expName)) {
            try {
                jSONObject.put("s17", expName);
                QQVideoPlaySDKManager.addSuperGlobalReportData("param_bucket5", expName);
            } catch (JSONException e16) {
                RFWLog.e("RFWFastCostExp9095", RFWLog.USR, e16);
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
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment(EXP_NAME);
    }

    public static Map<String, String> getExpParam() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getParams(EXP_NAME);
    }

    public static boolean hitExpBCDE() {
        if (TextUtils.isEmpty(getExpName())) {
            return false;
        }
        return !(EXP_NAME + "_A").equals(r0);
    }

    public static boolean hitExpC() {
        if (TextUtils.isEmpty(getExpName())) {
            return false;
        }
        return !(EXP_NAME + "_C").equals(r0);
    }

    public static void reportExpExposure() {
        if (!sExpose) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure(EXP_NAME);
            sExpose = true;
        }
    }
}
