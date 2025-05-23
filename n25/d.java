package n25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends c45.j {
    public boolean C;

    /* renamed from: d, reason: collision with root package name */
    public r25.e f418054d;

    /* renamed from: e, reason: collision with root package name */
    public int f418055e;

    /* renamed from: f, reason: collision with root package name */
    public String f418056f;

    /* renamed from: h, reason: collision with root package name */
    public e f418057h;

    /* renamed from: i, reason: collision with root package name */
    public int f418058i;

    /* renamed from: m, reason: collision with root package name */
    public final List<h> f418059m;

    public /* synthetic */ d() {
        this(null, 0, "", null, 0, new ArrayList(), false);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d());
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.User");
                this.f418054d = (r25.e) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418055e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418056f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.Content");
                this.f418057h = (e) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418058i = ((Integer) obj).intValue();
                return;
            case 6:
                List<h> list = this.f418059m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.ReplyInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.C = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public d(r25.e eVar, int i3, String str, e eVar2, int i16, List<h> list, boolean z16) {
        this.f418054d = eVar;
        this.f418055e = i3;
        this.f418056f = str;
        this.f418057h = eVar2;
        this.f418058i = i16;
        this.f418059m = list;
        this.C = z16;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418054d, new b.d(new r25.e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418055e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f418056f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f418057h, new b.d(new e("")))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f418058i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, this.f418059m, new b.f(new b.d(new h()), false))), TuplesKt.to(7, new c45.h(7, Boolean.valueOf(this.C), new b.e.a(false))));
        return mapOf;
    }
}
