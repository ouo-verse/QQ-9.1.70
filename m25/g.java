package m25;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f416064d;

    /* renamed from: e, reason: collision with root package name */
    public String f416065e;

    /* renamed from: f, reason: collision with root package name */
    public String f416066f;

    public g() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new g(0, null, null, 7, null));
    }

    public /* synthetic */ g(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f416064d), new b.e.h(false))), TuplesKt.to(2, new h(2, this.f416065e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f416066f, new b.e.g(false))));
        return mapOf;
    }

    public g(int i3, String str, String str2) {
        this.f416064d = i3;
        this.f416065e = str;
        this.f416066f = str2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f416064d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f416065e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f416066f = (String) obj;
        }
    }
}
