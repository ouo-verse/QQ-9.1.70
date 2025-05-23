package com.tencent.smtt.sdk.core.dynamicinstall.a;

import com.tencent.smtt.utils.TbsLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f369307a;

    /* renamed from: b, reason: collision with root package name */
    private String f369308b;

    /* renamed from: c, reason: collision with root package name */
    private String f369309c;

    /* renamed from: d, reason: collision with root package name */
    private int f369310d;

    /* renamed from: e, reason: collision with root package name */
    private int f369311e;

    /* renamed from: f, reason: collision with root package name */
    private int f369312f;

    /* renamed from: g, reason: collision with root package name */
    private String f369313g;

    public String a() {
        return this.f369307a;
    }

    public String b() {
        return this.f369308b;
    }

    public int c() {
        return this.f369311e;
    }

    public int d() {
        return this.f369312f;
    }

    public int e() {
        return this.f369310d;
    }

    public String f() {
        return this.f369313g;
    }

    public static b e(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            int i3 = jSONObject2.getInt("ret_code");
            if (i3 != 0) {
                bVar.b(i3);
                bVar.d(jSONObject2.getString("reason"));
                return bVar;
            }
            bVar.c(jSONObject.getString("name"));
            bVar.b(jSONObject.getString("md5"));
            bVar.a(jSONObject.getInt("size"));
            bVar.a(jSONObject.getString("url"));
            bVar.c(jSONObject.getInt("version"));
            return bVar;
        } catch (Exception unused) {
            TbsLog.i("ComponentResp", "parseResponse Data Failed");
            return null;
        }
    }

    public void a(String str) {
        this.f369307a = str;
    }

    public void b(String str) {
        this.f369308b = str;
    }

    public void c(String str) {
        this.f369309c = str;
    }

    public void d(String str) {
        this.f369313g = str;
    }

    public void a(int i3) {
        this.f369311e = i3;
    }

    public void b(int i3) {
        this.f369312f = i3;
    }

    public void c(int i3) {
        this.f369310d = i3;
    }
}
