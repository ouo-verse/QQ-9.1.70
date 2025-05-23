package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.tencent.raft.codegenmeta.utils.Constants;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b1 implements o1 {

    /* renamed from: a, reason: collision with root package name */
    private String f37078a;

    /* renamed from: b, reason: collision with root package name */
    private String f37079b;

    /* renamed from: c, reason: collision with root package name */
    private String f37080c;

    /* renamed from: d, reason: collision with root package name */
    private String f37081d;

    /* renamed from: e, reason: collision with root package name */
    private String f37082e;

    /* renamed from: f, reason: collision with root package name */
    private String f37083f;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f37078a);
        jSONObject.put("eventtime", this.f37081d);
        jSONObject.put("event", this.f37079b);
        jSONObject.put("event_session_name", this.f37082e);
        jSONObject.put("first_session_event", this.f37083f);
        if (TextUtils.isEmpty(this.f37080c)) {
            return null;
        }
        jSONObject.put(Constants.Service.PROPERTIES, new JSONObject(this.f37080c));
        return jSONObject;
    }

    public String b() {
        return this.f37081d;
    }

    public String c() {
        return this.f37078a;
    }

    public JSONObject d() {
        JSONObject a16 = a();
        a16.put(Constants.Service.PROPERTIES, n.b(this.f37080c, o0.d().a()));
        return a16;
    }

    public void e(String str) {
        this.f37083f = str;
    }

    public void f(String str) {
        this.f37082e = str;
    }

    public void a(String str) {
        this.f37080c = str;
    }

    public void b(String str) {
        this.f37079b = str;
    }

    public void c(String str) {
        this.f37081d = str;
    }

    public void d(String str) {
        this.f37078a = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f37079b = jSONObject.optString("event");
        this.f37080c = jSONObject.optString(Constants.Service.PROPERTIES);
        this.f37080c = n.a(this.f37080c, o0.d().a());
        this.f37078a = jSONObject.optString("type");
        this.f37081d = jSONObject.optString("eventtime");
        this.f37082e = jSONObject.optString("event_session_name");
        this.f37083f = jSONObject.optString("first_session_event");
    }
}
