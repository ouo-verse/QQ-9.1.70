package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class t extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final String f238910d = "t";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "MixSearchWeb";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && strArr != null && strArr.length != 0 && "MixSearchWeb".equals(str2) && "setSearchBarWord".equals(str3) && (this.mRuntime.f() instanceof MixSearchWebFragment)) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                ((MixSearchWebFragment) this.mRuntime.f()).th(jSONObject.optString("searchWord"), jSONObject.optString("placeholder"));
                return true;
            } catch (JSONException e16) {
                QLog.e(f238910d, 1, "handleJsRequest: e = " + e16);
            }
        }
        return false;
    }
}
