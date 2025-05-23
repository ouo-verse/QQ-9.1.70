package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class aa extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    public aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean p(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("reg_sig");
            String string2 = jSONObject.getString(MsfConstants.ATTRIBUTE_MAP_FACE_RESULT);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Bundle bundle = new Bundle();
                bundle.putString("reg_sig", string);
                bundle.putString(MsfConstants.ATTRIBUTE_MAP_FACE_RESULT, string2);
                WebViewBridge.f().j(this.mRuntime.a(), "action_qq_register_face_recognize_assist", bundle);
                this.mRuntime.a().setResult(-1);
                QLog.d("RegisterPlugin", 1, "handleFaceRecogResult");
                return true;
            }
            QLog.e("RegisterPlugin", 1, "handleFaceRecogResult: regSig or faceResult is empty");
            return false;
        } catch (JSONException e16) {
            QLog.e("RegisterPlugin", 1, "handleJsRequest: JsonException", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NonNull
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "register";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        QLog.d("RegisterPlugin", 1, "handleJsRequest: " + str3);
        if ("register".equals(str2) && (bVar = this.mRuntime) != null && bVar.a() != null) {
            if (!"notifyFaceRecogResult".equals(str3)) {
                return false;
            }
            if (strArr.length < 1) {
                QLog.e("RegisterPlugin", 1, "handleJsRequest: args length: " + strArr.length);
                return false;
            }
            return p(strArr[0]);
        }
        QLog.d("RegisterPlugin", 1, "handleJsRequest: null check fail return false");
        return false;
    }
}
