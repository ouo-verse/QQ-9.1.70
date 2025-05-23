package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class MiscJsPlugin extends BaseJsPlugin {
    private static final String TAG = "MiscJsPlugin";

    @JsEvent({"isDesktopExistSync"})
    public String isDesktopExistSync(RequestEvent requestEvent) {
        if (this.mMiniAppInfo.appMode.isLimitedAccess) {
            QMLog.e(TAG, "app is limited access");
            return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
        }
        if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isShortcutExist(this.mMiniAppContext.getAttachActivity(), this.mMiniAppInfo)) {
            return ApiUtil.wrapCallbackOk(requestEvent.event, null).toString();
        }
        return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
    }

    @JsEvent({"saveAppToDesktop"})
    public void saveAppToDesktop(final RequestEvent requestEvent) {
        try {
            if (this.mMiniAppInfo.appMode.isLimitedAccess) {
                QMLog.e(TAG, "app is limited access");
                requestEvent.fail();
            } else {
                ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).addShortcut(this.mMiniAppContext.getAttachActivity(), this.mMiniAppInfo, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.MiscJsPlugin.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        if (z16) {
                            requestEvent.ok();
                        } else {
                            requestEvent.fail();
                        }
                    }
                });
            }
        } catch (Exception e16) {
            QMLog.e(TAG, e16.getMessage(), e16);
            requestEvent.fail();
        }
    }
}
