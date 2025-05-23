package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class u extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Long f395504d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f395505e;

    public u() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new u(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ u(Long l3, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395504d, new b.e.i(true))), TuplesKt.to(2, new c45.h(2, this.f395505e, new b.e.a(true))));
        return mapOf;
    }

    public u(Long l3, Boolean bool) {
        this.f395504d = l3;
        this.f395505e = bool;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395504d = (Long) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f395505e = (Boolean) obj;
        }
    }
}
