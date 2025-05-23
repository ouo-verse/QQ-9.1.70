package j35;

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
    public m25.c f409217d;

    /* renamed from: e, reason: collision with root package name */
    public final List<i35.b> f409218e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f409219f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f409220h;

    public f() {
        this(null, null, false, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(null, null, false, null, 15, null));
    }

    public /* synthetic */ f(m25.c cVar, List list, boolean z16, c45.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), false, c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f409217d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, this.f409218e, new b.f(new b.d(new i35.b(0L, 0, null, 0L, 0L, 0L, null, 127, null)), false))), TuplesKt.to(3, new c45.h(3, Boolean.valueOf(this.f409219f), new b.e.a(false))), TuplesKt.to(4, new c45.h(4, this.f409220h, new b.e.C0167b(false))));
        return mapOf;
    }

    public f(m25.c cVar, List<i35.b> list, boolean z16, c45.a aVar) {
        this.f409217d = cVar;
        this.f409218e = list;
        this.f409219f = z16;
        this.f409220h = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f409217d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            List<i35.b> list = this.f409218e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan_ext.common.interact_msg.InteractMsg>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f409219f = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f409220h = (c45.a) obj;
        }
    }
}
