package o35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends c45.j {
    public String C;
    public boolean D;

    /* renamed from: d, reason: collision with root package name */
    public int f421910d;

    /* renamed from: e, reason: collision with root package name */
    public String f421911e;

    /* renamed from: f, reason: collision with root package name */
    public String f421912f;

    /* renamed from: h, reason: collision with root package name */
    public String f421913h;

    /* renamed from: i, reason: collision with root package name */
    public String f421914i;

    /* renamed from: m, reason: collision with root package name */
    public String f421915m;

    public h() {
        this(0, null, null, null, null, null, null, false, 255, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h(0, null, null, null, null, null, null, false, 255, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f421910d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421911e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421912f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421913h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421914i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421915m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.D = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ h(int i3, String str, String str2, String str3, String str4, String str5, String str6, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", "", "", "", "", false);
    }

    public h(int i3, String str, String str2, String str3, String str4, String str5, String str6, boolean z16) {
        this.f421910d = i3;
        this.f421911e = str;
        this.f421912f = str2;
        this.f421913h = str3;
        this.f421914i = str4;
        this.f421915m = str5;
        this.C = str6;
        this.D = z16;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f421910d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f421911e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f421912f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f421913h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f421914i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f421915m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, Boolean.valueOf(this.D), new b.e.a(false))));
        return mapOf;
    }
}
