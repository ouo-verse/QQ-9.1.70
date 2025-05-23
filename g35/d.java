package g35;

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
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f401213d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f401214e;

    public d(m25.c cVar, boolean z16) {
        this.f401213d = cVar;
        this.f401214e = z16;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new d(null, false));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f401213d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new h(2, Boolean.valueOf(this.f401214e), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f401213d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f401214e = ((Boolean) obj).booleanValue();
        }
    }
}
