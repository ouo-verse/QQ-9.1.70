package f35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f397806d;

    /* renamed from: e, reason: collision with root package name */
    public o25.e f397807e;

    /* renamed from: f, reason: collision with root package name */
    public String f397808f;

    public h(m25.c cVar, o25.e eVar, String str) {
        this.f397806d = cVar;
        this.f397807e = eVar;
        this.f397808f = str;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h(null, null, ""));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f397806d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f397807e, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(3, new c45.h(3, this.f397808f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f397806d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f397807e = (o25.e) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397808f = (String) obj;
        }
    }
}
