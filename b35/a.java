package b35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f27848d;

    /* renamed from: e, reason: collision with root package name */
    public long f27849e;

    /* renamed from: f, reason: collision with root package name */
    public long f27850f;

    public a(int i3, long j3, long j16) {
        this.f27848d = i3;
        this.f27849e = j3;
        this.f27850f = j16;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(0, 0L, 0L));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f27848d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f27849e), new b.e.f(false))), TuplesKt.to(3, new h(3, Long.valueOf(this.f27850f), new b.e.i(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f27848d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f27849e = ((Long) obj).longValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f27850f = ((Long) obj).longValue();
        }
    }
}
