package e35;

import c45.b;
import c45.d;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f395555d;

    /* renamed from: e, reason: collision with root package name */
    public int f395556e;

    /* renamed from: f, reason: collision with root package name */
    public int f395557f;

    /* renamed from: h, reason: collision with root package name */
    public int f395558h;

    public d(m25.c cVar, int i3, int i16, int i17) {
        this.f395555d = cVar;
        this.f395556e = i3;
        this.f395557f = i16;
        this.f395558h = i17;
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, new d.c(0).getValue(), 0, 0));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395555d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f395556e), new b.a(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f395557f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f395558h), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f395555d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.common.status.StatusKt.GenderType }");
            this.f395556e = ((Integer) obj).intValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f395557f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f395558h = ((Integer) obj).intValue();
        }
    }
}
