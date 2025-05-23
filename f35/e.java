package f35;

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
    public int f397795d;

    /* renamed from: e, reason: collision with root package name */
    public final List<String> f397796e;

    public e() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(0, null, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ e(int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f397795d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f397796e, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    public e(int i3, List<String> list) {
        this.f397795d = i3;
        this.f397796e = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f397795d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            List<String> list = this.f397796e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
