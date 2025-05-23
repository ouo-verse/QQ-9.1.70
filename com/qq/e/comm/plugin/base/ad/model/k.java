package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.plugin.k.y;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private int f39054a;

    /* renamed from: b, reason: collision with root package name */
    private int f39055b;

    /* renamed from: c, reason: collision with root package name */
    private String f39056c;

    /* renamed from: d, reason: collision with root package name */
    private String f39057d;

    /* renamed from: e, reason: collision with root package name */
    private String f39058e;

    /* renamed from: f, reason: collision with root package name */
    private String f39059f;

    /* renamed from: g, reason: collision with root package name */
    private String f39060g;

    /* renamed from: h, reason: collision with root package name */
    private String f39061h;

    /* renamed from: i, reason: collision with root package name */
    private String f39062i;

    /* renamed from: j, reason: collision with root package name */
    private float f39063j;

    /* renamed from: k, reason: collision with root package name */
    private int f39064k;

    public k(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            this.f39054a = y.c(jSONObject, IPublicAccountConfigAttr.CARD_STYLE);
            this.f39055b = y.c(jSONObject, "activity_start_time");
            this.f39056c = y.e(jSONObject, "count_down_text");
            this.f39057d = y.e(jSONObject, "activity_text");
            this.f39058e = y.e(jSONObject, "theme_color");
            this.f39059f = y.e(jSONObject, "logo_url");
            this.f39060g = y.e(jSONObject, "image_url");
            this.f39061h = y.e(jSONObject, "product_features_text");
            this.f39062i = y.e(jSONObject, "title");
            this.f39063j = (float) y.b(jSONObject, "vertical_offset_ratio");
            this.f39064k = y.c(jSONObject, "animation_type");
        }
    }

    public int a() {
        return this.f39054a;
    }

    public int b() {
        return this.f39055b;
    }

    public String c() {
        return this.f39056c;
    }

    public String d() {
        return this.f39057d;
    }

    public String e() {
        return this.f39058e;
    }

    public String f() {
        return this.f39059f;
    }

    public String g() {
        return this.f39060g;
    }

    public String h() {
        return this.f39061h;
    }

    public String i() {
        return this.f39062i;
    }

    public float j() {
        return this.f39063j / 10000.0f;
    }

    public int k() {
        return this.f39064k;
    }
}
