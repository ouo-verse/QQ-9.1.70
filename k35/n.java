package k35;

import c45.b;
import c45.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f411569d;

    /* renamed from: e, reason: collision with root package name */
    public int f411570e;

    /* renamed from: f, reason: collision with root package name */
    public final List<w25.g> f411571f;

    /* renamed from: h, reason: collision with root package name */
    public w25.d f411572h;

    public n() {
        this(0L, 0, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new n(0L, 0, null, null, 15, null));
    }

    public /* synthetic */ n(long j3, int i3, List list, w25.d dVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, d.c.f30317b.b().getValue(), new ArrayList(), null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f411569d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f411571f, new b.f(new b.d(new w25.g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null)), false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f411570e), new b.a(false))), TuplesKt.to(4, new c45.h(4, this.f411572h, new b.d(new w25.d(null, null, null, null, null, null, 63, null)))));
        return mapOf;
    }

    public n(long j3, int i3, List<w25.g> list, w25.d dVar) {
        this.f411569d = j3;
        this.f411570e = i3;
        this.f411571f = list;
        this.f411572h = dVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f411569d = ((Long) obj).longValue();
            return;
        }
        if (i3 == 2) {
            List<w25.g> list = this.f411571f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.User>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.Mood_svrKt.MatchResultType }");
            this.f411570e = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.MatchCard");
            this.f411572h = (w25.d) obj;
        }
    }
}
