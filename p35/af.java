package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class af extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f425135d;

    /* renamed from: e, reason: collision with root package name */
    public long f425136e;

    /* renamed from: f, reason: collision with root package name */
    public long f425137f;

    /* renamed from: h, reason: collision with root package name */
    public long f425138h;

    public af() {
        this(0L, 0L, 0L, 0L, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new af(0L, 0L, 0L, 0L, 15, null));
    }

    public /* synthetic */ af(long j3, long j16, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0L, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f425135d), new b.e.f(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f425136e), new b.e.f(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f425137f), new b.e.f(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f425138h), new b.e.f(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f425135d = ((Long) obj).longValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f425136e = ((Long) obj).longValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f425137f = ((Long) obj).longValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f425138h = ((Long) obj).longValue();
        }
    }

    public af(long j3, long j16, long j17, long j18) {
        this.f425135d = j3;
        this.f425136e = j16;
        this.f425137f = j17;
        this.f425138h = j18;
    }
}
