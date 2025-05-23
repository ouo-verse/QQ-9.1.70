package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class s extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public ab f395500d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f395501e;

    public s() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new s(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ s(ab abVar, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395500d, new b.d(new ab(null, null, 3, null)))), TuplesKt.to(2, new c45.h(2, this.f395501e, new b.e.a(true))));
        return mapOf;
    }

    public s(ab abVar, Boolean bool) {
        this.f395500d = abVar;
        this.f395501e = bool;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.ScreenCoord");
            this.f395500d = (ab) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f395501e = (Boolean) obj;
        }
    }
}
