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
public final class ab extends c45.j {
    public int C;
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public final List<n> f425113d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f425114e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f425115f;

    /* renamed from: h, reason: collision with root package name */
    public int f425116h;

    /* renamed from: i, reason: collision with root package name */
    public m25.c f425117i;

    /* renamed from: m, reason: collision with root package name */
    public String f425118m;

    public ab() {
        this((List) null, false, (c45.a) null, 0, (m25.c) null, 0, (String) null, 255);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ab((List) null, false, (c45.a) null, 0, (m25.c) null, 0, (String) null, 255));
    }

    public /* synthetic */ ab(List list, boolean z16, c45.a aVar, int i3, m25.c cVar, int i16, String str, int i17) {
        this((List<n>) ((i17 & 1) != 0 ? new ArrayList() : list), (i17 & 2) != 0 ? false : z16, (i17 & 4) != 0 ? c45.a.f30290b : aVar, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) != 0 ? null : cVar, (i17 & 32) != 0 ? "" : null, (i17 & 64) != 0 ? 0 : i16, (i17 & 128) != 0 ? "" : str);
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 100) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.C = ((Integer) obj).intValue();
            return;
        }
        if (i3 != 101) {
            switch (i3) {
                case 1:
                    List<n> list = this.f425113d;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.Feed>");
                    CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.f425114e = ((Boolean) obj).booleanValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                    this.f425115f = (c45.a) obj;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f425116h = ((Integer) obj).intValue();
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                    this.f425117i = (m25.c) obj;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f425118m = (String) obj;
                    return;
                default:
                    return;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        this.D = (String) obj;
    }

    public ab(List<n> list, boolean z16, c45.a aVar, int i3, m25.c cVar, String str, int i16, String str2) {
        this.f425113d = list;
        this.f425114e = z16;
        this.f425115f = aVar;
        this.f425116h = i3;
        this.f425117i = cVar;
        this.f425118m = str;
        this.C = i16;
        this.D = str2;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425113d, new b.f(new b.d(new n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287)), false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f425114e), new b.e.a(false))), TuplesKt.to(3, new c45.h(3, this.f425115f, new b.e.C0167b(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f425116h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, this.f425117i, new b.d(new m25.c(0 == true ? 1 : 0, 0 == true ? 1 : 0, 15)))), TuplesKt.to(6, new c45.h(6, this.f425118m, new b.e.g(false))), TuplesKt.to(100, new c45.h(100, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(101, new c45.h(101, this.D, new b.e.g(false))));
        return mapOf;
    }
}
