package n35;

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
public final class g extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<v> f418227d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f418228e;

    /* renamed from: f, reason: collision with root package name */
    public long f418229f;

    /* renamed from: h, reason: collision with root package name */
    public long f418230h;

    /* renamed from: i, reason: collision with root package name */
    public long f418231i;

    public g() {
        this(null, false, 0L, 0L, 0L, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, false, 0L, 0L, 0L, 31, null));
    }

    public /* synthetic */ g(List list, boolean z16, long j3, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), false, 0L, 0L, 0L);
    }

    public g(List<v> list, boolean z16, long j3, long j16, long j17) {
        this.f418227d = list;
        this.f418228e = z16;
        this.f418229f = j3;
        this.f418230h = j16;
        this.f418231i = j17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418227d, new b.f(new b.d(new v(null, null, 0, 0L, 0L, 0, 0, 127, null)), false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f418228e), new b.e.a(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f418229f), new b.e.i(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f418230h), new b.e.i(false))), TuplesKt.to(5, new c45.h(5, Long.valueOf(this.f418231i), new b.e.i(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<v> list = this.f418227d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.IndexNode>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f418228e = ((Boolean) obj).booleanValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418229f = ((Long) obj).longValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418230h = ((Long) obj).longValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418231i = ((Long) obj).longValue();
        }
    }
}
