package com.tencent.biz.troop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"InlinedApi"})
/* loaded from: classes5.dex */
public class c extends WebViewPlugin implements ITroopMemberApiClientApi.a {

    /* renamed from: d, reason: collision with root package name */
    AtomicBoolean f96764d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    com.tencent.biz.troop.b f96765e = null;

    /* renamed from: f, reason: collision with root package name */
    VideoCombineHelper f96766f = null;

    /* renamed from: h, reason: collision with root package name */
    protected String f96767h;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f96768d;

        a(String str) {
            this.f96768d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            boolean z16 = bundle.getBoolean("isSuccess", false);
            if (z16) {
                c.this.callJs(this.f96768d, bundle.getString("data"));
            } else if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "getTroopBarPublishInfo() in callback isSuccess=" + z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements VideoCombineHelper.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f96770a;

        b(String str) {
            this.f96770a = str;
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.e
        public void a(String str, boolean z16, String str2) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (z16) {
                    jSONObject.put("retCode", 0);
                } else {
                    jSONObject.put("retCode", 1);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("errMsg", str2);
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("file", str);
                }
                c.this.callJs(this.f96770a, jSONObject.toString());
            } catch (Exception e16) {
                QLog.e("WebViewPlugin", 1, str2, e16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.troop.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0981c implements VideoCombineHelper.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f96772a;

        C0981c(String str) {
            this.f96772a = str;
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.e
        public void a(String str, boolean z16, String str2) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (z16) {
                    jSONObject.put("retCode", 0);
                } else {
                    jSONObject.put("retCode", 1);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("errMsg", str2);
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("file", str);
                }
                c.this.callJs(this.f96772a, jSONObject.toString());
            } catch (Exception e16) {
                QLog.e("WebViewPlugin", 1, str2, e16);
            }
        }
    }

    private void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("gcode");
            String optString2 = jSONObject.optString("id");
            if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                this.f96765e.h(optString, optString2);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("WebViewPlugin", 2, "anonymousReport exception" + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
    public void callback(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if ("changeAnonymousNick".equals(bundle.getString("method"))) {
            boolean z16 = bundle.getBoolean("result");
            callJs(this.f96767h, "{result : " + z16 + "}");
            return;
        }
        String string = bundle.getString("callback");
        if (!TextUtils.isEmpty(string)) {
            callJs(string, bundle.getString("data"));
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "TroopMemberApiPlugin";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String optString;
        String optString2;
        String optString3;
        int optInt;
        String optString4;
        JSONArray optJSONArray;
        if ("anonymousReport".equals(str3)) {
            p(strArr[0]);
            return true;
        }
        if ("anonymousNickChanged".equals(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString5 = jSONObject.optString("troopUin");
                long optLong = jSONObject.optLong("bubbleId");
                int optInt2 = jSONObject.optInt("headId");
                String optString6 = jSONObject.optString("nickName");
                int optInt3 = jSONObject.optInt("expireTime");
                String optString7 = jSONObject.optString("rankColor");
                this.f96767h = jSONObject.optString("callback");
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewPlugin", 2, "TroopMemberApiPlugin, anonymousNickChanged, json : " + jSONObject);
                }
                this.f96765e.k(optString5, optLong, optInt2, optString6, optInt3, optString7, this);
                return true;
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebViewPlugin", 2, "TroopMemberApiPlugin, anonymousNickChanged, JSONException :" + e16);
                }
            }
        } else {
            if ("getUploadInfo".equals(str3)) {
                try {
                    callJs(new JSONObject(strArr[0]).optString("callback"), "{stateus:0}");
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
                return true;
            }
            if ("cleanDynamicRedPoint".equals(str3)) {
                try {
                    this.f96765e.m(new JSONObject(strArr[0]).optString("callback"), this);
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
                return true;
            }
            String str4 = "";
            if ("selectedTribe".endsWith(str3) && strArr.length == 1) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    Activity a16 = this.mRuntime.a();
                    String optString8 = jSONObject2.optString("name");
                    String optString9 = jSONObject2.optString("bid");
                    JSONObject optJSONObject = jSONObject2.optJSONObject("condition");
                    String optString10 = jSONObject2.optString("tribeList");
                    Intent intent = new Intent();
                    if (TextUtils.isEmpty(optString8)) {
                        optString8 = "";
                    }
                    intent.putExtra("tribeName", optString8);
                    if (TextUtils.isEmpty(optString9)) {
                        optString9 = "";
                    }
                    intent.putExtra("bid", optString9);
                    if (!TextUtils.isEmpty(optString10)) {
                        str4 = optString10;
                    }
                    intent.putExtra("tribeList", str4);
                    int optInt4 = optJSONObject.optInt("optionType", -1);
                    if (optInt4 != -1) {
                        intent.putExtra("optionType", optInt4);
                    }
                    a16.setResult(-1, intent);
                    a16.finish();
                } catch (JSONException e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e("WebViewPlugin", 2, "JSONException:" + e19.toString());
                    }
                }
            } else if ("getTroopBarPublishInfo".equals(str3)) {
                try {
                    String optString11 = new JSONObject(strArr[0]).optString("callback");
                    if (this.f96765e == null) {
                        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
                        this.f96765e = A;
                        A.p();
                    }
                    this.f96765e.I(new a(optString11));
                } catch (JSONException e26) {
                    e26.printStackTrace();
                }
            } else if (!"createVideoAndSend".equals(str3) && !"prepareVideoResources".equals(str3)) {
                if ("checkVideoLib".equals(str3)) {
                    try {
                        String optString12 = new JSONObject(strArr[0]).optString("callback");
                        JSONObject jSONObject3 = new JSONObject();
                        if (VideoEnvironment.checkAndLoadAVCodec()) {
                            jSONObject3.put("retCode", 0);
                            callJs(optString12, jSONObject3.toString());
                        } else {
                            jSONObject3.put("retCode", -1);
                            callJs(optString12, jSONObject3.toString());
                            if (this.f96765e == null) {
                                com.tencent.biz.troop.b A2 = com.tencent.biz.troop.b.A();
                                this.f96765e = A2;
                                A2.p();
                            }
                            this.f96765e.J0();
                        }
                    } catch (Exception e27) {
                        e27.printStackTrace();
                    }
                } else if ("setTribePublishTopic".equals(str3) && strArr.length == 1) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(strArr[0]);
                        String optString13 = jSONObject4.optString("callback");
                        JSONObject jSONObject5 = new JSONObject();
                        Activity a17 = this.mRuntime.a();
                        int optInt5 = jSONObject4.optInt("theme_id", -1);
                        String optString14 = jSONObject4.optString("theme_name");
                        Intent intent2 = new Intent();
                        if (optInt5 != -1 && optString14 == null) {
                            a17.setResult(0, intent2);
                            jSONObject5.put("retCode", -1);
                        } else {
                            intent2.putExtra("theme_id", optInt5);
                            if (!TextUtils.isEmpty(optString14)) {
                                str4 = optString14;
                            }
                            intent2.putExtra("theme_name", str4);
                            a17.setResult(-1, intent2);
                            jSONObject5.put("retCode", 0);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("WebViewPlugin", 2, "setTribePublishTopic JSAPI mThemeID = " + optInt5 + " mThemeName = " + optString14);
                        }
                        callJs(optString13, jSONObject5.toString());
                    } catch (JSONException e28) {
                        if (QLog.isColorLevel()) {
                            QLog.e("WebViewPlugin", 2, "selectedTheme JSONException:" + e28.toString());
                        }
                    }
                } else if ("enableShortVideoPublish".equals(str3) && strArr.length == 1) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("enableShortVideoPublish", ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture());
                        if (QLog.isColorLevel()) {
                            QLog.d("WebViewPlugin", 2, "retJson=" + jSONObject6);
                        }
                        callJs(new JSONObject(strArr[0]).optString("callback"), jSONObject6.toString());
                    } catch (Exception e29) {
                        if (QLog.isColorLevel()) {
                            QLog.e("WebViewPlugin", 2, "enableShortVideoPublish exp:" + e29.toString());
                        }
                    }
                }
            } else {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i("WebViewPlugin", 2, str3 + "json:" + strArr[0]);
                    }
                    JSONObject jSONObject7 = new JSONObject(strArr[0]);
                    optString = jSONObject7.optString("troopUin");
                    optString2 = jSONObject7.optString("wording");
                    optString3 = jSONObject7.optString("bgMusic");
                    optInt = jSONObject7.optInt("tailType");
                    optString4 = jSONObject7.optString("callback");
                    optJSONArray = jSONObject7.optJSONArray("videos");
                } catch (Exception e36) {
                    QLog.e("WebViewPlugin", 1, "invoke createVideoAndSend failed", e36);
                }
                if ((!"createVideoAndSend".equals(str3) || !TextUtils.isEmpty(optString)) && !TextUtils.isEmpty(optString2) && optJSONArray != null && optJSONArray.length() != 0) {
                    if (this.f96766f == null) {
                        this.f96766f = new VideoCombineHelper((QBaseActivity) this.mRuntime.a());
                    }
                    VideoCombineHelper videoCombineHelper = this.f96766f;
                    Objects.requireNonNull(videoCombineHelper);
                    VideoCombineHelper.g gVar = new VideoCombineHelper.g();
                    gVar.f96717c = optString;
                    gVar.f96719e = optString3;
                    gVar.f96720f = optString2;
                    gVar.f96721g = optInt;
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        gVar.f96718d.add(optJSONArray.getString(i3));
                    }
                    if ("createVideoAndSend".equals(str3)) {
                        this.f96766f.b(gVar, new b(optString4));
                    } else {
                        this.f96766f.d(gVar, new C0981c(optString4));
                    }
                    return true;
                }
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("retCode", 1);
                jSONObject8.put("errorMsg", "params error: troopUin = " + optString + " wroding = " + optString2 + " array = " + optJSONArray);
                callJs(optString4, jSONObject8.toString());
                return true;
            }
        }
        return false;
    }

    void init() {
        if (this.f96764d.compareAndSet(false, true)) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.f96765e = A;
            A.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        AppInterface b16 = this.mRuntime.b();
        Activity a16 = this.mRuntime.a();
        if (b16 != null && a16 != null) {
            init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        if (this.f96764d.get()) {
            this.f96765e.q();
        }
        this.f96766f = null;
    }
}
