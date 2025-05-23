package a35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f25447d;

    /* renamed from: e, reason: collision with root package name */
    public a f25448e;

    public c() {
        this(0L, null, 3, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(0L, null, 3, null));
    }

    public /* synthetic */ c(long j3, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        int i3 = 0;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f25447d), new b.e.f(false))), TuplesKt.to(2, new h(2, this.f25448e, new b.d(new a(i3, i3, 3, null)))));
        return mapOf;
    }

    public c(long j3, a aVar) {
        this.f25447d = j3;
        this.f25448e = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f25447d = ((Long) obj).longValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.room.data.Location");
            this.f25448e = (a) obj;
        }
    }
}
