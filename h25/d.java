package h25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends c45.j {
    public long C;
    public String D;
    public int E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public final List<Long> M;

    /* renamed from: d, reason: collision with root package name */
    public String f404190d;

    /* renamed from: e, reason: collision with root package name */
    public String f404191e;

    /* renamed from: f, reason: collision with root package name */
    public String f404192f;

    /* renamed from: h, reason: collision with root package name */
    public String f404193h;

    /* renamed from: i, reason: collision with root package name */
    public String f404194i;

    /* renamed from: m, reason: collision with root package name */
    public long f404195m;

    public d() {
        this(null, null, null, null, null, 0L, 0L, null, 0, null, null, null, null, null, null, null, null, 131071, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        String str = null;
        return fVar.g(new d(null, null, null, null, null, 0L, 0L, null, 0, null, null, null, str, str, null, null, null, 131071, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404190d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404191e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404192f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404193h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404194i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f404195m = ((Long) obj).longValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.C = ((Long) obj).longValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.D = (String) obj;
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
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.J = (String) obj;
                return;
            case 15:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.K = (String) obj;
                return;
            case 16:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.L = (String) obj;
                return;
            case 17:
            default:
                return;
            case 18:
                List<Long> list = this.M;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Long>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
        }
    }

    public /* synthetic */ d(String str, String str2, String str3, String str4, String str5, long j3, long j16, String str6, int i3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", 0L, 0L, "", 0, "", "", "", "", "", "", "", new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404190d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f404191e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f404192f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f404193h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f404194i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, Long.valueOf(this.f404195m), new b.e.f(false))), TuplesKt.to(7, new c45.h(7, Long.valueOf(this.C), new b.e.f(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))), TuplesKt.to(9, new c45.h(9, Integer.valueOf(this.E), new b.e.C0168e(false))), TuplesKt.to(10, new c45.h(10, this.F, new b.e.g(false))), TuplesKt.to(11, new c45.h(11, this.G, new b.e.g(false))), TuplesKt.to(12, new c45.h(12, this.H, new b.e.g(false))), TuplesKt.to(13, new c45.h(13, this.I, new b.e.g(false))), TuplesKt.to(14, new c45.h(14, this.J, new b.e.g(false))), TuplesKt.to(15, new c45.h(15, this.K, new b.e.g(false))), TuplesKt.to(16, new c45.h(16, this.L, new b.e.g(false))), TuplesKt.to(18, new c45.h(18, this.M, new b.f(new b.e.i(false), true))));
        return mapOf;
    }

    public d(String str, String str2, String str3, String str4, String str5, long j3, long j16, String str6, int i3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List<Long> list) {
        this.f404190d = str;
        this.f404191e = str2;
        this.f404192f = str3;
        this.f404193h = str4;
        this.f404194i = str5;
        this.f404195m = j3;
        this.C = j16;
        this.D = str6;
        this.E = i3;
        this.F = str7;
        this.G = str8;
        this.H = str9;
        this.I = str10;
        this.J = str11;
        this.K = str12;
        this.L = str13;
        this.M = list;
    }
}
