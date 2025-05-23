package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class aq {
    public static int a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("OnlineStatusAggregationSwitch", 1, "getConfigCountPerStatus: false, appRuntime == null, do return");
            return 25;
        }
        JSONObject jSONObject = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject("online_status_aggregation_feature_switch", "");
        if (jSONObject == null) {
            QLog.d("OnlineStatusAggregationSwitch", 1, "getConfigCountPerStatus: false, no json");
            return 25;
        }
        return jSONObject.optInt("count_per_status", 25);
    }

    public static boolean b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("OnlineStatusAggregationSwitch", 1, "isZPlanNestAllowShow: false, appRuntime == null, do return");
            return false;
        }
        JSONObject jSONObject = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject("online_status_aggregation_feature_switch", "");
        if (jSONObject == null) {
            QLog.d("OnlineStatusAggregationSwitch", 1, "isZPlanNestAllowShow: false, no json");
            return false;
        }
        return jSONObject.optBoolean("is_zplan_enable", false);
    }
}
