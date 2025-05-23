package o25;

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
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f421841d;

    /* renamed from: e, reason: collision with root package name */
    public final List<String> f421842e;

    /* renamed from: f, reason: collision with root package name */
    public int f421843f;

    /* renamed from: h, reason: collision with root package name */
    public final List<String> f421844h;

    /* renamed from: i, reason: collision with root package name */
    public String f421845i;

    public d() {
        this(null, null, 0, null, null, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, null, 0, null, null, 31, null));
    }

    public /* synthetic */ d(String str, List list, int i3, List list2, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", new ArrayList(), 0, new ArrayList(), "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421841d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f421842e, new b.f(new b.e.g(false), false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f421843f), new b.e.C0168e(false))), TuplesKt.to(4, new c45.h(4, this.f421844h, new b.f(new b.e.g(false), false))), TuplesKt.to(5, new c45.h(5, this.f421845i, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421841d = (String) obj;
            return;
        }
        if (i3 == 2) {
            List<String> list = this.f421842e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f421843f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            List<String> list2 = this.f421844h;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421845i = (String) obj;
        }
    }

    public d(String str, List<String> list, int i3, List<String> list2, String str2) {
        this.f421841d = str;
        this.f421842e = list;
        this.f421843f = i3;
        this.f421844h = list2;
        this.f421845i = str2;
    }
}
