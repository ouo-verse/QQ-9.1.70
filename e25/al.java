package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class al extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public boolean f395467d;

    public al() {
        this(false, 1, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new al(false, 1, null));
    }

    public /* synthetic */ al(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, Boolean.valueOf(this.f395467d), new b.e.a(false))));
        return mapOf;
    }

    public al(boolean z16) {
        this.f395467d = z16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f395467d = ((Boolean) obj).booleanValue();
        }
    }
}
