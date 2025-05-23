package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class x extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public ac f425225d;

    /* renamed from: e, reason: collision with root package name */
    public m25.c f425226e;

    public x() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new x(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ x(ac acVar, m25.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425225d, new b.d(new ac(null, 0, null, 0, 63)))), TuplesKt.to(2, new c45.h(2, this.f425226e, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    public x(ac acVar, m25.c cVar) {
        this.f425225d = acVar;
        this.f425226e = cVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.LikeInfo");
            this.f425225d = (ac) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425226e = (m25.c) obj;
        }
    }
}
