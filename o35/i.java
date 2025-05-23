package o35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f421916d;

    /* renamed from: e, reason: collision with root package name */
    public String f421917e;

    /* renamed from: f, reason: collision with root package name */
    public String f421918f;

    /* renamed from: h, reason: collision with root package name */
    public String f421919h;

    /* renamed from: i, reason: collision with root package name */
    public String f421920i;

    public i() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new i(null, null, null, null, null, 31, null));
    }

    public /* synthetic */ i(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421916d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f421917e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f421918f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f421919h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f421920i, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421916d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421917e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421918f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421919h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421920i = (String) obj;
        }
    }

    public i(String str, String str2, String str3, String str4, String str5) {
        this.f421916d = str;
        this.f421917e = str2;
        this.f421918f = str3;
        this.f421919h = str4;
        this.f421920i = str5;
    }
}
