package h25;

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

    /* renamed from: d, reason: collision with root package name */
    public al f404136d;

    /* renamed from: e, reason: collision with root package name */
    public final List<u> f404137e;

    public ad() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ad(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ ad(al alVar, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList());
    }

    public ad(al alVar, List<u> list) {
        this.f404136d = alVar;
        this.f404137e = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404136d, new b.d(new al(0L, null, null, null, null, null, null, null, null, null, null, 2047, null)))), TuplesKt.to(2, new c45.h(2, this.f404137e, new b.f(new b.d(new u(0, null, null, null, 15, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.RobotInfo");
            this.f404136d = (al) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            List<u> list = this.f404137e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.IdentityInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
