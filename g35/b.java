package g35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f401209d;

    /* renamed from: e, reason: collision with root package name */
    public final List<k25.c> f401210e;

    public b(m25.c cVar, List<k25.c> list) {
        this.f401209d = cVar;
        this.f401210e = list;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(null, new ArrayList()));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f401209d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new h(2, this.f401210e, new b.f(new b.d(new k25.c(0, 0, 0, 15)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f401209d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            List<k25.c> list = this.f401210e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.attendance_svr.attendance.Date>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
