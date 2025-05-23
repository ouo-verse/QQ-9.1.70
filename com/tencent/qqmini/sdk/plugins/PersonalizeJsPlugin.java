package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class PersonalizeJsPlugin extends BaseJsPlugin {
    private static final String TAG = "PersonalizeJsPlugin";
    private ChannelProxy mChannelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);

    @JsEvent({"Personalize"})
    public void personalize(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            if (jSONObject.has("api_name")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    requestEvent.fail("params error.");
                }
                try {
                    this.mChannelProxy.setPersonalizeInfo(this.mApkgInfo.appId, optJSONObject.optString("uin"), optJSONObject.optInt("set_type"), optJSONObject.optString("item_id"), optJSONObject.optString("busi_info"), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.PersonalizeJsPlugin.1
                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                        public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                            QMLog.i(PersonalizeJsPlugin.TAG, "setPersonalizeInfo result:" + z16);
                            if (z16) {
                                requestEvent.ok();
                            } else {
                                requestEvent.fail("params error.");
                            }
                        }
                    });
                    return;
                } catch (Exception unused) {
                    requestEvent.fail("params error.");
                    return;
                }
            }
            requestEvent.fail("params error.");
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }
}
