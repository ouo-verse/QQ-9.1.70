package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kx.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class v extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    com.tencent.biz.troop.b f238912d;

    /* renamed from: e, reason: collision with root package name */
    String f238913e;

    /* renamed from: f, reason: collision with root package name */
    c.a f238914f = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements c.a {
        a() {
        }

        @Override // kx.c.a
        public void a(Bundle bundle) {
            if (!TextUtils.isEmpty(v.this.f238913e)) {
                String string = bundle.getString("info");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", string);
                    v vVar = v.this;
                    vVar.callJs(vVar.f238913e, jSONObject.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d("PushApiPlugin", 2, "handleJsRequest callback:", string);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    QLog.e("PushApiPlugin", 1, th5, new Object[0]);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("PushApiPlugin", 2, "handleJsRequest callback is empty");
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "push";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (this.f238912d == null) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.f238912d = A;
            A.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.troop.b bVar = this.f238912d;
        if (bVar != null) {
            bVar.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("push".equals(str2)) {
            if ("addListener".equals(str3) && strArr.length > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    int optInt = jSONObject.optInt("appid");
                    this.f238913e = jSONObject.optString("callback");
                    this.f238912d.N().a(optInt, this.f238914f);
                    if (QLog.isColorLevel()) {
                        QLog.d("PushApiPlugin", 2, str2, ".", str3, " args:", jSONObject.toString());
                    }
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("PushApiPlugin", 2, "handleJsRequest pkgName:", str2, " method:", str3, " JSONException:", e16);
                    }
                    return false;
                }
            } else if ("removeListener".equals(str3) && strArr.length > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    this.f238912d.N().d(jSONObject2.optInt("appid"));
                    if (QLog.isColorLevel()) {
                        QLog.d("PushApiPlugin", 2, str2, ".", str3, " args:", jSONObject2.toString());
                    }
                } catch (JSONException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("PushApiPlugin", 2, "handleJsRequest pkgName:", str2, " method:", str3, " JSONException:", e17);
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
