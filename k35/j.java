package k35;

import c45.b;
import c45.d;
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
public final class j extends c45.j {
    public long C;
    public String D;
    public final List<String> E;
    public String F;
    public int G;

    /* renamed from: d, reason: collision with root package name */
    public long f411556d;

    /* renamed from: e, reason: collision with root package name */
    public String f411557e;

    /* renamed from: f, reason: collision with root package name */
    public String f411558f;

    /* renamed from: h, reason: collision with root package name */
    public long f411559h;

    /* renamed from: i, reason: collision with root package name */
    public long f411560i;

    /* renamed from: m, reason: collision with root package name */
    public final List<t35.a> f411561m;

    public j() {
        this(0L, null, null, 0L, 0L, null, 0L, null, null, null, 0, 2047, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j(0L, null, null, 0L, 0L, null, 0L, null, null, null, 0, 2047, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f411556d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f411557e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f411558f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f411559h = ((Long) obj).longValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f411560i = ((Long) obj).longValue();
                return;
            case 6:
                List<t35.a> list = this.f411561m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
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
                List<String> list2 = this.E;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.F = (String) obj;
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan_ext.mood_svr.mood_svr.Mood_svr_extKt.GreetStatus }");
                this.G = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ j(long j3, String str, String str2, long j16, long j17, List list, long j18, String str3, List list2, String str4, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", 0L, 0L, new ArrayList(), 0L, "", new ArrayList(), "", d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f411556d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f411557e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f411558f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f411559h), new b.e.i(false))), TuplesKt.to(5, new c45.h(5, Long.valueOf(this.f411560i), new b.e.f(false))), TuplesKt.to(6, new c45.h(6, this.f411561m, new b.f(new b.d(new t35.a(0, null, 63)), false))), TuplesKt.to(7, new c45.h(7, Long.valueOf(this.C), new b.e.i(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.f(new b.e.g(false), false))), TuplesKt.to(10, new c45.h(10, this.F, new b.e.g(false))), TuplesKt.to(11, new c45.h(11, Integer.valueOf(this.G), new b.a(false))));
        return mapOf;
    }

    public j(long j3, String str, String str2, long j16, long j17, List<t35.a> list, long j18, String str3, List<String> list2, String str4, int i3) {
        this.f411556d = j3;
        this.f411557e = str;
        this.f411558f = str2;
        this.f411559h = j16;
        this.f411560i = j17;
        this.f411561m = list;
        this.C = j18;
        this.D = str3;
        this.E = list2;
        this.F = str4;
        this.G = i3;
    }
}
