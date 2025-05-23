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
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public e f25449d;

    /* renamed from: e, reason: collision with root package name */
    public long f25450e;

    public d() {
        this(null, 0L, 3, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new d(null, 0L, 3, null));
    }

    public /* synthetic */ d(e eVar, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0L);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f25449d, new b.d(new e(null, null, 0, 7, null)))), TuplesKt.to(2, new h(2, Long.valueOf(this.f25450e), new b.e.f(false))));
        return mapOf;
    }

    public d(e eVar, long j3) {
        this.f25449d = eVar;
        this.f25450e = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.room.data.UserProfile");
            this.f25449d = (e) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f25450e = ((Long) obj).longValue();
        }
    }
}
