package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class SchemeJsPlugin extends BaseJsPlugin {
    private static final String TAG = "SchemeJsPlugin";

    @JsEvent({PluginConst.SchemeJsPluginConst.API_OPEN_SCHEME})
    public void openScheme(final RequestEvent requestEvent) {
        String str;
        Activity attachedActivity = this.mMiniAppContext.getAttachedActivity();
        if (attachedActivity == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            if (jSONObject.has("api_name")) {
                String optString = jSONObject.optString("api_name");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    str = JSONUtil.json2Params(optJSONObject);
                } else {
                    str = null;
                }
                final String str2 = optString + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str;
                ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).openSchema(attachedActivity, str2, -1, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.qqmini.sdk.plugins.SchemeJsPlugin.1
                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int i3, Bundle bundle) {
                        String str3;
                        super.onReceiveResult(i3, bundle);
                        QMLog.d(SchemeJsPlugin.TAG, "onReceiveResult resultCode : " + i3);
                        if (i3 == 1) {
                            requestEvent.ok();
                            return;
                        }
                        if (bundle != null) {
                            str3 = bundle.getString("errMsg");
                        } else {
                            str3 = "";
                        }
                        QMLog.d(SchemeJsPlugin.TAG, str2 + " failed, errMsg : " + str3);
                        requestEvent.fail(str3);
                    }
                });
                return;
            }
            requestEvent.fail("params error.");
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }
}
