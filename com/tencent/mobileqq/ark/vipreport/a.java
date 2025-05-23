package com.tencent.mobileqq.ark.vipreport;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f199664a;

    /* renamed from: b, reason: collision with root package name */
    public int f199665b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f199666c;

    /* renamed from: d, reason: collision with root package name */
    public long f199667d;

    /* renamed from: e, reason: collision with root package name */
    public long f199668e;

    /* renamed from: f, reason: collision with root package name */
    public long f199669f;

    /* renamed from: g, reason: collision with root package name */
    public long f199670g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap<String, String> f199671h;

    public JSONObject a() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f199664a)) {
                str = this.f199664a;
            } else {
                str = "";
            }
            jSONObject.put("evt", str);
            jSONObject.put("index", this.f199665b);
            jSONObject.put("result", this.f199666c);
            jSONObject.put("startTime", this.f199667d);
            jSONObject.put("endTime", this.f199668e);
            jSONObject.put("costTime", this.f199669f);
            jSONObject.put("net", this.f199670g);
            JSONObject jSONObject2 = new JSONObject();
            HashMap<String, String> hashMap = this.f199671h;
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("param", jSONObject2);
        } catch (JSONException e16) {
            QLog.e("ArkVipReportItem", 1, "getJsonObject()", e16);
        }
        return jSONObject;
    }
}
