package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f395468d;

    /* renamed from: e, reason: collision with root package name */
    public String f395469e;

    /* renamed from: f, reason: collision with root package name */
    public String f395470f;

    public b() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, null, null, 7, null));
    }

    public /* synthetic */ b(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395468d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f395469e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f395470f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395468d = (String) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395469e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395470f = (String) obj;
        }
    }

    public b(String str, String str2, String str3) {
        this.f395468d = str;
        this.f395469e = str2;
        this.f395470f = str3;
    }
}
