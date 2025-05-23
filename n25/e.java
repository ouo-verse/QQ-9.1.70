package n25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418060d;

    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ e(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418060d, new b.e.g(false))));
        return mapOf;
    }

    public e(String str) {
        this.f418060d = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418060d = (String) obj;
        }
    }
}
