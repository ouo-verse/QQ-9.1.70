package n25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f418079d;

    /* renamed from: e, reason: collision with root package name */
    public long f418080e;

    /* renamed from: f, reason: collision with root package name */
    public long f418081f;

    /* renamed from: h, reason: collision with root package name */
    public long f418082h;

    public i() {
        this(0L, 0L, 15);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new i(0L, 0L, 15));
    }

    public /* synthetic */ i(long j3, long j16, int i3) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, 0L, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f418079d), new b.e.f(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f418080e), new b.e.f(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f418081f), new b.e.f(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f418082h), new b.e.f(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418079d = ((Long) obj).longValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418080e = ((Long) obj).longValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418081f = ((Long) obj).longValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418082h = ((Long) obj).longValue();
        }
    }

    public i(long j3, long j16, long j17, long j18) {
        this.f418079d = j3;
        this.f418080e = j16;
        this.f418081f = j17;
        this.f418082h = j18;
    }
}
