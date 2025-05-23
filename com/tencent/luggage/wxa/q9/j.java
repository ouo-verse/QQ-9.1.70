package com.tencent.luggage.wxa.q9;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xn.a;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138403h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138404i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138405j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138406k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138407l;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f138408m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f138409n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f138410o;

    /* renamed from: p, reason: collision with root package name */
    public static final int f138411p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f138412q;

    /* renamed from: r, reason: collision with root package name */
    public static final a.C6921a f138413r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138414s;

    /* renamed from: b, reason: collision with root package name */
    public String f138415b;

    /* renamed from: d, reason: collision with root package name */
    public String f138417d;

    /* renamed from: f, reason: collision with root package name */
    public long f138419f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138416c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138418e = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138420g = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("PluginDevLaunchInfo");
        f138403h = bVar;
        f138404i = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138405j = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        f138406k = new com.tencent.luggage.wxa.ao.a("versionDesc", HippyControllerProps.STRING, bVar.a(), "");
        f138407l = new com.tencent.luggage.wxa.ao.a("devKey", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138408m = new String[0];
        f138409n = 93028124;
        f138410o = 688612233;
        f138411p = -1335185910;
        f138412q = 108705909;
        f138413r = a(j.class);
        f138414s = new com.tencent.luggage.wxa.zn.c();
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
        c6921a.f145160c[1] = "versionDesc";
        c6921a.f145161d.put("versionDesc", "TEXT");
        sb5.append(" versionDesc TEXT");
        sb5.append(", ");
        c6921a.f145160c[2] = "devKey";
        c6921a.f145161d.put("devKey", "LONG");
        sb5.append(" devKey LONG");
        c6921a.f145160c[3] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138414s;
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
            if (f138409n == hashCode) {
                try {
                    this.f138415b = cursor.getString(i3);
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BasePluginDevLaunchInfo", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138410o == hashCode) {
                try {
                    this.f138417d = cursor.getString(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BasePluginDevLaunchInfo", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138411p == hashCode) {
                try {
                    this.f138419f = cursor.getLong(i3);
                } catch (Throwable th7) {
                    w.a("MicroMsg.SDK.BasePluginDevLaunchInfo", th7, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138412q == hashCode) {
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
        if (this.f138416c) {
            contentValues.put("appId", this.f138415b);
        }
        if (this.f138418e) {
            contentValues.put("versionDesc", this.f138417d);
        }
        if (this.f138420g) {
            contentValues.put("devKey", Long.valueOf(this.f138419f));
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
