package b35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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
/* loaded from: classes39.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f27851d;

    /* renamed from: e, reason: collision with root package name */
    public int f27852e;

    /* renamed from: f, reason: collision with root package name */
    public final List<z25.b> f27853f;

    public b() {
        this(0L, 0, null, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0L, 0, null, 7, null));
    }

    public /* synthetic */ b(long j3, int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0, new ArrayList());
    }

    public b(long j3, int i3, List<z25.b> list) {
        this.f27851d = j3;
        this.f27852e = i3;
        this.f27853f = list;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f27851d), new b.e.i(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f27852e), new b.e.C0168e(false))), TuplesKt.to(3, new h(3, this.f27853f, new b.f(new b.d(new z25.b(null, null, null, false, 15, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f27851d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f27852e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            List<z25.b> list = this.f27853f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.chat_comm.MsgInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
