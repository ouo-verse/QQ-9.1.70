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
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f418218d;

    /* renamed from: e, reason: collision with root package name */
    public long f418219e;

    /* renamed from: f, reason: collision with root package name */
    public int f418220f;

    public c() {
        this(0L, 0L, 0, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(0L, 0L, 0, 7, null));
    }

    public /* synthetic */ c(long j3, long j16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f418218d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f418219e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f418220f), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418218d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418219e = ((Long) obj).longValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.ChannelType }");
            this.f418220f = ((Integer) obj).intValue();
        }
    }

    public c(long j3, long j16, int i3) {
        this.f418218d = j3;
        this.f418219e = j16;
        this.f418220f = i3;
    }
}
