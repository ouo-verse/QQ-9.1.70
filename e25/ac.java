package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ac extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f395430d;

    /* renamed from: e, reason: collision with root package name */
    public int f395431e;

    public ac(long j3, int i3) {
        this.f395430d = j3;
        this.f395431e = i3;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ac(0L, 0));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f395430d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f395431e), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395430d = ((Long) obj).longValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f395431e = ((Integer) obj).intValue();
        }
    }
}
