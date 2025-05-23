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
public abstract class o extends com.tencent.luggage.wxa.xn.a {

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138516h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138517i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138518j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138519k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138520l;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f138521m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f138522n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f138523o;

    /* renamed from: p, reason: collision with root package name */
    public static final int f138524p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f138525q;

    /* renamed from: r, reason: collision with root package name */
    public static final a.C6921a f138526r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.zn.c f138527s;

    /* renamed from: b, reason: collision with root package name */
    public String f138528b;

    /* renamed from: d, reason: collision with root package name */
    public int f138530d;

    /* renamed from: f, reason: collision with root package name */
    public String f138532f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138529c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138531e = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138533g = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("WxaPluginCodeVersionInfo");
        f138516h = bVar;
        f138517i = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138518j = new com.tencent.luggage.wxa.ao.a("pluginAppID", HippyControllerProps.STRING, bVar.a(), "");
        f138519k = new com.tencent.luggage.wxa.ao.a("pluginAppVersion", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138520l = new com.tencent.luggage.wxa.ao.a("pluginStringVersion", HippyControllerProps.STRING, bVar.a(), "");
        f138521m = new String[0];
        f138522n = 869640073;
        f138523o = -1159730422;
        f138524p = -1177314540;
        f138525q = 108705909;
        f138526r = a(o.class);
        f138527s = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[3];
        c6921a.f145160c = new String[4];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "pluginAppID";
        c6921a.f145161d.put("pluginAppID", "TEXT");
        sb5.append(" pluginAppID TEXT");
        sb5.append(", ");
        c6921a.f145160c[1] = "pluginAppVersion";
        c6921a.f145161d.put("pluginAppVersion", "INTEGER");
        sb5.append(" pluginAppVersion INTEGER");
        sb5.append(", ");
        c6921a.f145160c[2] = "pluginStringVersion";
        c6921a.f145161d.put("pluginStringVersion", "TEXT");
        sb5.append(" pluginStringVersion TEXT");
        c6921a.f145160c[3] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return f138527s;
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
            if (f138522n == hashCode) {
                try {
                    this.f138528b = cursor.getString(i3);
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseWxaPluginCodeVersionInfo", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138523o == hashCode) {
                try {
                    this.f138530d = cursor.getInt(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseWxaPluginCodeVersionInfo", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138524p == hashCode) {
                try {
                    this.f138532f = cursor.getString(i3);
                } catch (Throwable th7) {
                    w.a("MicroMsg.SDK.BaseWxaPluginCodeVersionInfo", th7, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138525q == hashCode) {
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
        if (this.f138529c) {
            contentValues.put("pluginAppID", this.f138528b);
        }
        if (this.f138531e) {
            contentValues.put("pluginAppVersion", Integer.valueOf(this.f138530d));
        }
        if (this.f138533g) {
            contentValues.put("pluginStringVersion", this.f138532f);
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
