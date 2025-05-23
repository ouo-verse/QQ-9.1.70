package m35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f416085d;

    /* renamed from: e, reason: collision with root package name */
    public int f416086e;

    /* renamed from: f, reason: collision with root package name */
    public int f416087f;

    public b(long j3, int i3, int i16) {
        this.f416085d = j3;
        this.f416086e = i3;
        this.f416087f = i16;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0L, 0, 0));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f416085d), new b.e.i(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f416086e), new b.e.h(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f416087f), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f416085d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f416086e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f416087f = ((Integer) obj).intValue();
        }
    }
}
