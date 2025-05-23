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
public final class n extends c45.j {
    public ah C;
    public long D;
    public ac E;
    public boolean F;
    public int G;
    public d H;
    public final List<String> I;
    public g J;
    public int K;
    public int L;
    public int M;
    public String N;
    public int P;

    /* renamed from: d, reason: collision with root package name */
    public String f425193d;

    /* renamed from: e, reason: collision with root package name */
    public s35.af f425194e;

    /* renamed from: f, reason: collision with root package name */
    public q25.g f425195f;

    /* renamed from: h, reason: collision with root package name */
    public q25.f f425196h;

    /* renamed from: i, reason: collision with root package name */
    public c45.a f425197i;

    /* renamed from: m, reason: collision with root package name */
    public final List<ag> f425198m;

    public n() {
        this(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425193d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo");
                this.f425194e = (s35.af) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.StatusInfo");
                this.f425195f = (q25.g) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.ResourceInfo");
                this.f425196h = (q25.f) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f425197i = (c45.a) obj;
                return;
            case 6:
                List<ag> list = this.f425198m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StImage>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
                this.C = (ah) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.D = ((Long) obj).longValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.LikeInfo");
                this.E = (ac) obj;
                return;
            case 10:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            default:
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.F = ((Boolean) obj).booleanValue();
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.G = ((Integer) obj).intValue();
                return;
            case 17:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.CityWalkInfo");
                this.H = (d) obj;
                return;
            case 19:
                List<String> list2 = this.I;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 20:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.CommentByPage");
                this.J = (g) obj;
                return;
            case 21:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.K = ((Integer) obj).intValue();
                return;
            case 22:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.FeedKt.FeedType }");
                this.L = ((Integer) obj).intValue();
                return;
            case 23:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.FeedKt.FeedSource }");
                this.M = ((Integer) obj).intValue();
                return;
            case 24:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.N = (String) obj;
                return;
            case 25:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.P = ((Integer) obj).intValue();
                return;
        }
    }

    public /* synthetic */ n(String str, s35.af afVar, q25.g gVar, q25.f fVar, c45.a aVar, List list, ah ahVar, long j3, ac acVar, boolean z16, int i3, d dVar, List list2, g gVar2, int i16, int i17, int i18) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? null : afVar, (i18 & 4) != 0 ? null : gVar, (i18 & 8) != 0 ? null : fVar, (i18 & 16) != 0 ? c45.a.f30290b : aVar, (i18 & 32) != 0 ? new ArrayList() : list, (i18 & 64) != 0 ? null : ahVar, (i18 & 128) != 0 ? 0L : j3, (i18 & 256) != 0 ? null : acVar, (i18 & 512) != 0 ? false : z16, (i18 & 1024) != 0 ? 0 : i3, (i18 & 2048) != 0 ? null : dVar, (i18 & 4096) != 0 ? new ArrayList() : list2, (i18 & 8192) != 0 ? null : gVar2, (i18 & 16384) != 0 ? 0 : i16, (32768 & i18) != 0 ? d.c.f30317b.b().getValue() : i17, (65536 & i18) != 0 ? d.c.f30317b.b().getValue() : 0, (i18 & 131072) != 0 ? "" : null, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425193d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f425194e, new b.d(new s35.af(null, 0L, str, 0, str2, 0, null, str3, str4, str5, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255)))), TuplesKt.to(3, new c45.h(3, this.f425195f, new b.d(new q25.g(0, 0, str6, str, str2, null, 0 == true ? 1 : 0, str3, str4, str5, 1023, 0 == true ? 1 : 0)))), TuplesKt.to(4, new c45.h(4, this.f425196h, new b.d(new q25.f(0, null, null, null, null, null, 63, null)))), TuplesKt.to(5, new c45.h(5, this.f425197i, new b.e.C0167b(false))), TuplesKt.to(6, new c45.h(6, this.f425198m, new b.f(new b.d(new ag(null, 15)), false))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))), TuplesKt.to(8, new c45.h(8, Long.valueOf(this.D), new b.e.i(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.d(new ac(str6, 0, null, 0, 63)))), TuplesKt.to(11, new c45.h(11, Boolean.valueOf(this.F), new b.e.a(false))), TuplesKt.to(12, new c45.h(12, Integer.valueOf(this.G), new b.e.h(false))), TuplesKt.to(17, new c45.h(17, this.H, new b.d(new d(null, 1, 0 == true ? 1 : 0)))), TuplesKt.to(19, new c45.h(19, this.I, new b.f(new b.e.g(false), false))), TuplesKt.to(20, new c45.h(20, this.J, new b.d(new g(false, 15)))), TuplesKt.to(21, new c45.h(21, Integer.valueOf(this.K), new b.e.h(false))), TuplesKt.to(22, new c45.h(22, Integer.valueOf(this.L), new b.a(false))), TuplesKt.to(23, new c45.h(23, Integer.valueOf(this.M), new b.a(false))), TuplesKt.to(24, new c45.h(24, this.N, new b.e.g(false))), TuplesKt.to(25, new c45.h(25, Integer.valueOf(this.P), new b.e.h(false))));
        return mapOf;
    }

    public n(String str, s35.af afVar, q25.g gVar, q25.f fVar, c45.a aVar, List<ag> list, ah ahVar, long j3, ac acVar, boolean z16, int i3, d dVar, List<String> list2, g gVar2, int i16, int i17, int i18, String str2, int i19) {
        this.f425193d = str;
        this.f425194e = afVar;
        this.f425195f = gVar;
        this.f425196h = fVar;
        this.f425197i = aVar;
        this.f425198m = list;
        this.C = ahVar;
        this.D = j3;
        this.E = acVar;
        this.F = z16;
        this.G = i3;
        this.H = dVar;
        this.I = list2;
        this.J = gVar2;
        this.K = i16;
        this.L = i17;
        this.M = i18;
        this.N = str2;
        this.P = i19;
    }
}
