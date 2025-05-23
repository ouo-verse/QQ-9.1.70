package j35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends c45.j {
    public j C;

    /* renamed from: d, reason: collision with root package name */
    public m25.c f409207d;

    /* renamed from: e, reason: collision with root package name */
    public int f409208e;

    /* renamed from: f, reason: collision with root package name */
    public b f409209f;

    /* renamed from: h, reason: collision with root package name */
    public k f409210h;

    /* renamed from: i, reason: collision with root package name */
    public i f409211i;

    /* renamed from: m, reason: collision with root package name */
    public a f409212m;

    public c() {
        this(0, (b) null, (k) null, (i) null, (a) null, (j) null, 127);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(0, (b) null, (k) null, (i) null, (a) null, (j) null, 127));
    }

    public /* synthetic */ c(int i3, b bVar, k kVar, i iVar, a aVar, j jVar, int i16) {
        this((m25.c) null, (i16 & 2) != 0 ? d.c.f30317b.b().getValue() : i3, (i16 & 4) != 0 ? null : bVar, (i16 & 8) != 0 ? null : kVar, (i16 & 16) != 0 ? null : iVar, (i16 & 32) != 0 ? null : aVar, (i16 & 64) != 0 ? null : jVar);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 0;
        int i16 = 3;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f409207d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f409208e), new b.a(false))), TuplesKt.to(3, new c45.h(3, this.f409209f, new b.d(new b(0 == true ? 1 : 0, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(4, new c45.h(4, this.f409210h, new b.d(new k(0L, 0 == true ? 1 : 0, i16)))), TuplesKt.to(5, new c45.h(5, this.f409211i, new b.d(new i(i3, i16)))), TuplesKt.to(6, new c45.h(6, this.f409212m, new b.d(new a(i3, i16)))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new j(null)))));
        return mapOf;
    }

    public c(m25.c cVar, int i3, b bVar, k kVar, i iVar, a aVar, j jVar) {
        this.f409207d = cVar;
        this.f409208e = i3;
        this.f409209f = bVar;
        this.f409210h = kVar;
        this.f409211i = iVar;
        this.f409212m = aVar;
        this.C = jVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.f409207d = (m25.c) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.Interact_svrKt.MsgType }");
                this.f409208e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.FeedShareInfo");
                this.f409209f = (b) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.UserShareInfo");
                this.f409210h = (k) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.MoodShareInfo");
                this.f409211i = (i) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.AttendanceShareInfo");
                this.f409212m = (a) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.PoiShareInfo");
                this.C = (j) obj;
                return;
            default:
                return;
        }
    }
}
