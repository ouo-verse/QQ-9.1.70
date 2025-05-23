package l25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f413741d;

    /* renamed from: e, reason: collision with root package name */
    public long f413742e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f413743f;

    public b() {
        this(0L, 7);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(0L, 7));
    }

    public /* synthetic */ b(long j3, int i3) {
        this((i3 & 1) != 0 ? 0L : j3, 0L, (i3 & 4) != 0 ? c45.a.f30290b : null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f413741d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f413742e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, this.f413743f, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f413741d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f413742e = ((Long) obj).longValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f413743f = (c45.a) obj;
        }
    }

    public b(long j3, long j16, c45.a aVar) {
        this.f413741d = j3;
        this.f413742e = j16;
        this.f413743f = aVar;
    }
}
