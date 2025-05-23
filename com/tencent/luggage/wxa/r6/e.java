package com.tencent.luggage.wxa.r6;

import com.tencent.luggage.wxa.i3.s;
import com.tencent.luggage.wxa.ii.t;
import com.tencent.luggage.wxa.j4.l;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.r6.a {

    /* renamed from: y */
    public static final a f139295y = new a(null);

    /* renamed from: b */
    public String f139296b;

    /* renamed from: c */
    public String f139297c;

    /* renamed from: d */
    public int f139298d;

    /* renamed from: e */
    public int f139299e;

    /* renamed from: f */
    public int f139300f;

    /* renamed from: g */
    public long f139301g;

    /* renamed from: h */
    public int f139302h;

    /* renamed from: i */
    public long f139303i;

    /* renamed from: j */
    public long f139304j;

    /* renamed from: k */
    public String f139305k;

    /* renamed from: l */
    public int f139306l;

    /* renamed from: m */
    public String f139307m;

    /* renamed from: n */
    public int f139308n;

    /* renamed from: o */
    public String f139309o;

    /* renamed from: p */
    public int f139310p;

    /* renamed from: q */
    public String f139311q;

    /* renamed from: r */
    public String f139312r;

    /* renamed from: s */
    public String f139313s;

    /* renamed from: t */
    public int f139314t;

    /* renamed from: u */
    public int f139315u;

    /* renamed from: v */
    public int f139316v;

    /* renamed from: w */
    public String f139317w;

    /* renamed from: x */
    public String f139318x;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r6.e$a$a */
        /* loaded from: classes8.dex */
        public static final class RunnableC6679a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.tencent.luggage.wxa.dk.b f139319a;

            /* renamed from: b */
            public final /* synthetic */ com.tencent.luggage.wxa.c5.e f139320b;

            /* renamed from: c */
            public final /* synthetic */ boolean f139321c;

            public RunnableC6679a(com.tencent.luggage.wxa.dk.b bVar, com.tencent.luggage.wxa.c5.e eVar, boolean z16) {
                this.f139319a = bVar;
                this.f139320b = eVar;
                this.f139321c = z16;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                com.tencent.luggage.wxa.dk.b bVar = this.f139319a;
                if (t.a().a(this.f139320b.getAppId()) != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f124310h = z16;
                String appId = this.f139320b.getAppId();
                int C1 = this.f139320b.C1();
                com.tencent.luggage.wxa.dk.b bVar2 = this.f139319a;
                int i3 = bVar2.f124305c;
                int i16 = bVar2.f124306d;
                int i17 = bVar2.f124307e;
                String a16 = com.tencent.luggage.wxa.bk.k.a(null, 1, null);
                String username = this.f139320b.S().G;
                String wxaLaunchInstanceId = this.f139320b.S().k();
                String j3 = this.f139320b.S().j();
                int i18 = !this.f139321c ? 1 : 0;
                long c16 = w0.c();
                long c17 = w0.c();
                String O = this.f139320b.O();
                boolean z17 = this.f139319a.f124310h;
                Intrinsics.checkNotNullExpressionValue(wxaLaunchInstanceId, "wxaLaunchInstanceId");
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                Intrinsics.checkNotNullExpressionValue(username, "username");
                e eVar = new e(wxaLaunchInstanceId, appId, C1, i3, i16, 0L, i17, c16, c17, a16, i18, username, 0, null, 0, O, null, null, z17 ? 1 : 0, 0, 0, null, j3, 3895328, null);
                com.tencent.luggage.wxa.li.b bVar3 = this.f139320b.S().J0;
                if (bVar3 != null) {
                    eVar.b(bVar3.f133421b);
                    eVar.c(bVar3.f133420a);
                }
                eVar.c();
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String a(a aVar, com.tencent.luggage.wxa.ki.a aVar2, com.tencent.luggage.wxa.z4.k kVar, String str, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            return aVar.a(aVar2, kVar, str);
        }

        public final String a(com.tencent.luggage.wxa.ki.a parcel, com.tencent.luggage.wxa.z4.k strategy, String str) {
            String e16;
            e eVar;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            String appId = parcel.f132018b;
            int i3 = parcel.f132022d;
            com.tencent.luggage.wxa.bk.e eVar2 = parcel.f132032i;
            com.tencent.luggage.wxa.z4.k kVar = com.tencent.luggage.wxa.z4.k.CREATE_NEW;
            int i16 = kVar == strategy ? 1 : 0;
            if (!(str == null || str.length() == 0) && com.tencent.luggage.wxa.z4.k.RESUME_EXISTED == strategy) {
                e16 = str;
            } else if (kVar == strategy) {
                e16 = s.f129353b.a(parcel);
            } else {
                com.tencent.luggage.wxa.er.a.b(z.m());
                e16 = com.tencent.luggage.wxa.l3.h.f132999i.a().e(appId, i3);
                Intrinsics.checkNotNull(e16);
            }
            String d16 = parcel.d();
            if (d16 == null || d16.length() == 0) {
                l lVar = l.b.f130852a;
                if (lVar == null) {
                    lVar = l.f130851b;
                }
                parcel.c(lVar.a(parcel));
            }
            int i17 = eVar2 != null ? eVar2.f122984c : 1000;
            long c16 = w0.c();
            long c17 = w0.c();
            String a16 = com.tencent.luggage.wxa.bk.k.a(null, 1, null);
            String str2 = parcel.f132026f;
            String d17 = parcel.d();
            if (d17 == null) {
                d17 = "";
            }
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            e eVar3 = new e(e16, appId, 0, 0, 0, 0L, i17, c16, c17, a16, i16, "", 0, null, 0, str2, null, null, 0, 0, 0, null, d17, 4157500, null);
            com.tencent.luggage.wxa.li.b bVar = parcel.V;
            if (bVar != null) {
                eVar = eVar3;
                eVar.b(bVar.f133421b);
                eVar.c(bVar.f133420a);
            } else {
                eVar = eVar3;
            }
            eVar.c();
            return e16;
        }

        public final void a(com.tencent.luggage.wxa.c5.e runtime, boolean z16) {
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            String appId = runtime.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "runtime.appId");
            com.tencent.luggage.wxa.dk.b a16 = b.a(appId);
            if (a16 == null) {
                return;
            }
            com.tencent.luggage.wxa.zp.h.f146825d.d(new RunnableC6679a(a16, runtime, z16));
        }
    }

    public /* synthetic */ e(String str, String str2, int i3, int i16, int i17, long j3, int i18, long j16, long j17, String str3, int i19, String str4, int i26, String str5, int i27, String str6, String str7, String str8, int i28, int i29, int i36, String str9, String str10, int i37, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i37 & 4) != 0 ? 0 : i3, (i37 & 8) != 0 ? 0 : i16, (i37 & 16) != 0 ? 0 : i17, (i37 & 32) != 0 ? 0L : j3, (i37 & 64) != 0 ? 1000 : i18, j16, j17, str3, i19, str4, (i37 & 4096) != 0 ? 0 : i26, (i37 & 8192) != 0 ? "" : str5, (i37 & 16384) != 0 ? 0 : i27, (32768 & i37) != 0 ? "" : str6, (65536 & i37) != 0 ? "" : str7, (131072 & i37) != 0 ? "" : str8, (262144 & i37) != 0 ? 1 : i28, (524288 & i37) != 0 ? 0 : i29, (1048576 & i37) != 0 ? 0 : i36, (2097152 & i37) != 0 ? "" : str9, (i37 & 4194304) != 0 ? "" : str10);
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 16367;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public boolean b() {
        return true;
    }

    public final void c(String str) {
        this.f139312r = str;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        String join = StringUtils.join(new Object[]{this.f139296b, this.f139297c, Integer.valueOf(this.f139298d), Integer.valueOf(this.f139299e), Integer.valueOf(this.f139300f), Long.valueOf(this.f139301g), Integer.valueOf(this.f139302h), Long.valueOf(this.f139303i), Long.valueOf(this.f139304j), this.f139305k, Integer.valueOf(this.f139306l), this.f139307m, Integer.valueOf(this.f139308n), this.f139309o, Integer.valueOf(this.f139310p), this.f139311q, this.f139312r, this.f139313s, Integer.valueOf(this.f139314t), Integer.valueOf(this.f139315u), Integer.valueOf(this.f139316v), this.f139317w, this.f139318x}, ",");
        Intrinsics.checkNotNullExpressionValue(join, "join(arrayOf(\n          \u2026sessionId\n        ), \",\")");
        return join;
    }

    public e(String InstanceId, String AppId, int i3, int i16, int i17, long j3, int i18, long j16, long j17, String networkType, int i19, String UserName, int i26, String str, int i27, String str2, String str3, String str4, int i28, int i29, int i36, String str5, String str6) {
        Intrinsics.checkNotNullParameter(InstanceId, "InstanceId");
        Intrinsics.checkNotNullParameter(AppId, "AppId");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(UserName, "UserName");
        this.f139296b = InstanceId;
        this.f139297c = AppId;
        this.f139298d = i3;
        this.f139299e = i16;
        this.f139300f = i17;
        this.f139301g = j3;
        this.f139302h = i18;
        this.f139303i = j16;
        this.f139304j = j17;
        this.f139305k = networkType;
        this.f139306l = i19;
        this.f139307m = UserName;
        this.f139308n = i26;
        this.f139309o = str;
        this.f139310p = i27;
        this.f139311q = str2;
        this.f139312r = str3;
        this.f139313s = str4;
        this.f139314t = i28;
        this.f139315u = i29;
        this.f139316v = i36;
        this.f139317w = str5;
        this.f139318x = str6;
    }

    public static final void a(com.tencent.luggage.wxa.c5.e eVar, boolean z16) {
        f139295y.a(eVar, z16);
    }

    public final void b(String str) {
        this.f139313s = str;
    }
}
