package p35;

import c45.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pbandk.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class v extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, Integer> f425218d;

    public v() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new v(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ v(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new LinkedHashMap());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425218d, new b.C0166b(new b.e.g(false), new b.a(false)))));
        return mapOf;
    }

    public v(Map<String, Integer> map) {
        this.f425218d = map;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.MessageMap.Entry<kotlin.String, kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.FeedKt.FeedStatus }>");
            c45.k.a((a.c) obj, this.f425218d);
        }
    }
}
