package com.tencent.luggage.wxa.q9;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138373b;

    /* renamed from: c, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138374c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138375d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138376e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138377f;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f138378g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f138379h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f138380i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f138381j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f138382k;

    /* renamed from: l, reason: collision with root package name */
    public static final a.C6921a f138383l;

    /* renamed from: m, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138384m;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("PersistentWxaSyncInvalidCodeCmd");
        f138373b = bVar;
        f138374c = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138375d = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        f138376e = new com.tencent.luggage.wxa.ao.a("timestamp", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138377f = new com.tencent.luggage.wxa.ao.a("reportId", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138378g = new String[0];
        f138379h = 93028124;
        f138380i = 55126294;
        f138381j = -427040401;
        f138382k = 108705909;
        f138383l = a(h.class);
        f138384m = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[3];
        c6921a.f145160c = new String[4];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "appId";
        c6921a.f145161d.put("appId", "TEXT PRIMARY KEY ");
        sb5.append(" appId TEXT PRIMARY KEY ");
        sb5.append(", ");
        c6921a.f145159b = "appId";
        c6921a.f145160c[1] = "timestamp";
        c6921a.f145161d.put("timestamp", "LONG");
        sb5.append(" timestamp LONG");
        sb5.append(", ");
        c6921a.f145160c[2] = "reportId";
        c6921a.f145161d.put("reportId", "INTEGER");
        sb5.append(" reportId INTEGER");
        c6921a.f145160c[3] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }
}
