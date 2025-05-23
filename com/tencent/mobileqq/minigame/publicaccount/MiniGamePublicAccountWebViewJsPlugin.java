package com.tencent.mobileqq.minigame.publicaccount;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniGamePublicAccountWebViewJsPlugin extends WebViewPlugin {
    public static String PLUGIN_NAMESPACE = MiniConst.MiniGamePublicAccountWebViewJsPluginConst.PLUGIN_NAMESPACE;
    private static final String TAG = "MiniGamePublicAccountWebViewJsPlugin";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return PLUGIN_NAMESPACE;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934624L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934624L) {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    if (map.containsKey("height")) {
                        jSONObject.put("height", map.get("height"));
                    }
                } catch (ClassCastException e16) {
                    QLog.e(TAG, 1, "handleEvent error", e16);
                } catch (JSONException e17) {
                    QLog.e(TAG, 1, "handleEvent error", e17);
                }
            }
            dispatchJsEvent("gameFeedsEvent", jSONObject, null);
            return true;
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (PLUGIN_NAMESPACE.equals(str2) && QLog.isColorLevel()) {
            QLog.d(TAG, 1, "pkgName:" + str2 + " method:" + str3);
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }
}
