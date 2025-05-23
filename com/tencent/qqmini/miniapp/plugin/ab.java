package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.container.core.MiniView;
import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes23.dex */
public class ab extends BaseJsPlugin {
    private String b(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams).optString("data");
        } catch (JSONException e16) {
            QMLog.d("ContainerCallbackJsPlugin", "get data exception:" + e16 + ",event = " + requestEvent.event);
            return null;
        }
    }

    @JsEvent({"onPageCallback"})
    public void setContainerCallback(RequestEvent requestEvent) {
        MiniView miniView;
        QMLog.d("ContainerCallbackJsPlugin", "setContainerCallback");
        String b16 = b(requestEvent);
        if (b16 == null) {
            requestEvent.fail("params illegal");
            QMLog.d("ContainerCallbackJsPlugin", "setActivityResult, data is null");
            return;
        }
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext instanceof ax) {
            miniView = ((ax) iMiniAppContext).r(requestEvent.webViewId);
        } else {
            miniView = null;
        }
        if (miniView == null) {
            requestEvent.fail("can not find mini view");
            QMLog.d("ContainerCallbackJsPlugin", "setActivityResult, can not find mini view");
        } else {
            miniView.m(b16);
            requestEvent.ok();
        }
    }
}
