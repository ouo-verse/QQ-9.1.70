package k35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f411551d;

    /* renamed from: e, reason: collision with root package name */
    public long f411552e;

    /* renamed from: f, reason: collision with root package name */
    public int f411553f;

    /* renamed from: h, reason: collision with root package name */
    public long f411554h;

    /* renamed from: i, reason: collision with root package name */
    public o25.e f411555i;

    public h(m25.c cVar, long j3, int i3, long j16, o25.e eVar) {
        this.f411551d = cVar;
        this.f411552e = j3;
        this.f411553f = i3;
        this.f411554h = j16;
        this.f411555i = eVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h(null, 0L, 0, 0L, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f411551d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f411552e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f411553f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f411554h), new b.e.i(false))), TuplesKt.to(5, new c45.h(5, this.f411555i, new b.d(new o25.e(0.0f, 0.0f, 7)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f411551d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f411552e = ((Long) obj).longValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f411553f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f411554h = ((Long) obj).longValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f411555i = (o25.e) obj;
        }
    }
}
