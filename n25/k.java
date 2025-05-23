package n25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends c45.j {
    public i C;
    public int D;
    public int E;
    public String F;
    public String G;
    public String H;
    public String I;
    public int J;
    public int K;
    public String L;
    public String M;
    public String N;
    public String P;
    public String Q;
    public String R;

    /* renamed from: d, reason: collision with root package name */
    public String f418086d;

    /* renamed from: e, reason: collision with root package name */
    public String f418087e;

    /* renamed from: f, reason: collision with root package name */
    public int f418088f;

    /* renamed from: h, reason: collision with root package name */
    public String f418089h;

    /* renamed from: i, reason: collision with root package name */
    public String f418090i;

    /* renamed from: m, reason: collision with root package name */
    public int f418091m;

    public k() {
        this((String) null, (String) null, 0, (String) null, (String) null, 0, (i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k((String) null, (String) null, 0, (String) null, (String) null, 0, (i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418086d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418087e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418088f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418089h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418090i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418091m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StGPSV2");
                this.C = (i) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.D = ((Integer) obj).intValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.E = ((Integer) obj).intValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.F = (String) obj;
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.G = (String) obj;
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.H = (String) obj;
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.I = (String) obj;
                return;
            case 14:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.J = ((Integer) obj).intValue();
                return;
            case 15:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.K = ((Integer) obj).intValue();
                return;
            case 16:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.L = (String) obj;
                return;
            case 17:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.M = (String) obj;
                return;
            case 18:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.N = (String) obj;
                return;
            case 19:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.P = (String) obj;
                return;
            case 20:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.Q = (String) obj;
                return;
            case 21:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.R = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ k(String str, String str2, int i3, String str3, String str4, int i16, i iVar, int i17, int i18, String str5, String str6, String str7, String str8, int i19, int i26, String str9, String str10, String str11, String str12, String str13, int i27) {
        this((i27 & 1) != 0 ? "" : str, (i27 & 2) != 0 ? "" : str2, (i27 & 4) != 0 ? 0 : i3, (i27 & 8) != 0 ? "" : str3, (i27 & 16) != 0 ? "" : str4, (i27 & 32) != 0 ? 0 : i16, (i27 & 64) != 0 ? null : iVar, (i27 & 128) != 0 ? 0 : i17, (i27 & 256) != 0 ? 0 : i18, (i27 & 512) != 0 ? "" : str5, (i27 & 1024) != 0 ? "" : str6, (i27 & 2048) != 0 ? "" : str7, (i27 & 4096) != 0 ? "" : str8, (i27 & 8192) != 0 ? 0 : i19, (i27 & 16384) != 0 ? 0 : i26, (32768 & i27) != 0 ? "" : str9, (65536 & i27) != 0 ? "" : str10, (131072 & i27) != 0 ? "" : str11, (262144 & i27) != 0 ? "" : str12, (524288 & i27) != 0 ? "" : str13, (i27 & 1048576) != 0 ? "" : null);
    }

    public k(String str, String str2, int i3, String str3, String str4, int i16, i iVar, int i17, int i18, String str5, String str6, String str7, String str8, int i19, int i26, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.f418086d = str;
        this.f418087e = str2;
        this.f418088f = i3;
        this.f418089h = str3;
        this.f418090i = str4;
        this.f418091m = i16;
        this.C = iVar;
        this.D = i17;
        this.E = i18;
        this.F = str5;
        this.G = str6;
        this.H = str7;
        this.I = str8;
        this.J = i19;
        this.K = i26;
        this.L = str9;
        this.M = str10;
        this.N = str11;
        this.P = str12;
        this.Q = str13;
        this.R = str14;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418086d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f418087e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f418088f), new b.e.C0168e(false))), TuplesKt.to(4, new c45.h(4, this.f418089h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f418090i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f418091m), new b.e.C0168e(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new i(0L, 0L, 15)))), TuplesKt.to(8, new c45.h(8, Integer.valueOf(this.D), new b.e.C0168e(false))), TuplesKt.to(9, new c45.h(9, Integer.valueOf(this.E), new b.e.C0168e(false))), TuplesKt.to(10, new c45.h(10, this.F, new b.e.g(false))), TuplesKt.to(11, new c45.h(11, this.G, new b.e.g(false))), TuplesKt.to(12, new c45.h(12, this.H, new b.e.g(false))), TuplesKt.to(13, new c45.h(13, this.I, new b.e.g(false))), TuplesKt.to(14, new c45.h(14, Integer.valueOf(this.J), new b.e.C0168e(false))), TuplesKt.to(15, new c45.h(15, Integer.valueOf(this.K), new b.e.C0168e(false))), TuplesKt.to(16, new c45.h(16, this.L, new b.e.g(false))), TuplesKt.to(17, new c45.h(17, this.M, new b.e.g(false))), TuplesKt.to(18, new c45.h(18, this.N, new b.e.g(false))), TuplesKt.to(19, new c45.h(19, this.P, new b.e.g(false))), TuplesKt.to(20, new c45.h(20, this.Q, new b.e.g(false))), TuplesKt.to(21, new c45.h(21, this.R, new b.e.g(false))));
        return mapOf;
    }
}
