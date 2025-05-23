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
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<g> f421899d;

    /* renamed from: e, reason: collision with root package name */
    public long f421900e;

    /* renamed from: f, reason: collision with root package name */
    public String f421901f;

    /* renamed from: h, reason: collision with root package name */
    public String f421902h;

    /* renamed from: i, reason: collision with root package name */
    public String f421903i;

    public f() {
        this(null, 0L, null, null, null, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(null, 0L, null, null, null, 31, null));
    }

    public /* synthetic */ f(List list, long j3, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), 0L, "", "", "");
    }

    public f(List<g> list, long j3, String str, String str2, String str3) {
        this.f421899d = list;
        this.f421900e = j3;
        this.f421901f = str;
        this.f421902h = str2;
        this.f421903i = str3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421899d, new b.f(new b.d(new g(0L, null, null, null, false, null, null, 127, null)), false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f421900e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, this.f421901f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f421902h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f421903i, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<g> list = this.f421899d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.card.InteractUser>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f421900e = ((Long) obj).longValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421901f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421902h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421903i = (String) obj;
        }
    }
}
