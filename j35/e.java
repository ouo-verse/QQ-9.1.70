package j35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f409214d;

    /* renamed from: e, reason: collision with root package name */
    public int f409215e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f409216f;

    public e(m25.c cVar, int i3, c45.a aVar) {
        this.f409214d = cVar;
        this.f409215e = i3;
        this.f409216f = aVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, 0, c45.a.f30290b));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f409214d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f409215e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f409216f, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f409214d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f409215e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f409216f = (c45.a) obj;
        }
    }
}
