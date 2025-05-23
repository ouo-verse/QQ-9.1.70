package k35;

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
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f411539d;

    /* renamed from: e, reason: collision with root package name */
    public final List<Long> f411540e;

    /* renamed from: f, reason: collision with root package name */
    public int f411541f;

    public d(m25.c cVar, List<Long> list, int i3) {
        this.f411539d = cVar;
        this.f411540e = list;
        this.f411541f = i3;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, new ArrayList(), 0));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f411539d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f411540e, new b.f(new b.e.i(false), true))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f411541f), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f411539d = (m25.c) obj;
        } else if (i3 == 2) {
            List<Long> list = this.f411540e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Long>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f411541f = ((Integer) obj).intValue();
        }
    }
}
