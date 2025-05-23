package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes23.dex */
public class ak extends BaseJsPlugin {
    @JsEvent({"getPageLoadOptionsSync"})
    public JSONObject getPageLoadOptions(RequestEvent requestEvent) {
        MiniWebView s16;
        if (this.mIsContainer) {
            IJsService iJsService = requestEvent.jsService;
            if (iJsService instanceof MiniWebView) {
                s16 = (MiniWebView) iJsService;
            } else {
                ax axVar = (ax) this.mMiniAppContext;
                int i3 = requestEvent.webViewId;
                try {
                    i3 = new JSONObject(requestEvent.jsonParams).optInt("webviewId", requestEvent.webViewId);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                s16 = axVar.s(i3);
            }
            if (s16 == null) {
                requestEvent.fail("miniWebView is null");
                return null;
            }
            JSONObject I = s16.I();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", I);
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            requestEvent.ok(jSONObject);
            return jSONObject;
        }
        requestEvent.fail("only container can call this");
        return null;
    }
}
