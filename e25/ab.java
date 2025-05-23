package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ab extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Integer f395428d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f395429e;

    public ab() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ab(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ ab(Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395428d, new b.e.h(true))), TuplesKt.to(2, new c45.h(2, this.f395429e, new b.e.h(true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f395428d = (Integer) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f395429e = (Integer) obj;
        }
    }

    public ab(Integer num, Integer num2) {
        this.f395428d = num;
        this.f395429e = num2;
    }
}
