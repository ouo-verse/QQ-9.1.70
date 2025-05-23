package com.tencent.biz.eqq;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    protected Activity f78507d;

    private void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("uin");
            String string2 = jSONObject.getString("name");
            Intent m3 = BaseAIOUtils.m(new Intent(this.f78507d, (Class<?>) ChatActivity.class), null);
            m3.putExtra("uin", string);
            m3.putExtra("uintype", 1024);
            m3.putExtra("uinname", string2);
            m3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
            m3.putExtra("aio_msg_source", 999);
            this.f78507d.startActivity(m3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "eqq";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"eqq".equals(str2)) {
            return false;
        }
        if ("showEQQ".equals(str3)) {
            if (strArr.length > 0) {
                q(strArr[0]);
            }
            return true;
        }
        if ("showEQQAio".equals(str3) && strArr.length == 1) {
            p(strArr[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f78507d = this.mRuntime.a();
    }

    protected void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CrmUtils.n(this.f78507d, null, new JSONObject(str).getString("uin"), false, -1, true, -1);
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("EqqWebviewPlugin", 2, "showEqq json error!");
            }
        }
    }
}
