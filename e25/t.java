package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Long f395502d;

    /* renamed from: e, reason: collision with root package name */
    public ad f395503e;

    public t(Long l3, ad adVar) {
        this.f395502d = l3;
        this.f395503e = adVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new t(null, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395502d, new b.e.i(true))), TuplesKt.to(2, new c45.h(2, this.f395503e, new b.d(new ad(0L, null, null, null, null, 0L, null, 127, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395502d = (Long) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.Tree");
            this.f395503e = (ad) obj;
        }
    }
}
