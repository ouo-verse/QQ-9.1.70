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
public final class y extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<z> f395514d;

    /* renamed from: e, reason: collision with root package name */
    public String f395515e;

    /* renamed from: f, reason: collision with root package name */
    public int f395516f;

    /* renamed from: h, reason: collision with root package name */
    public a f395517h;

    public y() {
        this(null, null, 0, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new y(null, null, 0, null, 15, null));
    }

    public /* synthetic */ y(List list, String str, int i3, a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), "", 0, null);
    }

    public y(List<z> list, String str, int i3, a aVar) {
        this.f395514d = list;
        this.f395515e = str;
        this.f395516f = i3;
        this.f395517h = aVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395514d, new b.f(new b.d(new z(null, 0L, null, null, 15, null)), false))), TuplesKt.to(2, new c45.h(2, this.f395515e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f395516f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f395517h, new b.d(new a(0, null, null, null, 15, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<z> list = this.f395514d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.QzonePhoto>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395515e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f395516f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.BubbleTips");
            this.f395517h = (a) obj;
        }
    }
}
