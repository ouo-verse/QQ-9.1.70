package f35;

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
public final class k extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public boolean f397816d;

    /* renamed from: e, reason: collision with root package name */
    public final List<t35.b> f397817e;

    /* renamed from: f, reason: collision with root package name */
    public final List<e> f397818f;

    /* renamed from: h, reason: collision with root package name */
    public final List<String> f397819h;

    public k() {
        this(false, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(false, null, null, null, 15, null));
    }

    public /* synthetic */ k(boolean z16, List list, List list2, List list3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, new ArrayList(), new ArrayList(), new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Boolean.valueOf(this.f397816d), new b.e.a(false))), TuplesKt.to(2, new c45.h(2, this.f397817e, new b.f(new b.d(new t35.b(0, null, null, null, 15, null)), false))), TuplesKt.to(3, new c45.h(3, this.f397818f, new b.f(new b.d(new e(0, null, 3, 0 == true ? 1 : 0)), false))), TuplesKt.to(4, new c45.h(4, this.f397819h, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    public k(boolean z16, List<t35.b> list, List<e> list2, List<String> list3) {
        this.f397816d = z16;
        this.f397817e = list;
        this.f397818f = list2;
        this.f397819h = list3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f397816d = ((Boolean) obj).booleanValue();
            return;
        }
        if (i3 == 2) {
            List<t35.b> list = this.f397817e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.TagTab>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            List<e> list2 = this.f397818f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.user_manager_svr.user_manager_svr.IDCardTagIcon>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        } else {
            if (i3 != 4) {
                return;
            }
            List<String> list3 = this.f397819h;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
        }
    }
}
