package com.tencent.mobileqq.minigame.jsplugin;

import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class QQWidgetJsPlugin extends BaseJsPlugin {
    public static final String EVENT_ADD_WIDGET = "addWidget";
    public static final String EVENT_IS_WIDGET_EXIST_SYNC = "isWidgetExistSync";
    private static final String TAG = "QQWidgetJsPlugin";
    private static final String TEST_MINI_GAME_APPID = "1112109186";

    private Boolean isSupportWidget() {
        String str;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && (str = miniAppInfo.appId) != null) {
            return Boolean.valueOf(str.equals(MiniGameVAUtil.META_MINI_GAME_APPID) || this.mMiniAppInfo.appId.equals(TEST_MINI_GAME_APPID));
        }
        return Boolean.FALSE;
    }

    @JsEvent(isSync = false, value = {EVENT_ADD_WIDGET})
    public void addWidget(final RequestEvent requestEvent) {
        final JSONObject jSONObject = new JSONObject();
        if (!isSupportWidget().booleanValue()) {
            try {
                jSONObject.put("errCode", -1);
                requestEvent.fail(jSONObject, "not support");
                return;
            } catch (JSONException e16) {
                QMLog.e(TAG, "addWidget JSONException:" + e16);
                return;
            }
        }
        ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).addWidget(new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.minigame.jsplugin.QQWidgetJsPlugin.1
            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Integer num, String str) {
                try {
                    if (num.intValue() != 0) {
                        jSONObject.put("errCode", num);
                        requestEvent.fail(jSONObject, str);
                    } else {
                        requestEvent.ok();
                    }
                    return null;
                } catch (Exception e17) {
                    QMLog.e(QQWidgetJsPlugin.TAG, "addWidget Exception:" + e17);
                    requestEvent.fail("addWidget exception:" + e17.getMessage());
                    return null;
                }
            }
        });
    }

    @JsEvent({EVENT_IS_WIDGET_EXIST_SYNC})
    public String isWidgetExist(RequestEvent requestEvent) {
        if (!isSupportWidget().booleanValue()) {
            return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
        }
        if (((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).hasWidget()) {
            return ApiUtil.wrapCallbackOk(requestEvent.event, null).toString();
        }
        return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
    }
}
