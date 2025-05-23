package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public ab f418252d;

    /* renamed from: e, reason: collision with root package name */
    public aw f418253e;

    /* renamed from: f, reason: collision with root package name */
    public af f418254f;

    /* renamed from: h, reason: collision with root package name */
    public int f418255h;

    public r() {
        this(null, null, null, 0, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new r(null, null, null, 0, 15, null));
    }

    public /* synthetic */ r(ab abVar, aw awVar, af afVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, d.c.f30317b.b().getValue());
    }

    public r(ab abVar, aw awVar, af afVar, int i3) {
        this.f418252d = abVar;
        this.f418253e = awVar;
        this.f418254f = afVar;
        this.f418255h = i3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        c45.a aVar = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418252d, new b.d(new ab(0, null, null, aVar, 0, 0, 0, 127, null)))), TuplesKt.to(2, new c45.h(2, this.f418253e, new b.d(new aw(0, 0, aVar, 7, null)))), TuplesKt.to(3, new c45.h(3, this.f418254f, new b.d(new af(0L, 0, 0, 0, null, 0, null, null, null, 511, null)))), TuplesKt.to(10, new c45.h(10, Integer.valueOf(this.f418255h), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.PicExtBizInfo");
            this.f418252d = (ab) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.VideoExtBizInfo");
            this.f418253e = (aw) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.PttExtBizInfo");
            this.f418254f = (af) obj;
        } else {
            if (i3 != 10) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.BusinessType }");
            this.f418255h = ((Integer) obj).intValue();
        }
    }
}
