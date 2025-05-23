package p25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o25.e;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class a extends j {
    public String C;
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public long f424994d;

    /* renamed from: e, reason: collision with root package name */
    public int f424995e;

    /* renamed from: f, reason: collision with root package name */
    public e f424996f;

    /* renamed from: h, reason: collision with root package name */
    public long f424997h;

    /* renamed from: i, reason: collision with root package name */
    public long f424998i;

    /* renamed from: m, reason: collision with root package name */
    public int f424999m;

    public a() {
        this(0L, 0, null, 0L, 0L, 0, null, null, 255, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(0L, 0, null, 0L, 0L, 0, null, null, 255, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f424994d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f424995e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
                this.f424996f = (e) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f424997h = ((Long) obj).longValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f424998i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f424999m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.D = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ a(long j3, int i3, e eVar, long j16, long j17, int i16, String str, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0, null, 0L, 0L, 0, "", "");
    }

    public a(long j3, int i3, e eVar, long j16, long j17, int i16, String str, String str2) {
        this.f424994d = j3;
        this.f424995e = i3;
        this.f424996f = eVar;
        this.f424997h = j16;
        this.f424998i = j17;
        this.f424999m = i16;
        this.C = str;
        this.D = str2;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        float f16 = 0.0f;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f424994d), new b.e.i(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f424995e), new b.e.h(false))), TuplesKt.to(3, new h(3, this.f424996f, new b.d(new e(f16, f16, 7)))), TuplesKt.to(4, new h(4, Long.valueOf(this.f424997h), new b.e.f(false))), TuplesKt.to(5, new h(5, Long.valueOf(this.f424998i), new b.e.f(false))), TuplesKt.to(6, new h(6, Integer.valueOf(this.f424999m), new b.e.h(false))), TuplesKt.to(7, new h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new h(8, this.D, new b.e.g(false))));
        return mapOf;
    }
}
