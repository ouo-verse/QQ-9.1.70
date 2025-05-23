package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.Permissions;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class MapJsPlugin extends BaseJsPlugin {
    public static final String LOCATION_TYPE_02 = "gcj02";
    public static final String LOCATION_TYPE_84 = "wgs84";
    private static final String TAG = "MapJsPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkLocationPermission() {
        IPermissionManagerProxy iPermissionManagerProxy = (IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class);
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (iPermissionManagerProxy != null && attachActivity != null) {
            if (!iPermissionManagerProxy.isPermissionGranted(attachActivity, Permissions.ACCESS_COARSE_LOCATION) || iPermissionManagerProxy.isPermissionGranted(attachActivity, Permissions.ACCESS_FINE_LOCATION)) {
                return false;
            }
            return true;
        }
        QMLog.e(TAG, "permissionManager is null");
        return false;
    }

    @JsEvent({"chooseLocation"})
    public void chooseLocation(final RequestEvent requestEvent) {
        if (!((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).chooseLocation(this.mMiniAppContext.getAttachActivity(), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.MapJsPlugin.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    requestEvent.ok(jSONObject);
                } else {
                    requestEvent.fail();
                }
            }
        })) {
            MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u9009\u62e9\u5b9a\u4f4d", 1);
            requestEvent.fail("app not implement");
        }
    }

    @JsEvent({"getLocation"})
    public void getLocation(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            getLocationJsonObject(requestEvent, jSONObject.optString("type"), jSONObject.optString("altitude"), new ApiUtil.OnLocationFinish() { // from class: com.tencent.qqmini.sdk.plugins.MapJsPlugin.1
                @Override // com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil.OnLocationFinish
                public void onLocationFinishCallback(JSONObject jSONObject2) {
                    if (MapJsPlugin.this.checkLocationPermission()) {
                        try {
                            jSONObject2.put("isOnlyGrantCoarse", true);
                        } catch (JSONException e16) {
                            QMLog.e(MapJsPlugin.TAG, requestEvent.event + " error.", e16);
                        }
                    }
                    requestEvent.ok(jSONObject2);
                }
            });
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error, ", e16);
            requestEvent.fail();
        }
    }

    public void getLocationJsonObject(final RequestEvent requestEvent, String str, String str2, final ApiUtil.OnLocationFinish onLocationFinish) throws Exception {
        if (!LOCATION_TYPE_02.equals(str) && !LOCATION_TYPE_84.equals(str)) {
            QMLog.e(TAG, "getLocationJsonObject type is not support.");
            requestEvent.fail("invalid data,type error");
            return;
        }
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if ((iMiniAppContext instanceof BaseRuntime) && !((BaseRuntime) iMiniAppContext).getIsForeground()) {
            requestEvent.fail("app is not in the forground.");
            return;
        }
        if (!((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getLocation(this.mMiniAppContext.getAttachActivity(), str, !TextUtils.isEmpty(str2), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.MapJsPlugin.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    onLocationFinish.onLocationFinishCallback(jSONObject);
                } else {
                    requestEvent.fail(jSONObject, null);
                }
            }
        })) {
            MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u5b9a\u4f4d", 1);
            requestEvent.fail("app not implement");
        }
    }

    @JsEvent({"openLocation"})
    public void openLocation(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            if (!((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).openLocation(this.mMiniAppContext.getAttachActivity(), jSONObject.optDouble("latitude"), jSONObject.optDouble("longitude"), jSONObject.optInt("scale", 18), jSONObject.optString("name"), jSONObject.optString("address"))) {
                MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u6253\u5f00\u5730\u56fe", 1);
                requestEvent.fail("app not implement");
            } else {
                requestEvent.ok();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error, ", e16);
            requestEvent.fail();
        }
    }
}
