package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f404226d;

    /* renamed from: e, reason: collision with root package name */
    public int f404227e;

    /* renamed from: f, reason: collision with root package name */
    public int f404228f;

    /* renamed from: h, reason: collision with root package name */
    public int f404229h;

    /* renamed from: i, reason: collision with root package name */
    public int f404230i;

    /* renamed from: m, reason: collision with root package name */
    public int f404231m;

    public /* synthetic */ r(int i3, int i16, int i17) {
        this((i17 & 1) != 0 ? 0 : i3, 0, 0, 0, 0, (i17 & 32) != 0 ? 0 : i16);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        int i3 = 0;
        return fVar.g(new r(i3, i3, 63));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f404226d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f404227e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f404228f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f404229h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f404230i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f404231m = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    public r(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.f404226d = i3;
        this.f404227e = i16;
        this.f404228f = i17;
        this.f404229h = i18;
        this.f404230i = i19;
        this.f404231m = i26;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f404226d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f404227e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f404228f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f404229h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f404230i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f404231m), new b.e.h(false))));
        return mapOf;
    }
}
