package k35;

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
public final class e extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<h35.a> f411542d;

    /* renamed from: e, reason: collision with root package name */
    public long f411543e;

    public e() {
        this(null, 0L, 3, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, 0L, 3, null));
    }

    public /* synthetic */ e(List list, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), 0L);
    }

    public e(List<h35.a> list, long j3) {
        this.f411542d = list;
        this.f411543e = j3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f411542d, new b.f(new b.d(new h35.a(null, 0L, null, 0L, 0L, 31, null)), false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f411543e), new b.e.f(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<h35.a> list = this.f411542d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan_ext.common.barrage.Barrage>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f411543e = ((Long) obj).longValue();
        }
    }
}
