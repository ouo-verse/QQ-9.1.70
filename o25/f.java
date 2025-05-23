package o25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends j {
    public String C;
    public String D;
    public String E;
    public String F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public boolean K;
    public String L;
    public String M;
    public int N;

    /* renamed from: d, reason: collision with root package name */
    public String f421849d;

    /* renamed from: e, reason: collision with root package name */
    public String f421850e;

    /* renamed from: f, reason: collision with root package name */
    public String f421851f;

    /* renamed from: h, reason: collision with root package name */
    public String f421852h;

    /* renamed from: i, reason: collision with root package name */
    public String f421853i;

    /* renamed from: m, reason: collision with root package name */
    public String f421854m;

    public f() {
        this(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new f(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421849d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421850e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421851f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421852h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421853i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421854m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.D = (String) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.E = (String) obj;
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.F = (String) obj;
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.G = ((Boolean) obj).booleanValue();
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.H = ((Boolean) obj).booleanValue();
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.I = ((Integer) obj).intValue();
                return;
            case 14:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.J = ((Integer) obj).intValue();
                return;
            case 15:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.K = ((Boolean) obj).booleanValue();
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
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.N = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z16, boolean z17, int i3, int i16, boolean z18, String str11, String str12, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", "", "", "", "", "", false, false, 0, 0, false, "", "", 0);
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z16, boolean z17, int i3, int i16, boolean z18, String str11, String str12, int i17) {
        this.f421849d = str;
        this.f421850e = str2;
        this.f421851f = str3;
        this.f421852h = str4;
        this.f421853i = str5;
        this.f421854m = str6;
        this.C = str7;
        this.D = str8;
        this.E = str9;
        this.F = str10;
        this.G = z16;
        this.H = z17;
        this.I = i3;
        this.J = i16;
        this.K = z18;
        this.L = str11;
        this.M = str12;
        this.N = i17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421849d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f421850e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f421851f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f421852h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f421853i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f421854m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.e.g(false))), TuplesKt.to(10, new c45.h(10, this.F, new b.e.g(false))), TuplesKt.to(11, new c45.h(11, Boolean.valueOf(this.G), new b.e.a(false))), TuplesKt.to(12, new c45.h(12, Boolean.valueOf(this.H), new b.e.a(false))), TuplesKt.to(13, new c45.h(13, Integer.valueOf(this.I), new b.e.h(false))), TuplesKt.to(14, new c45.h(14, Integer.valueOf(this.J), new b.e.h(false))), TuplesKt.to(15, new c45.h(15, Boolean.valueOf(this.K), new b.e.a(false))), TuplesKt.to(16, new c45.h(16, this.L, new b.e.g(false))), TuplesKt.to(17, new c45.h(17, this.M, new b.e.g(false))), TuplesKt.to(18, new c45.h(18, Integer.valueOf(this.N), new b.e.h(false))));
        return mapOf;
    }
}
