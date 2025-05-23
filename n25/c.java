package n25;

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
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f418050d;

    /* renamed from: e, reason: collision with root package name */
    public final List<d> f418051e;

    /* renamed from: f, reason: collision with root package name */
    public String f418052f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f418053h;

    public c() {
        this(0, null, null, false, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(0, null, null, false, 15, null));
    }

    public /* synthetic */ c(int i3, List list, String str, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, new ArrayList(), "", false);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418050d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f418051e, new b.f(new b.d(new d()), false))), TuplesKt.to(3, new c45.h(3, this.f418052f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Boolean.valueOf(this.f418053h), new b.e.a(false))));
        return mapOf;
    }

    public c(int i3, List<d> list, String str, boolean z16) {
        this.f418050d = i3;
        this.f418051e = list;
        this.f418052f = str;
        this.f418053h = z16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f418050d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            List<d> list = this.f418051e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.CommentInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418052f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f418053h = ((Boolean) obj).booleanValue();
        }
    }
}
