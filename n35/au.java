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
public final class au extends c45.j {
    public final List<aj> C;
    public c45.a D;
    public final List<an> E;

    /* renamed from: d, reason: collision with root package name */
    public String f418201d;

    /* renamed from: e, reason: collision with root package name */
    public long f418202e;

    /* renamed from: f, reason: collision with root package name */
    public final List<l35.a> f418203f;

    /* renamed from: h, reason: collision with root package name */
    public final List<l35.b> f418204h;

    /* renamed from: i, reason: collision with root package name */
    public long f418205i;

    /* renamed from: m, reason: collision with root package name */
    public w f418206m;

    public au() {
        this(null, 0L, null, null, 0L, null, null, null, null, 511, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new au(null, 0L, null, null, 0L, null, null, null, null, 511, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418201d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f418202e = ((Long) obj).longValue();
                return;
            case 3:
                List<l35.a> list = this.f418203f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqnt.common.richmedia_common.Addr>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 4:
                List<l35.b> list2 = this.f418204h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqnt.common.richmedia_common.AddrIpv6>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f418205i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo");
                this.f418206m = (w) obj;
                return;
            case 7:
                List<aj> list3 = this.C;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaStorageTransInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.D = (c45.a) obj;
                return;
            case 9:
            default:
                return;
            case 10:
                List<an> list4 = this.E;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.SubFileInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list4, (Sequence) obj);
                return;
        }
    }

    public /* synthetic */ au(String str, long j3, List list, List list2, long j16, w wVar, List list3, c45.a aVar, List list4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, new ArrayList(), new ArrayList(), 0L, null, new ArrayList(), c45.a.f30290b, new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418201d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f418202e), new b.e.f(false))), TuplesKt.to(3, new c45.h(3, this.f418203f, new b.f(new b.d(new l35.a(0, 0, 0, 0, 0, 31, null)), false))), TuplesKt.to(4, new c45.h(4, this.f418204h, new b.f(new b.d(new l35.b()), false))), TuplesKt.to(5, new c45.h(5, Long.valueOf(this.f418205i), new b.e.i(false))), TuplesKt.to(6, new c45.h(6, this.f418206m, new b.d(new w(null, null, 3, null)))), TuplesKt.to(7, new c45.h(7, this.C, new b.f(new b.d(new aj()), false))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.C0167b(false))), TuplesKt.to(10, new c45.h(10, this.E, new b.f(new b.d(new an()), false))));
        return mapOf;
    }

    public au(String str, long j3, List<l35.a> list, List<l35.b> list2, long j16, w wVar, List<aj> list3, c45.a aVar, List<an> list4) {
        this.f418201d = str;
        this.f418202e = j3;
        this.f418203f = list;
        this.f418204h = list2;
        this.f418205i = j16;
        this.f418206m = wVar;
        this.C = list3;
        this.D = aVar;
        this.E = list4;
    }
}
