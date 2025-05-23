package f35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f397792d;

    /* renamed from: e, reason: collision with root package name */
    public String f397793e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f397794f;

    public d() {
        this(null, null, false, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, null, false, 7, null));
    }

    public /* synthetic */ d(m25.c cVar, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "", false);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f397792d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, this.f397793e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Boolean.valueOf(this.f397794f), new b.e.a(false))));
        return mapOf;
    }

    public d(m25.c cVar, String str, boolean z16) {
        this.f397792d = cVar;
        this.f397793e = str;
        this.f397794f = z16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f397792d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397793e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f397794f = ((Boolean) obj).booleanValue();
        }
    }
}
