package com.tencent.biz.richframework.video.rfw.player.exp;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoSystemExp9065 {
    private static volatile boolean sExpose;

    public static void addExpToQFSPlayerReport(JSONObject jSONObject) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fluency_9055", true)) {
            return;
        }
        String expName = getExpName();
        if (jSONObject != null && !TextUtils.isEmpty(expName)) {
            try {
                jSONObject.put("s16", expName);
                QQVideoPlaySDKManager.addSuperGlobalReportData("video_experiment_name", expName);
            } catch (JSONException e16) {
                RFWLog.e("RFWVideoSystemExp9065", RFWLog.USR, e16);
            }
        }
    }

    private static String getExpName() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("exp_video_use_system_player");
    }

    public static void reportExpExposure() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fluency_9055", true) && !sExpose) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_video_use_system_player");
            sExpose = true;
        }
    }
}
