package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class PhoneNumberAction implements Action<Boolean> {
    private PhoneNumberActionCallback callback;
    private RequestEvent req;

    /* loaded from: classes23.dex */
    public interface PhoneNumberActionCallback {
        void onGetAuthDialogRet(boolean z16, JSONObject jSONObject);
    }

    public static PhoneNumberAction obtain(RequestEvent requestEvent, PhoneNumberActionCallback phoneNumberActionCallback) {
        PhoneNumberAction phoneNumberAction = new PhoneNumberAction();
        phoneNumberAction.callback = phoneNumberActionCallback;
        phoneNumberAction.req = requestEvent;
        return phoneNumberAction;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        IJsPluginEngine jsPluginEngine = baseRuntime.getJsPluginEngine();
        if (jsPluginEngine instanceof JsPluginEngine) {
            ((JsPluginEngine) jsPluginEngine).showRequestPermissionDialog(this.req, this.callback);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
