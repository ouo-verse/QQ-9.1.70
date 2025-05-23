package e25;

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
public final class o extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<ai> f395490d;

    /* renamed from: e, reason: collision with root package name */
    public final List<aj> f395491e;

    /* renamed from: f, reason: collision with root package name */
    public long f395492f;

    public o() {
        this(null, null, 0L, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new o(null, null, 0L, 7, null));
    }

    public /* synthetic */ o(List list, List list2, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), new ArrayList(), 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395490d, new b.f(new b.d(new ai(0L, 0L, null, 7, null)), false))), TuplesKt.to(2, new c45.h(2, this.f395491e, new b.f(new b.d(new aj(0, 0, null, 0L, 0L, null, false, null, null, 511, null)), false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f395492f), new b.e.i(false))));
        return mapOf;
    }

    public o(List<ai> list, List<aj> list2, long j3) {
        this.f395490d = list;
        this.f395491e = list2;
        this.f395492f = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<ai> list = this.f395490d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.UserWater>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            List<aj> list2 = this.f395491e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.WaterTask>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395492f = ((Long) obj).longValue();
        }
    }
}
