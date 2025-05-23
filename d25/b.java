package d25;

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
    public long f392713d;

    /* renamed from: e, reason: collision with root package name */
    public Float f392714e;

    /* renamed from: f, reason: collision with root package name */
    public Float f392715f;

    /* renamed from: h, reason: collision with root package name */
    public Float f392716h;

    public b(long j3, Float f16, Float f17, Float f18) {
        this.f392713d = j3;
        this.f392714e = f16;
        this.f392715f = f17;
        this.f392716h = f18;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0L, null, null, null));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f392713d), new b.e.i(true))), TuplesKt.to(2, new h(2, this.f392714e, new b.e.d(true))), TuplesKt.to(3, new h(3, this.f392715f, new b.e.d(true))), TuplesKt.to(4, new h(4, this.f392716h, new b.e.d(true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f392713d = ((Long) obj).longValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f392714e = (Float) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f392715f = (Float) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f392716h = (Float) obj;
        }
    }
}
