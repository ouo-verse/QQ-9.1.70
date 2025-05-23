package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ah extends c45.j {
    public x C;
    public ar D;
    public p E;
    public c45.a F;

    /* renamed from: d, reason: collision with root package name */
    public ai f418152d;

    /* renamed from: e, reason: collision with root package name */
    public at f418153e;

    /* renamed from: f, reason: collision with root package name */
    public n f418154f;

    /* renamed from: h, reason: collision with root package name */
    public l f418155h;

    /* renamed from: i, reason: collision with root package name */
    public g f418156i;

    /* renamed from: m, reason: collision with root package name */
    public ao f418157m;

    public /* synthetic */ ah(ai aiVar, n nVar, int i3) {
        this((i3 & 1) != 0 ? null : aiVar, null, (i3 & 4) != 0 ? null : nVar, null, null, null, null, null, null, (i3 & 512) != 0 ? c45.a.f30290b : null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ah(null, 0 == true ? 1 : 0, 1023));
    }

    public ah(ai aiVar, at atVar, n nVar, l lVar, g gVar, ao aoVar, x xVar, ar arVar, p pVar, c45.a aVar) {
        this.f418152d = aiVar;
        this.f418153e = atVar;
        this.f418154f = nVar;
        this.f418155h = lVar;
        this.f418156i = gVar;
        this.f418157m = aoVar;
        this.C = xVar;
        this.D = arVar;
        this.E = pVar;
        this.F = aVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418152d, new b.d(new ai(null, null, null, 7, null)))), TuplesKt.to(2, new c45.h(2, this.f418153e, new b.d(new at(null, false, false, 0L, 0, null, 0, false, 255, null)))), TuplesKt.to(3, new c45.h(3, this.f418154f, new b.d(new n((v) null, 3)))), TuplesKt.to(4, new c45.h(4, this.f418155h, new b.d(new l(null, 1, null)))), TuplesKt.to(5, new c45.h(5, this.f418156i, new b.d(new g(null, false, 0L, 0L, 0L, 31, null)))), TuplesKt.to(6, new c45.h(6, this.f418157m, new b.d(new ao(false, 0L, null, 0, 15, null)))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new x(null, 0L, 3, null)))), TuplesKt.to(8, new c45.h(8, this.D, new b.d(new ar(null, 0, 3, null)))), TuplesKt.to(9, new c45.h(9, this.E, new b.d(new p(null)))), TuplesKt.to(99, new c45.h(99, this.F, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 != 99) {
            switch (i3) {
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.ReqHead");
                    this.f418152d = (ai) obj;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.UploadReq");
                    this.f418153e = (at) obj;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DownloadReq");
                    this.f418154f = (n) obj;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DownloadRKeyReq");
                    this.f418155h = (l) obj;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DeleteReq");
                    this.f418156i = (g) obj;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.UploadCompletedReq");
                    this.f418157m = (ao) obj;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfoAuthReq");
                    this.C = (x) obj;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.UploadKeyRenewalReq");
                    this.D = (ar) obj;
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DownloadSafeReq");
                    this.E = (p) obj;
                    return;
                default:
                    return;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
        this.F = (c45.a) obj;
    }
}
