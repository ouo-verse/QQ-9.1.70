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
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f421838d;

    /* renamed from: e, reason: collision with root package name */
    public int f421839e;

    /* renamed from: f, reason: collision with root package name */
    public int f421840f;

    public c() {
        this(null, 0, 0, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, 0, 0, 7, null));
    }

    public /* synthetic */ c(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421838d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f421839e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f421840f), new b.e.h(false))));
        return mapOf;
    }

    public c(String str, int i3, int i16) {
        this.f421838d = str;
        this.f421839e = i3;
        this.f421840f = i16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421838d = (String) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f421839e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f421840f = ((Integer) obj).intValue();
        }
    }
}
