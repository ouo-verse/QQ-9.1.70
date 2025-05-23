package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import com.tencent.mobileqq.vip.TMSManager;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class KingCardJsPlugin extends VasWebviewJsPluginV2 {
    public static final String BUSINESS_NAME = "kingCard";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(method = "openKingCardActivation")
    public void openKingCardActivation(VasWebviewJsPluginV2.JsData jsData) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", TMSManager.e().k(this.mRuntime.a()) ? 1 : 0);
            super.callJs(jsData.callbackId, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(jsData.callbackId, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "supportKingCardActivation")
    public void supportKingCardActivation(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", TMSManager.e().n() ? 1 : 0);
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }
}
