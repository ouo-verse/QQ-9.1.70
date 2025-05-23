package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class s extends c45.j {
    public int C;
    public int D;
    public boolean E;

    /* renamed from: d, reason: collision with root package name */
    public long f418256d;

    /* renamed from: e, reason: collision with root package name */
    public String f418257e;

    /* renamed from: f, reason: collision with root package name */
    public String f418258f;

    /* renamed from: h, reason: collision with root package name */
    public String f418259h;

    /* renamed from: i, reason: collision with root package name */
    public t f418260i;

    /* renamed from: m, reason: collision with root package name */
    public int f418261m;

    public s() {
        this(0L, null, null, null, null, 0, 0, 0, false, 511, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new s(0L, null, null, null, null, 0, 0, 0, false, 511, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f418256d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418257e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418258f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418259h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.FileType");
                this.f418260i = (t) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418261m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.C = ((Integer) obj).intValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.D = ((Integer) obj).intValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.E = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ s(long j3, String str, String str2, String str3, t tVar, int i3, int i16, int i17, boolean z16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", "", null, 0, 0, 0, false);
    }

    public s(long j3, String str, String str2, String str3, t tVar, int i3, int i16, int i17, boolean z16) {
        this.f418256d = j3;
        this.f418257e = str;
        this.f418258f = str2;
        this.f418259h = str3;
        this.f418260i = tVar;
        this.f418261m = i3;
        this.C = i16;
        this.D = i17;
        this.E = z16;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f418256d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f418257e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f418258f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f418259h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f418260i, new b.d(new t(0, 0, 0, 0, 15, null)))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f418261m), new b.e.h(false))), TuplesKt.to(7, new c45.h(7, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(8, new c45.h(8, Integer.valueOf(this.D), new b.e.h(false))), TuplesKt.to(9, new c45.h(9, Boolean.valueOf(this.E), new b.e.a(false))));
        return mapOf;
    }
}
