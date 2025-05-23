package p35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class e extends c45.j {
    public m25.c C;
    public boolean D;
    public int E;

    /* renamed from: d, reason: collision with root package name */
    public String f425159d;

    /* renamed from: e, reason: collision with root package name */
    public String f425160e;

    /* renamed from: f, reason: collision with root package name */
    public String f425161f;

    /* renamed from: h, reason: collision with root package name */
    public i f425162h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f425163i;

    /* renamed from: m, reason: collision with root package name */
    public String f425164m;

    public e(String str, String str2, String str3, i iVar, boolean z16, String str4, m25.c cVar, boolean z17, int i3) {
        this.f425159d = str;
        this.f425160e = str2;
        this.f425161f = str3;
        this.f425162h = iVar;
        this.f425163i = z16;
        this.f425164m = str4;
        this.C = cVar;
        this.D = z17;
        this.E = i3;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e("", "", "", null, false, "", null, false, new d.c(0).getValue()));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425159d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425160e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425161f = (String) obj;
                return;
            case 4:
            default:
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.Content");
                this.f425162h = (i) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f425163i = ((Boolean) obj).booleanValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425164m = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.C = (m25.c) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.D = ((Boolean) obj).booleanValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.FeedKt.CommentAndReplySource }");
                this.E = ((Integer) obj).intValue();
                return;
        }
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425159d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f425160e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f425161f, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f425162h, new b.d(new i("")))), TuplesKt.to(6, new c45.h(6, Boolean.valueOf(this.f425163i), new b.e.a(false))), TuplesKt.to(7, new c45.h(7, this.f425164m, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, this.C, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(9, new c45.h(9, Boolean.valueOf(this.D), new b.e.a(false))), TuplesKt.to(10, new c45.h(10, Integer.valueOf(this.E), new b.a(false))));
        return mapOf;
    }
}
