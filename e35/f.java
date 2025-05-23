package e35;

import c45.b;
import c45.d;
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
public final class f extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f395563d;

    /* renamed from: e, reason: collision with root package name */
    public g f395564e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f395565f;

    /* renamed from: h, reason: collision with root package name */
    public h f395566h;

    /* renamed from: i, reason: collision with root package name */
    public final List<q25.f> f395567i;

    public f() {
        this(0, null, false, null, null, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new f(0, null, false, null, null, 31, null));
    }

    public /* synthetic */ f(int i3, g gVar, boolean z16, h hVar, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), null, false, null, new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f395563d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f395564e, new b.d(new g(null, null, 3, null)))), TuplesKt.to(3, new c45.h(3, Boolean.valueOf(this.f395565f), new b.e.a(false))), TuplesKt.to(4, new c45.h(4, this.f395566h, new b.d(new h("")))), TuplesKt.to(5, new c45.h(5, this.f395567i, new b.f(new b.d(new q25.f(0, null, null, null, null, null, 63, null)), false))));
        return mapOf;
    }

    public f(int i3, g gVar, boolean z16, h hVar, List<q25.f> list) {
        this.f395563d = i3;
        this.f395564e = gVar;
        this.f395565f = z16;
        this.f395566h = hVar;
        this.f395567i = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.status_panel_svr.status_panel_svr.Status_panel_svrKt.MotionGroupType }");
            this.f395563d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.status_panel_svr.status_panel_svr.MotionIcon");
            this.f395564e = (g) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f395565f = ((Boolean) obj).booleanValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.status_panel_svr.status_panel_svr.RedDotInfo");
            this.f395566h = (h) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            List<q25.f> list = this.f395567i;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.status.ResourceInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
