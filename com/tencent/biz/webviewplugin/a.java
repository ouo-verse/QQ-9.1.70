package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final String f97535d = "a";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "arcard";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(f97535d, 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, strArr));
        }
        if ("arcard".equals(str2)) {
            if ("isEntranceSupport".equals(str3)) {
                if (strArr == null || strArr.length <= 0) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    QLog.d(f97535d, 2, "handleJsRequest jsonobject is " + jSONObject.toString());
                    String optString = jSONObject.optString("callback");
                    boolean z16 = !com.tencent.mobileqq.ar.g.b();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("is_entrance_support", z16);
                    callJs(optString, jSONObject2.toString());
                    return true;
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
            if ("isModelSupport".equals(str3)) {
                try {
                    JSONObject jSONObject3 = new JSONObject(strArr[0]);
                    QLog.d(f97535d, 2, "handleJsRequest jsonobject is " + jSONObject3.toString());
                    String optString2 = jSONObject3.optString("callback");
                    boolean c16 = com.tencent.mobileqq.ar.ARRecord.e.c();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("is_device_support", c16);
                    callJs(optString2, jSONObject4.toString());
                    return true;
                } catch (JSONException e17) {
                    e17.printStackTrace();
                    return false;
                }
            }
            return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }
}
