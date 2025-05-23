package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class m extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f425190d;

    /* renamed from: e, reason: collision with root package name */
    public int f425191e;

    /* renamed from: f, reason: collision with root package name */
    public String f425192f;

    public m() {
        this(null, 0, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new m(null, 0, null, 7, null));
    }

    public /* synthetic */ m(m25.c cVar, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(2, new c45.h(2, this.f425190d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f425191e), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f425192f, new b.e.g(false))));
        return mapOf;
    }

    public m(m25.c cVar, int i3, String str) {
        this.f425190d = cVar;
        this.f425191e = i3;
        this.f425192f = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425190d = (m25.c) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425191e = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425192f = (String) obj;
        }
    }
}
