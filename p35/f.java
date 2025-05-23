package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f425165d;

    /* renamed from: e, reason: collision with root package name */
    public String f425166e;

    /* renamed from: f, reason: collision with root package name */
    public m25.c f425167f;

    /* renamed from: h, reason: collision with root package name */
    public String f425168h;

    public f() {
        this(0, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(0, null, null, null, 15, null));
    }

    public /* synthetic */ f(int i3, String str, m25.c cVar, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f425165d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f425166e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f425167f, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(4, new c45.h(4, this.f425168h, new b.e.g(false))));
        return mapOf;
    }

    public f(int i3, String str, m25.c cVar, String str2) {
        this.f425165d = i3;
        this.f425166e = str;
        this.f425167f = cVar;
        this.f425168h = str2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425165d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425166e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425167f = (m25.c) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425168h = (String) obj;
        }
    }
}
