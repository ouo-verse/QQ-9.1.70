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
public final class w extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<z> f418273d;

    /* renamed from: e, reason: collision with root package name */
    public r f418274e;

    public w() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new w(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ w(List list, r rVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), null);
    }

    public w(List<z> list, r rVar) {
        this.f418273d = list;
        this.f418274e = rVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418273d, new b.f(new b.d(new z(null, null, null, null, false, null, 63, null)), false))), TuplesKt.to(2, new c45.h(2, this.f418274e, new b.d(new r(null, null, 0 == true ? 1 : 0, 0, 15, 0 == true ? 1 : 0)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<z> list = this.f418273d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfoBody>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.ExtBizInfo");
            this.f418274e = (r) obj;
        }
    }
}
