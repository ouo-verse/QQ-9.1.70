package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f404206d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f404207e;

    public h() {
        this(0L, false, 3, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h(0L, false, 3, null));
    }

    public /* synthetic */ h(long j3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, false);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f404206d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f404207e), new b.e.a(false))));
        return mapOf;
    }

    public h(long j3, boolean z16) {
        this.f404206d = j3;
        this.f404207e = z16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404206d = ((Long) obj).longValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f404207e = ((Boolean) obj).booleanValue();
        }
    }
}
