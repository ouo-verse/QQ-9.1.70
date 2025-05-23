package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class w0 {
    public static void a(String str, String str2) {
        n0 n0Var;
        String str3;
        String replace = "{url}/getPublicKey?keytype=2".replace("{url}", a1.f(str, str2));
        String f16 = q0.f();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", f16);
        try {
            n0Var = w.a(replace, new byte[0], hashMap);
        } catch (Exception e16) {
            v.e("GetPublicKey", "get pubKey response Exception :" + e16.getMessage());
            n0Var = null;
        }
        if (n0Var == null) {
            str3 = "get pubKey response is null";
        } else if (n0Var.b() == 200) {
            if (TextUtils.isEmpty(n0Var.a())) {
                return;
            }
            c(n0Var.a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + n0Var.b();
        }
        v.e("GetPublicKey", str3);
    }

    public static String b(String str, String str2) {
        String o16;
        String c16 = q0.c();
        if (TextUtils.isEmpty(c16)) {
            c16 = d.a(q0.i(), "Privacy_MY", "public_key_version", "");
            q0.g(c16);
        }
        if ("maint".equals(str2)) {
            o16 = q0.n();
            if (TextUtils.isEmpty(o16)) {
                o16 = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", d.a(q0.i(), "Privacy_MY", "public_key_maint", ""));
                q0.d(o16);
            }
        } else {
            o16 = q0.o();
            if (TextUtils.isEmpty(o16)) {
                o16 = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", d.a(q0.i(), "Privacy_MY", "public_key_oper", ""));
                q0.e(o16);
            }
        }
        if (!TextUtils.isEmpty(o16) && !TextUtils.isEmpty(c16) && !a()) {
            return o16;
        }
        b0.a().a(new j1(str, str2));
        return null;
    }

    private static void c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("publicKey");
            String optString2 = jSONObject.optString("publicKeyOM");
            String optString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String optString4 = jSONObject.optString(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL);
            d.b(q0.i(), "Privacy_MY", "public_key_oper", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString));
            d.b(q0.i(), "Privacy_MY", "public_key_maint", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            d.b(q0.i(), "Privacy_MY", "public_key_time_interval", optString4);
            d.b(q0.i(), "Privacy_MY", "public_key_version", optString3);
            d.b(q0.i(), "Privacy_MY", "public_key_time_last", str3);
            q0.e(optString);
            q0.d(optString2);
            q0.g(optString3);
            q0.c(str3);
            q0.f(optString4);
        } catch (JSONException e16) {
            v.e("GetPublicKey", "get pubKey parse json JSONException :" + e16.getMessage());
        }
    }

    public static boolean a() {
        String a16 = q0.a();
        if (TextUtils.isEmpty(a16)) {
            a16 = d.a(q0.i(), "Privacy_MY", "public_key_time_interval", "");
            q0.f(a16);
        }
        String m3 = q0.m();
        if (TextUtils.isEmpty(m3)) {
            m3 = d.a(q0.i(), "Privacy_MY", "public_key_time_last", "");
            q0.c(m3);
        }
        if (TextUtils.isEmpty(a16) || TextUtils.isEmpty(m3)) {
            return true;
        }
        try {
            return System.currentTimeMillis() - Long.parseLong(m3) > ((long) Integer.parseInt(a16));
        } catch (NumberFormatException e16) {
            v.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e16.getMessage());
            return true;
        }
    }
}
