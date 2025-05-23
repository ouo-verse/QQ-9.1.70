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
public abstract class c extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: j, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138280j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138281k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138282l;

    /* renamed from: m, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138283m;

    /* renamed from: n, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138284n;

    /* renamed from: o, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138285o;

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f138286p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f138287q;

    /* renamed from: r, reason: collision with root package name */
    public static final int f138288r;

    /* renamed from: s, reason: collision with root package name */
    public static final int f138289s;

    /* renamed from: t, reason: collision with root package name */
    public static final int f138290t;

    /* renamed from: u, reason: collision with root package name */
    public static final int f138291u;

    /* renamed from: v, reason: collision with root package name */
    public static final a.C6921a f138292v;

    /* renamed from: w, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138293w;

    /* renamed from: b, reason: collision with root package name */
    public String f138294b;

    /* renamed from: d, reason: collision with root package name */
    public String f138296d;

    /* renamed from: f, reason: collision with root package name */
    public String f138298f;

    /* renamed from: h, reason: collision with root package name */
    public int f138300h;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138295c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138297e = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138299g = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f138301i = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("AppBrandKVData");
        f138280j = bVar;
        f138281k = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138282l = new com.tencent.luggage.wxa.ao.a("key", HippyControllerProps.STRING, bVar.a(), "");
        f138283m = new com.tencent.luggage.wxa.ao.a("data", HippyControllerProps.STRING, bVar.a(), "");
        f138284n = new com.tencent.luggage.wxa.ao.a("dataType", HippyControllerProps.STRING, bVar.a(), "");
        f138285o = new com.tencent.luggage.wxa.ao.a("size", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138286p = new String[0];
        f138287q = 106079;
        f138288r = 3076010;
        f138289s = 1789070852;
        f138290t = 3530753;
        f138291u = 108705909;
        f138292v = a(c.class);
        f138293w = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[4];
        c6921a.f145160c = new String[5];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "key";
        c6921a.f145161d.put("key", "TEXT PRIMARY KEY ");
        sb5.append(" key TEXT PRIMARY KEY ");
        sb5.append(", ");
        c6921a.f145159b = "key";
        c6921a.f145160c[1] = "data";
        c6921a.f145161d.put("data", "TEXT");
        sb5.append(" data TEXT");
        sb5.append(", ");
        c6921a.f145160c[2] = "dataType";
        c6921a.f145161d.put("dataType", "TEXT");
        sb5.append(" dataType TEXT");
        sb5.append(", ");
        c6921a.f145160c[3] = "size";
        c6921a.f145161d.put("size", "INTEGER");
        sb5.append(" size INTEGER");
        c6921a.f145160c[4] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138293w;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public Object d() {
        return this.f138294b;
    }

    public final void e() {
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
            if (f138287q == hashCode) {
                try {
                    this.f138294b = cursor.getString(i3);
                    this.f138295c = true;
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseAppBrandKVData", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138288r == hashCode) {
                try {
                    this.f138296d = cursor.getString(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseAppBrandKVData", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138289s == hashCode) {
                try {
                    this.f138298f = cursor.getString(i3);
                } catch (Throwable th7) {
                    w.a("MicroMsg.SDK.BaseAppBrandKVData", th7, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138290t == hashCode) {
                try {
                    this.f138300h = cursor.getInt(i3);
                } catch (Throwable th8) {
                    w.a("MicroMsg.SDK.BaseAppBrandKVData", th8, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138291u == hashCode) {
                this.f145157a = cursor.getLong(i3);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        e();
        ContentValues contentValues = new ContentValues();
        if (this.f138295c) {
            contentValues.put("key", this.f138294b);
        }
        if (this.f138297e) {
            contentValues.put("data", this.f138296d);
        }
        if (this.f138299g) {
            contentValues.put("dataType", this.f138298f);
        }
        if (this.f138301i) {
            contentValues.put("size", Integer.valueOf(this.f138300h));
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
