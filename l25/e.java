package l25;

import c45.b;
import com.tencent.mobileqq.startup.step.InitSkin;
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
public final class e extends c45.j {
    public String C;
    public String D;
    public String E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;

    /* renamed from: d, reason: collision with root package name */
    public int f413751d;

    /* renamed from: e, reason: collision with root package name */
    public int f413752e;

    /* renamed from: f, reason: collision with root package name */
    public String f413753f;

    /* renamed from: h, reason: collision with root package name */
    public final List<f> f413754h;

    /* renamed from: i, reason: collision with root package name */
    public String f413755i;

    /* renamed from: m, reason: collision with root package name */
    public c45.a f413756m;

    public e() {
        this(0, 0, null, null, null, null, null, null, null, 0, 0, false, false, InitSkin.DRAWABLE_COUNT, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(0, 0, null, null, null, null, null, null, null, 0, 0, false, false, InitSkin.DRAWABLE_COUNT, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f413751d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f413752e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f413753f = (String) obj;
                return;
            case 4:
                List<f> list = this.f413754h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChImageUrl>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f413755i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f413756m = (c45.a) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.D = (String) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.E = (String) obj;
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
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.H = ((Boolean) obj).booleanValue();
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.I = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ e(int i3, int i16, String str, List list, String str2, c45.a aVar, String str3, String str4, String str5, int i17, int i18, boolean z16, boolean z17, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, "", new ArrayList(), "", c45.a.f30290b, "", "", "", 0, 0, false, false);
    }

    public e(int i3, int i16, String str, List<f> list, String str2, c45.a aVar, String str3, String str4, String str5, int i17, int i18, boolean z16, boolean z17) {
        this.f413751d = i3;
        this.f413752e = i16;
        this.f413753f = str;
        this.f413754h = list;
        this.f413755i = str2;
        this.f413756m = aVar;
        this.C = str3;
        this.D = str4;
        this.E = str5;
        this.F = i17;
        this.G = i18;
        this.H = z16;
        this.I = z17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f413751d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f413752e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f413753f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f413754h, new b.f(new b.d(new f(0, null, 0, 0, null, 31, null)), false))), TuplesKt.to(5, new c45.h(5, this.f413755i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f413756m, new b.e.C0167b(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.e.g(false))), TuplesKt.to(10, new c45.h(10, Integer.valueOf(this.F), new b.e.h(false))), TuplesKt.to(11, new c45.h(11, Integer.valueOf(this.G), new b.e.h(false))), TuplesKt.to(12, new c45.h(12, Boolean.valueOf(this.H), new b.e.a(false))), TuplesKt.to(13, new c45.h(13, Boolean.valueOf(this.I), new b.e.a(false))));
        return mapOf;
    }
}
