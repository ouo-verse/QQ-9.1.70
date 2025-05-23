package a35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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
/* loaded from: classes39.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f25442d;

    /* renamed from: e, reason: collision with root package name */
    public long f25443e;

    /* renamed from: f, reason: collision with root package name */
    public final List<d> f25444f;

    /* renamed from: h, reason: collision with root package name */
    public final List<c> f25445h;

    /* renamed from: i, reason: collision with root package name */
    public int f25446i;

    public b() {
        this(0, 0L, null, null, 0, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0, 0L, null, null, 0, 31, null));
    }

    public /* synthetic */ b(int i3, long j3, List list, List list2, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0L, new ArrayList(), new ArrayList(), 0);
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f25442d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f25443e = ((Long) obj).longValue();
            return;
        }
        if (i3 == 3) {
            List<d> list = this.f25444f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.room.data.SimpleUserInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 4) {
            List<c> list2 = this.f25445h;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.room.data.SimpleTableInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f25446i = ((Integer) obj).intValue();
        }
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f25442d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f25443e), new b.e.f(false))), TuplesKt.to(3, new h(3, this.f25444f, new b.f(new b.d(new d(null, 0L, 3, null)), false))), TuplesKt.to(4, new h(4, this.f25445h, new b.f(new b.d(new c(0L, null, 3, null)), false))), TuplesKt.to(5, new h(5, Integer.valueOf(this.f25446i), new b.e.C0168e(false))));
        return mapOf;
    }

    public b(int i3, long j3, List<d> list, List<c> list2, int i16) {
        this.f25442d = i3;
        this.f25443e = j3;
        this.f25444f = list;
        this.f25445h = list2;
        this.f25446i = i16;
    }
}
