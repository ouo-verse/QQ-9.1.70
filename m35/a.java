package m35;

import c45.b;
import c45.d;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends j {
    public c45.a C;
    public c45.a D;
    public long E;
    public int F;
    public int G;
    public c45.a H;
    public String I;
    public int J;
    public int K;

    /* renamed from: d, reason: collision with root package name */
    public long f416079d;

    /* renamed from: e, reason: collision with root package name */
    public long f416080e;

    /* renamed from: f, reason: collision with root package name */
    public int f416081f;

    /* renamed from: h, reason: collision with root package name */
    public String f416082h;

    /* renamed from: i, reason: collision with root package name */
    public c45.a f416083i;

    /* renamed from: m, reason: collision with root package name */
    public c45.a f416084m;

    public a() {
        this(0L, 0L, 0, null, null, null, null, null, 0L, 0, 0, null, null, 0, 0, 32767, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(0L, 0L, 0, null, null, null, null, null, 0L, 0, 0, null, 0 == true ? 1 : 0, 0, 0, 32767, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f416079d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f416080e = ((Long) obj).longValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f416081f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f416082h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f416083i = (c45.a) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f416084m = (c45.a) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.C = (c45.a) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.D = (c45.a) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.E = ((Long) obj).longValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.F = ((Integer) obj).intValue();
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.G = ((Integer) obj).intValue();
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.H = (c45.a) obj;
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.I = (String) obj;
                return;
            case 14:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.J = ((Integer) obj).intValue();
                return;
            case 15:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.filenotify.FilenotifyKt.FileSceneType }");
                this.K = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(long j3, long j16, int i3, String str, c45.a aVar, c45.a aVar2, c45.a aVar3, c45.a aVar4, long j17, int i16, int i17, c45.a aVar5, String str2, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0, "", r0, r0, r0, r0, 0L, 0, 0, r0, "", 0, d.c.f30317b.b().getValue());
        c45.a aVar6 = c45.a.f30290b;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f416079d), new b.e.i(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f416080e), new b.e.i(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f416081f), new b.e.h(false))), TuplesKt.to(4, new h(4, this.f416082h, new b.e.g(false))), TuplesKt.to(5, new h(5, this.f416083i, new b.e.C0167b(false))), TuplesKt.to(6, new h(6, this.f416084m, new b.e.C0167b(false))), TuplesKt.to(7, new h(7, this.C, new b.e.C0167b(false))), TuplesKt.to(8, new h(8, this.D, new b.e.C0167b(false))), TuplesKt.to(9, new h(9, Long.valueOf(this.E), new b.e.i(false))), TuplesKt.to(10, new h(10, Integer.valueOf(this.F), new b.e.h(false))), TuplesKt.to(11, new h(11, Integer.valueOf(this.G), new b.e.h(false))), TuplesKt.to(12, new h(12, this.H, new b.e.C0167b(false))), TuplesKt.to(13, new h(13, this.I, new b.e.g(false))), TuplesKt.to(14, new h(14, Integer.valueOf(this.J), new b.e.h(false))), TuplesKt.to(15, new h(15, Integer.valueOf(this.K), new b.a(false))));
        return mapOf;
    }

    public a(long j3, long j16, int i3, String str, c45.a aVar, c45.a aVar2, c45.a aVar3, c45.a aVar4, long j17, int i16, int i17, c45.a aVar5, String str2, int i18, int i19) {
        this.f416079d = j3;
        this.f416080e = j16;
        this.f416081f = i3;
        this.f416082h = str;
        this.f416083i = aVar;
        this.f416084m = aVar2;
        this.C = aVar3;
        this.D = aVar4;
        this.E = j17;
        this.F = i16;
        this.G = i17;
        this.H = aVar5;
        this.I = str2;
        this.J = i18;
        this.K = i19;
    }
}
