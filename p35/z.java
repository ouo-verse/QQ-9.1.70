package p35;

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
/* loaded from: classes33.dex */
public final class z extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<ad> f425231d;

    /* renamed from: e, reason: collision with root package name */
    public m25.c f425232e;

    public z() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new z(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ z(List list, m25.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), null);
    }

    public z(List<ad> list, m25.c cVar) {
        this.f425231d = list;
        this.f425232e = cVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425231d, new b.f(new b.d(new ad(null, null, 0, null, 15, null)), false))), TuplesKt.to(2, new c45.h(2, this.f425232e, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<ad> list = this.f425231d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.RecommendComment>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425232e = (m25.c) obj;
        }
    }
}
