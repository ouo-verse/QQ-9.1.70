package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends WebViewPlugin {

    /* renamed from: e, reason: collision with root package name */
    private static String f238857e;

    /* renamed from: d, reason: collision with root package name */
    public BroadcastReceiver f238858d = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("callback");
            int intExtra = intent.getIntExtra("bless_type", 0);
            int intExtra2 = intent.getIntExtra("bless_num", 0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bless_type", intExtra);
                jSONObject.put("bless_num", intExtra2);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.i("BlessJsApiPlugin", 2, String.format("call blessWebView, blesstype:%d, member:%d", Integer.valueOf(intExtra), Integer.valueOf(intExtra2)));
            }
            if (intExtra != 2) {
                if (intExtra == 3) {
                    c.this.callJs(c.f238857e, jSONObject.toString());
                    return;
                } else {
                    c.this.callJs(stringExtra, jSONObject.toString());
                    return;
                }
            }
            try {
                String stringExtra2 = intent.getStringExtra("bless_ptv_url");
                String stringExtra3 = intent.getStringExtra("bless_ptv_uuid");
                String stringExtra4 = intent.getStringExtra("bless_ptv_md5");
                String stringExtra5 = intent.getStringExtra("bless_ptv_nick");
                jSONObject.put("bless_ptv_url", stringExtra2);
                jSONObject.put("bless_ptv_uuid", stringExtra3);
                jSONObject.put("bless_ptv_md5", stringExtra4);
                jSONObject.put("bless_ptv_nick", stringExtra5);
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            c.this.callJs(c.f238857e, jSONObject.toString());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "bless";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.BlessJsApiPlugin");
        this.mRuntime.a().registerReceiver(this.f238858d, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        this.mRuntime.a().unregisterReceiver(this.f238858d);
    }

    public void q(Intent intent, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("BlessJsApiPlugin", 2, "onActivityResult, requestCode:" + i3 + "\uff0cresultCode\uff1a" + i16);
        }
        if (i3 != 11000 || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("arg_callback");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            if (i16 == -1) {
                String stringExtra2 = intent.getStringExtra("arg_result_json");
                if (stringExtra2 != null) {
                    JSONObject jSONObject = new JSONObject(stringExtra2);
                    jSONObject.put("retCode", 0);
                    callJs(stringExtra, jSONObject.toString());
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("retCode", -1);
            String jSONObject3 = jSONObject2.toString();
            if (QLog.isColorLevel()) {
                QLog.d("BlessJsApiPlugin", 2, "startNewPTVActivity result:" + jSONObject3);
            }
            callJs(stringExtra, jSONObject3);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("BlessJsApiPlugin", 2, "Call BlessJsApiPlugin handleJsRequest, url" + str + " pkgName:" + str2);
        }
        if (!"bless".equals(str2)) {
            return false;
        }
        if ("GSBase64Encode".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessJsApiPlugin", 2, "Call Bless Api GSBaze64Encode, args:" + strArr);
            }
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    String optString = jSONObject.optString("need_encode_string");
                    String optString2 = jSONObject.optString("callback");
                    if (!TextUtils.isEmpty(optString2)) {
                        String b16 = com.tencent.mobileqq.nearby.k.b(optString);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("encoded_string", b16);
                        callJs(optString2, jSONObject2.toString());
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        } else if ("getBlessConfig".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessJsApiPlugin", 2, "Call Bless Api getBlessConfig, args:" + strArr);
            }
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString3 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString3)) {
                        String C = BlessManager.C();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("bless_config", C);
                        callJs(optString3, jSONObject3.toString());
                    }
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            }
        } else if ("sendBlessText".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessJsApiPlugin", 2, "Call Bless Api sendBlessText, args:" + strArr);
            }
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject4 = new JSONObject(strArr[0]);
                    String optString4 = jSONObject4.optString("callback");
                    String optString5 = jSONObject4.optString("blesswords");
                    if (!TextUtils.isEmpty(optString4)) {
                        com.tencent.mobileqq.activity.bless.f.d(this.mRuntime.a(), optString5, optString4);
                    }
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
            }
        } else if ("sendBlessPtv".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessJsApiPlugin", 2, "Call sendBlessPtv, args:" + strArr);
            }
            if (strArr != null && strArr.length > 0) {
                try {
                    JSONObject jSONObject5 = new JSONObject(strArr[0]);
                    String optString6 = jSONObject5.optString("callback");
                    String optString7 = jSONObject5.optString("supportvideo");
                    String optString8 = jSONObject5.optString("supportphoto");
                    String optString9 = jSONObject5.optString("cameramode");
                    String optString10 = jSONObject5.optString("supportDD");
                    String optString11 = jSONObject5.optString("unfoldDD");
                    String optString12 = jSONObject5.optString("DDItemID");
                    String optString13 = jSONObject5.optString("supportFilter");
                    if (!TextUtils.isEmpty(optString6)) {
                        Activity a16 = this.mRuntime.a();
                        f238857e = optString6;
                        com.tencent.mobileqq.activity.bless.f.e(a16, optString7, optString8, optString9, optString10, optString11, optString12, optString13, optString6);
                    }
                } catch (JSONException e19) {
                    QLog.d("BlessJsApiPlugin", 1, "Call sendBlessPtv error, ", e19);
                }
            }
        } else if ("isSupportPTV".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessJsApiPlugin", 2, "Call Bless Api isSupportPTV, args:" + strArr);
            }
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString14 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString14)) {
                        boolean c16 = com.tencent.mobileqq.activity.bless.f.c(this.mRuntime.b());
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("is_support_ptv", c16);
                        callJs(optString14, jSONObject6.toString());
                    }
                } catch (JSONException e26) {
                    e26.printStackTrace();
                }
            }
        } else if ("isMobileSupportPTV".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessJsApiPlugin", 2, "Call Bless Api isMobileSupportPTV, args:" + strArr);
            }
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString15 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString15)) {
                        boolean a17 = com.tencent.mobileqq.activity.bless.f.a(this.mRuntime.b());
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("is_mobile_support_ptv", a17);
                        callJs(optString15, jSONObject7.toString());
                    }
                } catch (JSONException e27) {
                    e27.printStackTrace();
                }
            }
        } else if ("isMobileSupportPendant".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("BlessJsApiPlugin", 2, "Call Bless Api isMobileSupportPendant, args:" + strArr);
            }
            if (strArr != null && strArr.length > 0) {
                try {
                    String optString16 = new JSONObject(strArr[0]).optString("callback");
                    if (!TextUtils.isEmpty(optString16)) {
                        boolean b17 = com.tencent.mobileqq.activity.bless.f.b(this.mRuntime.b());
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("is_support_DynamicDecoration", b17);
                        callJs(optString16, jSONObject8.toString());
                    }
                } catch (JSONException e28) {
                    e28.printStackTrace();
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        int intValue;
        if (j3 == 8589934600L && map != null && (intValue = ((Integer) map.get("requestCode")).intValue()) == 11000) {
            q((Intent) map.get("data"), intValue, ((Integer) map.get(QzoneIPCModule.RESULT_CODE)).intValue());
            return true;
        }
        return super.handleEvent(str, j3, map);
    }
}
