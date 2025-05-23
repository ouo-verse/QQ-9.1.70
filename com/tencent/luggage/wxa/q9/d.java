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
public abstract class d extends com.tencent.luggage.wxa.xn.a {
    public static final com.tencent.luggage.wxa.ao.a A;
    public static final com.tencent.luggage.wxa.ao.a B;
    public static final com.tencent.luggage.wxa.ao.a C;
    public static final com.tencent.luggage.wxa.ao.a D;
    public static final com.tencent.luggage.wxa.ao.a E;
    public static final com.tencent.luggage.wxa.ao.a F;
    public static final com.tencent.luggage.wxa.ao.a G;
    public static final com.tencent.luggage.wxa.ao.a H;
    public static final com.tencent.luggage.wxa.ao.a I;
    public static final com.tencent.luggage.wxa.ao.a J;
    public static final String[] K;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int O;
    public static final int P;
    public static final int Q;
    public static final int R;
    public static final int S;
    public static final int T;
    public static final int U;
    public static final int V;
    public static final int W;
    public static final a.C6921a X;
    public static final com.tencent.luggage.wxa.zn.c Y;

    /* renamed from: x, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.b f138302x;

    /* renamed from: y, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138303y;

    /* renamed from: z, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138304z;

    /* renamed from: b, reason: collision with root package name */
    public String f138305b;

    /* renamed from: d, reason: collision with root package name */
    public int f138307d;

    /* renamed from: f, reason: collision with root package name */
    public String f138309f;

    /* renamed from: h, reason: collision with root package name */
    public String f138311h;

    /* renamed from: j, reason: collision with root package name */
    public long f138313j;

    /* renamed from: l, reason: collision with root package name */
    public String f138315l;

    /* renamed from: n, reason: collision with root package name */
    public long f138317n;

    /* renamed from: p, reason: collision with root package name */
    public int f138319p;

    /* renamed from: r, reason: collision with root package name */
    public String f138321r;

    /* renamed from: t, reason: collision with root package name */
    public long f138323t;

    /* renamed from: v, reason: collision with root package name */
    public long f138325v;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138306c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138308e = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138310g = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f138312i = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f138314k = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f138316m = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f138318o = true;

    /* renamed from: q, reason: collision with root package name */
    public boolean f138320q = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f138322s = true;

    /* renamed from: u, reason: collision with root package name */
    public boolean f138324u = true;

    /* renamed from: w, reason: collision with root package name */
    public boolean f138326w = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("AppBrandWxaPkgManifestRecord");
        f138302x = bVar;
        f138303y = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138304z = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        A = new com.tencent.luggage.wxa.ao.a("version", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        B = new com.tencent.luggage.wxa.ao.a("versionMd5", HippyControllerProps.STRING, bVar.a(), "");
        C = new com.tencent.luggage.wxa.ao.a("NewMd5", HippyControllerProps.STRING, bVar.a(), "");
        D = new com.tencent.luggage.wxa.ao.a("checksum", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        E = new com.tencent.luggage.wxa.ao.a("pkgPath", HippyControllerProps.STRING, bVar.a(), "");
        F = new com.tencent.luggage.wxa.ao.a(WadlProxyConsts.CREATE_TIME, PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        G = new com.tencent.luggage.wxa.ao.a("debugType", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        H = new com.tencent.luggage.wxa.ao.a("downloadURL", HippyControllerProps.STRING, bVar.a(), "");
        I = new com.tencent.luggage.wxa.ao.a("startTime", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        J = new com.tencent.luggage.wxa.ao.a("endTime", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        K = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)"};
        L = 93028124;
        M = 351608024;
        N = -670514810;
        O = -1964995618;
        P = 1536908355;
        Q = -517880815;
        R = 1369213417;
        S = -198232019;
        T = -1211149369;
        U = -2129294769;
        V = -1607243192;
        W = 108705909;
        X = a(d.class);
        Y = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[11];
        c6921a.f145160c = new String[12];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "appId";
        c6921a.f145161d.put("appId", "TEXT");
        sb5.append(" appId TEXT");
        sb5.append(", ");
        c6921a.f145160c[1] = "version";
        c6921a.f145161d.put("version", "INTEGER");
        sb5.append(" version INTEGER");
        sb5.append(", ");
        c6921a.f145160c[2] = "versionMd5";
        c6921a.f145161d.put("versionMd5", "TEXT");
        sb5.append(" versionMd5 TEXT");
        sb5.append(", ");
        c6921a.f145160c[3] = "NewMd5";
        c6921a.f145161d.put("NewMd5", "TEXT");
        sb5.append(" NewMd5 TEXT");
        sb5.append(", ");
        c6921a.f145160c[4] = "checksum";
        c6921a.f145161d.put("checksum", "LONG");
        sb5.append(" checksum LONG");
        sb5.append(", ");
        c6921a.f145160c[5] = "pkgPath";
        c6921a.f145161d.put("pkgPath", "TEXT");
        sb5.append(" pkgPath TEXT");
        sb5.append(", ");
        c6921a.f145160c[6] = WadlProxyConsts.CREATE_TIME;
        c6921a.f145161d.put(WadlProxyConsts.CREATE_TIME, "LONG");
        sb5.append(" createTime LONG");
        sb5.append(", ");
        c6921a.f145160c[7] = "debugType";
        c6921a.f145161d.put("debugType", "INTEGER default '0' ");
        sb5.append(" debugType INTEGER default '0' ");
        sb5.append(", ");
        c6921a.f145160c[8] = "downloadURL";
        c6921a.f145161d.put("downloadURL", "TEXT");
        sb5.append(" downloadURL TEXT");
        sb5.append(", ");
        c6921a.f145160c[9] = "startTime";
        c6921a.f145161d.put("startTime", "LONG");
        sb5.append(" startTime LONG");
        sb5.append(", ");
        c6921a.f145160c[10] = "endTime";
        c6921a.f145161d.put("endTime", "LONG");
        sb5.append(" endTime LONG");
        c6921a.f145160c[11] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return Y;
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
            if (L == hashCode) {
                try {
                    this.f138305b = cursor.getString(i3);
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (M == hashCode) {
                try {
                    this.f138307d = cursor.getInt(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (N == hashCode) {
                try {
                    this.f138309f = cursor.getString(i3);
                } catch (Throwable th7) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th7, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (O == hashCode) {
                try {
                    this.f138311h = cursor.getString(i3);
                } catch (Throwable th8) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th8, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (P == hashCode) {
                try {
                    this.f138313j = cursor.getLong(i3);
                } catch (Throwable th9) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th9, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (Q == hashCode) {
                try {
                    this.f138315l = cursor.getString(i3);
                } catch (Throwable th10) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th10, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (R == hashCode) {
                try {
                    this.f138317n = cursor.getLong(i3);
                } catch (Throwable th11) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th11, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (S == hashCode) {
                try {
                    this.f138319p = cursor.getInt(i3);
                } catch (Throwable th12) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th12, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (T == hashCode) {
                try {
                    this.f138321r = cursor.getString(i3);
                } catch (Throwable th13) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th13, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (U == hashCode) {
                try {
                    this.f138323t = cursor.getLong(i3);
                } catch (Throwable th14) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th14, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (V == hashCode) {
                try {
                    this.f138325v = cursor.getLong(i3);
                } catch (Throwable th15) {
                    w.a("MicroMsg.SDK.BaseAppBrandWxaPkgManifestRecord", th15, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (W == hashCode) {
                this.f145157a = cursor.getLong(i3);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        e();
        ContentValues contentValues = new ContentValues();
        if (this.f138306c) {
            contentValues.put("appId", this.f138305b);
        }
        if (this.f138308e) {
            contentValues.put("version", Integer.valueOf(this.f138307d));
        }
        if (this.f138310g) {
            contentValues.put("versionMd5", this.f138309f);
        }
        if (this.f138312i) {
            contentValues.put("NewMd5", this.f138311h);
        }
        if (this.f138314k) {
            contentValues.put("checksum", Long.valueOf(this.f138313j));
        }
        if (this.f138316m) {
            contentValues.put("pkgPath", this.f138315l);
        }
        if (this.f138318o) {
            contentValues.put(WadlProxyConsts.CREATE_TIME, Long.valueOf(this.f138317n));
        }
        if (this.f138320q) {
            contentValues.put("debugType", Integer.valueOf(this.f138319p));
        }
        if (this.f138322s) {
            contentValues.put("downloadURL", this.f138321r);
        }
        if (this.f138324u) {
            contentValues.put("startTime", Long.valueOf(this.f138323t));
        }
        if (this.f138326w) {
            contentValues.put("endTime", Long.valueOf(this.f138325v));
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
