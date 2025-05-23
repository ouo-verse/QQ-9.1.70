package k25;

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
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public boolean f411442d;

    /* renamed from: e, reason: collision with root package name */
    public d f411443e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f411444f;

    /* renamed from: h, reason: collision with root package name */
    public int f411445h;

    public b() {
        this(false, null, false, 0, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(false, null, false, 0, 15, null));
    }

    public /* synthetic */ b(boolean z16, d dVar, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, null, false, 0);
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f411442d = ((Boolean) obj).booleanValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.attendance_svr.attendance.LuckyCard");
            this.f411443e = (d) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f411444f = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f411445h = ((Integer) obj).intValue();
        }
    }

    public b(boolean z16, d dVar, boolean z17, int i3) {
        this.f411442d = z16;
        this.f411443e = dVar;
        this.f411444f = z17;
        this.f411445h = i3;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Boolean.valueOf(this.f411442d), new b.e.a(false))), TuplesKt.to(2, new h(2, this.f411443e, new b.d(new d(null, null, null, 0, null, null, null, 127, null)))), TuplesKt.to(3, new h(3, Boolean.valueOf(this.f411444f), new b.e.a(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f411445h), new b.e.h(false))));
        return mapOf;
    }
}
