package i35;

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
public final class b extends j {
    public e C;

    /* renamed from: d, reason: collision with root package name */
    public long f407157d;

    /* renamed from: e, reason: collision with root package name */
    public int f407158e;

    /* renamed from: f, reason: collision with root package name */
    public d f407159f;

    /* renamed from: h, reason: collision with root package name */
    public long f407160h;

    /* renamed from: i, reason: collision with root package name */
    public long f407161i;

    /* renamed from: m, reason: collision with root package name */
    public long f407162m;

    public b() {
        this(0L, 0, null, 0L, 0L, 0L, null, 127, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0L, 0, null, 0L, 0L, 0L, null, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f407157d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan_ext.common.interact_msg.Interact_msgKt.InteractMsgType }");
                this.f407158e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.common.interact_msg.MsgContent");
                this.f407159f = (d) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f407160h = ((Long) obj).longValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f407161i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f407162m = ((Long) obj).longValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan_ext.common.interact_msg.RedDot");
                this.C = (e) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ b(long j3, int i3, d dVar, long j16, long j17, long j18, e eVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, d.c.f30317b.b().getValue(), null, 0L, 0L, 0L, null);
    }

    public b(long j3, int i3, d dVar, long j16, long j17, long j18, e eVar) {
        this.f407157d = j3;
        this.f407158e = i3;
        this.f407159f = dVar;
        this.f407160h = j16;
        this.f407161i = j17;
        this.f407162m = j18;
        this.C = eVar;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f407157d), new b.e.i(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f407158e), new b.a(false))), TuplesKt.to(3, new h(3, this.f407159f, new b.d(new d(null, null, null, 7, null)))), TuplesKt.to(4, new h(4, Long.valueOf(this.f407160h), new b.e.f(false))), TuplesKt.to(5, new h(5, Long.valueOf(this.f407161i), new b.e.i(false))), TuplesKt.to(6, new h(6, Long.valueOf(this.f407162m), new b.e.i(false))), TuplesKt.to(7, new h(7, this.C, new b.d(new e(0, 0L, 3, 0 == true ? 1 : 0)))));
        return mapOf;
    }
}
