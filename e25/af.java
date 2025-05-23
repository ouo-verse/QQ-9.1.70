package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class af extends c45.j {
    public long C;

    /* renamed from: d, reason: collision with root package name */
    public float f395444d;

    /* renamed from: e, reason: collision with root package name */
    public float f395445e;

    /* renamed from: f, reason: collision with root package name */
    public String f395446f;

    /* renamed from: h, reason: collision with root package name */
    public String f395447h;

    /* renamed from: i, reason: collision with root package name */
    public long f395448i;

    /* renamed from: m, reason: collision with root package name */
    public float f395449m;

    public af() {
        this(0.0f, 0.0f, null, null, 0L, 0.0f, 0L, 127, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new af(0.0f, 0.0f, null, null, 0L, 0.0f, 0L, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                this.f395444d = ((Float) obj).floatValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                this.f395445e = ((Float) obj).floatValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395446f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395447h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395448i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                this.f395449m = ((Float) obj).floatValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.C = ((Long) obj).longValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ af(float f16, float f17, String str, String str2, long j3, float f18, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0.0f, 0.0f, "", "", 0L, 0.0f, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Float.valueOf(this.f395444d), new b.e.d(false))), TuplesKt.to(2, new c45.h(2, Float.valueOf(this.f395445e), new b.e.d(false))), TuplesKt.to(3, new c45.h(3, this.f395446f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f395447h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, Long.valueOf(this.f395448i), new b.e.i(false))), TuplesKt.to(6, new c45.h(6, Float.valueOf(this.f395449m), new b.e.d(false))), TuplesKt.to(7, new c45.h(7, Long.valueOf(this.C), new b.e.i(false))));
        return mapOf;
    }

    public af(float f16, float f17, String str, String str2, long j3, float f18, long j16) {
        this.f395444d = f16;
        this.f395445e = f17;
        this.f395446f = str;
        this.f395447h = str2;
        this.f395448i = j3;
        this.f395449m = f18;
        this.C = j16;
    }
}
