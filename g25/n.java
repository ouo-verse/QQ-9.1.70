package g25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public c45.a f401186d;

    /* renamed from: e, reason: collision with root package name */
    public String f401187e;

    public n() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new n(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ n(c45.a aVar, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(c45.a.f30290b, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f401186d, new b.e.C0167b(false))), TuplesKt.to(2, new c45.h(2, this.f401187e, new b.e.g(false))));
        return mapOf;
    }

    public n(c45.a aVar, String str) {
        this.f401186d = aVar;
        this.f401187e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f401186d = (c45.a) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f401187e = (String) obj;
        }
    }
}
