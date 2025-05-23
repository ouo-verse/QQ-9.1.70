package e25;

import c45.b;
import com.tencent.mobileqq.startup.step.InitSkin;
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
public final class i extends c45.j {
    public String C;
    public String D;
    public final List<h> E;
    public b F;
    public int G;
    public String H;
    public long I;

    /* renamed from: d, reason: collision with root package name */
    public long f395478d;

    /* renamed from: e, reason: collision with root package name */
    public String f395479e;

    /* renamed from: f, reason: collision with root package name */
    public long f395480f;

    /* renamed from: h, reason: collision with root package name */
    public String f395481h;

    /* renamed from: i, reason: collision with root package name */
    public String f395482i;

    /* renamed from: m, reason: collision with root package name */
    public int f395483m;

    public i() {
        this(0L, null, 0L, null, null, 0, null, null, null, null, 0, null, 0L, InitSkin.DRAWABLE_COUNT, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new i(0L, null, 0L, null, null, 0, null, null, null, null, 0, null, 0L, InitSkin.DRAWABLE_COUNT, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395478d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395479e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395480f = ((Long) obj).longValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395481h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395482i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f395483m = ((Integer) obj).intValue();
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
                List<h> list = this.E;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.FlowerGene>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.Button");
                this.F = (b) obj;
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.G = ((Integer) obj).intValue();
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.H = (String) obj;
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.I = ((Long) obj).longValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ i(long j3, String str, long j16, String str2, String str3, int i3, String str4, String str5, List list, b bVar, int i16, String str6, long j17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", 0L, "", "", 0, "", "", new ArrayList(), null, 0, "", 0L);
    }

    public i(long j3, String str, long j16, String str2, String str3, int i3, String str4, String str5, List<h> list, b bVar, int i16, String str6, long j17) {
        this.f395478d = j3;
        this.f395479e = str;
        this.f395480f = j16;
        this.f395481h = str2;
        this.f395482i = str3;
        this.f395483m = i3;
        this.C = str4;
        this.D = str5;
        this.E = list;
        this.F = bVar;
        this.G = i16;
        this.H = str6;
        this.I = j17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f395478d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f395479e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f395480f), new b.e.i(false))), TuplesKt.to(4, new c45.h(4, this.f395481h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f395482i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f395483m), new b.e.h(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.f(new b.d(new h(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)), false))), TuplesKt.to(10, new c45.h(10, this.F, new b.d(new b(null, null, 0 == true ? 1 : 0, 7, null)))), TuplesKt.to(11, new c45.h(11, Integer.valueOf(this.G), new b.e.h(false))), TuplesKt.to(12, new c45.h(12, this.H, new b.e.g(false))), TuplesKt.to(13, new c45.h(13, Long.valueOf(this.I), new b.e.i(false))));
        return mapOf;
    }
}
