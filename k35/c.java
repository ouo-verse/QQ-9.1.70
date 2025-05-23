package k35;

import c45.b;
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
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<w25.g> f411534d;

    /* renamed from: e, reason: collision with root package name */
    public w25.g f411535e;

    /* renamed from: f, reason: collision with root package name */
    public long f411536f;

    /* renamed from: h, reason: collision with root package name */
    public long f411537h;

    /* renamed from: i, reason: collision with root package name */
    public String f411538i;

    public c() {
        this(null, null, 0L, 0L, null, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, null, 0L, 0L, null, 31, null));
    }

    public /* synthetic */ c(List list, w25.g gVar, long j3, long j16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), null, 0L, 0L, "");
    }

    public c(List<w25.g> list, w25.g gVar, long j3, long j16, String str) {
        this.f411534d = list;
        this.f411535e = gVar;
        this.f411536f = j3;
        this.f411537h = j16;
        this.f411538i = str;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f411534d, new b.f(new b.d(new w25.g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null)), false))), TuplesKt.to(2, new c45.h(2, this.f411535e, new b.d(new w25.g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null)))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f411536f), new b.e.i(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f411537h), new b.e.i(false))), TuplesKt.to(5, new c45.h(5, this.f411538i, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<w25.g> list = this.f411534d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.User>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.User");
            this.f411535e = (w25.g) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f411536f = ((Long) obj).longValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f411537h = ((Long) obj).longValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f411538i = (String) obj;
        }
    }
}
