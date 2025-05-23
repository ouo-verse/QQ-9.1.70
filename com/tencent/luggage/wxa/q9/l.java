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
public abstract class l extends com.tencent.luggage.wxa.xn.a {
    public static final int A0;
    public static final int B0;
    public static final int C0;
    public static final int D0;
    public static final int E0;
    public static final int F0;
    public static final int G0;
    public static final int H0;
    public static final int I0;
    public static final int J0;
    public static final int K0;
    public static final int L0;
    public static final int M0;
    public static final int N0;
    public static final int O0;
    public static final a.C6921a P0;
    public static final com.tencent.luggage.wxa.zn.c Q0;
    public static final com.tencent.luggage.wxa.ao.b T;
    public static final com.tencent.luggage.wxa.ao.a U;
    public static final com.tencent.luggage.wxa.ao.a V;
    public static final com.tencent.luggage.wxa.ao.a W;
    public static final com.tencent.luggage.wxa.ao.a X;
    public static final com.tencent.luggage.wxa.ao.a Y;
    public static final com.tencent.luggage.wxa.ao.a Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138437a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138438b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138439c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138440d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138441e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138442f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138443g0;

    /* renamed from: h0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138444h0;

    /* renamed from: i0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138445i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138446j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138447k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138448l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138449m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138450n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138451o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138452p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.ao.a f138453q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final String[] f138454r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final int f138455s0;

    /* renamed from: t0, reason: collision with root package name */
    public static final int f138456t0;

    /* renamed from: u0, reason: collision with root package name */
    public static final int f138457u0;

    /* renamed from: v0, reason: collision with root package name */
    public static final int f138458v0;

    /* renamed from: w0, reason: collision with root package name */
    public static final int f138459w0;

    /* renamed from: x0, reason: collision with root package name */
    public static final int f138460x0;

    /* renamed from: y0, reason: collision with root package name */
    public static final int f138461y0;

    /* renamed from: z0, reason: collision with root package name */
    public static final int f138462z0;
    public String B;
    public String D;
    public String F;
    public String H;
    public String J;
    public String L;
    public long N;
    public String P;
    public String R;

    /* renamed from: b, reason: collision with root package name */
    public int f138463b;

    /* renamed from: d, reason: collision with root package name */
    public String f138465d;

    /* renamed from: f, reason: collision with root package name */
    public String f138467f;

    /* renamed from: h, reason: collision with root package name */
    public String f138469h;

    /* renamed from: j, reason: collision with root package name */
    public String f138471j;

    /* renamed from: l, reason: collision with root package name */
    public String f138473l;

    /* renamed from: n, reason: collision with root package name */
    public String f138475n;

    /* renamed from: p, reason: collision with root package name */
    public String f138477p;

    /* renamed from: r, reason: collision with root package name */
    public String f138479r;

    /* renamed from: t, reason: collision with root package name */
    public String f138481t;

    /* renamed from: v, reason: collision with root package name */
    public int f138483v;

    /* renamed from: x, reason: collision with root package name */
    public String f138485x;

    /* renamed from: z, reason: collision with root package name */
    public String f138487z;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138464c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138466e = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138468g = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f138470i = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f138472k = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f138474m = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f138476o = true;

    /* renamed from: q, reason: collision with root package name */
    public boolean f138478q = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f138480s = true;

    /* renamed from: u, reason: collision with root package name */
    public boolean f138482u = true;

    /* renamed from: w, reason: collision with root package name */
    public boolean f138484w = true;

    /* renamed from: y, reason: collision with root package name */
    public boolean f138486y = true;
    public boolean A = true;
    public boolean C = true;
    public boolean E = true;
    public boolean G = true;
    public boolean I = true;
    public boolean K = true;
    public boolean M = true;
    public boolean O = true;
    public boolean Q = true;
    public boolean S = true;

    static {
        com.tencent.luggage.wxa.ao.b bVar = new com.tencent.luggage.wxa.ao.b("WxaAttributesTable");
        T = bVar;
        U = new com.tencent.luggage.wxa.ao.a("rowid", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        V = new com.tencent.luggage.wxa.ao.a("usernameHash", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        W = new com.tencent.luggage.wxa.ao.a("username", HippyControllerProps.STRING, bVar.a(), "");
        X = new com.tencent.luggage.wxa.ao.a("appId", HippyControllerProps.STRING, bVar.a(), "");
        Y = new com.tencent.luggage.wxa.ao.a("nickname", HippyControllerProps.STRING, bVar.a(), "");
        Z = new com.tencent.luggage.wxa.ao.a("shortNickname", HippyControllerProps.STRING, bVar.a(), "");
        f138437a0 = new com.tencent.luggage.wxa.ao.a("brandIconURL", HippyControllerProps.STRING, bVar.a(), "");
        f138438b0 = new com.tencent.luggage.wxa.ao.a("roundedSquareIconURL", HippyControllerProps.STRING, bVar.a(), "");
        f138439c0 = new com.tencent.luggage.wxa.ao.a("bigHeadURL", HippyControllerProps.STRING, bVar.a(), "");
        f138440d0 = new com.tencent.luggage.wxa.ao.a("smallHeadURL", HippyControllerProps.STRING, bVar.a(), "");
        f138441e0 = new com.tencent.luggage.wxa.ao.a("signature", HippyControllerProps.STRING, bVar.a(), "");
        f138442f0 = new com.tencent.luggage.wxa.ao.a("appOpt", PoiListCacheRecord.WEIGHT_TYPE, bVar.a(), "");
        f138443g0 = new com.tencent.luggage.wxa.ao.a("registerSource", HippyControllerProps.STRING, bVar.a(), "");
        f138444h0 = new com.tencent.luggage.wxa.ao.a("appInfo", HippyControllerProps.STRING, bVar.a(), "");
        f138445i0 = new com.tencent.luggage.wxa.ao.a("versionInfo", HippyControllerProps.STRING, bVar.a(), "");
        f138446j0 = new com.tencent.luggage.wxa.ao.a("passThroughInfo", HippyControllerProps.STRING, bVar.a(), "");
        f138447k0 = new com.tencent.luggage.wxa.ao.a("stablePassThroughInfo", HippyControllerProps.STRING, bVar.a(), "");
        f138448l0 = new com.tencent.luggage.wxa.ao.a("bindWxaInfo", HippyControllerProps.STRING, bVar.a(), "");
        f138449m0 = new com.tencent.luggage.wxa.ao.a("dynamicInfo", HippyControllerProps.STRING, bVar.a(), "");
        f138450n0 = new com.tencent.luggage.wxa.ao.a("reserved", HippyControllerProps.STRING, bVar.a(), "");
        f138451o0 = new com.tencent.luggage.wxa.ao.a("syncTimeSecond", PoiListCacheRecord.TIMESTAMP_TYPE, bVar.a(), "");
        f138452p0 = new com.tencent.luggage.wxa.ao.a("syncVersion", HippyControllerProps.STRING, bVar.a(), "");
        f138453q0 = new com.tencent.luggage.wxa.ao.a("bizMenu", HippyControllerProps.STRING, bVar.a(), "");
        f138454r0 = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)"};
        f138455s0 = 1007641348;
        f138456t0 = -265713450;
        f138457u0 = 93028124;
        f138458v0 = 70690926;
        f138459w0 = -738700022;
        f138460x0 = -571464529;
        f138461y0 = -1153507156;
        f138462z0 = -1301829041;
        A0 = 1551813736;
        B0 = 1073584312;
        C0 = -1411089198;
        D0 = -485573474;
        E0 = -794273169;
        F0 = 688769446;
        G0 = -1954138046;
        H0 = 566372231;
        I0 = 1199995761;
        J0 = -258997875;
        K0 = -350385368;
        L0 = -1164564836;
        M0 = -1289976387;
        N0 = -97827566;
        O0 = 108705909;
        P0 = a(l.class);
        Q0 = new com.tencent.luggage.wxa.zn.c();
    }

    public static a.C6921a a(Class cls) {
        a.C6921a c6921a = new a.C6921a();
        c6921a.f145158a = new Field[22];
        c6921a.f145160c = new String[23];
        StringBuilder sb5 = new StringBuilder();
        c6921a.f145160c[0] = "usernameHash";
        c6921a.f145161d.put("usernameHash", "INTEGER PRIMARY KEY ");
        sb5.append(" usernameHash INTEGER PRIMARY KEY ");
        sb5.append(", ");
        c6921a.f145159b = "usernameHash";
        c6921a.f145160c[1] = "username";
        c6921a.f145161d.put("username", "TEXT");
        sb5.append(" username TEXT");
        sb5.append(", ");
        c6921a.f145160c[2] = "appId";
        c6921a.f145161d.put("appId", "TEXT");
        sb5.append(" appId TEXT");
        sb5.append(", ");
        c6921a.f145160c[3] = "nickname";
        c6921a.f145161d.put("nickname", "TEXT");
        sb5.append(" nickname TEXT");
        sb5.append(", ");
        c6921a.f145160c[4] = "shortNickname";
        c6921a.f145161d.put("shortNickname", "TEXT");
        sb5.append(" shortNickname TEXT");
        sb5.append(", ");
        c6921a.f145160c[5] = "brandIconURL";
        c6921a.f145161d.put("brandIconURL", "TEXT");
        sb5.append(" brandIconURL TEXT");
        sb5.append(", ");
        c6921a.f145160c[6] = "roundedSquareIconURL";
        c6921a.f145161d.put("roundedSquareIconURL", "TEXT");
        sb5.append(" roundedSquareIconURL TEXT");
        sb5.append(", ");
        c6921a.f145160c[7] = "bigHeadURL";
        c6921a.f145161d.put("bigHeadURL", "TEXT");
        sb5.append(" bigHeadURL TEXT");
        sb5.append(", ");
        c6921a.f145160c[8] = "smallHeadURL";
        c6921a.f145161d.put("smallHeadURL", "TEXT");
        sb5.append(" smallHeadURL TEXT");
        sb5.append(", ");
        c6921a.f145160c[9] = "signature";
        c6921a.f145161d.put("signature", "TEXT");
        sb5.append(" signature TEXT");
        sb5.append(", ");
        c6921a.f145160c[10] = "appOpt";
        c6921a.f145161d.put("appOpt", "INTEGER default '0' ");
        sb5.append(" appOpt INTEGER default '0' ");
        sb5.append(", ");
        c6921a.f145160c[11] = "registerSource";
        c6921a.f145161d.put("registerSource", "TEXT");
        sb5.append(" registerSource TEXT");
        sb5.append(", ");
        c6921a.f145160c[12] = "appInfo";
        c6921a.f145161d.put("appInfo", "TEXT");
        sb5.append(" appInfo TEXT");
        sb5.append(", ");
        c6921a.f145160c[13] = "versionInfo";
        c6921a.f145161d.put("versionInfo", "TEXT");
        sb5.append(" versionInfo TEXT");
        sb5.append(", ");
        c6921a.f145160c[14] = "passThroughInfo";
        c6921a.f145161d.put("passThroughInfo", "TEXT");
        sb5.append(" passThroughInfo TEXT");
        sb5.append(", ");
        c6921a.f145160c[15] = "stablePassThroughInfo";
        c6921a.f145161d.put("stablePassThroughInfo", "TEXT");
        sb5.append(" stablePassThroughInfo TEXT");
        sb5.append(", ");
        c6921a.f145160c[16] = "bindWxaInfo";
        c6921a.f145161d.put("bindWxaInfo", "TEXT");
        sb5.append(" bindWxaInfo TEXT");
        sb5.append(", ");
        c6921a.f145160c[17] = "dynamicInfo";
        c6921a.f145161d.put("dynamicInfo", "TEXT");
        sb5.append(" dynamicInfo TEXT");
        sb5.append(", ");
        c6921a.f145160c[18] = "reserved";
        c6921a.f145161d.put("reserved", "TEXT");
        sb5.append(" reserved TEXT");
        sb5.append(", ");
        c6921a.f145160c[19] = "syncTimeSecond";
        c6921a.f145161d.put("syncTimeSecond", "LONG default '0' ");
        sb5.append(" syncTimeSecond LONG default '0' ");
        sb5.append(", ");
        c6921a.f145160c[20] = "syncVersion";
        c6921a.f145161d.put("syncVersion", "TEXT");
        sb5.append(" syncVersion TEXT");
        sb5.append(", ");
        c6921a.f145160c[21] = "bizMenu";
        c6921a.f145161d.put("bizMenu", "TEXT");
        sb5.append(" bizMenu TEXT");
        c6921a.f145160c[22] = "rowid";
        c6921a.f145162e = sb5.toString();
        if (c6921a.f145159b == null) {
            c6921a.f145159b = "rowid";
        }
        return c6921a;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public com.tencent.luggage.wxa.zn.c c() {
        return Q0;
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public Object d() {
        return Integer.valueOf(this.f138463b);
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
            if (f138455s0 == hashCode) {
                try {
                    this.f138463b = cursor.getInt(i3);
                    this.f138464c = true;
                } catch (Throwable th5) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th5, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138456t0 == hashCode) {
                try {
                    this.f138465d = cursor.getString(i3);
                } catch (Throwable th6) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th6, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138457u0 == hashCode) {
                try {
                    this.f138467f = cursor.getString(i3);
                } catch (Throwable th7) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th7, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138458v0 == hashCode) {
                try {
                    this.f138469h = cursor.getString(i3);
                } catch (Throwable th8) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th8, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138459w0 == hashCode) {
                try {
                    this.f138471j = cursor.getString(i3);
                } catch (Throwable th9) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th9, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138460x0 == hashCode) {
                try {
                    this.f138473l = cursor.getString(i3);
                } catch (Throwable th10) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th10, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138461y0 == hashCode) {
                try {
                    this.f138475n = cursor.getString(i3);
                } catch (Throwable th11) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th11, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (f138462z0 == hashCode) {
                try {
                    this.f138477p = cursor.getString(i3);
                } catch (Throwable th12) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th12, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (A0 == hashCode) {
                try {
                    this.f138479r = cursor.getString(i3);
                } catch (Throwable th13) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th13, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (B0 == hashCode) {
                try {
                    this.f138481t = cursor.getString(i3);
                } catch (Throwable th14) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th14, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (C0 == hashCode) {
                try {
                    this.f138483v = cursor.getInt(i3);
                } catch (Throwable th15) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th15, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (D0 == hashCode) {
                try {
                    this.f138485x = cursor.getString(i3);
                } catch (Throwable th16) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th16, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (E0 == hashCode) {
                try {
                    this.f138487z = cursor.getString(i3);
                } catch (Throwable th17) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th17, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (F0 == hashCode) {
                try {
                    this.B = cursor.getString(i3);
                } catch (Throwable th18) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th18, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (G0 == hashCode) {
                try {
                    this.D = cursor.getString(i3);
                } catch (Throwable th19) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th19, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (H0 == hashCode) {
                try {
                    this.F = cursor.getString(i3);
                } catch (Throwable th20) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th20, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (I0 == hashCode) {
                try {
                    this.H = cursor.getString(i3);
                } catch (Throwable th21) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th21, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (J0 == hashCode) {
                try {
                    this.J = cursor.getString(i3);
                } catch (Throwable th22) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th22, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (K0 == hashCode) {
                try {
                    this.L = cursor.getString(i3);
                } catch (Throwable th23) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th23, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (L0 == hashCode) {
                try {
                    this.N = cursor.getLong(i3);
                } catch (Throwable th24) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th24, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (M0 == hashCode) {
                try {
                    this.P = cursor.getString(i3);
                } catch (Throwable th25) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th25, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (N0 == hashCode) {
                try {
                    this.R = cursor.getString(i3);
                } catch (Throwable th26) {
                    w.a("MicroMsg.SDK.BaseWxaAttributesTable", th26, "convertFrom %s", columnNames[i3]);
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.b("db data is not match", false);
                    }
                }
            } else if (O0 == hashCode) {
                this.f145157a = cursor.getLong(i3);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        e();
        ContentValues contentValues = new ContentValues();
        if (this.f138464c) {
            contentValues.put("usernameHash", Integer.valueOf(this.f138463b));
        }
        if (this.f138466e) {
            contentValues.put("username", this.f138465d);
        }
        if (this.f138468g) {
            contentValues.put("appId", this.f138467f);
        }
        if (this.f138470i) {
            contentValues.put("nickname", this.f138469h);
        }
        if (this.f138472k) {
            contentValues.put("shortNickname", this.f138471j);
        }
        if (this.f138474m) {
            contentValues.put("brandIconURL", this.f138473l);
        }
        if (this.f138476o) {
            contentValues.put("roundedSquareIconURL", this.f138475n);
        }
        if (this.f138478q) {
            contentValues.put("bigHeadURL", this.f138477p);
        }
        if (this.f138480s) {
            contentValues.put("smallHeadURL", this.f138479r);
        }
        if (this.f138482u) {
            contentValues.put("signature", this.f138481t);
        }
        if (this.f138484w) {
            contentValues.put("appOpt", Integer.valueOf(this.f138483v));
        }
        if (this.f138486y) {
            contentValues.put("registerSource", this.f138485x);
        }
        if (this.A) {
            contentValues.put("appInfo", this.f138487z);
        }
        if (this.C) {
            contentValues.put("versionInfo", this.B);
        }
        if (this.E) {
            contentValues.put("passThroughInfo", this.D);
        }
        if (this.G) {
            contentValues.put("stablePassThroughInfo", this.F);
        }
        if (this.I) {
            contentValues.put("bindWxaInfo", this.H);
        }
        if (this.K) {
            contentValues.put("dynamicInfo", this.J);
        }
        if (this.M) {
            contentValues.put("reserved", this.L);
        }
        if (this.O) {
            contentValues.put("syncTimeSecond", Long.valueOf(this.N));
        }
        if (this.Q) {
            contentValues.put("syncVersion", this.P);
        }
        if (this.S) {
            contentValues.put("bizMenu", this.R);
        }
        long j3 = this.f145157a;
        if (j3 > 0) {
            contentValues.put("rowid", Long.valueOf(j3));
        }
        return contentValues;
    }
}
