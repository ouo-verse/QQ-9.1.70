package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class n extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "gflivesdk";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("openView".equals(str3)) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("LiveRoomBusinessPlugin", 2, "openView");
                }
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("viewType");
                String optString2 = jSONObject.optString("callback");
                if (!WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY.equals(optString)) {
                    return true;
                }
                String optString3 = jSONObject.optString("url");
                Activity a16 = this.mRuntime.a();
                if (a16 == null || optString3 == null || optString3.isEmpty()) {
                    return true;
                }
                LiveRoomProxyActivity.open(a16, optString3, "BusinessPlugin openView");
                callJs(optString2, "{\"result\":0}");
                return true;
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("LiveRoomBusinessPlugin", 2, e16.getMessage(), e16);
                }
                return false;
            }
        }
        "checkSDKInstalled".equals(str3);
        return false;
    }
}
