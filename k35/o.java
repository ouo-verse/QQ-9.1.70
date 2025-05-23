package k35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f411573d;

    /* renamed from: e, reason: collision with root package name */
    public long f411574e;

    /* renamed from: f, reason: collision with root package name */
    public int f411575f;

    public o(m25.c cVar, long j3, int i3) {
        this.f411573d = cVar;
        this.f411574e = j3;
        this.f411575f = i3;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new o(null, 0L, 0));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f411573d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f411574e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f411575f), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f411573d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f411574e = ((Long) obj).longValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f411575f = ((Integer) obj).intValue();
        }
    }
}
