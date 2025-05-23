package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f404203d;

    /* renamed from: e, reason: collision with root package name */
    public int f404204e;

    /* renamed from: f, reason: collision with root package name */
    public String f404205f;

    public g() {
        this(0, 0, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(0, 0, null, 7, null));
    }

    public /* synthetic */ g(int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f404203d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f404204e), new b.e.C0168e(false))), TuplesKt.to(3, new c45.h(3, this.f404205f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404203d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404204e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404205f = (String) obj;
        }
    }

    public g(int i3, int i16, String str) {
        this.f404203d = i3;
        this.f404204e = i16;
        this.f404205f = str;
    }
}
