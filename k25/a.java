package k25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f411440d;

    /* renamed from: e, reason: collision with root package name */
    public c f411441e;

    public a(m25.c cVar, c cVar2) {
        this.f411440d = cVar;
        this.f411441e = cVar2;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, null));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f411440d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new h(2, this.f411441e, new b.d(new c(0, 0, 0, 15)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f411440d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.attendance_svr.attendance.Date");
            this.f411441e = (c) obj;
        }
    }
}
