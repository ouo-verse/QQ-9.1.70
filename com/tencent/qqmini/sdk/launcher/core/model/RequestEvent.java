package com.tencent.qqmini.sdk.launcher.core.model;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RequestEvent {
    public int callbackId;
    public String event;
    public IJsService jsService;
    public String jsonParams;
    public int webViewId;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Builder {
        RequestEvent reqEvent = new RequestEvent();

        public RequestEvent build() {
            return this.reqEvent;
        }

        public Builder setCallbackId(int i3) {
            this.reqEvent.callbackId = i3;
            return this;
        }

        public Builder setEvent(String str) {
            this.reqEvent.event = str;
            return this;
        }

        public Builder setJsService(IJsService iJsService) {
            this.reqEvent.jsService = iJsService;
            return this;
        }

        public Builder setJsonParams(String str) {
            this.reqEvent.jsonParams = str;
            return this;
        }

        public Builder setWebViewId(int i3) {
            this.reqEvent.webViewId = i3;
            return this;
        }
    }

    public String cancel() {
        return cancel(null);
    }

    public void evaluateCallbackJs(String str) {
        IJsService iJsService = this.jsService;
        if (iJsService != null) {
            iJsService.evaluateCallbackJs(this.callbackId, str);
        }
    }

    public String fail(JSONObject jSONObject, String str) {
        String jSONObject2 = ApiUtil.wrapCallbackFail(this.event, jSONObject, str).toString();
        evaluateCallbackJs(jSONObject2);
        return jSONObject2;
    }

    public String ok() {
        return ok(null);
    }

    public String cancel(JSONObject jSONObject) {
        String jSONObject2 = ApiUtil.wrapCallbackCancel(this.event, jSONObject).toString();
        evaluateCallbackJs(jSONObject2);
        return jSONObject2;
    }

    public String ok(JSONObject jSONObject) {
        String jSONObject2 = ApiUtil.wrapCallbackOk(this.event, jSONObject).toString();
        evaluateCallbackJs(jSONObject2);
        return jSONObject2;
    }

    public String fail() {
        return fail(null);
    }

    public String fail(String str) {
        return fail(null, str);
    }
}
