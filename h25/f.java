package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f404200d;

    /* renamed from: e, reason: collision with root package name */
    public int f404201e;

    /* renamed from: f, reason: collision with root package name */
    public int f404202f;

    public f() {
        this(null, 0, 0, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(null, 0, 0, 7, null));
    }

    public /* synthetic */ f(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404200d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f404201e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f404202f), new b.e.h(false))));
        return mapOf;
    }

    public f(String str, int i3, int i16) {
        this.f404200d = str;
        this.f404201e = i3;
        this.f404202f = i16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404200d = (String) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404201e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404202f = ((Integer) obj).intValue();
        }
    }
}
