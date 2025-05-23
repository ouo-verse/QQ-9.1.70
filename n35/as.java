package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class as extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418193d;

    /* renamed from: e, reason: collision with root package name */
    public long f418194e;

    public as() {
        this(null, 0L, 3, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new as(null, 0L, 3, null));
    }

    public /* synthetic */ as(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418193d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f418194e), new b.e.f(false))));
        return mapOf;
    }

    public as(String str, long j3) {
        this.f418193d = str;
        this.f418194e = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418193d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418194e = ((Long) obj).longValue();
        }
    }
}
