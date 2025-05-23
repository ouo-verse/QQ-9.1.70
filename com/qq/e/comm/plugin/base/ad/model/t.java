package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.plugin.k.y;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private JSONArray f39138a;

    /* renamed from: b, reason: collision with root package name */
    private int f39139b;

    /* renamed from: c, reason: collision with root package name */
    private int f39140c;

    /* renamed from: d, reason: collision with root package name */
    private int f39141d;

    /* renamed from: e, reason: collision with root package name */
    private int f39142e;

    /* renamed from: f, reason: collision with root package name */
    private int f39143f;

    public t(JSONObject jSONObject) {
        this.f39139b = Integer.MIN_VALUE;
        this.f39140c = Integer.MIN_VALUE;
        this.f39141d = Integer.MIN_VALUE;
        this.f39142e = Integer.MIN_VALUE;
        this.f39143f = Integer.MIN_VALUE;
        JSONArray f16 = y.f(jSONObject, "judgment_angle");
        this.f39138a = f16;
        if (!y.a(f16)) {
            this.f39139b = y.a(this.f39138a, 0, Integer.MIN_VALUE);
            this.f39140c = y.a(this.f39138a, 1, Integer.MIN_VALUE);
            this.f39141d = y.a(this.f39138a, 2, Integer.MIN_VALUE);
            this.f39142e = y.a(this.f39138a, 3, Integer.MIN_VALUE);
        }
        this.f39143f = y.b(jSONObject, "trigger_max_angle", Integer.MIN_VALUE);
    }

    public boolean a() {
        return !y.a(this.f39138a);
    }

    public int b() {
        return this.f39139b;
    }

    public int c() {
        return this.f39140c;
    }

    public int d() {
        return this.f39141d;
    }

    public int e() {
        return this.f39142e;
    }

    public int f() {
        return this.f39143f;
    }
}
