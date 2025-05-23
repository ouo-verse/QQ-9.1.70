package d25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f392717d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f392718e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f392719f;

    public c() {
        this(false, 7);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(false, 7));
    }

    public /* synthetic */ c(boolean z16, int i3) {
        this(0L, (i3 & 2) != 0 ? false : z16, null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f392717d), new b.e.i(true))), TuplesKt.to(2, new h(2, Boolean.valueOf(this.f392718e), new b.e.a(true))), TuplesKt.to(3, new h(3, this.f392719f, new b.e.C0167b(true))));
        return mapOf;
    }

    public c(long j3, boolean z16, c45.a aVar) {
        this.f392717d = j3;
        this.f392718e = z16;
        this.f392719f = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f392717d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f392718e = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f392719f = (c45.a) obj;
        }
    }
}
