package e25;

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
public final class ad extends c45.j {
    public aa C;

    /* renamed from: d, reason: collision with root package name */
    public long f395432d;

    /* renamed from: e, reason: collision with root package name */
    public af f395433e;

    /* renamed from: f, reason: collision with root package name */
    public ah f395434f;

    /* renamed from: h, reason: collision with root package name */
    public final List<ae> f395435h;

    /* renamed from: i, reason: collision with root package name */
    public ag f395436i;

    /* renamed from: m, reason: collision with root package name */
    public long f395437m;

    public ad() {
        this(0L, null, null, null, null, 0L, null, 127, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ad(0L, null, null, null, null, 0L, null, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395432d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.TreeProgress");
                this.f395433e = (af) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.TreeTopAsset");
                this.f395434f = (ah) obj;
                return;
            case 4:
                List<ae> list = this.f395435h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.TreeBodyAsset>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.TreeRootAsset");
                this.f395436i = (ag) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395437m = ((Long) obj).longValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.SceneResource");
                this.C = (aa) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ ad(long j3, af afVar, ah ahVar, List list, ag agVar, long j16, aa aaVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, null, null, new ArrayList(), null, 0L, null);
    }

    public ad(long j3, af afVar, ah ahVar, List<ae> list, ag agVar, long j16, aa aaVar) {
        this.f395432d = j3;
        this.f395433e = afVar;
        this.f395434f = ahVar;
        this.f395435h = list;
        this.f395436i = agVar;
        this.f395437m = j16;
        this.C = aaVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f395432d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f395433e, new b.d(new af(0.0f, 0.0f, null, null, 0L, 0.0f, 0L, 127, null)))), TuplesKt.to(3, new c45.h(3, this.f395434f, new b.d(new ah(null, null, null, null, 15, null)))), TuplesKt.to(4, new c45.h(4, this.f395435h, new b.f(new b.d(new ae(0L, null, null, null, null, 0L, 0L, 0.0f, 255, null)), false))), TuplesKt.to(5, new c45.h(5, this.f395436i, new b.d(new ag(null, null, 3, null)))), TuplesKt.to(6, new c45.h(6, Long.valueOf(this.f395437m), new b.e.i(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new aa(null, null, 3, null)))));
        return mapOf;
    }
}
