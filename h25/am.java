package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class am extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public v f404165d;

    /* renamed from: e, reason: collision with root package name */
    public v f404166e;

    /* renamed from: f, reason: collision with root package name */
    public w f404167f;

    public am() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new am(null, null, null, 7, null));
    }

    public /* synthetic */ am(v vVar, v vVar2, w wVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null);
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.Metric");
            this.f404165d = (v) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.Metric");
            this.f404166e = (v) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.MetricChange");
            this.f404167f = (w) obj;
        }
    }

    public am(v vVar, v vVar2, w wVar) {
        this.f404165d = vVar;
        this.f404166e = vVar2;
        this.f404167f = wVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404165d, new b.d(new v(0L, 0L, 0L, 7, null)))), TuplesKt.to(2, new c45.h(2, this.f404166e, new b.d(new v(0L, 0L, 0L, 7, null)))), TuplesKt.to(3, new c45.h(3, this.f404167f, new b.d(new w(0.0f, 0.0f, 0.0f, 7, null)))));
        return mapOf;
    }
}
