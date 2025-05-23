package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class UpdateAppJsPlugin extends BaseJsPlugin {
    public static final String API_UPDATE_QQ_APP = "updateQQApp";
    public static final String TAG = "UpdateAppJsPlugin";
    private Activity mActivity;
    private MiniAppProxy mMiniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        this.mActivity = iMiniAppContext.getAttachedActivity();
    }

    @JsEvent({API_UPDATE_QQ_APP})
    public void updateQQApp(final RequestEvent requestEvent) {
        Activity activity = this.mActivity;
        if (activity == null) {
            QMLog.e(TAG, "mActivity is null ?!!");
            return;
        }
        try {
            this.mMiniAppProxy.getAppUpdate(activity, new MiniAppProxy.IAppUpdateListener() { // from class: com.tencent.qqmini.sdk.plugins.UpdateAppJsPlugin.1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IAppUpdateListener
                public void onGetAppUpdateResult(boolean z16, String str) {
                    if (z16) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("updateMsg", str);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                        requestEvent.ok(jSONObject);
                        return;
                    }
                    requestEvent.fail(str);
                }
            });
        } catch (Exception unused) {
            QMLog.e(TAG, "Failed to updateQQApp");
        }
    }
}
