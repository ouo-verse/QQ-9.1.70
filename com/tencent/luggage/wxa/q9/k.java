package com.tencent.luggage.wxa.q9;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138421b;

    /* renamed from: c, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138422c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138423d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138424e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138425f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138426g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138427h;

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f138428i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f138429j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f138430k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f138431l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f138432m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f138433n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f138434o;

    /* renamed from: p, reason: collision with root package name */
    public static final a.C6921a f138435p;

    /* renamed from: q, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138436q;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("RecommendWxaList");
        f138421b = bVar;
        f138422c = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138423d = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        f138424e = new com.tencent.luggage.wxa.ao.a("nickname", HippyControllerProps.STRING, bVar.a(), "");
        f138425f = new com.tencent.luggage.wxa.ao.a("iconUrl", HippyControllerProps.STRING, bVar.a(), "");
        f138426g = new com.tencent.luggage.wxa.ao.a("tagIdList", HippyControllerProps.STRING, bVar.a(), "");
        f138427h = new com.tencent.luggage.wxa.ao.a("type", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138428i = new String[0];
        f138429j = 93028124;
        f138430k = 70690926;
        f138431l = 1638765110;
        f138432m = 1445805203;
        f138433n = 3575610;
        f138434o = 108705909;
        f138435p = a(k.class);
        f138436q = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[5];
        c6921a.f145160c = new String[6];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "appId";
        c6921a.f145161d.put("appId", "TEXT PRIMARY KEY ");
        sb5.append(" appId TEXT PRIMARY KEY ");
        sb5.append(", ");
        c6921a.f145159b = "appId";
        c6921a.f145160c[1] = "nickname";
        c6921a.f145161d.put("nickname", "TEXT");
        sb5.append(" nickname TEXT");
        sb5.append(", ");
        c6921a.f145160c[2] = "iconUrl";
        c6921a.f145161d.put("iconUrl", "TEXT");
        sb5.append(" iconUrl TEXT");
        sb5.append(", ");
        c6921a.f145160c[3] = "tagIdList";
        c6921a.f145161d.put("tagIdList", "TEXT");
        sb5.append(" tagIdList TEXT");
        sb5.append(", ");
        c6921a.f145160c[4] = "type";
        c6921a.f145161d.put("type", "INTEGER");
        sb5.append(" type INTEGER");
        c6921a.f145160c[5] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }
}
