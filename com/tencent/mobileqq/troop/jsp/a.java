package com.tencent.mobileqq.troop.jsp;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.biz.troop.b f297705d;

    /* renamed from: e, reason: collision with root package name */
    protected AtomicBoolean f297706e = new AtomicBoolean(false);

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "GroupAppPanel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"GroupAppPanel".equals(str2)) {
            return false;
        }
        if (!"launchGroupApp".equals(str3) || strArr.length <= 0 || this.f297705d == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            this.f297705d.T(jSONObject.getString("groupCode"), jSONObject.getString("appID"), jSONObject.getString("url"), jSONObject.getString("source"));
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("TroopAppPanelJsPlugin", 2, "launchGroupApp: args error");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        if (this.f297706e.compareAndSet(false, true)) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.f297705d = A;
            A.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        if (this.f297706e.get()) {
            this.f297705d.q();
        }
    }
}
