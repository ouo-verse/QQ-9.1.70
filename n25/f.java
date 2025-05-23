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
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418061d;

    /* renamed from: e, reason: collision with root package name */
    public int f418062e;

    /* renamed from: f, reason: collision with root package name */
    public final List<r25.e> f418063f;

    /* renamed from: h, reason: collision with root package name */
    public int f418064h;

    /* renamed from: i, reason: collision with root package name */
    public String f418065i;

    /* renamed from: m, reason: collision with root package name */
    public int f418066m;

    public f() {
        this(null, 0, null, 0, 63);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(null, 0, null, 0, 63));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418061d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418062e = ((Integer) obj).intValue();
                return;
            case 3:
                List<r25.e> list = this.f418063f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.user.User>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418064h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418065i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418066m = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ f(String str, int i3, List list, int i16, int i17) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? new ArrayList() : list, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) == 0 ? null : "", 0);
    }

    public f(String str, int i3, List<r25.e> list, int i16, String str2, int i17) {
        this.f418061d = str;
        this.f418062e = i3;
        this.f418063f = list;
        this.f418064h = i16;
        this.f418065i = str2;
        this.f418066m = i17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418061d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418062e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f418063f, new b.f(new b.d(new r25.e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)), false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f418064h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, this.f418065i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f418066m), new b.e.C0168e(false))));
        return mapOf;
    }
}
