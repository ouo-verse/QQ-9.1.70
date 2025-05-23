package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a0 implements g {

    /* renamed from: a, reason: collision with root package name */
    private Context f37057a = q0.i();

    /* renamed from: b, reason: collision with root package name */
    private String f37058b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f37059c;

    /* renamed from: d, reason: collision with root package name */
    private String f37060d;

    /* renamed from: e, reason: collision with root package name */
    private String f37061e;

    /* renamed from: f, reason: collision with root package name */
    private String f37062f;

    /* renamed from: g, reason: collision with root package name */
    private String f37063g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f37064h;

    public a0(String str, JSONObject jSONObject, String str2, String str3, long j3) {
        this.f37058b = str;
        this.f37059c = jSONObject;
        this.f37060d = str2;
        this.f37061e = str3;
        this.f37062f = String.valueOf(j3);
        if (z.i(str2, "oper")) {
            p0 a16 = y.a().a(str2, j3);
            this.f37063g = a16.a();
            this.f37064h = Boolean.valueOf(a16.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String valueOf;
        JSONArray jSONArray;
        v.c("hmsSdk", "Begin to run EventRecordTask...");
        int h16 = q0.h();
        int k3 = a1.k(this.f37060d, this.f37061e);
        if (c0.a(this.f37057a, "stat_v2_1", h16 * 1048576)) {
            v.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            e.a().a("", "alltype");
            return;
        }
        b1 b1Var = new b1();
        b1Var.b(this.f37058b);
        b1Var.a(this.f37059c.toString());
        b1Var.d(this.f37061e);
        b1Var.c(this.f37062f);
        b1Var.f(this.f37063g);
        Boolean bool = this.f37064h;
        if (bool == null) {
            valueOf = null;
        } else {
            valueOf = String.valueOf(bool);
        }
        b1Var.e(valueOf);
        try {
            JSONObject d16 = b1Var.d();
            String a16 = n1.a(this.f37060d, this.f37061e);
            String a17 = d.a(this.f37057a, "stat_v2_1", a16, "");
            try {
                if (!TextUtils.isEmpty(a17)) {
                    jSONArray = new JSONArray(a17);
                } else {
                    jSONArray = new JSONArray();
                }
            } catch (JSONException unused) {
                v.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.mo162put(d16);
            d.b(this.f37057a, "stat_v2_1", a16, jSONArray.toString());
            if (jSONArray.toString().length() > k3 * 1024) {
                e.a().a(this.f37060d, this.f37061e);
            }
        } catch (JSONException unused2) {
            v.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
