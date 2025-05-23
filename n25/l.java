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
import n35.w;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends c45.j {
    public k C;
    public long D;
    public f E;
    public j F;
    public boolean G;
    public int H;
    public int I;
    public final List<m> J;
    public int K;
    public int L;
    public b M;
    public int N;
    public final List<String> P;
    public int Q;
    public c R;

    /* renamed from: d, reason: collision with root package name */
    public String f418092d;

    /* renamed from: e, reason: collision with root package name */
    public r25.e f418093e;

    /* renamed from: f, reason: collision with root package name */
    public q25.g f418094f;

    /* renamed from: h, reason: collision with root package name */
    public q25.f f418095h;

    /* renamed from: i, reason: collision with root package name */
    public c45.a f418096i;

    /* renamed from: m, reason: collision with root package name */
    public final List<j> f418097m;

    public l() {
        this(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, 0 == true ? 1 : 0, 2097151));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418092d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.User");
                this.f418093e = (r25.e) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.StatusInfo");
                this.f418094f = (q25.g) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.ResourceInfo");
                this.f418095h = (q25.f) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f418096i = (c45.a) obj;
                return;
            case 6:
                List<j> list = this.f418097m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.StImage>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
                this.C = (k) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.D = ((Long) obj).longValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.LikeInfo");
                this.E = (f) obj;
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StImage");
                this.F = (j) obj;
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.G = ((Boolean) obj).booleanValue();
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.H = ((Integer) obj).intValue();
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.I = ((Integer) obj).intValue();
                return;
            case 14:
                List<m> list2 = this.J;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.Topic>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 15:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.K = ((Integer) obj).intValue();
                return;
            case 16:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.L = ((Integer) obj).intValue();
                return;
            case 17:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.CityWalkInfo");
                this.M = (b) obj;
                return;
            case 18:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.N = ((Integer) obj).intValue();
                return;
            case 19:
                List<String> list3 = this.P;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            case 20:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.Q = ((Integer) obj).intValue();
                return;
            case 21:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.CommentByPage");
                this.R = (c) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ l(String str, r25.e eVar, q25.g gVar, q25.f fVar, c45.a aVar, List list, k kVar, long j3, f fVar2, boolean z16, int i3, List list2, int i16, b bVar, List list3, int i17) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? null : eVar, (i17 & 4) != 0 ? null : gVar, (i17 & 8) != 0 ? null : fVar, (i17 & 16) != 0 ? c45.a.f30290b : aVar, (i17 & 32) != 0 ? new ArrayList() : list, (i17 & 64) != 0 ? null : kVar, (i17 & 128) != 0 ? 0L : j3, (i17 & 256) != 0 ? null : fVar2, null, (i17 & 1024) != 0 ? false : z16, (i17 & 2048) != 0 ? 0 : i3, 0, (i17 & 8192) != 0 ? new ArrayList() : list2, 0, (32768 & i17) != 0 ? 0 : i16, (65536 & i17) != 0 ? null : bVar, 0, (i17 & 262144) != 0 ? new ArrayList() : list3, 0, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 7;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418092d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f418093e, new b.d(new r25.e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)))), TuplesKt.to(3, new c45.h(3, this.f418094f, new b.d(new q25.g(0, 0, null, null, null, null, null, null, null, null, 1023, null)))), TuplesKt.to(4, new c45.h(4, this.f418095h, new b.d(new q25.f(0, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, null, 63, null)))), TuplesKt.to(5, new c45.h(5, this.f418096i, new b.e.C0167b(false))), TuplesKt.to(6, new c45.h(6, this.f418097m, new b.f(new b.d(new j((w) null, (String) (0 == true ? 1 : 0), i3)), false))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new k((String) null, (String) null, 0, (String) null, (String) null, 0, (i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))), TuplesKt.to(8, new c45.h(8, Long.valueOf(this.D), new b.e.i(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.d(new f(0 == true ? 1 : 0, 0, null, 0, 63)))), TuplesKt.to(10, new c45.h(10, this.F, new b.d(new j((w) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), i3)))), TuplesKt.to(11, new c45.h(11, Boolean.valueOf(this.G), new b.e.a(false))), TuplesKt.to(12, new c45.h(12, Integer.valueOf(this.H), new b.e.h(false))), TuplesKt.to(13, new c45.h(13, Integer.valueOf(this.I), new b.e.h(false))), TuplesKt.to(14, new c45.h(14, this.J, new b.f(new b.d(new m(0 == true ? 1 : 0, 15)), false))), TuplesKt.to(15, new c45.h(15, Integer.valueOf(this.K), new b.e.h(false))), TuplesKt.to(16, new c45.h(16, Integer.valueOf(this.L), new b.e.h(false))), TuplesKt.to(17, new c45.h(17, this.M, new b.d(new b(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0)))), TuplesKt.to(18, new c45.h(18, Integer.valueOf(this.N), new b.e.h(false))), TuplesKt.to(19, new c45.h(19, this.P, new b.f(new b.e.g(false), false))), TuplesKt.to(20, new c45.h(20, Integer.valueOf(this.Q), new b.e.h(false))), TuplesKt.to(21, new c45.h(21, this.R, new b.d(new c(0, null, null, false, 15, null)))));
        return mapOf;
    }

    public l(String str, r25.e eVar, q25.g gVar, q25.f fVar, c45.a aVar, List<j> list, k kVar, long j3, f fVar2, j jVar, boolean z16, int i3, int i16, List<m> list2, int i17, int i18, b bVar, int i19, List<String> list3, int i26, c cVar) {
        this.f418092d = str;
        this.f418093e = eVar;
        this.f418094f = gVar;
        this.f418095h = fVar;
        this.f418096i = aVar;
        this.f418097m = list;
        this.C = kVar;
        this.D = j3;
        this.E = fVar2;
        this.F = jVar;
        this.G = z16;
        this.H = i3;
        this.I = i16;
        this.J = list2;
        this.K = i17;
        this.L = i18;
        this.M = bVar;
        this.N = i19;
        this.P = list3;
        this.Q = i26;
        this.R = cVar;
    }
}
