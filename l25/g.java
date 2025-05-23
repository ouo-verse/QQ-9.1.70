package l25;

import c45.b;
import com.tencent.mobileqq.startup.step.InitSkin;
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
    public final List<h> f413762d;

    /* renamed from: e, reason: collision with root package name */
    public final List<e> f413763e;

    public g() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ g(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f413762d, new b.f(new b.d(new h(0, null, null, 7, null)), false))), TuplesKt.to(2, new c45.h(2, this.f413763e, new b.f(new b.d(new e(0, 0, null, 0 == true ? 1 : 0, null, null, null, null, null, 0, 0, false, false, InitSkin.DRAWABLE_COUNT, null)), false))));
        return mapOf;
    }

    public g(List<h> list, List<e> list2) {
        this.f413762d = list;
        this.f413763e = list2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<h> list = this.f413762d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChRichTextContent>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 2) {
                return;
            }
            List<e> list2 = this.f413763e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChImage>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        }
    }
}
