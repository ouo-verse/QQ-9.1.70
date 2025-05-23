package o25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public float f421846d;

    /* renamed from: e, reason: collision with root package name */
    public float f421847e;

    /* renamed from: f, reason: collision with root package name */
    public long f421848f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e() {
        this(r0, r0, 7);
        float f16 = 0.0f;
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        float f16 = 0.0f;
        return fVar.g(new e(f16, f16, 7));
    }

    public /* synthetic */ e(float f16, float f17, int i3) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Float.valueOf(this.f421846d), new b.e.d(false))), TuplesKt.to(2, new c45.h(2, Float.valueOf(this.f421847e), new b.e.d(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f421848f), new b.e.f(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f421846d = ((Float) obj).floatValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f421847e = ((Float) obj).floatValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f421848f = ((Long) obj).longValue();
        }
    }

    public e(float f16, float f17, long j3) {
        this.f421846d = f16;
        this.f421847e = f17;
        this.f421848f = j3;
    }
}
