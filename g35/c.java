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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public final List<a> f401211d;

    /* renamed from: e, reason: collision with root package name */
    public k25.c f401212e;

    public c() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ c(List list, k25.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f401211d, new b.f(new b.d(new a(null, null, 3, null)), false))), TuplesKt.to(2, new h(2, this.f401212e, new b.d(new k25.c(0, 0, 0, 15)))));
        return mapOf;
    }

    public c(List<a> list, k25.c cVar) {
        this.f401211d = list;
        this.f401212e = cVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<a> list = this.f401211d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan_ext.attendance_svr.attendance.AttendanceDetail>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.attendance_svr.attendance.Date");
            this.f401212e = (k25.c) obj;
        }
    }
}
