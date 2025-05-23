package o25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f421860d;

    /* renamed from: e, reason: collision with root package name */
    public int f421861e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        int i3 = 0;
        return fVar.g(new h(i3, i3, 3, null));
    }

    public /* synthetic */ h(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f421860d), new b.e.C0168e(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f421861e), new b.e.C0168e(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f421860d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f421861e = ((Integer) obj).intValue();
        }
    }

    public h(int i3, int i16) {
        this.f421860d = i3;
        this.f421861e = i16;
    }
}
