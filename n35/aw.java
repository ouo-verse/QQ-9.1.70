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
public final class aw extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f418211d;

    /* renamed from: e, reason: collision with root package name */
    public int f418212e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f418213f;

    public aw() {
        this(0, 0, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new aw(0, 0, null, 7, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ aw(int i3, int i16, c45.a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1.b().getValue(), r1.b().getValue(), c45.a.f30290b);
        d.c.a aVar2 = d.c.f30317b;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418211d), new b.a(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418212e), new b.a(false))), TuplesKt.to(3, new c45.h(3, this.f418213f, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SceneType }");
            this.f418211d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SceneType }");
            this.f418212e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f418213f = (c45.a) obj;
        }
    }

    public aw(int i3, int i16, c45.a aVar) {
        this.f418211d = i3;
        this.f418212e = i16;
        this.f418213f = aVar;
    }
}
