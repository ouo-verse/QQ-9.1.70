package f25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Integer f397750d;

    /* renamed from: e, reason: collision with root package name */
    public c45.a f397751e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f397752f;

    public h() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h(null, null, null, 7, null));
    }

    public /* synthetic */ h(Integer num, c45.a aVar, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f397750d, new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f397751e, new b.e.C0167b(true))), TuplesKt.to(3, new c45.h(3, this.f397752f, new b.e.C0168e(true))));
        return mapOf;
    }

    public h(Integer num, c45.a aVar, Integer num2) {
        this.f397750d = num;
        this.f397751e = aVar;
        this.f397752f = num2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.ConfigKt.MetaType }");
            this.f397750d = (Integer) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f397751e = (c45.a) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f397752f = (Integer) obj;
        }
    }
}
