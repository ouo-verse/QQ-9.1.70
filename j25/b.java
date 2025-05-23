package j25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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
public final class b extends j {
    public final List<String> C;

    /* renamed from: d, reason: collision with root package name */
    public long f409175d;

    /* renamed from: e, reason: collision with root package name */
    public String f409176e;

    /* renamed from: f, reason: collision with root package name */
    public final List<a> f409177f;

    /* renamed from: h, reason: collision with root package name */
    public String f409178h;

    /* renamed from: i, reason: collision with root package name */
    public String f409179i;

    /* renamed from: m, reason: collision with root package name */
    public final List<String> f409180m;

    public b() {
        this(0L, null, null, null, null, null, null, 127, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0L, null, null, null, null, null, null, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f409175d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f409176e = (String) obj;
                return;
            case 3:
                List<a> list = this.f409177f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.kuolie.common.signal.PartnerAdjective>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f409178h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f409179i = (String) obj;
                return;
            case 6:
                List<String> list2 = this.f409180m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 7:
                List<String> list3 = this.C;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ b(long j3, String str, List list, String str2, String str3, List list2, List list3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", new ArrayList(), "", "", new ArrayList(), new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f409175d), new b.e.i(false))), TuplesKt.to(2, new h(2, this.f409176e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f409177f, new b.f(new b.d(new a(0L, null, 3, null)), false))), TuplesKt.to(4, new h(4, this.f409178h, new b.e.g(false))), TuplesKt.to(5, new h(5, this.f409179i, new b.e.g(false))), TuplesKt.to(6, new h(6, this.f409180m, new b.f(new b.e.g(false), false))), TuplesKt.to(7, new h(7, this.C, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    public b(long j3, String str, List<a> list, String str2, String str3, List<String> list2, List<String> list3) {
        this.f409175d = j3;
        this.f409176e = str;
        this.f409177f = list;
        this.f409178h = str2;
        this.f409179i = str3;
        this.f409180m = list2;
        this.C = list3;
    }
}
