package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class v extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f404245d;

    /* renamed from: e, reason: collision with root package name */
    public long f404246e;

    /* renamed from: f, reason: collision with root package name */
    public long f404247f;

    public v() {
        this(0L, 0L, 0L, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new v(0L, 0L, 0L, 7, null));
    }

    public /* synthetic */ v(long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f404245d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f404246e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f404247f), new b.e.i(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404245d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404246e = ((Long) obj).longValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404247f = ((Long) obj).longValue();
        }
    }

    public v(long j3, long j16, long j17) {
        this.f404245d = j3;
        this.f404246e = j16;
        this.f404247f = j17;
    }
}
