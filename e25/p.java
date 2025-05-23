package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Long f395493d;

    /* renamed from: e, reason: collision with root package name */
    public Long f395494e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f395495f;

    /* renamed from: h, reason: collision with root package name */
    public Long f395496h;

    public /* synthetic */ p(Integer num, int i3) {
        this(null, null, (i3 & 4) != 0 ? null : num, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new p(null, 15));
    }

    public p(Long l3, Long l16, Integer num, Long l17) {
        this.f395493d = l3;
        this.f395494e = l16;
        this.f395495f = num;
        this.f395496h = l17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395493d, new b.e.i(true))), TuplesKt.to(2, new c45.h(2, this.f395494e, new b.e.i(true))), TuplesKt.to(3, new c45.h(3, this.f395495f, new b.a(false))), TuplesKt.to(4, new c45.h(4, this.f395496h, new b.e.i(true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395493d = (Long) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395494e = (Long) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.intimate_space.social_tree.Intimate_space_eventKt.TreeState }");
            this.f395495f = (Integer) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395496h = (Long) obj;
        }
    }
}
