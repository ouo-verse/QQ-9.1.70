package o35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends c45.j {
    public String C;

    /* renamed from: d, reason: collision with root package name */
    public long f421904d;

    /* renamed from: e, reason: collision with root package name */
    public String f421905e;

    /* renamed from: f, reason: collision with root package name */
    public String f421906f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f421907h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f421908i;

    /* renamed from: m, reason: collision with root package name */
    public String f421909m;

    public g() {
        this(0L, null, null, null, false, null, null, 127, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(0L, null, null, null, false, null, null, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f421904d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421905e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421906f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f421907h = (c45.a) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f421908i = ((Boolean) obj).booleanValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421909m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ g(long j3, String str, String str2, c45.a aVar, boolean z16, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", c45.a.f30290b, false, "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f421904d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f421905e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f421906f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f421907h, new b.e.C0167b(false))), TuplesKt.to(5, new c45.h(5, Boolean.valueOf(this.f421908i), new b.e.a(false))), TuplesKt.to(6, new c45.h(6, this.f421909m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))));
        return mapOf;
    }

    public g(long j3, String str, String str2, c45.a aVar, boolean z16, String str3, String str4) {
        this.f421904d = j3;
        this.f421905e = str;
        this.f421906f = str2;
        this.f421907h = aVar;
        this.f421908i = z16;
        this.f421909m = str3;
        this.C = str4;
    }
}
