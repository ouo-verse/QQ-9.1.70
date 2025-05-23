package j35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f409228d;

    /* renamed from: e, reason: collision with root package name */
    public String f409229e;

    public k() {
        this(0L, null, 3);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(0L, null, 3));
    }

    public /* synthetic */ k(long j3, String str, int i3) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f409228d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f409229e, new b.e.g(false))));
        return mapOf;
    }

    public k(long j3, String str) {
        this.f409228d = j3;
        this.f409229e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f409228d = ((Long) obj).longValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f409229e = (String) obj;
        }
    }
}
