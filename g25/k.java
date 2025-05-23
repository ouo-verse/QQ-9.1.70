package g25;

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
public final class k extends c45.j {
    public int C;
    public long D;
    public boolean E;
    public final List<String> F;
    public String G;
    public n H;
    public c45.a I;
    public String J;
    public int K;
    public int L;
    public long M;
    public f25.e N;
    public long P;
    public e Q;
    public boolean R;
    public int S;
    public int T;
    public long U;
    public String V;
    public String W;
    public long X;
    public String Y;
    public f25.i Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f401168a0;

    /* renamed from: b0, reason: collision with root package name */
    public final List<f25.g> f401169b0;

    /* renamed from: c0, reason: collision with root package name */
    public l f401170c0;

    /* renamed from: d, reason: collision with root package name */
    public long f401171d;

    /* renamed from: d0, reason: collision with root package name */
    public int f401172d0;

    /* renamed from: e, reason: collision with root package name */
    public String f401173e;

    /* renamed from: e0, reason: collision with root package name */
    public i f401174e0;

    /* renamed from: f, reason: collision with root package name */
    public String f401175f;

    /* renamed from: f0, reason: collision with root package name */
    public String f401176f0;

    /* renamed from: h, reason: collision with root package name */
    public String f401177h;

    /* renamed from: i, reason: collision with root package name */
    public int f401178i;

    /* renamed from: m, reason: collision with root package name */
    public final List<f> f401179m;

    public k() {
        this(0L, null, null, null, 0, null, 0, 0L, false, null, null, null, null, null, 0, 0, 0L, null, 0L, null, false, 0, 0, 0L, null, null, 0L, null, null, false, null, null, 0, null, null, -1, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(0L, null, null, null, 0, null, 0, 0L, false, null, null, null, null, 0 == true ? 1 : 0, 0, 0, 0L, null, 0L, null, false, 0, 0, 0L, null, null, 0L, null, null, false, null, null, 0, null, null, -1, 7, null));
    }

    public /* synthetic */ k(long j3, String str, String str2, String str3, int i3, List list, int i16, long j16, boolean z16, List list2, String str4, n nVar, c45.a aVar, String str5, int i17, int i18, long j17, f25.e eVar, long j18, e eVar2, boolean z17, int i19, int i26, long j19, String str6, String str7, long j26, String str8, f25.i iVar, boolean z18, List list3, l lVar, int i27, i iVar2, String str9, int i28, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", "", 0, new ArrayList(), 0, 0L, false, new ArrayList(), "", null, c45.a.f30290b, "", d.c.f30317b.b().getValue(), 0, 0L, null, 0L, null, false, 0, 0, 0L, "", "", 0L, "", null, false, new ArrayList(), null, 0, null, "");
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 != 100) {
            switch (i3) {
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.f401171d = ((Long) obj).longValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f401173e = (String) obj;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f401175f = (String) obj;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f401177h = (String) obj;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f401178i = ((Integer) obj).intValue();
                    return;
                case 6:
                    List<f> list = this.f401179m;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.FeatureInfo>");
                    CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.C = ((Integer) obj).intValue();
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.D = ((Long) obj).longValue();
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.E = ((Boolean) obj).booleanValue();
                    return;
                case 10:
                    List<String> list2 = this.F;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                    CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.G = (String) obj;
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.RobtoCreateInfo");
                    this.H = (n) obj;
                    return;
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                    this.I = (c45.a) obj;
                    return;
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.J = (String) obj;
                    return;
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.ListKt.RobotBizType }");
                    this.K = ((Integer) obj).intValue();
                    return;
                case 16:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.L = ((Integer) obj).intValue();
                    return;
                case 17:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.M = ((Long) obj).longValue();
                    return;
                case 18:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.MsgBackground");
                    this.N = (f25.e) obj;
                    return;
                case 19:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.P = ((Long) obj).longValue();
                    return;
                case 20:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.BotMetaCfg");
                    this.Q = (e) obj;
                    return;
                case 21:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.R = ((Boolean) obj).booleanValue();
                    return;
                case 22:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.S = ((Integer) obj).intValue();
                    return;
                case 23:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.T = ((Integer) obj).intValue();
                    return;
                case 24:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.U = ((Long) obj).longValue();
                    return;
                case 25:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.V = (String) obj;
                    return;
                case 26:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.W = (String) obj;
                    return;
                case 27:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.X = ((Long) obj).longValue();
                    return;
                case 28:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.Y = (String) obj;
                    return;
                case 29:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.RobotTTSList");
                    this.Z = (f25.i) obj;
                    return;
                case 30:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.f401168a0 = ((Boolean) obj).booleanValue();
                    return;
                case 31:
                    List<f25.g> list3 = this.f401169b0;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.RobotCategory>");
                    CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                    return;
                case 32:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.RobotRecommendInfo");
                    this.f401170c0 = (l) obj;
                    return;
                case 33:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f401172d0 = ((Integer) obj).intValue();
                    return;
                case 34:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.PrivateProto");
                    this.f401174e0 = (i) obj;
                    return;
                default:
                    return;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        this.f401176f0 = (String) obj;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 3;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f401171d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f401173e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f401175f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f401177h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f401178i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, this.f401179m, new b.f(new b.d(new f(0, "")), false))), TuplesKt.to(7, new c45.h(7, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(8, new c45.h(8, Long.valueOf(this.D), new b.e.i(false))), TuplesKt.to(9, new c45.h(9, Boolean.valueOf(this.E), new b.e.a(false))), TuplesKt.to(10, new c45.h(10, this.F, new b.f(new b.e.g(false), false))), TuplesKt.to(11, new c45.h(11, this.G, new b.e.g(false))), TuplesKt.to(12, new c45.h(12, this.H, new b.d(new n(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(13, new c45.h(13, this.I, new b.e.C0167b(false))), TuplesKt.to(14, new c45.h(14, this.J, new b.e.g(false))), TuplesKt.to(15, new c45.h(15, Integer.valueOf(this.K), new b.a(false))), TuplesKt.to(16, new c45.h(16, Integer.valueOf(this.L), new b.e.h(false))), TuplesKt.to(17, new c45.h(17, Long.valueOf(this.M), new b.e.i(false))), TuplesKt.to(18, new c45.h(18, this.N, new b.d(new f25.e(null, null, null, null, null, null, 63, null)))), TuplesKt.to(19, new c45.h(19, Long.valueOf(this.P), new b.e.i(false))), TuplesKt.to(20, new c45.h(20, this.Q, new b.d(new e(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 7, 0 == true ? 1 : 0)))), TuplesKt.to(21, new c45.h(21, Boolean.valueOf(this.R), new b.e.a(false))), TuplesKt.to(22, new c45.h(22, Integer.valueOf(this.S), new b.e.C0168e(false))), TuplesKt.to(23, new c45.h(23, Integer.valueOf(this.T), new b.e.C0168e(false))), TuplesKt.to(24, new c45.h(24, Long.valueOf(this.U), new b.e.i(false))), TuplesKt.to(25, new c45.h(25, this.V, new b.e.g(false))), TuplesKt.to(26, new c45.h(26, this.W, new b.e.g(false))), TuplesKt.to(27, new c45.h(27, Long.valueOf(this.X), new b.e.i(false))), TuplesKt.to(28, new c45.h(28, this.Y, new b.e.g(false))), TuplesKt.to(29, new c45.h(29, this.Z, new b.d(new f25.i(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(30, new c45.h(30, Boolean.valueOf(this.f401168a0), new b.e.a(false))), TuplesKt.to(31, new c45.h(31, this.f401169b0, new b.f(new b.d(new f25.g(null, null)), false))), TuplesKt.to(32, new c45.h(32, this.f401170c0, new b.d(new l(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 15, 0 == true ? 1 : 0)))), TuplesKt.to(33, new c45.h(33, Integer.valueOf(this.f401172d0), new b.e.h(false))), TuplesKt.to(34, new c45.h(34, this.f401174e0, new b.d(new i(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(100, new c45.h(100, this.f401176f0, new b.e.g(false))));
        return mapOf;
    }

    public k(long j3, String str, String str2, String str3, int i3, List<f> list, int i16, long j16, boolean z16, List<String> list2, String str4, n nVar, c45.a aVar, String str5, int i17, int i18, long j17, f25.e eVar, long j18, e eVar2, boolean z17, int i19, int i26, long j19, String str6, String str7, long j26, String str8, f25.i iVar, boolean z18, List<f25.g> list3, l lVar, int i27, i iVar2, String str9) {
        this.f401171d = j3;
        this.f401173e = str;
        this.f401175f = str2;
        this.f401177h = str3;
        this.f401178i = i3;
        this.f401179m = list;
        this.C = i16;
        this.D = j16;
        this.E = z16;
        this.F = list2;
        this.G = str4;
        this.H = nVar;
        this.I = aVar;
        this.J = str5;
        this.K = i17;
        this.L = i18;
        this.M = j17;
        this.N = eVar;
        this.P = j18;
        this.Q = eVar2;
        this.R = z17;
        this.S = i19;
        this.T = i26;
        this.U = j19;
        this.V = str6;
        this.W = str7;
        this.X = j26;
        this.Y = str8;
        this.Z = iVar;
        this.f401168a0 = z18;
        this.f401169b0 = list3;
        this.f401170c0 = lVar;
        this.f401172d0 = i27;
        this.f401174e0 = iVar2;
        this.f401176f0 = str9;
    }
}
