package e35;

import c45.b;
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
public final class i extends j {

    /* renamed from: d, reason: collision with root package name */
    public q25.g f395571d;

    /* renamed from: e, reason: collision with root package name */
    public final List<f> f395572e;

    /* renamed from: f, reason: collision with root package name */
    public b f395573f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f395574h;

    public i() {
        this(null, null, null, false, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new i(null, null, null, false, 15, null));
    }

    public /* synthetic */ i(q25.g gVar, List list, b bVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), null, false);
    }

    public i(q25.g gVar, List<f> list, b bVar, boolean z16) {
        this.f395571d = gVar;
        this.f395572e = list;
        this.f395573f = bVar;
        this.f395574h = z16;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395571d, new b.d(new q25.g(0, 0, null, null, null, null, null, null, null, null, 1023, null)))), TuplesKt.to(2, new c45.h(2, this.f395572e, new b.f(new b.d(new f(0, null, false, null, null, 31, null)), false))), TuplesKt.to(3, new c45.h(3, this.f395573f, new b.d(new b(null, null, 3, null)))), TuplesKt.to(4, new c45.h(4, Boolean.valueOf(this.f395574h), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.StatusInfo");
            this.f395571d = (q25.g) obj;
            return;
        }
        if (i3 == 2) {
            List<f> list = this.f395572e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.status_panel_svr.status_panel_svr.MotionGroup>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.status_panel_svr.status_panel_svr.CornerIconInfo");
            this.f395573f = (b) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f395574h = ((Boolean) obj).booleanValue();
        }
    }
}
