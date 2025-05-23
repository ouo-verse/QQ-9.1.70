package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class y extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f404257d;

    /* renamed from: e, reason: collision with root package name */
    public long f404258e;

    /* renamed from: f, reason: collision with root package name */
    public long f404259f;

    public y() {
        this(0L, 0L, 0L, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new y(0L, 0L, 0L, 7, null));
    }

    public /* synthetic */ y(long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f404257d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f404258e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f404259f), new b.e.i(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404257d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404258e = ((Long) obj).longValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404259f = ((Long) obj).longValue();
        }
    }

    public y(long j3, long j16, long j17) {
        this.f404257d = j3;
        this.f404258e = j16;
        this.f404259f = j17;
    }
}
