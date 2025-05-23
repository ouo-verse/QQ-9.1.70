package e25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f395471d;

    /* renamed from: e, reason: collision with root package name */
    public final List<Integer> f395472e;

    public c(long j3, List<Integer> list) {
        this.f395471d = j3;
        this.f395472e = list;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(0L, new ArrayList()));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f395471d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f395472e, new b.f(new b.e.h(false), true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395471d = ((Long) obj).longValue();
        } else {
            if (i3 != 2) {
                return;
            }
            List<Integer> list = this.f395472e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
