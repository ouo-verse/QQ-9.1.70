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
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f395547d;

    /* renamed from: e, reason: collision with root package name */
    public String f395548e;

    /* renamed from: f, reason: collision with root package name */
    public final List<i> f395549f;

    /* renamed from: h, reason: collision with root package name */
    public String f395550h;

    public a() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new a(null, null, null, null, 15, null));
    }

    public /* synthetic */ a(String str, String str2, List list, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", new ArrayList(), "");
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395547d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395548e = (String) obj;
        } else if (i3 == 3) {
            List<i> list = this.f395549f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.status_panel_svr.status_panel_svr.StatusGrid>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395550h = (String) obj;
        }
    }

    public a(String str, String str2, List<i> list, String str3) {
        this.f395547d = str;
        this.f395548e = str2;
        this.f395549f = list;
        this.f395550h = str3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395547d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f395548e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f395549f, new b.f(new b.d(new i(null, null, null, false, 15, null)), false))), TuplesKt.to(4, new c45.h(4, this.f395550h, new b.e.g(false))));
        return mapOf;
    }
}
