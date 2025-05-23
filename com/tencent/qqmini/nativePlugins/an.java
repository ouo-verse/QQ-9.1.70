package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.out.nativePlugins.TimTeamPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class an extends BaseJsPlugin {
    private JSONObject b(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams);
        } catch (JSONException unused) {
            QMLog.e(TimTeamPlugin.TAG, "Failed to parse jsonParams=" + requestEvent.jsonParams);
            return null;
        }
    }

    @JsEvent({TimTeamPlugin.PLUGIN_NAME})
    public void timSpace(RequestEvent requestEvent) {
        try {
            String string = new JSONObject(b(requestEvent).getString("data")).getString("action");
            if (QMLog.isColorLevel()) {
                QMLog.d(TimTeamPlugin.TAG, "onInvoke|" + string);
            }
            if (TextUtils.equals(string, TimTeamPlugin.ACTION_SHOW_PROFILE)) {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.mMiniAppContext.getAttachActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
                activityURIRequest.extra().putString("uin", AppConstants.TIM_TEAM_UIN);
                QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            }
        } catch (Exception unused) {
            if (QMLog.isColorLevel()) {
                QMLog.w(TimTeamPlugin.TAG, "decode param error");
            }
        }
    }
}
