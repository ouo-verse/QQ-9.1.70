package i35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n25.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public g f407168d;

    /* renamed from: e, reason: collision with root package name */
    public c f407169e;

    /* renamed from: f, reason: collision with root package name */
    public a f407170f;

    public d() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new d(null, null, null, 7, null));
    }

    public /* synthetic */ d(g gVar, c cVar, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null);
    }

    public d(g gVar, c cVar, a aVar) {
        this.f407168d = gVar;
        this.f407169e = cVar;
        this.f407170f = aVar;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        String str = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f407168d, new b.d(new g(null, null, 0, null, null, null, null, null, 0, null, 1023, null)))), TuplesKt.to(2, new h(2, this.f407169e, new b.d(new c(0, str, null, null, null, 31, null)))), TuplesKt.to(3, new h(3, this.f407170f, new b.d(new a(null, null, str, 0 == true ? 1 : 0, 0, 31, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.PsvFeed");
            this.f407168d = (g) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.common.interact_msg.MoodGroup");
            this.f407169e = (c) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.common.interact_msg.FollowEvent");
            this.f407170f = (a) obj;
        }
    }
}
