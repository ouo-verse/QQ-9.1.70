package j35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import x25.m;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m f409227d;

    public j() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ j(m mVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f409227d, new b.d(new m(null, null, 0L, null, 0L, null, false, null, null, 0L, null, 0, null, null, 16383, null)))));
        return mapOf;
    }

    public j(m mVar) {
        this.f409227d = mVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.poi_svr.poi_svr.PoiData");
            this.f409227d = (m) obj;
        }
    }
}
