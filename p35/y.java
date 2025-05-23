package p35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class y extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f425227d;

    /* renamed from: e, reason: collision with root package name */
    public m25.c f425228e;

    /* renamed from: f, reason: collision with root package name */
    public int f425229f;

    /* renamed from: h, reason: collision with root package name */
    public int f425230h;

    public y(String str, m25.c cVar, int i3, int i16) {
        this.f425227d = str;
        this.f425228e = cVar;
        this.f425229f = i3;
        this.f425230h = i16;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new y("", null, new d.c(0).getValue(), new d.c(0).getValue()));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425227d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f425228e, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f425229f), new b.a(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f425230h), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425227d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425228e = (m25.c) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.FeedKt.RecommendCommentFetchSource }");
            this.f425229f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.FeedKt.RecCommentType }");
            this.f425230h = ((Integer) obj).intValue();
        }
    }
}
