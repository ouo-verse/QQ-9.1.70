package com.tencent.biz.richframework.video.rfw.player.exp;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.utils.c;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RFWPlayerPreRenderExp9095 {
    private static final String EXP_NAME;
    private static final HashMap<String, String> FAKE_NAME;
    private static volatile boolean sExpose;

    static {
        String str;
        String str2;
        String str3;
        String str4;
        if (AppSetting.isGrayVersion()) {
            str = "exp_xsj_player_prender_time_gray";
        } else {
            str = "exp_xsj_player_prender_time";
        }
        EXP_NAME = str;
        HashMap<String, String> hashMap = new HashMap<>();
        FAKE_NAME = hashMap;
        String str5 = str + "_A";
        if (AppSetting.isGrayVersion()) {
            str2 = "9095_PRE_A_G";
        } else {
            str2 = "9095_R_PRE_A";
        }
        hashMap.put(str5, str2);
        String str6 = str + "_B";
        if (AppSetting.isGrayVersion()) {
            str3 = "9095_PRE_B_G";
        } else {
            str3 = "9095_R_PRE_B";
        }
        hashMap.put(str6, str3);
        String str7 = str + "_C";
        if (AppSetting.isGrayVersion()) {
            str4 = "9095_PRE_C_G";
        } else {
            str4 = "9095_R_PRE_C";
        }
        hashMap.put(str7, str4);
    }

    public static void addExpToQFSPlayerReport(JSONObject jSONObject) {
        String expName = getExpName();
        if (jSONObject != null && !TextUtils.isEmpty(expName)) {
            try {
                jSONObject.put("s22", expName);
                QQVideoPlaySDKManager.addSuperGlobalReportData("param_bucket3", expName);
            } catch (JSONException e16) {
                RFWLog.e("RFWPlayerPreRenderExp9095", RFWLog.USR, e16);
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

    private static String getExpName() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment(EXP_NAME);
    }

    private static Map<String, String> getExpParam() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getParams(EXP_NAME);
    }

    public static int getPreRenderTimeS(int i3) {
        if (!c.h()) {
            return i3;
        }
        Map<String, String> expParam = getExpParam();
        if (expParam != null && !expParam.isEmpty() && expParam.containsKey("preRenderTime")) {
            try {
                String str = expParam.get("preRenderTime");
                if (str == null) {
                    return i3;
                }
                return Integer.parseInt(str);
            } catch (Exception e16) {
                QLog.d("RFWPlayerPreRenderExp9095", 1, e16, new Object[0]);
            }
        }
        return i3;
    }

    public static void reportExpExposure() {
        if (!sExpose) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure(EXP_NAME);
            sExpose = true;
        }
    }
}
