package com.tencent.mobileqq.crossend.communication.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends BaseJsPlugin {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(RequestEvent requestEvent, JSONObject jSONObject) {
        try {
            if (jSONObject.getInt("code") == 0) {
                requestEvent.ok(jSONObject);
            } else {
                requestEvent.fail(jSONObject, "error message");
            }
        } catch (JSONException e16) {
            QLog.e("QQCrossEndMiniPlugin", 1, e16, new Object[0]);
        }
    }

    @JsEvent({"QQWebApi"})
    private void handleJsRequest(final RequestEvent requestEvent) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(requestEvent.jsonParams);
            String string = jSONObject2.getString("business");
            String string2 = jSONObject2.getString("method");
            if (jSONObject2.has("data")) {
                jSONObject = jSONObject2.getJSONObject("data");
            } else {
                jSONObject = new JSONObject();
            }
            com.tencent.mobileqq.crossend.communication.core.a.d(string, string2, jSONObject, new ab1.a() { // from class: com.tencent.mobileqq.crossend.communication.base.f
                @Override // ab1.a
                public final void f(JSONObject jSONObject3) {
                    g.c(RequestEvent.this, jSONObject3);
                }
            });
        } catch (JSONException e16) {
            QLog.e("QQCrossEndMiniPlugin", 1, e16, new Object[0]);
        }
    }
}
