package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class v extends c45.j {
    public int C;

    /* renamed from: d, reason: collision with root package name */
    public s f418267d;

    /* renamed from: e, reason: collision with root package name */
    public String f418268e;

    /* renamed from: f, reason: collision with root package name */
    public int f418269f;

    /* renamed from: h, reason: collision with root package name */
    public long f418270h;

    /* renamed from: i, reason: collision with root package name */
    public long f418271i;

    /* renamed from: m, reason: collision with root package name */
    public int f418272m;

    public v() {
        this(null, null, 0, 0L, 0L, 0, 0, 127, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new v(null, null, 0, 0L, 0L, 0, 0, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.FileInfo");
                this.f418267d = (s) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418268e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.StoreID }");
                this.f418269f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f418270h = ((Long) obj).longValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f418271i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SubFileType }");
                this.f418272m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.C = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ v(s sVar, String str, int i3, long j3, long j16, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "", r1.b().getValue(), 0L, 0L, r1.b().getValue(), 0);
        d.c.a aVar = d.c.f30317b;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418267d, new b.d(new s(0L, null, null, null, null, 0, 0, 0, false, 511, null)))), TuplesKt.to(2, new c45.h(2, this.f418268e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f418269f), new b.a(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f418270h), new b.e.f(false))), TuplesKt.to(5, new c45.h(5, Long.valueOf(this.f418271i), new b.e.f(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f418272m), new b.a(false))), TuplesKt.to(7, new c45.h(7, Integer.valueOf(this.C), new b.e.h(false))));
        return mapOf;
    }

    public v(s sVar, String str, int i3, long j3, long j16, int i16, int i17) {
        this.f418267d = sVar;
        this.f418268e = str;
        this.f418269f = i3;
        this.f418270h = j3;
        this.f418271i = j16;
        this.f418272m = i16;
        this.C = i17;
    }
}
