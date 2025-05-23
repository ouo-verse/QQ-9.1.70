package o35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p35.n;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends c45.j {
    public h C;
    public i D;

    /* renamed from: d, reason: collision with root package name */
    public int f421874d;

    /* renamed from: e, reason: collision with root package name */
    public String f421875e;

    /* renamed from: f, reason: collision with root package name */
    public n f421876f;

    /* renamed from: h, reason: collision with root package name */
    public f f421877h;

    /* renamed from: i, reason: collision with root package name */
    public b f421878i;

    /* renamed from: m, reason: collision with root package name */
    public j f421879m;

    public a() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new a(0, null, null, null, null, null, null, null, 255, null));
    }

    public /* synthetic */ a(int i3, String str, n nVar, f fVar, b bVar, j jVar, h hVar, i iVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "", null, null, null, null, null, null);
    }

    public a(int i3, String str, n nVar, f fVar, b bVar, j jVar, h hVar, i iVar) {
        this.f421874d = i3;
        this.f421875e = str;
        this.f421876f = nVar;
        this.f421877h = fVar;
        this.f421878i = bVar;
        this.f421879m = jVar;
        this.C = hVar;
        this.D = iVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f421874d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f421875e, new b.e.g(false))), TuplesKt.to(1001, new c45.h(1001, this.f421876f, new b.d(new n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287)))), TuplesKt.to(1002, new c45.h(1002, this.f421877h, new b.d(new f(null, 0L, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 31, null)))), TuplesKt.to(1003, new c45.h(1003, this.f421878i, new b.d(new b(null, null, null, null, null, null, 63, null)))), TuplesKt.to(1004, new c45.h(1004, this.f421879m, new b.d(new j(c45.a.f30290b)))), TuplesKt.to(1005, new c45.h(1005, this.C, new b.d(new h(0, null, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, false, 255, 0 == true ? 1 : 0)))), TuplesKt.to(1006, new c45.h(1006, this.D, new b.d(new i(null, null, null, null, null, 31, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.card.CardKt.CardType }");
            this.f421874d = ((Integer) obj).intValue();
            return;
        }
        if (i3 != 2) {
            switch (i3) {
                case 1001:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.Feed");
                    this.f421876f = (n) obj;
                    return;
                case 1002:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.card.InteractCard");
                    this.f421877h = (f) obj;
                    return;
                case 1003:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.card.EntranceCard");
                    this.f421878i = (b) obj;
                    return;
                case 1004:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.card.TextCard");
                    this.f421879m = (j) obj;
                    return;
                case 1005:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.card.MoodCard");
                    this.C = (h) obj;
                    return;
                case 1006:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.card.SimpleBarCard");
                    this.D = (i) obj;
                    return;
                default:
                    return;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        this.f421875e = (String) obj;
    }
}
