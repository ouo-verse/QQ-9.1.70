package n35;

import c45.b;
import c45.d;
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
public final class at extends c45.j {
    public int C;
    public boolean D;

    /* renamed from: d, reason: collision with root package name */
    public final List<aq> f418195d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f418196e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f418197f;

    /* renamed from: h, reason: collision with root package name */
    public long f418198h;

    /* renamed from: i, reason: collision with root package name */
    public int f418199i;

    /* renamed from: m, reason: collision with root package name */
    public r f418200m;

    public at() {
        this(null, false, false, 0L, 0, null, 0, false, 255, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new at(null, false, false, 0L, 0, null, 0, false, 255, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                List<aq> list = this.f418195d;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.UploadInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f418196e = ((Boolean) obj).booleanValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f418197f = ((Boolean) obj).booleanValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f418198h = ((Long) obj).longValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SceneType }");
                this.f418199i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.ExtBizInfo");
                this.f418200m = (r) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.C = ((Integer) obj).intValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.D = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ at(List list, boolean z16, boolean z17, long j3, int i3, r rVar, int i16, boolean z18, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), false, false, 0L, d.c.f30317b.b().getValue(), null, 0, false);
    }

    public at(List<aq> list, boolean z16, boolean z17, long j3, int i3, r rVar, int i16, boolean z18) {
        this.f418195d = list;
        this.f418196e = z16;
        this.f418197f = z17;
        this.f418198h = j3;
        this.f418199i = i3;
        this.f418200m = rVar;
        this.C = i16;
        this.D = z18;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418195d, new b.f(new b.d(new aq()), false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f418196e), new b.e.a(false))), TuplesKt.to(3, new c45.h(3, Boolean.valueOf(this.f418197f), new b.e.a(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f418198h), new b.e.i(false))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f418199i), new b.a(false))), TuplesKt.to(6, new c45.h(6, this.f418200m, new b.d(new r(null, null, null, 0, 15, null)))), TuplesKt.to(7, new c45.h(7, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(8, new c45.h(8, Boolean.valueOf(this.D), new b.e.a(false))));
        return mapOf;
    }
}
