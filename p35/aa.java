package p35;

import c45.b;
import c45.d;
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
public final class aa extends c45.j {
    public final List<String> C;

    /* renamed from: d, reason: collision with root package name */
    public String f425107d;

    /* renamed from: e, reason: collision with root package name */
    public int f425108e;

    /* renamed from: f, reason: collision with root package name */
    public int f425109f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f425110h;

    /* renamed from: i, reason: collision with root package name */
    public String f425111i;

    /* renamed from: m, reason: collision with root package name */
    public m25.c f425112m;

    public /* synthetic */ aa(String str, int i3, int i16, c45.a aVar, String str2, m25.c cVar, List list, int i17) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? d.c.f30317b.b().getValue() : i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? c45.a.f30290b : aVar, (i17 & 16) == 0 ? str2 : "", (i17 & 32) != 0 ? null : cVar, (i17 & 64) != 0 ? new ArrayList() : list);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new aa(null, 0, 0, null, null, null, null, 127));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425107d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.common.CommonKt.AccountType }");
                this.f425108e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425109f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f425110h = (c45.a) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425111i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.f425112m = (m25.c) obj;
                return;
            case 7:
                List<String> list = this.C;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425107d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f425108e), new b.a(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f425109f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f425110h, new b.e.C0167b(false))), TuplesKt.to(5, new c45.h(5, this.f425111i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f425112m, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(7, new c45.h(7, this.C, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    public aa(String str, int i3, int i16, c45.a aVar, String str2, m25.c cVar, List<String> list) {
        this.f425107d = str;
        this.f425108e = i3;
        this.f425109f = i16;
        this.f425110h = aVar;
        this.f425111i = str2;
        this.f425112m = cVar;
        this.C = list;
    }
}
