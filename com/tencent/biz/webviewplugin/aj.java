package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class aj extends VasWebviewJsPlugin {
    private boolean p(String... strArr) {
        if (strArr != null && strArr.length >= 1) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("gc");
                String optString2 = jSONObject.optString("robotUin");
                String optString3 = jSONObject.optString("robotName");
                String optString4 = jSONObject.optString("callback");
                Bundle bundle = new Bundle();
                bundle.putString("robotuin", optString2);
                bundle.putString("troopuin", optString);
                bundle.putString("robotname", optString3);
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_share_robot_card", optString4, this.mOnRemoteResp.key, bundle));
                return true;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    private boolean q(String... strArr) {
        if (strArr != null && strArr.length >= 1) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("oninfoUrl");
                String optString2 = jSONObject.optString("oninfoTitle");
                String optString3 = jSONObject.optString("offinfoUrl");
                String optString4 = jSONObject.optString("offinfoTitle");
                String optString5 = jSONObject.optString("gc");
                String optString6 = jSONObject.optString("robotUin");
                String optString7 = jSONObject.optString("robotName");
                int optInt = jSONObject.optInt("isRobotBuddy");
                String optString8 = jSONObject.optString("callback");
                Bundle bundle = new Bundle();
                bundle.putString("onurl", optString);
                bundle.putString("ontitle", optString2);
                bundle.putString("offtitle", optString4);
                bundle.putString("offurl", optString3);
                bundle.putString("robotuin", optString6);
                bundle.putString("troopuin", optString5);
                bundle.putString("robotname", optString7);
                bundle.putInt("isrobotbuddy", optInt);
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_invoke_robot_function", optString8, this.mOnRemoteResp.key, bundle));
                return true;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    private boolean r(String... strArr) {
        if (strArr != null && strArr.length >= 1) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("gc");
                String optString2 = jSONObject.optString("robotUin");
                String optString3 = jSONObject.optString("robotName");
                Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("isAdd"));
                String optString4 = jSONObject.optString("callback");
                Bundle bundle = new Bundle();
                bundle.putString("robotuin", optString2);
                bundle.putString("troopuin", optString);
                bundle.putString("robotname", optString3);
                bundle.putBoolean("isadd", valueOf.booleanValue());
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_robot_member_change_function", optString4, this.mOnRemoteResp.key, bundle));
                return true;
            } catch (JSONException e16) {
                QLog.e("TroopRobotPlugin", 2, "handleJsRequest exception notifyRobotMmeberChange" + e16.getMessage());
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "robotsummary";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"robotsummary".equals(str2)) {
            return false;
        }
        if ("sharecard".equals(str3)) {
            return p(strArr);
        }
        if ("executecommand".equals(str3)) {
            return q(strArr);
        }
        if (!"memberchange".equals(str3)) {
            return false;
        }
        return r(strArr);
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        Activity a16;
        super.onResponse(bundle);
        if (bundle == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRobotPlugin", 2, "robot plugin onResponse is null");
                return;
            }
            return;
        }
        if (bundle.getInt("respkey") != this.mOnRemoteResp.key) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRobotPlugin", 2, "robot plugin onResponse key not match");
                return;
            }
            return;
        }
        String string = bundle.getString("cmd");
        if ("ipc_cmd_share_robot_card".equals(string)) {
            int i3 = bundle.getBundle("response").getInt("result");
            if (QLog.isColorLevel()) {
                QLog.d("TroopRobotPlugin", 2, "robot plugin is robot:" + i3);
            }
            if (i3 == 1 && (a16 = this.mRuntime.a()) != null && !a16.isFinishing()) {
                com.tencent.mobileqq.troop.utils.k.a(a16, bundle.getBundle(Const.BUNDLE_KEY_REQUEST).getString("robotuin"), bundle.getString("share_robot_card_ark_info"));
                return;
            }
            return;
        }
        if ("ipc_cmd_invoke_robot_function".equals(string)) {
            String string2 = bundle.getBundle("response").getString("result");
            if (QLog.isColorLevel()) {
                QLog.d("TroopRobotPlugin", 2, "strResult:" + string2);
            }
            Activity a17 = this.mRuntime.a();
            Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
            int i16 = bundle2.getInt("isrobotbuddy");
            String string3 = bundle2.getString("onurl");
            String string4 = bundle2.getString("ontitle");
            String string5 = bundle2.getString("offtitle");
            String string6 = bundle2.getString("offurl");
            String string7 = bundle2.getString("robotuin");
            String string8 = bundle2.getString("troopuin");
            String string9 = bundle2.getString("robotname");
            if (i16 == 1) {
                com.tencent.mobileqq.troop.utils.k.j(a17, string8, string2, string7, string9, string3, string4, string6, string5, i16);
            } else if (i16 == 0) {
                com.tencent.mobileqq.troop.utils.k.j(a17, string2, null, string7, string9, string3, string4, string6, string5, i16);
            }
        }
    }
}
