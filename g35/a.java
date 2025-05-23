package g35;

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
/* loaded from: classes38.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public k25.c f401207d;

    /* renamed from: e, reason: collision with root package name */
    public k25.d f401208e;

    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ a(k25.c cVar, k25.d dVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public a(k25.c cVar, k25.d dVar) {
        this.f401207d = cVar;
        this.f401208e = dVar;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f401207d, new b.d(new k25.c(0, 0, 0, 15)))), TuplesKt.to(2, new h(2, this.f401208e, new b.d(new k25.d(null, null, null, 0, null, null, null, 127, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.attendance_svr.attendance.Date");
            this.f401207d = (k25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.attendance_svr.attendance.LuckyCard");
            this.f401208e = (k25.d) obj;
        }
    }
}
