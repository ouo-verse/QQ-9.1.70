package com.tencent.mobileqq.troop.browser;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends VasWebviewJsPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static String f294665f;

    /* renamed from: d, reason: collision with root package name */
    protected Context f294666d;

    /* renamed from: e, reason: collision with root package name */
    protected AppInterface f294667e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76234);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f294665f = "TroopUpgradePlugin";
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f294666d = null;
            this.f294667e = null;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "Troop";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return 2147614720L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(f294665f, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (!"Troop".equals(str2)) {
            return false;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(strArr[0]);
        } catch (JSONException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (jSONObject == null) {
            return false;
        }
        if ("updateMaxMemberNum".equals(str3)) {
            String optString = jSONObject.optString("groupId", "");
            int optInt = jSONObject.optInt("type", 0);
            if (TextUtils.isEmpty(optString) || optInt == 0) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("groupId", optString);
            bundle.putInt("type", optInt);
            sendRemoteReq(com.tencent.mobileqq.emosm.a.a("notifyTroopUpgradeSuccess", "", this.mOnRemoteResp.key, bundle), true, false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onCreate();
        this.f294666d = this.mRuntime.a();
        this.f294667e = this.mRuntime.b();
    }
}
