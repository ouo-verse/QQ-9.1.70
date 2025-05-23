package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class am extends c45.j {
    public c C;
    public i D;
    public c45.a E;

    /* renamed from: d, reason: collision with root package name */
    public int f418173d;

    /* renamed from: e, reason: collision with root package name */
    public int f418174e;

    /* renamed from: f, reason: collision with root package name */
    public int f418175f;

    /* renamed from: h, reason: collision with root package name */
    public int f418176h;

    /* renamed from: i, reason: collision with root package name */
    public b f418177i;

    /* renamed from: m, reason: collision with root package name */
    public u f418178m;

    public am() {
        this(0, 0, 0, 0, 511);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new am(0, 0, 0, 0, 511));
    }

    public /* synthetic */ am(int i3, int i16, int i17, int i18, int i19) {
        this((i19 & 1) != 0 ? d.c.f30317b.b().getValue() : i3, (i19 & 2) != 0 ? d.c.f30317b.b().getValue() : i16, (i19 & 4) != 0 ? d.c.f30317b.b().getValue() : i17, (i19 & 8) != 0 ? d.c.f30317b.b().getValue() : i18, null, null, null, null, (i19 & 256) != 0 ? c45.a.f30290b : null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(101, new c45.h(101, Integer.valueOf(this.f418173d), new b.a(false))), TuplesKt.to(102, new c45.h(102, Integer.valueOf(this.f418174e), new b.a(false))), TuplesKt.to(103, new c45.h(103, Integer.valueOf(this.f418175f), new b.a(false))), TuplesKt.to(200, new c45.h(200, Integer.valueOf(this.f418176h), new b.a(false))), TuplesKt.to(201, new c45.h(201, this.f418177i, new b.d(new b(0, null, null, 7, null)))), TuplesKt.to(202, new c45.h(202, this.f418178m, new b.d(new u(0L)))), TuplesKt.to(203, new c45.h(203, this.C, new b.d(new c(0L, 0L, 0, 7, null)))), TuplesKt.to(204, new c45.h(204, this.D, new b.d(new i(0L)))), TuplesKt.to(205, new c45.h(205, this.E, new b.e.C0167b(false))));
        return mapOf;
    }

    public am(int i3, int i16, int i17, int i18, b bVar, u uVar, c cVar, i iVar, c45.a aVar) {
        this.f418173d = i3;
        this.f418174e = i16;
        this.f418175f = i17;
        this.f418176h = i18;
        this.f418177i = bVar;
        this.f418178m = uVar;
        this.C = cVar;
        this.D = iVar;
        this.E = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 101:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.RequestType }");
                this.f418173d = ((Integer) obj).intValue();
                return;
            case 102:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.BusinessType }");
                this.f418174e = ((Integer) obj).intValue();
                return;
            case 103:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.AppType }");
                this.f418175f = ((Integer) obj).intValue();
                return;
            default:
                switch (i3) {
                    case 200:
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SceneType }");
                        this.f418176h = ((Integer) obj).intValue();
                        return;
                    case 201:
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.C2CUserInfo");
                        this.f418177i = (b) obj;
                        return;
                    case 202:
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.GroupUserInfo");
                        this.f418178m = (u) obj;
                        return;
                    case 203:
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.ChannelUserInfo");
                        this.C = (c) obj;
                        return;
                    case 204:
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DiscussInfo");
                        this.D = (i) obj;
                        return;
                    case 205:
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                        this.E = (c45.a) obj;
                        return;
                    default:
                        return;
                }
        }
    }
}
