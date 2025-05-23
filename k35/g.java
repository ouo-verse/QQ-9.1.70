package k35;

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
public final class g extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<j> f411548d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f411549e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f411550f;

    public g() {
        this(null, false, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, false, null, 7, null));
    }

    public /* synthetic */ g(List list, boolean z16, c45.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), false, c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f411548d, new b.f(new b.d(new j(0L, null, null, 0L, 0L, null, 0L, null, null, null, 0, 2047, null)), false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f411549e), new b.e.a(false))), TuplesKt.to(3, new c45.h(3, this.f411550f, new b.e.C0167b(false))));
        return mapOf;
    }

    public g(List<j> list, boolean z16, c45.a aVar) {
        this.f411548d = list;
        this.f411549e = z16;
        this.f411550f = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<j> list = this.f411548d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan_ext.mood_svr.mood_svr.InteractUser>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f411549e = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f411550f = (c45.a) obj;
        }
    }
}
