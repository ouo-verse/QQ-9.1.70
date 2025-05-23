package e25;

import c45.b;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class v extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Long f395506d;

    /* renamed from: e, reason: collision with root package name */
    public i f395507e;

    public v() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new v(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ v(Long l3, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public v(Long l3, i iVar) {
        this.f395506d = l3;
        this.f395507e = iVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395506d, new b.e.i(true))), TuplesKt.to(2, new c45.h(2, this.f395507e, new b.d(new i(0L, null, 0L, null, null, 0, null, null, null, null, 0, null, 0L, InitSkin.DRAWABLE_COUNT, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395506d = (Long) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.FlowerState");
            this.f395507e = (i) obj;
        }
    }
}
