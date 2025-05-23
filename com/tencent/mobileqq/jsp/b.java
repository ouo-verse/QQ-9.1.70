package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "AvatarState";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        try {
            if (!((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("avatar_state_plugin_switch")) {
                return false;
            }
            String optString = new JSONObject(strArr[0]).optString("callback");
            if (((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isDeviceSupportFilament()) {
                str4 = "1";
            } else {
                str4 = "2";
            }
            QLog.d("AvatarStatePlugin", 1, "handleJsRequest func=" + optString + ", result=" + str4);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("{'checkresult':");
            sb5.append(str4);
            sb5.append("}");
            callJs(optString, sb5.toString());
            return true;
        } catch (Exception e16) {
            QLog.e("AvatarStatePlugin", 1, "Exception", e16);
            return false;
        }
    }
}
