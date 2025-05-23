package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class t extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f425213d;

    /* renamed from: e, reason: collision with root package name */
    public String f425214e;

    /* renamed from: f, reason: collision with root package name */
    public n f425215f;

    /* renamed from: h, reason: collision with root package name */
    public m25.c f425216h;

    public t() {
        this(0, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new t(0, null, null, null, 15, null));
    }

    public /* synthetic */ t(int i3, String str, n nVar, m25.c cVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null, null);
    }

    public t(int i3, String str, n nVar, m25.c cVar) {
        this.f425213d = i3;
        this.f425214e = str;
        this.f425215f = nVar;
        this.f425216h = cVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f425213d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f425214e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f425215f, new b.d(new n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287)))), TuplesKt.to(4, new c45.h(4, this.f425216h, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425213d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425214e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.Feed");
            this.f425215f = (n) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425216h = (m25.c) obj;
        }
    }
}
