package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v2;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeConstant;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsHandler;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsHandler;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsBridgeControllerV2 {
    private static final String TAG = "jsbridge.JsBridgeControllerV2";
    private final JsHandlerRegistryV2 mJsHandlerFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsBridgeControllerV2(Object obj) {
        this.mJsHandlerFactory = new JsHandlerRegistryV2(obj);
    }

    private static String getResponse(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", str);
        hashMap.put("result", obj);
        return new JSONObject(hashMap).toString();
    }

    private JsBridgeData parseMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(BaseJsHandler.JS_HANDLER_NAME);
            String optString2 = jSONObject.optString("callbackId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                optJSONObject.put("callbackId", optString2);
            }
            return new JsBridgeData(optString, optString2, optJSONObject);
        } catch (Exception unused) {
            Log.e(TAG, "parseMessage(), parse message error ");
            return null;
        }
    }

    public String postMessage(String str) {
        JsBridgeData parseMessage = parseMessage(str);
        if (parseMessage != null) {
            return processMessage(parseMessage);
        }
        return getResponse("500", JsBridgeConstant.PARSE_MESSAGE_ERROR);
    }

    String processMessage(JsBridgeData jsBridgeData) {
        try {
            IJsHandler jsHandler = this.mJsHandlerFactory.getJsHandler(jsBridgeData.mHandleName);
            if (jsHandler != null) {
                jsHandler.handle(jsBridgeData.mHandleName, jsBridgeData.mData);
                return getResponse("200", "");
            }
        } catch (Error e16) {
            Log.e(TAG, "processMessage(), error: " + e16);
        }
        return getResponse("500", JsBridgeConstant.PROCESS_MESSAGE_ERROR);
    }
}
