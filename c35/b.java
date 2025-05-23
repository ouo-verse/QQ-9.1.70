package c35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public final List<a35.b> f30265d;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ b(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new h(1, this.f30265d, new b.f(new b.d(new a35.b(0, 0L, null, null, 0, 31, null)), false))));
        return mapOf;
    }

    public b(List<a35.b> list) {
        this.f30265d = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<a35.b> list = this.f30265d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.room.data.SimpleRoomInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
