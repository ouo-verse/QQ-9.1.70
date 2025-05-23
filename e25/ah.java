package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ah extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f395452d;

    /* renamed from: e, reason: collision with root package name */
    public String f395453e;

    /* renamed from: f, reason: collision with root package name */
    public String f395454f;

    /* renamed from: h, reason: collision with root package name */
    public String f395455h;

    public ah() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ah(null, null, null, null, 15, null));
    }

    public /* synthetic */ ah(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395452d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f395453e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f395454f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f395455h, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395452d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395453e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395454f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395455h = (String) obj;
        }
    }

    public ah(String str, String str2, String str3, String str4) {
        this.f395452d = str;
        this.f395453e = str2;
        this.f395454f = str3;
        this.f395455h = str4;
    }
}
