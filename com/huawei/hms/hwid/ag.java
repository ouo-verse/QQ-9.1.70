package com.huawei.hms.hwid;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ag {

    /* renamed from: a, reason: collision with root package name */
    private Integer f37304a;

    /* renamed from: b, reason: collision with root package name */
    private String f37305b;

    public Integer a() {
        return this.f37304a;
    }

    public String b() {
        return this.f37305b;
    }

    public static ag b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ag();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Integer valueOf = jSONObject.has("errorCode") ? Integer.valueOf(jSONObject.getInt("errorCode")) : null;
            String string = jSONObject.has("errorMsg") ? jSONObject.getString("errorMsg") : null;
            ag agVar = new ag();
            agVar.a(valueOf);
            agVar.a(string);
            return agVar;
        } catch (JSONException unused) {
            as.d("ReadSmsOutputBean", "ReadSmsOutputBean json parse falied", true);
            return new ag();
        }
    }

    public void a(Integer num) {
        this.f37304a = num;
    }

    public void a(String str) {
        this.f37305b = str;
    }
}
