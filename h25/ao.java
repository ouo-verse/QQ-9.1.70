package h25;

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
public final class ao extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f404172d;

    /* renamed from: e, reason: collision with root package name */
    public final List<Long> f404173e;

    public ao(String str, List<Long> list) {
        this.f404172d = str;
        this.f404173e = list;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ao("", new ArrayList()));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404172d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f404173e, new b.f(new b.e.i(false), true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404172d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            List<Long> list = this.f404173e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Long>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
