package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class as extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f404180d;

    /* renamed from: e, reason: collision with root package name */
    public int f404181e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public as() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        int i3 = 0;
        return fVar.g(new as(i3, i3, 3, null));
    }

    public /* synthetic */ as(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f404180d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f404181e), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404180d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404181e = ((Integer) obj).intValue();
        }
    }

    public as(int i3, int i16) {
        this.f404180d = i3;
        this.f404181e = i16;
    }
}
