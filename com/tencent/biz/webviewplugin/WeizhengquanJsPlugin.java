package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WeizhengquanJsPlugin extends com.tencent.mobileqq.webview.swift.k {

    /* renamed from: d, reason: collision with root package name */
    Activity f97531d;

    /* renamed from: e, reason: collision with root package name */
    private final String f97532e = "getPayAdInfo";

    /* renamed from: f, reason: collision with root package name */
    private final String f97533f = "pushMusicInfo";

    /* renamed from: h, reason: collision with root package name */
    String f97534h = "";

    private void q(JsBridgeListener jsBridgeListener, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.i("WeizhengquanJsPlugin", 2, "prosGetPayAdInfo...");
        }
        if (!(this.mRuntime.b() instanceof x05.a)) {
            QLog.i("WeizhengquanJsPlugin", 2, "activity error : " + this.f97531d);
            return;
        }
        int c16 = ((x05.a) this.mRuntime.b()).c(this.f97531d);
        QLog.i("WeizhengquanJsPlugin", 2, "bzCode = " + c16);
        if (1 != c16) {
            return;
        }
        Bundle b16 = ((x05.a) this.mRuntime.b()).b(this.f97531d);
        if (b16 == null) {
            QLog.i("WeizhengquanJsPlugin", 2, "error bundle is null...");
            return;
        }
        String string = b16.getString("paySuccJsonData");
        int i3 = b16.getInt("ScreenHeight");
        int i16 = b16.getInt("PayHeight");
        int i17 = b16.getInt("ADHeight");
        QLog.i("WeizhengquanJsPlugin", 2, "data = " + string + " sh = " + i3 + " ph = " + i16 + " ah = " + i17);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ScreenHeight", i3);
            jSONObject2.put("PayHeight", i16);
            jSONObject2.put("ADHeight", i17);
            jSONObject.put("display", jSONObject2);
            jSONObject.put("paySuccJsonData", string);
            QLog.i("WeizhengquanJsPlugin", 2, this.f97534h + " => " + jSONObject);
            callJs(this.f97534h, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void r(JsBridgeListener jsBridgeListener, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.i("WeizhengquanJsPlugin", 2, "prosPushMusicInfo...");
        }
        if (strArr.length <= 0) {
            QLog.i("WeizhengquanJsPlugin", 2, "error, parameters empty...");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret_code", "0");
            jSONObject.put("ret_msg", "success");
            callJs(this.f97534h, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        Intent intent = new Intent();
        intent.putExtra("h5arg", strArr[0]);
        this.f97531d.setResult(-1, intent);
        this.f97531d.finish();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "qw";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.k, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        QLog.d("WeizhengquanJsPlugin", 2, "handleJsRequest url = " + str + " pkgName = " + str2 + " methodName = " + str3 + " arg.length = " + strArr.length);
        if (!getNameSpace().equals(str2)) {
            return false;
        }
        String p16 = p(strArr);
        this.f97534h = p16;
        if (TextUtils.isEmpty(p16)) {
            QLog.d("WeizhengquanJsPlugin", 2, "function name is null...");
            return true;
        }
        if ("getPayAdInfo".equals(str3)) {
            q(jsBridgeListener, strArr);
            return true;
        }
        if (!"pushMusicInfo".equals(str3)) {
            return false;
        }
        r(jsBridgeListener, strArr);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        this.f97531d = this.mRuntime.a();
    }

    private String p(String... strArr) {
        if (strArr != null && strArr.length > 0 && !TextUtils.isEmpty(strArr[0])) {
            QLog.i("WeizhengquanJsPlugin", 2, "arg[0] = " + strArr[0]);
            try {
                this.f97534h = new JSONObject(strArr[0]).optString("callback");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            QLog.i("WeizhengquanJsPlugin", 2, "parameter callback = " + this.f97534h);
            return this.f97534h;
        }
        QLog.i("WeizhengquanJsPlugin", 2, "parameter error..." + strArr);
        return null;
    }
}
