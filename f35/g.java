package f35;

import c45.b;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends c45.j {
    public boolean C;
    public m25.g D;
    public j E;
    public k F;

    /* renamed from: d, reason: collision with root package name */
    public m25.c f397800d;

    /* renamed from: e, reason: collision with root package name */
    public r25.e f397801e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f397802f;

    /* renamed from: h, reason: collision with root package name */
    public v35.e f397803h;

    /* renamed from: i, reason: collision with root package name */
    public l f397804i;

    /* renamed from: m, reason: collision with root package name */
    public m25.f f397805m;

    public g() {
        this(null, null, false, null, null, null, false, null, null, null, 1023, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, null, false, null, null, null, false, null, null, null, 1023, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.f397800d = (m25.c) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.User");
                this.f397801e = (r25.e) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f397802f = ((Boolean) obj).booleanValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.GetConfigRsp");
                this.f397803h = (v35.e) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.user_manager_svr.user_manager_svr.VerifyInfo");
                this.f397804i = (l) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.Response");
                this.f397805m = (m25.f) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.C = ((Boolean) obj).booleanValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.TipInfo");
                this.D = (m25.g) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.user_manager_svr.user_manager_svr.NewUserConfig");
                this.E = (j) obj;
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.user_manager_svr.user_manager_svr.OldUserConfig");
                this.F = (k) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ g(m25.c cVar, r25.e eVar, boolean z16, v35.e eVar2, l lVar, m25.f fVar, boolean z17, m25.g gVar, j jVar, k kVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, false, null, null, null, false, null, null, null);
    }

    public g(m25.c cVar, r25.e eVar, boolean z16, v35.e eVar2, l lVar, m25.f fVar, boolean z17, m25.g gVar, j jVar, k kVar) {
        this.f397800d = cVar;
        this.f397801e = eVar;
        this.f397802f = z16;
        this.f397803h = eVar2;
        this.f397804i = lVar;
        this.f397805m = fVar;
        this.C = z17;
        this.D = gVar;
        this.E = jVar;
        this.F = kVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        Pair pair = TuplesKt.to(1, new c45.h(1, this.f397800d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15))));
        int i3 = 0;
        List list = null;
        int i16 = 3;
        m25.g gVar = this.D;
        byte b16 = 0 == true ? 1 : 0;
        j jVar = this.E;
        byte b17 = 0 == true ? 1 : 0;
        byte b18 = 0 == true ? 1 : 0;
        mapOf = MapsKt__MapsKt.mapOf(pair, TuplesKt.to(2, new c45.h(2, this.f397801e, new b.d(new r25.e(0L, list, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)))), TuplesKt.to(3, new c45.h(3, Boolean.valueOf(this.f397802f), new b.e.a(false))), TuplesKt.to(4, new c45.h(4, this.f397803h, new b.d(new v35.e(false, null, list, null, null, 31, null)))), TuplesKt.to(5, new c45.h(5, this.f397804i, new b.d(new l(i3, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(6, new c45.h(6, this.f397805m, new b.d(new m25.f(i3, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(7, new c45.h(7, Boolean.valueOf(this.C), new b.e.a(false))), TuplesKt.to(8, new c45.h(8, gVar, new b.d(new m25.g(0, b16, null, 7, 0 == true ? 1 : 0)))), TuplesKt.to(9, new c45.h(9, jVar, new b.d(new j(0 == true ? 1 : 0, b17, 0 == true ? 1 : 0, null, b18, null, 63, null)))), TuplesKt.to(10, new c45.h(10, this.F, new b.d(new k(false, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 15, 0 == true ? 1 : 0)))));
        return mapOf;
    }
}
