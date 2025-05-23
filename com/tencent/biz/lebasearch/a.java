package com.tencent.biz.lebasearch;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    QQCustomDialog f78634d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.biz.troop.b f78635e = null;

    /* renamed from: f, reason: collision with root package name */
    QQCustomDialog f78636f = null;

    /* renamed from: h, reason: collision with root package name */
    String f78637h = null;

    /* renamed from: i, reason: collision with root package name */
    public BusinessObserver f78638i = new C0793a();

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, long j3, String str, String str2) {
        if (this.mRuntime.a() == null || this.mRuntime.a().isFinishing()) {
            return;
        }
        if (this.f78634d == null) {
            this.f78634d = Utils.createPluginSetDialogForWeb(this.mRuntime.a(), this.f78635e, this.f78638i, i3, j3, str, str2);
        }
        if (this.f78634d.isShowing()) {
            return;
        }
        this.f78634d.show();
    }

    private void r(String str) {
        AppRuntime c16 = this.mRuntime.c();
        if (c16 != null) {
            if (str == null) {
                str = "";
            }
            ReportController.r(c16, "dc00898", "", c16.getCurrentUin(), "0X800C2C1", "0X800C2C1", 0, 0, "", "", str, "");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "lebaPlugin";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4 = strArr[0];
        if (str3 == null) {
            return false;
        }
        QLog.i("LebaPlugin", 1, "handleJsRequest method= " + str3);
        r(str3);
        if (str3.equals("showOpenDialog")) {
            try {
                JSONObject jSONObject = new JSONObject(str4);
                long optLong = jSONObject.optLong("id", -1L);
                String optString = jSONObject.optString("msg");
                String optString2 = jSONObject.optString("callback");
                if (optLong != -1) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("reqCode", 10000);
                    bundle.putLong("uiResId", optLong);
                    bundle.putString("msg", optString);
                    bundle.putString("callback", optString2);
                    bundle.putInt("dialogType", 1);
                    this.f78635e.z0(18, bundle, this.f78638i);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } else if (str3.equals("getPluginStatus")) {
            try {
                JSONObject jSONObject2 = new JSONObject(str4);
                long optLong2 = jSONObject2.optLong("id", -1L);
                String optString3 = jSONObject2.optString("callback");
                if (optLong2 != -1) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("reqCode", 10002);
                    bundle2.putLong("uiResId", optLong2);
                    bundle2.putString("callback", optString3);
                    this.f78635e.z0(18, bundle2, this.f78638i);
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        } else if (str3.equals("search")) {
            try {
                if (!TextUtils.isEmpty(new JSONObject(str4).optString("keyWord"))) {
                    this.mRuntime.a();
                }
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.f78635e = A;
        A.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        com.tencent.biz.troop.b bVar = this.f78635e;
        if (bVar != null) {
            bVar.q();
        }
        QQCustomDialog qQCustomDialog = this.f78634d;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f78634d.dismiss();
        }
        super.onDestroy();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.lebasearch.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0793a implements BusinessObserver {
        C0793a() {
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:20:0x0070). Please report as a decompilation issue!!! */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            Bundle bundle;
            if (i3 == 17) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (z16) {
                        jSONObject.put("userOption", 1);
                    } else {
                        jSONObject.put("userOption", 0);
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                if (TextUtils.isEmpty(a.this.f78637h)) {
                    return;
                }
                a aVar = a.this;
                aVar.callJs(aVar.f78637h, jSONObject.toString());
                a.this.f78637h = null;
                return;
            }
            if (i3 == 18 && (bundle = (Bundle) obj) != null) {
                int i16 = bundle.getInt("reqCode");
                if (i16 == 10000) {
                    String string = bundle.getString("name");
                    String string2 = bundle.getString("callback");
                    String string3 = bundle.getString("msg");
                    long j3 = bundle.getLong("uiResId");
                    a aVar2 = a.this;
                    aVar2.f78637h = string2;
                    aVar2.q(1, j3, string, string3);
                    return;
                }
                if (i16 == 10002) {
                    boolean z17 = bundle.getBoolean(h.f248218g);
                    String string4 = bundle.getString("callback");
                    boolean z18 = bundle.getBoolean("has");
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (z18) {
                            jSONObject2.put(h.f248218g, z17 ? 1 : 0);
                        } else {
                            jSONObject2.put(h.f248218g, 1);
                        }
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                    if (TextUtils.isEmpty(string4)) {
                        return;
                    }
                    a.this.callJs(string4, jSONObject2.toString());
                }
            }
        }
    }
}
