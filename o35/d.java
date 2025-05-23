package o35;

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
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<a> f421891d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f421892e;

    /* renamed from: f, reason: collision with root package name */
    public String f421893f;

    /* renamed from: h, reason: collision with root package name */
    public m25.c f421894h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f421895i;

    public d() {
        this(null, false, null, null, false, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, false, null, null, false, 31, null));
    }

    public /* synthetic */ d(List list, boolean z16, String str, m25.c cVar, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), false, "", null, false);
    }

    public d(List<a> list, boolean z16, String str, m25.c cVar, boolean z17) {
        this.f421891d = list;
        this.f421892e = z16;
        this.f421893f = str;
        this.f421894h = cVar;
        this.f421895i = z17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421891d, new b.f(new b.d(new a(0, null, null, null, null, null, null, null, 255, null)), false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f421892e), new b.e.a(false))), TuplesKt.to(3, new c45.h(3, this.f421893f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f421894h, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(5, new c45.h(5, Boolean.valueOf(this.f421895i), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<a> list = this.f421891d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.card.Card>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f421892e = ((Boolean) obj).booleanValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421893f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f421894h = (m25.c) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f421895i = ((Boolean) obj).booleanValue();
        }
    }
}
