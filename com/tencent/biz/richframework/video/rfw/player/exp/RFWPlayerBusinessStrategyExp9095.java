package com.tencent.biz.richframework.video.rfw.player.exp;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RFWPlayerBusinessStrategyExp9095 {
    private static final HashMap<String, String> FAKE_NAME;
    private static volatile boolean sExpose;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        FAKE_NAME = hashMap;
        hashMap.put("exp_xsj_player_business_strage_exp_A", "9095_BS_EXPA");
        hashMap.put("exp_xsj_player_business_strage_exp_B", "9095_BS_EXPB");
        hashMap.put("exp_xsj_player_business_strage_exp_C", "9095_BS_EXPC");
    }

    public static void addExpToQFSPlayerReport(JSONObject jSONObject) {
        String expName = getExpName();
        if (jSONObject != null && !TextUtils.isEmpty(expName)) {
            try {
                jSONObject.put("s23", expName);
                QQVideoPlaySDKManager.addSuperGlobalReportData("video_experiment_name_2", expName);
            } catch (JSONException e16) {
                RFWLog.e("RFWPlayerBusinessStrategyExp9095", RFWLog.USR, e16);
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
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("exp_xsj_player_business_strage_exp");
    }

    public static Map<String, String> getExpParam() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getParams("exp_xsj_player_business_strage_exp");
    }

    public static void onAccountChange() {
        sExpose = false;
    }

    public static void reportExpExposure() {
        if (!sExpose) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_player_business_strage_exp");
            sExpose = true;
        }
    }
}
