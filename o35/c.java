package o35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n25.k;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f421886d;

    /* renamed from: e, reason: collision with root package name */
    public o25.e f421887e;

    /* renamed from: f, reason: collision with root package name */
    public k f421888f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f421889h;

    /* renamed from: i, reason: collision with root package name */
    public m25.c f421890i;

    public c(String str, o25.e eVar, k kVar, c45.a aVar, m25.c cVar) {
        this.f421886d = str;
        this.f421887e = eVar;
        this.f421888f = kVar;
        this.f421889h = aVar;
        this.f421890i = cVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c("", null, null, c45.a.f30290b, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421886d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f421887e, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(3, new c45.h(3, this.f421888f, new b.d(new k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))), TuplesKt.to(4, new c45.h(4, this.f421889h, new b.e.C0167b(false))), TuplesKt.to(5, new c45.h(5, this.f421890i, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421886d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f421887e = (o25.e) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
            this.f421888f = (k) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f421889h = (c45.a) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f421890i = (m25.c) obj;
        }
    }
}
