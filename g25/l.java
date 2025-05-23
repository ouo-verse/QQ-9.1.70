package g25;

import c45.b;
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
public final class l extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<m> f401180d;

    /* renamed from: e, reason: collision with root package name */
    public String f401181e;

    /* renamed from: f, reason: collision with root package name */
    public String f401182f;

    /* renamed from: h, reason: collision with root package name */
    public String f401183h;

    public l() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new l(null, null, null, null, 15, null));
    }

    public /* synthetic */ l(List list, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), "", "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f401180d, new b.f(new b.d(new m("", "")), false))), TuplesKt.to(2, new c45.h(2, this.f401181e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f401182f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f401183h, new b.e.g(false))));
        return mapOf;
    }

    public l(List<m> list, String str, String str2, String str3) {
        this.f401180d = list;
        this.f401181e = str;
        this.f401182f = str2;
        this.f401183h = str3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<m> list = this.f401180d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.RobotRecommendTag>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f401181e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f401182f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f401183h = (String) obj;
        }
    }
}
