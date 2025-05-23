package e25;

import c45.b;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<i> f395485d;

    public k() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ k(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395485d, new b.f(new b.d(new i(0L, null, 0L, null, null, 0, null, null, null, null, 0, null, 0L, InitSkin.DRAWABLE_COUNT, null)), false))));
        return mapOf;
    }

    public k(List<i> list) {
        this.f395485d = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<i> list = this.f395485d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.FlowerState>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
