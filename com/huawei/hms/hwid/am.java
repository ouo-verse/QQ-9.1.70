package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class am {

    /* renamed from: a, reason: collision with root package name */
    protected String f37306a;

    /* renamed from: b, reason: collision with root package name */
    protected String f37307b;

    /* renamed from: c, reason: collision with root package name */
    protected long f37308c;

    /* renamed from: d, reason: collision with root package name */
    protected String f37309d;

    public String a() {
        return this.f37306a;
    }

    public void b(String str) {
        this.f37306a = str;
    }

    public void c(String str) {
        this.f37307b = str;
    }

    public void d(String str) {
        this.f37309d = str;
    }

    protected JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("appId", this.f37306a);
        jSONObject.putOpt("packageName", this.f37307b);
        jSONObject.put("hmsSdkVersion", this.f37308c);
        jSONObject.putOpt("subAppId", this.f37309d);
        return jSONObject;
    }

    public String toString() {
        return "HuaweiIdCpClientInfo{appId='" + this.f37306a + "', packageName='" + this.f37307b + "', hmsSdkVersion=" + this.f37308c + "', subAppId=" + this.f37309d + '}';
    }

    public void a(long j3) {
        this.f37308c = j3;
    }

    public long b() {
        return this.f37308c;
    }

    public String c() {
        return this.f37309d;
    }

    public String d() throws JSONException {
        return e().toString();
    }
}
