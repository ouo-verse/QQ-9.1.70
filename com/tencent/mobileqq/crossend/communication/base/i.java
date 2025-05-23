package com.tencent.mobileqq.crossend.communication.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str, JSONObject jSONObject) {
        callJs(str, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQWebApi";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (strArr != null && strArr.length >= 1) {
            try {
                JSONObject jSONObject2 = new JSONObject(strArr[0]);
                final String string = jSONObject2.getString("callback");
                String string2 = jSONObject2.getString("business");
                if (jSONObject2.has("data")) {
                    jSONObject = jSONObject2.getJSONObject("data");
                } else {
                    jSONObject = new JSONObject();
                }
                com.tencent.mobileqq.crossend.communication.core.a.d(string2, str3, jSONObject, new ab1.a() { // from class: com.tencent.mobileqq.crossend.communication.base.h
                    @Override // ab1.a
                    public final void f(JSONObject jSONObject3) {
                        i.this.q(string, jSONObject3);
                    }
                });
            } catch (JSONException e16) {
                QLog.e("QQCrossEndWebPlugin", 1, e16, new Object[0]);
            }
        }
        return true;
    }
}
