package k35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f411564d;

    /* renamed from: e, reason: collision with root package name */
    public int f411565e;

    /* renamed from: f, reason: collision with root package name */
    public o25.e f411566f;

    /* renamed from: h, reason: collision with root package name */
    public a f411567h;

    /* renamed from: i, reason: collision with root package name */
    public n25.k f411568i;

    public m(m25.c cVar, int i3, o25.e eVar, a aVar, n25.k kVar) {
        this.f411564d = cVar;
        this.f411565e = i3;
        this.f411566f = eVar;
        this.f411567h = aVar;
        this.f411568i = kVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new m(null, 0, null, null, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f411564d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f411565e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f411566f, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(4, new c45.h(4, this.f411567h, new b.d(new a(0)))), TuplesKt.to(5, new c45.h(5, this.f411568i, new b.d(new n25.k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f411564d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f411565e = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f411566f = (o25.e) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.mood_svr.mood_svr.GameData");
            this.f411567h = (a) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
            this.f411568i = (n25.k) obj;
        }
    }
}
