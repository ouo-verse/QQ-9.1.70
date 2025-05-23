package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.plugin.k.y;
import com.tencent.ditto.shell.LayoutAttrDefine;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private int f39150a;

    /* renamed from: b, reason: collision with root package name */
    private int f39151b;

    /* renamed from: c, reason: collision with root package name */
    private int f39152c;

    /* renamed from: d, reason: collision with root package name */
    private int f39153d;

    /* renamed from: e, reason: collision with root package name */
    private int f39154e;

    /* renamed from: f, reason: collision with root package name */
    private int f39155f;

    /* renamed from: g, reason: collision with root package name */
    private int f39156g;

    /* renamed from: h, reason: collision with root package name */
    private int f39157h;

    /* renamed from: i, reason: collision with root package name */
    private int f39158i;

    /* renamed from: j, reason: collision with root package name */
    private String f39159j;

    /* renamed from: k, reason: collision with root package name */
    private String f39160k;

    /* renamed from: l, reason: collision with root package name */
    private int f39161l;

    public v(JSONObject jSONObject) {
        this.f39150a = 0;
        this.f39151b = 0;
        this.f39152c = 0;
        this.f39153d = 0;
        this.f39154e = 0;
        this.f39155f = 0;
        this.f39156g = 0;
        this.f39157h = 0;
        this.f39158i = 0;
        this.f39161l = 0;
        if (!y.a(jSONObject)) {
            return;
        }
        this.f39150a = jSONObject.optInt("area_type", 0);
        this.f39159j = jSONObject.optString("render_pic_url");
        this.f39160k = jSONObject.optString("h5_url");
        this.f39161l = jSONObject.optInt("slide_tips_margin_bottom");
        JSONObject optJSONObject = jSONObject.optJSONObject("area_boundary");
        if (y.a(optJSONObject)) {
            this.f39151b = optJSONObject.optInt(LayoutAttrDefine.MARGIN_LEFT, 0) / 2;
            this.f39152c = optJSONObject.optInt(LayoutAttrDefine.MARGIN_RIGHT, 0) / 2;
            this.f39153d = optJSONObject.optInt(LayoutAttrDefine.MARGIN_TOP, 0) / 2;
            this.f39154e = optJSONObject.optInt(LayoutAttrDefine.MARGIN_BOTTOM, 0) / 2;
            this.f39155f = optJSONObject.optInt("margin_left_rate", 0);
            this.f39156g = optJSONObject.optInt("margin_right_rate", 0);
            this.f39157h = optJSONObject.optInt("margin_bottom_rate", 0);
            this.f39158i = optJSONObject.optInt("area_aspect_radio", 0);
        }
    }

    public int a() {
        return this.f39150a;
    }

    public String b() {
        return this.f39159j;
    }

    public int c() {
        return this.f39155f;
    }

    public int d() {
        return this.f39156g;
    }

    public int e() {
        return this.f39157h;
    }

    public int f() {
        return this.f39158i;
    }
}
