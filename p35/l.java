package p35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class l extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f425185d;

    /* renamed from: e, reason: collision with root package name */
    public String f425186e;

    /* renamed from: f, reason: collision with root package name */
    public String f425187f;

    /* renamed from: h, reason: collision with root package name */
    public int f425188h;

    /* renamed from: i, reason: collision with root package name */
    public m25.c f425189i;

    public l(int i3, String str, String str2, int i16, m25.c cVar) {
        this.f425185d = i3;
        this.f425186e = str;
        this.f425187f = str2;
        this.f425188h = i16;
        this.f425189i = cVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new l(0, "", "", new d.c(0).getValue(), null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f425185d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f425186e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f425187f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f425188h), new b.a(false))), TuplesKt.to(5, new c45.h(5, this.f425189i, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425185d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425186e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425187f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.common.CommonKt.AccountType }");
            this.f425188h = ((Integer) obj).intValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425189i = (m25.c) obj;
        }
    }
}
