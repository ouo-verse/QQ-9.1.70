package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.utils.ah;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public WadlParams f106814a;

    /* renamed from: b, reason: collision with root package name */
    public String f106815b;

    /* renamed from: c, reason: collision with root package name */
    public int f106816c;

    /* renamed from: d, reason: collision with root package name */
    public String f106817d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f106818e;

    /* renamed from: f, reason: collision with root package name */
    public String f106819f;

    /* renamed from: g, reason: collision with root package name */
    public String f106820g;

    /* renamed from: h, reason: collision with root package name */
    public String f106821h;

    /* renamed from: i, reason: collision with root package name */
    public String f106822i;

    /* renamed from: j, reason: collision with root package name */
    public String f106823j;

    /* renamed from: k, reason: collision with root package name */
    public long f106824k;

    /* renamed from: l, reason: collision with root package name */
    public String f106825l;

    /* renamed from: m, reason: collision with root package name */
    public long f106826m;

    /* renamed from: n, reason: collision with root package name */
    public String f106827n;

    /* renamed from: o, reason: collision with root package name */
    public String f106828o;

    /* renamed from: p, reason: collision with root package name */
    public String f106829p;

    /* renamed from: q, reason: collision with root package name */
    public String f106830q;

    /* renamed from: r, reason: collision with root package name */
    public String f106831r;

    /* renamed from: s, reason: collision with root package name */
    public String f106832s;

    public static h b() {
        h hVar = new h();
        try {
            hVar.f106826m = ah.X() / 1048576;
            hVar.f106825l = String.valueOf(ah.U()[1]);
            hVar.f106815b = "";
            hVar.f106816c = 0;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hVar;
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("leftMemorySize", this.f106826m);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
