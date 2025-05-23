package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class TreasureCardJsPlugin extends VasWebviewJsPluginV2 {
    public static final String BUSINESS_NAME = "treasureCard";
    public static final String TAG = "TreasureCardJsPlugin";

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "clearSimCache")
    public void clearSimCache(String str) {
        try {
            boolean clearCacheAndRequest = VasUtil.getService(this.mRuntime.c()).getVasFtManager().clearCacheAndRequest();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Const.BUNDLE_KEY_REQUEST, clearCacheAndRequest);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, BUSINESS_NAME + str + " request:" + jSONObject);
            }
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|from", method = "freeTrafficCardModel")
    public void freeTrafficCardModel(String str, String str2) {
        try {
            IVasFTManager vasFtManager = VasUtil.getService(this.mRuntime.c()).getVasFtManager();
            JSONObject json = vasFtManager.obtainCardInfo(str2).toJson();
            json.put("cardStates", vasFtManager.obtainCardState(str2));
            super.callJs(str, json.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|from", method = "tcardModel")
    public void tcardModel(String str, String str2) {
        try {
            IVasFTManager vasFtManager = VasUtil.getService(this.mRuntime.c()).getVasFtManager();
            JSONObject json = vasFtManager.obtainCardInfo(str2).toJson();
            json.put("mobileCardStates", vasFtManager.treasureCardState(str2));
            super.callJs(str, json.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }
}
