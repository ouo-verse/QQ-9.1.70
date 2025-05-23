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
public abstract class a extends com.tencent.luggage.wxa.xn.a {
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final a.C6921a H;
    public static final com.tencent.luggage.wxa.zn.c I;

    /* renamed from: p, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138245p;

    /* renamed from: q, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138246q;

    /* renamed from: r, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138247r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138248s;

    /* renamed from: t, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138249t;

    /* renamed from: u, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138250u;

    /* renamed from: v, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138251v;

    /* renamed from: w, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138252w;

    /* renamed from: x, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138253x;

    /* renamed from: y, reason: collision with root package name */
    public static final String[] f138254y;

    /* renamed from: z, reason: collision with root package name */
    public static final int f138255z;

    /* renamed from: b, reason: collision with root package name */
    public String f138256b;

    /* renamed from: d, reason: collision with root package name */
    public int f138258d;

    /* renamed from: f, reason: collision with root package name */
    public long f138260f;

    /* renamed from: h, reason: collision with root package name */
    public String f138262h;

    /* renamed from: j, reason: collision with root package name */
    public String f138264j;

    /* renamed from: l, reason: collision with root package name */
    public int f138266l;

    /* renamed from: n, reason: collision with root package name */
    public String f138268n;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138257c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138259e = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138261g = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f138263i = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f138265k = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f138267m = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f138269o = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("AppBrandBackgroundFetchData");
        f138245p = bVar;
        f138246q = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138247r = new com.tencent.luggage.wxa.ao.a("username", HippyControllerProps.STRING, bVar.a(), "");
        f138248s = new com.tencent.luggage.wxa.ao.a("fetchType", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138249t = new com.tencent.luggage.wxa.ao.a("updateTime", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138250u = new com.tencent.luggage.wxa.ao.a("path", HippyControllerProps.STRING, bVar.a(), "");
        f138251v = new com.tencent.luggage.wxa.ao.a("query", HippyControllerProps.STRING, bVar.a(), "");
        f138252w = new com.tencent.luggage.wxa.ao.a("scene", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138253x = new com.tencent.luggage.wxa.ao.a("data", HippyControllerProps.STRING, bVar.a(), "");
        f138254y = new String[0];
        f138255z = -265713450;
        A = -1237377772;
        B = -295931082;
        C = 3433509;
        D = 107944136;
        E = 109254796;
        F = 3076010;
        G = 108705909;
        H = a(a.class);
        I = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[7];
        c6921a.f145160c = new String[8];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "username";
        c6921a.f145161d.put("username", "TEXT");
        sb5.append(" username TEXT");
        sb5.append(", ");
        c6921a.f145160c[1] = "fetchType";
        c6921a.f145161d.put("fetchType", "INTEGER");
        sb5.append(" fetchType INTEGER");
        sb5.append(", ");
        c6921a.f145160c[2] = "updateTime";
        c6921a.f145161d.put("updateTime", "LONG");
        sb5.append(" updateTime LONG");
        sb5.append(", ");
        c6921a.f145160c[3] = "path";
        c6921a.f145161d.put("path", "TEXT");
        sb5.append(" path TEXT");
        sb5.append(", ");
        c6921a.f145160c[4] = "query";
        c6921a.f145161d.put("query", "TEXT");
        sb5.append(" query TEXT");
        sb5.append(", ");
        c6921a.f145160c[5] = "scene";
        c6921a.f145161d.put("scene", "INTEGER");
        sb5.append(" scene INTEGER");
        sb5.append(", ");
        c6921a.f145160c[6] = "data";
        c6921a.f145161d.put("data", "TEXT");
        sb5.append(" data TEXT");
        c6921a.f145160c[7] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return I;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public Object d() {
        return Long.valueOf(this.f145157a);
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
            if (f138255z == hashCode) {
                try {
                    this.f138256b = cursor.getString(i3);
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseAppBrandBackgroundFetchData", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (A == hashCode) {
                try {
                    this.f138258d = cursor.getInt(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseAppBrandBackgroundFetchData", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (B == hashCode) {
                try {
                    this.f138260f = cursor.getLong(i3);
                } catch (Throwable th7) {
                    w.a("MicroMsg.SDK.BaseAppBrandBackgroundFetchData", th7, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (C == hashCode) {
                try {
                    this.f138262h = cursor.getString(i3);
                } catch (Throwable th8) {
                    w.a("MicroMsg.SDK.BaseAppBrandBackgroundFetchData", th8, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (D == hashCode) {
                try {
                    this.f138264j = cursor.getString(i3);
                } catch (Throwable th9) {
                    w.a("MicroMsg.SDK.BaseAppBrandBackgroundFetchData", th9, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (E == hashCode) {
                try {
                    this.f138266l = cursor.getInt(i3);
                } catch (Throwable th10) {
                    w.a("MicroMsg.SDK.BaseAppBrandBackgroundFetchData", th10, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (F == hashCode) {
                try {
                    this.f138268n = cursor.getString(i3);
                } catch (Throwable th11) {
                    w.a("MicroMsg.SDK.BaseAppBrandBackgroundFetchData", th11, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (G == hashCode) {
                this.f145157a = cursor.getLong(i3);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        e();
        ContentValues contentValues = new ContentValues();
        if (this.f138257c) {
            contentValues.put("username", this.f138256b);
        }
        if (this.f138259e) {
            contentValues.put("fetchType", Integer.valueOf(this.f138258d));
        }
        if (this.f138261g) {
            contentValues.put("updateTime", Long.valueOf(this.f138260f));
        }
        if (this.f138263i) {
            contentValues.put("path", this.f138262h);
        }
        if (this.f138265k) {
            contentValues.put("query", this.f138264j);
        }
        if (this.f138267m) {
            contentValues.put("scene", Integer.valueOf(this.f138266l));
        }
        if (this.f138269o) {
            contentValues.put("data", this.f138268n);
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
