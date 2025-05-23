package f25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f397755d;

    /* renamed from: e, reason: collision with root package name */
    public String f397756e;

    /* renamed from: f, reason: collision with root package name */
    public String f397757f;

    /* renamed from: h, reason: collision with root package name */
    public String f397758h;

    public j() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j(null, null, null, null, 15, null));
    }

    public /* synthetic */ j(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f397755d, new b.e.g(true))), TuplesKt.to(2, new c45.h(2, this.f397756e, new b.e.g(true))), TuplesKt.to(3, new c45.h(3, this.f397757f, new b.e.g(true))), TuplesKt.to(4, new c45.h(4, this.f397758h, new b.e.g(true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397755d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397756e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397757f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397758h = (String) obj;
        }
    }

    public j(String str, String str2, String str3, String str4) {
        this.f397755d = str;
        this.f397756e = str2;
        this.f397757f = str3;
        this.f397758h = str4;
    }
}
