package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class RepeatRequestEvent extends RequestEvent implements Action<String> {
    private static final String TAG = "RepeatRequestEvent";
    private RequestEvent originRequestEvent;

    public static RepeatRequestEvent obtain(RequestEvent requestEvent, String str) {
        RepeatRequestEvent repeatRequestEvent = new RepeatRequestEvent();
        repeatRequestEvent.originRequestEvent = requestEvent;
        repeatRequestEvent.event = str;
        repeatRequestEvent.jsonParams = requestEvent.jsonParams;
        repeatRequestEvent.callbackId = requestEvent.callbackId;
        repeatRequestEvent.jsService = requestEvent.jsService;
        repeatRequestEvent.webViewId = requestEvent.webViewId;
        return repeatRequestEvent;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.model.RequestEvent
    public String cancel(JSONObject jSONObject) {
        return this.originRequestEvent.cancel(jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.model.RequestEvent
    public String fail(JSONObject jSONObject, String str) {
        return this.originRequestEvent.fail(jSONObject, str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.model.RequestEvent
    public String ok(JSONObject jSONObject) {
        return this.originRequestEvent.ok(jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public String perform(BaseRuntime baseRuntime) {
        IJsPluginEngine jsPluginEngine = baseRuntime.getJsPluginEngine();
        if (jsPluginEngine instanceof JsPluginEngine) {
            QMLog.d(TAG, "Dispatch repeat RequestEvent=" + this.event);
            return ((JsPluginEngine) jsPluginEngine).dispatchSecondaryRequestEvent(this);
        }
        QMLog.w(TAG, "Failed to handle repeat RequestEvent=" + this.event);
        return "";
    }
}
