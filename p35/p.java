package p35;

import c45.b;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class p extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f425201d;

    /* renamed from: e, reason: collision with root package name */
    public h f425202e;

    public p() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new p(0, null, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ p(int i3, h hVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null);
    }

    public p(int i3, h hVar) {
        this.f425201d = i3;
        this.f425202e = hVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f425201d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f425202e, new b.d(new h((s35.af) null, 0, (String) null, (i) null, 0, (List) null, 127)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425201d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.CommentInfo");
            this.f425202e = (h) obj;
        }
    }
}
