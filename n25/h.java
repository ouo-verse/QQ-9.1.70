package n25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public r25.e f418073d;

    /* renamed from: e, reason: collision with root package name */
    public int f418074e;

    /* renamed from: f, reason: collision with root package name */
    public String f418075f;

    /* renamed from: h, reason: collision with root package name */
    public e f418076h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f418077i;

    /* renamed from: m, reason: collision with root package name */
    public r25.e f418078m;

    public /* synthetic */ h() {
        this(null, 0, "", null, false, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h());
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.User");
                this.f418073d = (r25.e) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418074e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418075f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.Content");
                this.f418076h = (e) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f418077i = ((Boolean) obj).booleanValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.User");
                this.f418078m = (r25.e) obj;
                return;
            default:
                return;
        }
    }

    public h(r25.e eVar, int i3, String str, e eVar2, boolean z16, r25.e eVar3) {
        this.f418073d = eVar;
        this.f418074e = i3;
        this.f418075f = str;
        this.f418076h = eVar2;
        this.f418077i = z16;
        this.f418078m = eVar3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418073d, new b.d(new r25.e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418074e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f418075f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f418076h, new b.d(new e("")))), TuplesKt.to(5, new c45.h(5, Boolean.valueOf(this.f418077i), new b.e.a(false))), TuplesKt.to(6, new c45.h(6, this.f418078m, new b.d(new r25.e(0L, null, 0 == true ? 1 : 0, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)))));
        return mapOf;
    }
}
