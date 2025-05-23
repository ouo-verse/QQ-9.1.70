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
public abstract class i extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138385h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138386i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138387j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138388k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138389l;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f138390m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f138391n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f138392o;

    /* renamed from: p, reason: collision with root package name */
    public static final int f138393p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f138394q;

    /* renamed from: r, reason: collision with root package name */
    public static final a.C6921a f138395r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138396s;

    /* renamed from: b, reason: collision with root package name */
    public String f138397b;

    /* renamed from: d, reason: collision with root package name */
    public long f138399d;

    /* renamed from: f, reason: collision with root package name */
    public int f138401f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138398c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138400e = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138402g = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("PersistentWxaSyncInvalidContactCmd");
        f138385h = bVar;
        f138386i = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138387j = new com.tencent.luggage.wxa.ao.a("username", HippyControllerProps.STRING, bVar.a(), "");
        f138388k = new com.tencent.luggage.wxa.ao.a("timestamp", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138389l = new com.tencent.luggage.wxa.ao.a("reportId", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138390m = new String[0];
        f138391n = -265713450;
        f138392o = 55126294;
        f138393p = -427040401;
        f138394q = 108705909;
        f138395r = a(i.class);
        f138396s = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[3];
        c6921a.f145160c = new String[4];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "username";
        c6921a.f145161d.put("username", "TEXT PRIMARY KEY ");
        sb5.append(" username TEXT PRIMARY KEY ");
        sb5.append(", ");
        c6921a.f145159b = "username";
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

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138396s;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public Object d() {
        return this.f138397b;
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
            if (f138391n == hashCode) {
                try {
                    this.f138397b = cursor.getString(i3);
                    this.f138398c = true;
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BasePersistentWxaSyncInvalidContactCmd", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138392o == hashCode) {
                try {
                    this.f138399d = cursor.getLong(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BasePersistentWxaSyncInvalidContactCmd", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138393p == hashCode) {
                try {
                    this.f138401f = cursor.getInt(i3);
                } catch (Throwable th7) {
                    w.a("MicroMsg.SDK.BasePersistentWxaSyncInvalidContactCmd", th7, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138394q == hashCode) {
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
        if (this.f138398c) {
            contentValues.put("username", this.f138397b);
        }
        if (this.f138400e) {
            contentValues.put("timestamp", Long.valueOf(this.f138399d));
        }
        if (this.f138402g) {
            contentValues.put("reportId", Integer.valueOf(this.f138401f));
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
