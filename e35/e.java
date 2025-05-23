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
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public final List<a> f395559d;

    /* renamed from: e, reason: collision with root package name */
    public String f395560e;

    /* renamed from: f, reason: collision with root package name */
    public String f395561f;

    /* renamed from: h, reason: collision with root package name */
    public c f395562h;

    public e() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, null, null, null, 15, null));
    }

    public /* synthetic */ e(List list, String str, String str2, c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), "", "", null);
    }

    public e(List<a> list, String str, String str2, c cVar) {
        this.f395559d = list;
        this.f395560e = str;
        this.f395561f = str2;
        this.f395562h = cVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 0;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395559d, new b.f(new b.d(new a(null, null, null, null, 15, null)), false))), TuplesKt.to(2, new c45.h(2, this.f395560e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f395561f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f395562h, new b.d(new c(i3, i3, 3, 0 == true ? 1 : 0)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<a> list = this.f395559d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.status_panel_svr.status_panel_svr.CategoryInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395560e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395561f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.status_panel_svr.status_panel_svr.DefaultStatus");
            this.f395562h = (c) obj;
        }
    }
}
