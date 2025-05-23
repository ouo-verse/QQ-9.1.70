package com.tencent.mobileqq.mini.out.nativePlugins;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class TimTeamPlugin implements NativePlugin {
    public static final String ACTION_SHOW_PROFILE = "showCoopSpaceProfile";
    public static final String PLUGIN_NAME = "tim_space";
    public static final String TAG = "TimTeamPlugin";

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        if (jSContext != null) {
            try {
                String string = new JSONObject(jSONObject.getString("data")).getString("action");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onInvoke|" + string);
                }
                if (TextUtils.equals(string, ACTION_SHOW_PROFILE)) {
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(jSContext.getActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
                    activityURIRequest.extra().putString("uin", AppConstants.TIM_TEAM_UIN);
                    QRoute.startUri(activityURIRequest, (o) null);
                }
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "decode param error");
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
