package p35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class q extends c45.j {
    public String C;
    public m25.c D;

    /* renamed from: d, reason: collision with root package name */
    public String f425203d;

    /* renamed from: e, reason: collision with root package name */
    public int f425204e;

    /* renamed from: f, reason: collision with root package name */
    public String f425205f;

    /* renamed from: h, reason: collision with root package name */
    public int f425206h;

    /* renamed from: i, reason: collision with root package name */
    public int f425207i;

    /* renamed from: m, reason: collision with root package name */
    public int f425208m;

    public /* synthetic */ q(String str, int i3, String str2, int i16, String str3, m25.c cVar, int i17) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? d.c.f30317b.b().getValue() : i3, (i17 & 4) != 0 ? "" : str2, 0, (i17 & 16) != 0 ? 0 : i16, 0, (i17 & 64) != 0 ? "" : str3, (i17 & 128) != 0 ? null : cVar);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new q(null, 0, null, 0, null, null, 255));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425203d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.common.CommonKt.AccountType }");
                this.f425204e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425205f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425206h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425207i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425208m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.D = (m25.c) obj;
                return;
            default:
                return;
        }
    }

    public q(String str, int i3, String str2, int i16, int i17, int i18, String str3, m25.c cVar) {
        this.f425203d = str;
        this.f425204e = i3;
        this.f425205f = str2;
        this.f425206h = i16;
        this.f425207i = i17;
        this.f425208m = i18;
        this.C = str3;
        this.D = cVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425203d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f425204e), new b.a(false))), TuplesKt.to(3, new c45.h(3, this.f425205f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f425206h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f425207i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f425208m), new b.e.h(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }
}
