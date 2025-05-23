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
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f416051d;

    /* renamed from: e, reason: collision with root package name */
    public String f416052e;

    /* renamed from: f, reason: collision with root package name */
    public int f416053f;

    public b() {
        this(null, null, 0, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, null, 0, 7, null));
    }

    public /* synthetic */ b(String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", 0);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f416051d, new b.e.g(false))), TuplesKt.to(2, new h(2, this.f416052e, new b.e.g(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f416053f), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f416051d = (String) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f416052e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f416053f = ((Integer) obj).intValue();
        }
    }

    public b(String str, String str2, int i3) {
        this.f416051d = str;
        this.f416052e = str2;
        this.f416053f = i3;
    }
}
