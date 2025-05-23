package com.tencent.luggage.wxa.q9;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138327h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138328i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138329j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138330k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138331l;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f138332m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f138333n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f138334o;

    /* renamed from: p, reason: collision with root package name */
    public static final int f138335p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f138336q;

    /* renamed from: r, reason: collision with root package name */
    public static final a.C6921a f138337r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138338s;

    /* renamed from: b, reason: collision with root package name */
    public String f138339b;

    /* renamed from: d, reason: collision with root package name */
    public int f138341d;

    /* renamed from: f, reason: collision with root package name */
    public String f138343f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138340c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138342e = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138344g = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("DevPkgLaunchExtInfo");
        f138327h = bVar;
        f138328i = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138329j = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        f138330k = new com.tencent.luggage.wxa.ao.a("versionType", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138331l = new com.tencent.luggage.wxa.ao.a(WadlProxyConsts.EXT_JSON, HippyControllerProps.STRING, bVar.a(), "");
        f138332m = new String[0];
        f138333n = 93028124;
        f138334o = 689108018;
        f138335p = -1306463575;
        f138336q = 108705909;
        f138337r = a(e.class);
        f138338s = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[3];
        c6921a.f145160c = new String[4];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "appId";
        c6921a.f145161d.put("appId", "TEXT");
        sb5.append(" appId TEXT");
        sb5.append(", ");
        c6921a.f145160c[1] = "versionType";
        c6921a.f145161d.put("versionType", "INTEGER");
        sb5.append(" versionType INTEGER");
        sb5.append(", ");
        c6921a.f145160c[2] = WadlProxyConsts.EXT_JSON;
        c6921a.f145161d.put(WadlProxyConsts.EXT_JSON, "TEXT");
        sb5.append(" extJson TEXT");
        c6921a.f145160c[3] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138338s;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public Object d() {
        return Long.valueOf(this.f145157a);
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public void a(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames == null) {
            return;
        }
        int length = columnNames.length;
        for (int i3 = 0; i3 < length; i3++) {
            int hashCode = columnNames[i3].hashCode();
            if (f138333n == hashCode) {
                try {
                    this.f138339b = cursor.getString(i3);
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseDevPkgLaunchExtInfo", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138334o == hashCode) {
                try {
                    this.f138341d = cursor.getInt(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseDevPkgLaunchExtInfo", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138335p == hashCode) {
                try {
                    this.f138343f = cursor.getString(i3);
                } catch (Throwable th7) {
                    w.a("MicroMsg.SDK.BaseDevPkgLaunchExtInfo", th7, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138336q == hashCode) {
                this.f145157a = cursor.getLong(i3);
            }
        }
    }

    public final void e() {
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        e();
        ContentValues contentValues = new ContentValues();
        if (this.f138340c) {
            contentValues.put("appId", this.f138339b);
        }
        if (this.f138342e) {
            contentValues.put("versionType", Integer.valueOf(this.f138341d));
        }
        if (this.f138344g) {
            contentValues.put(WadlProxyConsts.EXT_JSON, this.f138343f);
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
