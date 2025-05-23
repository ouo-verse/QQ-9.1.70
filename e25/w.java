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
public final class w extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Long f395508d;

    /* renamed from: e, reason: collision with root package name */
    public final List<z> f395509e;

    /* renamed from: f, reason: collision with root package name */
    public ab f395510f;

    /* renamed from: h, reason: collision with root package name */
    public a f395511h;

    public w() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new w(null, null, null, null, 15, null));
    }

    public /* synthetic */ w(Long l3, List list, ab abVar, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), null, null);
    }

    public w(Long l3, List<z> list, ab abVar, a aVar) {
        this.f395508d = l3;
        this.f395509e = list;
        this.f395510f = abVar;
        this.f395511h = aVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395508d, new b.e.i(true))), TuplesKt.to(2, new c45.h(2, this.f395509e, new b.f(new b.d(new z(null, 0L, null, null, 15, null)), false))), TuplesKt.to(3, new c45.h(3, this.f395510f, new b.d(new ab(null, null, 3, null)))), TuplesKt.to(4, new c45.h(4, this.f395511h, new b.d(new a(0, null, null, null, 15, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395508d = (Long) obj;
            return;
        }
        if (i3 == 2) {
            List<z> list = this.f395509e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.QzonePhoto>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.ScreenCoord");
            this.f395510f = (ab) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.BubbleTips");
            this.f395511h = (a) obj;
        }
    }
}
