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
public final class k extends c45.j {
    public ax C;

    /* renamed from: d, reason: collision with root package name */
    public String f418236d;

    /* renamed from: e, reason: collision with root package name */
    public String f418237e;

    /* renamed from: f, reason: collision with root package name */
    public int f418238f;

    /* renamed from: h, reason: collision with root package name */
    public final List<l35.a> f418239h;

    /* renamed from: i, reason: collision with root package name */
    public final List<l35.b> f418240i;

    /* renamed from: m, reason: collision with root package name */
    public ac f418241m;

    public k() {
        this(null, null, 0, null, null, null, null, 127, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(null, null, 0, null, null, null, null, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418236d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418237e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418238f = ((Integer) obj).intValue();
                return;
            case 4:
                List<l35.a> list = this.f418239h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqnt.common.richmedia_common.Addr>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 5:
                List<l35.b> list2 = this.f418240i;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqnt.common.richmedia_common.AddrIpv6>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.PicUrlExtInfo");
                this.f418241m = (ac) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.VideoExtInfo");
                this.C = (ax) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ k(String str, String str2, int i3, List list, List list2, ac acVar, ax axVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", 0, new ArrayList(), new ArrayList(), null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418236d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f418237e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f418238f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f418239h, new b.f(new b.d(new l35.a(0, 0, 0, 0, 0, 31, null)), false))), TuplesKt.to(5, new c45.h(5, this.f418240i, new b.f(new b.d(new l35.b()), false))), TuplesKt.to(6, new c45.h(6, this.f418241m, new b.d(new ac(null, null, null, 7, null)))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new ax(0, 1, null)))));
        return mapOf;
    }

    public k(String str, String str2, int i3, List<l35.a> list, List<l35.b> list2, ac acVar, ax axVar) {
        this.f418236d = str;
        this.f418237e = str2;
        this.f418238f = i3;
        this.f418239h = list;
        this.f418240i = list2;
        this.f418241m = acVar;
        this.C = axVar;
    }
}
