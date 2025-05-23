package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class u extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f418266d;

    public u() {
        this(0L, 1, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new u(0L, 1, null));
    }

    public /* synthetic */ u(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f418266d), new b.e.i(false))));
        return mapOf;
    }

    public u(long j3) {
        this.f418266d = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418266d = ((Long) obj).longValue();
        }
    }
}
