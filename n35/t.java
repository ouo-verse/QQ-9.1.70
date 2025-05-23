package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f418262d;

    /* renamed from: e, reason: collision with root package name */
    public int f418263e;

    /* renamed from: f, reason: collision with root package name */
    public int f418264f;

    /* renamed from: h, reason: collision with root package name */
    public int f418265h;

    public t() {
        this(0, 0, 0, 0, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new t(0, 0, 0, 0, 15, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ t(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1.b().getValue(), r1.b().getValue(), r1.b().getValue(), r1.b().getValue());
        d.c.a aVar = d.c.f30317b;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418262d), new b.a(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418263e), new b.a(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f418264f), new b.a(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f418265h), new b.a(false))));
        return mapOf;
    }

    public t(int i3, int i16, int i17, int i18) {
        this.f418262d = i3;
        this.f418263e = i16;
        this.f418264f = i17;
        this.f418265h = i18;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.FileClass }");
            this.f418262d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.PictureFormat }");
            this.f418263e = ((Integer) obj).intValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.VideoCodecFormat }");
            this.f418264f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.AudioCodecFormat }");
            this.f418265h = ((Integer) obj).intValue();
        }
    }
}
