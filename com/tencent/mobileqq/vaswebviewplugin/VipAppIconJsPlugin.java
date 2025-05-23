package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasAppIconStateManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class VipAppIconJsPlugin extends VasWebviewJsPluginV2 {
    public static final String BUSINESS_NAME = "vipappicon";
    private static final String TAG = "VipAppIconJsPlugin";

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|iconId", method = "enable")
    public void enable(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).isSupport(Integer.parseInt(str2)));
            jSONObject.put("msg", "");
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "getClientAppIconId")
    public void getClientAppIconId(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            jSONObject.put("msg", "");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("iconId", ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).getPrepareIconId());
            jSONObject.put("data", jSONObject2);
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|iconId", method = "setClientAppIconId")
    public void setClientAppIconId(String str, String str2) {
        VasLogReporter.getAppIcon().reportHighest("js setClientAppIconId " + str2);
        try {
            ((IVasAppIconStateManager) QRoute.api(IVasAppIconStateManager.class)).setUseAppIcon(true);
            if (VasToggle.BUG_TASK_861918821.isEnable(true)) {
                VasUtil.getService().getAppIconSwitchManager().changeIconForJsb(this.mRuntime.c().getAccount(), Integer.parseInt(str2));
            } else {
                VasUtil.getService().getAppIconSwitchManager().checkAndSwitchIcon(this.mRuntime.c().getAccount(), true);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            jSONObject.put("msg", "");
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }
}
