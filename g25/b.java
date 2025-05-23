package g25;

import c45.b;
import c45.d;
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
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f401138d;

    /* renamed from: e, reason: collision with root package name */
    public final List<a> f401139e;

    public b() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(0, null, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ b(int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f401138d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f401139e, new b.f(new b.d(new a(null, null, null, null, null, 0, 63, null)), false))));
        return mapOf;
    }

    public b(int i3, List<a> list) {
        this.f401138d = i3;
        this.f401139e = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.ListKt.AdelieCardType }");
            this.f401138d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            List<a> list = this.f401139e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.AdelieCardInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
