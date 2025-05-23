package i25;

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
/* loaded from: classes38.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f407129d;

    /* renamed from: e, reason: collision with root package name */
    public String f407130e;

    public c() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(0, null, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ c(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f407129d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, this.f407130e, new b.e.g(false))));
        return mapOf;
    }

    public c(int i3, String str) {
        this.f407129d = i3;
        this.f407130e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f407129d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f407130e = (String) obj;
        }
    }
}
