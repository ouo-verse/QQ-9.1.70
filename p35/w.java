package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class w extends c45.j {
    public m25.c C;
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public int f425219d;

    /* renamed from: e, reason: collision with root package name */
    public int f425220e;

    /* renamed from: f, reason: collision with root package name */
    public String f425221f;

    /* renamed from: h, reason: collision with root package name */
    public String f425222h;

    /* renamed from: i, reason: collision with root package name */
    public String f425223i;

    /* renamed from: m, reason: collision with root package name */
    public int f425224m;

    public w(int i3, int i16, String str, String str2, String str3, int i17, m25.c cVar, String str4) {
        this.f425219d = i3;
        this.f425220e = i16;
        this.f425221f = str;
        this.f425222h = str2;
        this.f425223i = str3;
        this.f425224m = i17;
        this.C = cVar;
        this.D = str4;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new w(0, 0, "", "", "", 0, null, ""));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425219d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425220e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425221f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425222h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425223i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425224m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.C = (m25.c) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.D = (String) obj;
                return;
            default:
                return;
        }
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f425219d), new b.e.C0168e(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f425220e), new b.e.C0168e(false))), TuplesKt.to(3, new c45.h(3, this.f425221f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f425222h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f425223i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f425224m), new b.e.h(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))));
        return mapOf;
    }
}
