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
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f418225d;

    /* renamed from: e, reason: collision with root package name */
    public int f418226e;

    public f() {
        this(0L, 0, 3, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(0L, 0, 3, null));
    }

    public /* synthetic */ f(long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f418225d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418226e), new b.a(false))));
        return mapOf;
    }

    public f(long j3, int i3) {
        this.f418225d = j3;
        this.f418226e = i3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418225d = ((Long) obj).longValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.Cmd }");
            this.f418226e = ((Integer) obj).intValue();
        }
    }
}
