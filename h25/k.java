package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public x f404214d;

    /* renamed from: e, reason: collision with root package name */
    public f f404215e;

    public k() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ k(x xVar, f fVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public k(x xVar, f fVar) {
        this.f404214d = xVar;
        this.f404215e = fVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404214d, new b.d(new x(null, null, null, null, null, 0, null, 65535)))), TuplesKt.to(2, new c45.h(2, this.f404215e, new b.d(new f(null, 0, 0, 7, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.MyBotInfo");
            this.f404214d = (x) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.AsyncTask");
            this.f404215e = (f) obj;
        }
    }
}
