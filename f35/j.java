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
public final class j extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public boolean f397810d;

    /* renamed from: e, reason: collision with root package name */
    public final List<String> f397811e;

    /* renamed from: f, reason: collision with root package name */
    public final List<String> f397812f;

    /* renamed from: h, reason: collision with root package name */
    public final List<t35.b> f397813h;

    /* renamed from: i, reason: collision with root package name */
    public final List<e> f397814i;

    /* renamed from: m, reason: collision with root package name */
    public final List<String> f397815m;

    public j() {
        this(false, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j(false, null, null, null, null, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f397810d = ((Boolean) obj).booleanValue();
                return;
            case 2:
                List<String> list = this.f397811e;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 3:
                List<String> list2 = this.f397812f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 4:
                List<t35.b> list3 = this.f397813h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.TagTab>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            case 5:
                List<e> list4 = this.f397814i;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.user_manager_svr.user_manager_svr.IDCardTagIcon>");
                CollectionsKt__MutableCollectionsKt.addAll(list4, (Sequence) obj);
                return;
            case 6:
                List<String> list5 = this.f397815m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list5, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ j(boolean z16, List list, List list2, List list3, List list4, List list5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Boolean.valueOf(this.f397810d), new b.e.a(false))), TuplesKt.to(2, new c45.h(2, this.f397811e, new b.f(new b.e.g(false), false))), TuplesKt.to(3, new c45.h(3, this.f397812f, new b.f(new b.e.g(false), false))), TuplesKt.to(4, new c45.h(4, this.f397813h, new b.f(new b.d(new t35.b(0, null, null, null, 15, null)), false))), TuplesKt.to(5, new c45.h(5, this.f397814i, new b.f(new b.d(new e(0, null, 3, 0 == true ? 1 : 0)), false))), TuplesKt.to(6, new c45.h(6, this.f397815m, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    public j(boolean z16, List<String> list, List<String> list2, List<t35.b> list3, List<e> list4, List<String> list5) {
        this.f397810d = z16;
        this.f397811e = list;
        this.f397812f = list2;
        this.f397813h = list3;
        this.f397814i = list4;
        this.f397815m = list5;
    }
}
