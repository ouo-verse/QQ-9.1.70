package com.tencent.luggage.wxa.q9;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138270b;

    /* renamed from: c, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138271c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138272d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138273e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f138274f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f138275g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f138276h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f138277i;

    /* renamed from: j, reason: collision with root package name */
    public static final a.C6921a f138278j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138279k;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("AppBrandCommonKVData");
        f138270b = bVar;
        f138271c = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138272d = new com.tencent.luggage.wxa.ao.a("key", HippyControllerProps.STRING, bVar.a(), "");
        f138273e = new com.tencent.luggage.wxa.ao.a("value", HippyControllerProps.STRING, bVar.a(), "");
        f138274f = new String[0];
        f138275g = 106079;
        f138276h = 111972721;
        f138277i = 108705909;
        f138278j = a(b.class);
        f138279k = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[2];
        c6921a.f145160c = new String[3];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "key";
        c6921a.f145161d.put("key", "TEXT PRIMARY KEY ");
        sb5.append(" key TEXT PRIMARY KEY ");
        sb5.append(", ");
        c6921a.f145159b = "key";
        c6921a.f145160c[1] = "value";
        c6921a.f145161d.put("value", "TEXT");
        sb5.append(" value TEXT");
        c6921a.f145160c[2] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }
}
