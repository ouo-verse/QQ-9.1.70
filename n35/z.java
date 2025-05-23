package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class z extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public v f418280d;

    /* renamed from: e, reason: collision with root package name */
    public ad f418281e;

    /* renamed from: f, reason: collision with root package name */
    public ay f418282f;

    /* renamed from: h, reason: collision with root package name */
    public a f418283h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f418284i;

    /* renamed from: m, reason: collision with root package name */
    public c45.a f418285m;

    public z() {
        this(null, null, null, null, false, null, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new z(null, null, null, null, false, null, 63, null));
    }

    public /* synthetic */ z(v vVar, ad adVar, ay ayVar, a aVar, boolean z16, c45.a aVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, false, c45.a.f30290b);
    }

    public z(v vVar, ad adVar, ay ayVar, a aVar, boolean z16, c45.a aVar2) {
        this.f418280d = vVar;
        this.f418281e = adVar;
        this.f418282f = ayVar;
        this.f418283h = aVar;
        this.f418284i = z16;
        this.f418285m = aVar2;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418280d, new b.d(new v(null, null, 0, 0L, 0L, 0, 0, 127, null)))), TuplesKt.to(2, new c45.h(2, this.f418281e, new b.d(new ad(null, null, null, 7, null)))), TuplesKt.to(3, new c45.h(3, this.f418282f, new b.d(new ay()))), TuplesKt.to(4, new c45.h(4, this.f418283h, new b.d(new a()))), TuplesKt.to(5, new c45.h(5, Boolean.valueOf(this.f418284i), new b.e.a(false))), TuplesKt.to(6, new c45.h(6, this.f418285m, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.IndexNode");
                this.f418280d = (v) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.PictureInfo");
                this.f418281e = (ad) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.VideoInfo");
                this.f418282f = (ay) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.AudioInfo");
                this.f418283h = (a) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f418284i = ((Boolean) obj).booleanValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f418285m = (c45.a) obj;
                return;
            default:
                return;
        }
    }
}
