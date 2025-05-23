package p35;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class g extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f425169d;

    /* renamed from: e, reason: collision with root package name */
    public final List<h> f425170e;

    /* renamed from: f, reason: collision with root package name */
    public String f425171f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f425172h;

    public g() {
        this(false, 15);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(false, 15));
    }

    public /* synthetic */ g(boolean z16, int i3) {
        this(0, (i3 & 2) != 0 ? new ArrayList() : null, (i3 & 4) != 0 ? "" : null, (i3 & 8) != 0 ? false : z16);
    }

    public g(int i3, List<h> list, String str, boolean z16) {
        this.f425169d = i3;
        this.f425170e = list;
        this.f425171f = str;
        this.f425172h = z16;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f425169d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f425170e, new b.f(new b.d(new h((s35.af) null, 0, (String) null, (i) null, 0, (List) null, 127)), false))), TuplesKt.to(3, new c45.h(3, this.f425171f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Boolean.valueOf(this.f425172h), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425169d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            List<h> list = this.f425170e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.CommentInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425171f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f425172h = ((Boolean) obj).booleanValue();
        }
    }
}
