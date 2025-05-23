package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ak extends c45.j {
    public y C;
    public as D;
    public q E;
    public c45.a F;

    /* renamed from: d, reason: collision with root package name */
    public al f418164d;

    /* renamed from: e, reason: collision with root package name */
    public au f418165e;

    /* renamed from: f, reason: collision with root package name */
    public o f418166f;

    /* renamed from: h, reason: collision with root package name */
    public m f418167h;

    /* renamed from: i, reason: collision with root package name */
    public h f418168i;

    /* renamed from: m, reason: collision with root package name */
    public ap f418169m;

    public ak() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ak(null, null, null, null, null, null, null, null, null, null, 1023, null));
    }

    public /* synthetic */ ak(al alVar, au auVar, o oVar, m mVar, h hVar, ap apVar, y yVar, as asVar, q qVar, c45.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, null, null, null, null, c45.a.f30290b);
    }

    public ak(al alVar, au auVar, o oVar, m mVar, h hVar, ap apVar, y yVar, as asVar, q qVar, c45.a aVar) {
        this.f418164d = alVar;
        this.f418165e = auVar;
        this.f418166f = oVar;
        this.f418167h = mVar;
        this.f418168i = hVar;
        this.f418169m = apVar;
        this.C = yVar;
        this.D = asVar;
        this.E = qVar;
        this.F = aVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418164d, new b.d(new al(null, 0, null, 7, null)))), TuplesKt.to(2, new c45.h(2, this.f418165e, new b.d(new au(null, 0L, null, null, 0L, null, null, null, null, 511, null)))), TuplesKt.to(3, new c45.h(3, this.f418166f, new b.d(new o(null, 0L, null, 0, 15, null)))), TuplesKt.to(4, new c45.h(4, this.f418167h, new b.d(new m(null, 1, null)))), TuplesKt.to(5, new c45.h(5, this.f418168i, new b.d(new h()))), TuplesKt.to(6, new c45.h(6, this.f418169m, new b.d(new ap(0L)))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new y(0, null, 0L, 7, null)))), TuplesKt.to(8, new c45.h(8, this.D, new b.d(new as(null, 0L, 3, null)))), TuplesKt.to(9, new c45.h(9, this.E, new b.d(new q("")))), TuplesKt.to(99, new c45.h(99, this.F, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 != 99) {
            switch (i3) {
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RspHead");
                    this.f418164d = (al) obj;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.UploadRsp");
                    this.f418165e = (au) obj;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DownloadRsp");
                    this.f418166f = (o) obj;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DownloadRKeyRsp");
                    this.f418167h = (m) obj;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DeleteRsp");
                    this.f418168i = (h) obj;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.UploadCompletedRsp");
                    this.f418169m = (ap) obj;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfoAuthRsp");
                    this.C = (y) obj;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.UploadKeyRenewalRsp");
                    this.D = (as) obj;
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DownloadSafeRsp");
                    this.E = (q) obj;
                    return;
                default:
                    return;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
        this.F = (c45.a) obj;
    }
}
