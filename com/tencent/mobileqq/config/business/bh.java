package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bh {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f202610a = new ConcurrentHashMap<>(6);

    /* renamed from: b, reason: collision with root package name */
    public boolean f202611b = false;

    public static bh a() {
        bh bhVar = new bh();
        bhVar.f202610a.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
        bhVar.f202610a.put("pskey", "[\"qun.qq.com\",\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\",\"tenpay.com\",\"buluo.qq.com\",\"docs.qq.com\",\"ti.qq.com\",\"accounts.qq.com\",\"yundong.qq.com\",\"mp.qq.com\",\"xsj.qq.com\"]");
        bhVar.f202610a.put(ICustomDataEditor.STRING_ARRAY_PARAM_1, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        bhVar.f202610a.put(ICustomDataEditor.STRING_ARRAY_PARAM_2, "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
        bhVar.f202610a.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\", \"https://ptlogin2.qq.com\"]");
        bhVar.f202610a.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
        bhVar.f202611b = false;
        return bhVar;
    }

    public static bh c(String str) {
        boolean z16;
        if (str == null) {
            QLog.d("TicketAuthorizeConf", 1, "getDefaultValue");
            return a();
        }
        try {
            bh bhVar = new bh();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("use_mqq_oa_config") == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            bhVar.f202611b = z16;
            bhVar.f202610a.put("skey", jSONObject.optJSONArray("skey").toString());
            bhVar.f202610a.put("pskey", jSONObject.optJSONArray("pskey").toString());
            bhVar.f202610a.put(ICustomDataEditor.STRING_ARRAY_PARAM_1, jSONObject.optJSONArray(ICustomDataEditor.STRING_ARRAY_PARAM_1).toString());
            bhVar.f202610a.put(ICustomDataEditor.STRING_ARRAY_PARAM_2, jSONObject.optJSONArray(ICustomDataEditor.STRING_ARRAY_PARAM_2).toString());
            bhVar.f202610a.put("ptlogin2", jSONObject.optJSONArray("ptlogin2").toString());
            bhVar.f202610a.put("pt4_token", jSONObject.optJSONArray("pt4_token").toString());
            return bhVar;
        } catch (Exception e16) {
            QLog.e("TicketAuthorizeConf", 1, e16.toString());
            return a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray b(String str) {
        JSONArray jSONArray;
        Object valueOf;
        String str2 = this.f202610a.get(str);
        if (str2 != null && !"".equals(str2)) {
            try {
                jSONArray = new JSONArray(str2);
            } catch (JSONException e16) {
                QLog.e("TicketAuthorizeConf", 1, e16.toString());
            }
            Object[] objArr = new Object[4];
            objArr[0] = "key:";
            objArr[1] = str;
            objArr[2] = " config:";
            if (jSONArray != null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(jSONArray.length());
            }
            objArr[3] = valueOf;
            QLog.d("TicketAuthorizeConf", 1, objArr);
            return jSONArray;
        }
        jSONArray = null;
        Object[] objArr2 = new Object[4];
        objArr2[0] = "key:";
        objArr2[1] = str;
        objArr2[2] = " config:";
        if (jSONArray != null) {
        }
        objArr2[3] = valueOf;
        QLog.d("TicketAuthorizeConf", 1, objArr2);
        return jSONArray;
    }
}
