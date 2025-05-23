package h25;

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
    public String f404196d;

    /* renamed from: e, reason: collision with root package name */
    public String f404197e;

    /* renamed from: f, reason: collision with root package name */
    public String f404198f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f404199h;

    public e() {
        this(null, null, null, false, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, null, null, false, 15, null));
    }

    public /* synthetic */ e(String str, String str2, String str3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", false);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404196d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f404197e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f404198f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Boolean.valueOf(this.f404199h), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404196d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404197e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404198f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f404199h = ((Boolean) obj).booleanValue();
        }
    }

    public e(String str, String str2, String str3, boolean z16) {
        this.f404196d = str;
        this.f404197e = str2;
        this.f404198f = str3;
        this.f404199h = z16;
    }
}
