package f25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f397738d;

    /* renamed from: e, reason: collision with root package name */
    public String f397739e;

    /* renamed from: f, reason: collision with root package name */
    public String f397740f;

    /* renamed from: h, reason: collision with root package name */
    public String f397741h;

    /* renamed from: i, reason: collision with root package name */
    public String f397742i;

    /* renamed from: m, reason: collision with root package name */
    public String f397743m;

    public e() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, null, null, null, null, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f397738d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f397739e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f397740f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f397741h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f397742i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f397743m = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ e(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f397738d, new b.e.g(true))), TuplesKt.to(2, new c45.h(2, this.f397739e, new b.e.g(true))), TuplesKt.to(3, new c45.h(3, this.f397740f, new b.e.g(true))), TuplesKt.to(4, new c45.h(4, this.f397741h, new b.e.g(true))), TuplesKt.to(5, new c45.h(5, this.f397742i, new b.e.g(true))), TuplesKt.to(6, new c45.h(6, this.f397743m, new b.e.g(true))));
        return mapOf;
    }

    public e(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f397738d = str;
        this.f397739e = str2;
        this.f397740f = str3;
        this.f397741h = str4;
        this.f397742i = str5;
        this.f397743m = str6;
    }
}
