package a35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f25440d;

    /* renamed from: e, reason: collision with root package name */
    public int f25441e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        int i3 = 0;
        return fVar.g(new a(i3, i3, 3, null));
    }

    public /* synthetic */ a(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f25440d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f25441e), new b.e.C0168e(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f25440d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f25441e = ((Integer) obj).intValue();
        }
    }

    public a(int i3, int i16) {
        this.f25440d = i3;
        this.f25441e = i16;
    }
}
