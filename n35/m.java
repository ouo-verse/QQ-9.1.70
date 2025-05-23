package n35;

import c45.b;
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
/* loaded from: classes38.dex */
public final class m extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<ag> f418243d;

    public m() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new m(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ m(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418243d, new b.f(new b.d(new ag()), false))));
        return mapOf;
    }

    public m(List<ag> list) {
        this.f418243d = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<ag> list = this.f418243d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RKeyInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
