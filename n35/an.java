package n35;

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
/* loaded from: classes38.dex */
public final class an extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f418179d;

    /* renamed from: e, reason: collision with root package name */
    public String f418180e;

    /* renamed from: f, reason: collision with root package name */
    public long f418181f;

    /* renamed from: h, reason: collision with root package name */
    public final List<l35.a> f418182h;

    /* renamed from: i, reason: collision with root package name */
    public final List<l35.b> f418183i;

    public /* synthetic */ an() {
        this(d.c.f30317b.b().getValue(), "", 0L, new ArrayList(), new ArrayList());
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new an());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418179d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f418180e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f418181f), new b.e.f(false))), TuplesKt.to(4, new c45.h(4, this.f418182h, new b.f(new b.d(new l35.a(0, 0, 0, 0, 0, 31, null)), false))), TuplesKt.to(5, new c45.h(5, this.f418183i, new b.f(new b.d(new l35.b()), false))));
        return mapOf;
    }

    public an(int i3, String str, long j3, List<l35.a> list, List<l35.b> list2) {
        this.f418179d = i3;
        this.f418180e = str;
        this.f418181f = j3;
        this.f418182h = list;
        this.f418183i = list2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SubFileType }");
            this.f418179d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418180e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418181f = ((Long) obj).longValue();
        } else if (i3 == 4) {
            List<l35.a> list = this.f418182h;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqnt.common.richmedia_common.Addr>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 5) {
                return;
            }
            List<l35.b> list2 = this.f418183i;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqnt.common.richmedia_common.AddrIpv6>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        }
    }
}
