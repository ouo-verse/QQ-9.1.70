package m25;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public b f416054d;

    /* renamed from: e, reason: collision with root package name */
    public c45.a f416055e;

    /* renamed from: f, reason: collision with root package name */
    public d f416056f;

    /* renamed from: h, reason: collision with root package name */
    public a f416057h;

    public c() {
        this(null, 0 == true ? 1 : 0, 15);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, 0 == true ? 1 : 0, 15));
    }

    public /* synthetic */ c(b bVar, c45.a aVar, int i3) {
        this((i3 & 1) != 0 ? null : bVar, (i3 & 2) != 0 ? c45.a.f30290b : aVar, null, null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        int i3 = 3;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f416054d, new b.d(new b(null, null, 0, 7, null)))), TuplesKt.to(2, new h(2, this.f416055e, new b.e.C0167b(false))), TuplesKt.to(3, new h(3, this.f416056f, new b.d(new d(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(4, new h(4, this.f416057h, new b.d(new a(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))));
        return mapOf;
    }

    public c(b bVar, c45.a aVar, d dVar, a aVar2) {
        this.f416054d = bVar;
        this.f416055e = aVar;
        this.f416056f = dVar;
        this.f416057h = aVar2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.ClientInfo");
            this.f416054d = (b) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f416055e = (c45.a) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.Entry");
            this.f416056f = (d) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.BytesEntry");
            this.f416057h = (a) obj;
        }
    }
}
