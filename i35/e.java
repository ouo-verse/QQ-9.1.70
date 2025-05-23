package i35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f407171d;

    /* renamed from: e, reason: collision with root package name */
    public long f407172e;

    public e() {
        this(0, 0L, 3, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new e(0, 0L, 3, null));
    }

    public /* synthetic */ e(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0L);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f407171d), new b.e.h(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f407172e), new b.e.i(false))));
        return mapOf;
    }

    public e(int i3, long j3) {
        this.f407171d = i3;
        this.f407172e = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f407171d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f407172e = ((Long) obj).longValue();
        }
    }
}
