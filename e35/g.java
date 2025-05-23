package e35;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f395568d;

    /* renamed from: e, reason: collision with root package name */
    public String f395569e;

    public g() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ g(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395568d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f395569e, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395568d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395569e = (String) obj;
        }
    }

    public g(String str, String str2) {
        this.f395568d = str;
        this.f395569e = str2;
    }
}
