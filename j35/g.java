package j35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f409221d;

    /* renamed from: e, reason: collision with root package name */
    public b f409222e;

    /* renamed from: f, reason: collision with root package name */
    public k f409223f;

    public g() {
        this(0, null, 0 == true ? 1 : 0, 7);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(0, null, 0 == true ? 1 : 0, 7));
    }

    public /* synthetic */ g(int i3, b bVar, k kVar, int i16) {
        this((i16 & 1) != 0 ? d.c.f30317b.b().getValue() : i3, (i16 & 2) != 0 ? null : bVar, (i16 & 4) != 0 ? null : kVar);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 3;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f409221d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f409222e, new b.d(new b(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(3, new c45.h(3, this.f409223f, new b.d(new k(0L, 0 == true ? 1 : 0, i3)))));
        return mapOf;
    }

    public g(int i3, b bVar, k kVar) {
        this.f409221d = i3;
        this.f409222e = bVar;
        this.f409223f = kVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.Interact_svrKt.MsgType }");
            this.f409221d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.FeedShareInfo");
            this.f409222e = (b) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.interact_svr.interact_svr.UserShareInfo");
            this.f409223f = (k) obj;
        }
    }
}
