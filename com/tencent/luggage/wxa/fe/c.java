package com.tencent.luggage.wxa.fe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";

    /* renamed from: a, reason: collision with root package name */
    public String f126083a = "";

    /* renamed from: b, reason: collision with root package name */
    public int f126084b = -1;

    /* renamed from: c, reason: collision with root package name */
    public Class f126085c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends ResultReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126086a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f126087b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            super(handler);
            this.f126086a = dVar;
            this.f126087b = i3;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i3, Bundle bundle) {
            if (i3 == -1) {
                w.d("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth ok");
                c cVar = c.this;
                com.tencent.luggage.wxa.xd.d dVar = this.f126086a;
                int i16 = this.f126087b;
                if (bundle == null) {
                    bundle = null;
                }
                cVar.a(dVar, i16, bundle, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                return;
            }
            if (i3 == 1) {
                w.f("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth failed");
                c cVar2 = c.this;
                com.tencent.luggage.wxa.xd.d dVar2 = this.f126086a;
                int i17 = this.f126087b;
                if (bundle == null) {
                    bundle = null;
                }
                cVar2.a(dVar2, i17, bundle, "fail");
                return;
            }
            w.b("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter user cancelled");
            c cVar3 = c.this;
            com.tencent.luggage.wxa.xd.d dVar3 = this.f126086a;
            int i18 = this.f126087b;
            if (bundle == null) {
                bundle = null;
            }
            cVar3.a(dVar3, i18, bundle, "cancel");
        }
    }

    public c(Class cls) {
        this.f126085c = cls;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        Activity activity = (Activity) dVar.getContext();
        if (activity == null) {
            w.b("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", dVar.getAppId());
            dVar.a(i3, makeReturnJson("fail"));
            return;
        }
        if (this.f126085c == null) {
            w.b("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication ui is null!");
            dVar.a(i3, makeReturnJson("fail:JsApiStartSoterAuthentication UI is null!"));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
        String optString = jSONObject.optString("challenge");
        String optString2 = jSONObject.optString("authContent");
        Intent intent = new Intent(activity, (Class<?>) this.f126085c);
        intent.putExtra("auth_mode", d.a(optJSONArray));
        intent.putExtra("challenge", optString);
        intent.putExtra("auth_content", optString2);
        intent.putExtra("key_soter_fp_luggage_fromscene", 1);
        try {
            int i16 = jSONObject.getInt("scene");
            this.f126084b = i16;
            intent.putExtra("key_soter_fp_luggage_scene", i16);
        } catch (JSONException unused) {
            w.d("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter authentication scene null");
        }
        intent.putExtra("Soter_Result_Receiver", new a(new Handler(Looper.getMainLooper()), dVar, i3));
        com.tencent.luggage.wxa.fa.b.a(activity, intent);
        activity.startActivity(intent);
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, Bundle bundle, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        byte b16;
        String str7;
        int i16;
        String str8;
        String str9 = str;
        String str10 = "";
        if (bundle != null) {
            int i17 = bundle.getInt(CheckForwardServlet.KEY_ERR_CODE);
            String string = bundle.getString("err_msg");
            String string2 = bundle.getString("result_json");
            String string3 = bundle.getString("result_json_signature");
            byte b17 = bundle.getByte("use_mode");
            str4 = bundle.getString("authkey_result_json");
            String string4 = bundle.getString("authkey_result_json_signature");
            if (com.tencent.luggage.wxa.bn.b.a() == null || i17 != 0) {
                str5 = "";
                str6 = str5;
            } else {
                str5 = com.tencent.luggage.wxa.bn.b.a().a();
                str6 = com.tencent.luggage.wxa.bn.b.a().b();
            }
            str8 = string4;
            b16 = b17;
            str3 = string3;
            str2 = string2;
            str7 = string;
            i16 = i17;
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            b16 = 0;
            str7 = "not returned";
            i16 = -1;
            str8 = str6;
        }
        JSONArray a16 = d.a(b16);
        if (a16 != null && a16.length() > 0) {
            try {
                str10 = a16.getString(0);
            } catch (JSONException e16) {
                w.a("MicroMsg.JsApiLuggageStartSoterAuthentication", e16, "hy: json error in callback", new Object[0]);
            }
        }
        HashMap hashMap = new HashMap(6);
        hashMap.put("authMode", str10);
        hashMap.put("errCode", Integer.valueOf(i16));
        hashMap.put("resultJSON", str2);
        hashMap.put("resultJSONSignature", str3);
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put("resultJSON", str5);
        hashMap2.put("resultJSONSignature", str6);
        hashMap.put("ask", hashMap2);
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put("resultJSON", str4);
        hashMap3.put("resultJSONSignature", str8);
        hashMap.put("authKey", hashMap3);
        if ("fail".equals(str9)) {
            str9 = str9 + " " + str7;
        }
        dVar.a(i3, makeReturnJson(str9, hashMap));
    }
}
