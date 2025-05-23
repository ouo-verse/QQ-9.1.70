package com.qq.e.comm.plugin.base.ad.model;

import android.text.TextUtils;
import com.qq.e.comm.plugin.k.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private String f39071a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f39072b;

    /* renamed from: c, reason: collision with root package name */
    private int f39073c;

    /* renamed from: d, reason: collision with root package name */
    private String f39074d;

    /* renamed from: e, reason: collision with root package name */
    private String f39075e;

    /* renamed from: f, reason: collision with root package name */
    private long f39076f;

    public static n a(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return null;
        }
        n nVar = new n();
        nVar.a(y.e(jSONObject, "market_deep_link"));
        nVar.a(y.c(jSONObject, "market_jump_type"));
        nVar.b(y.e(jSONObject, "customized_deep_link"));
        nVar.c(y.e(jSONObject, "customized_atd_deep_link"));
        nVar.a(y.d(jSONObject, "customized_expired_timestamp_ms"));
        JSONArray f16 = y.f(jSONObject, "market_package_name");
        if (!y.a(f16)) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < f16.length(); i3++) {
                String c16 = y.c(f16, i3);
                if (!TextUtils.isEmpty(c16)) {
                    arrayList.add(c16);
                }
            }
            nVar.a(arrayList);
        }
        return nVar;
    }

    public List<String> b() {
        return this.f39072b;
    }

    public int c() {
        return this.f39073c;
    }

    public String d() {
        return this.f39074d;
    }

    public String e() {
        return this.f39075e;
    }

    public long f() {
        return this.f39076f;
    }

    public void b(String str) {
        this.f39074d = str;
    }

    public void c(String str) {
        this.f39075e = str;
    }

    public String a() {
        return this.f39071a;
    }

    public void a(String str) {
        this.f39071a = str;
    }

    public void a(List<String> list) {
        this.f39072b = list;
    }

    public void a(int i3) {
        this.f39073c = i3;
    }

    public void a(long j3) {
        this.f39076f = j3;
    }
}
