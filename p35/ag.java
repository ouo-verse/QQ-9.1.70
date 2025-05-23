package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ag extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public n35.w f425139d;

    /* renamed from: e, reason: collision with root package name */
    public String f425140e;

    /* renamed from: f, reason: collision with root package name */
    public int f425141f;

    /* renamed from: h, reason: collision with root package name */
    public int f425142h;

    public ag() {
        this(null, 15);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ag(null, 15));
    }

    public /* synthetic */ ag(n35.w wVar, int i3) {
        this((i3 & 1) != 0 ? null : wVar, (i3 & 2) != 0 ? "" : null, 0, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425139d, new b.d(new n35.w(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(2, new c45.h(2, this.f425140e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f425141f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f425142h), new b.e.h(false))));
        return mapOf;
    }

    public ag(n35.w wVar, String str, int i3, int i16) {
        this.f425139d = wVar;
        this.f425140e = str;
        this.f425141f = i3;
        this.f425142h = i16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo");
            this.f425139d = (n35.w) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425140e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425141f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425142h = ((Integer) obj).intValue();
        }
    }
}
