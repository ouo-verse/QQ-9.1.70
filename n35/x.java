package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class x extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public c45.a f418275d;

    /* renamed from: e, reason: collision with root package name */
    public long f418276e;

    public x() {
        this(null, 0L, 3, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new x(null, 0L, 3, null));
    }

    public /* synthetic */ x(c45.a aVar, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(c45.a.f30290b, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418275d, new b.e.C0167b(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f418276e), new b.e.f(false))));
        return mapOf;
    }

    public x(c45.a aVar, long j3) {
        this.f418275d = aVar;
        this.f418276e = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f418275d = (c45.a) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418276e = ((Long) obj).longValue();
        }
    }
}
