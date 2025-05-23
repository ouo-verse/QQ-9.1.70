package o25;

import c45.b;
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
/* loaded from: classes38.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f421830d;

    /* renamed from: e, reason: collision with root package name */
    public e f421831e;

    /* renamed from: f, reason: collision with root package name */
    public final List<c> f421832f;

    /* renamed from: h, reason: collision with root package name */
    public final List<b> f421833h;

    /* renamed from: i, reason: collision with root package name */
    public d f421834i;

    public a() {
        this(0, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new a(0, null, null, null, null, 31, null));
    }

    public /* synthetic */ a(int i3, e eVar, List list, List list2, d dVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null, new ArrayList(), new ArrayList(), null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f421830d), new b.e.C0168e(false))), TuplesKt.to(2, new c45.h(2, this.f421831e, new b.d(new e(0.0f, 0.0f, 7)))), TuplesKt.to(3, new c45.h(3, this.f421832f, new b.f(new b.d(new c(null, 0, 0, 7, null)), false))), TuplesKt.to(4, new c45.h(4, this.f421833h, new b.f(new b.d(new b(null, 0 == true ? 1 : 0, null, 7, null)), false))), TuplesKt.to(5, new c45.h(5, this.f421834i, new b.d(new d(null, null, 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 31, null)))));
        return mapOf;
    }

    public a(int i3, e eVar, List<c> list, List<b> list2, d dVar) {
        this.f421830d = i3;
        this.f421831e = eVar;
        this.f421832f = list;
        this.f421833h = list2;
        this.f421834i = dVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f421830d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f421831e = (e) obj;
            return;
        }
        if (i3 == 3) {
            List<c> list = this.f421832f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.map.AreaBackground>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 4) {
            List<b> list2 = this.f421833h;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.map.AreaAttachment>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.AreaSummaryInfo");
            this.f421834i = (d) obj;
        }
    }
}
