package l35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public c45.a f413786d;

    /* renamed from: e, reason: collision with root package name */
    public int f413787e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f413788f;

    /* renamed from: h, reason: collision with root package name */
    public int f413789h;

    /* renamed from: i, reason: collision with root package name */
    public int f413790i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ b() {
        this(r3, 0, r3, 0, 0);
        c45.a aVar = c45.a.f30290b;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b());
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f413786d, new b.e.C0167b(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f413787e), new b.e.h(false))), TuplesKt.to(3, new h(3, this.f413788f, new b.e.C0167b(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f413789h), new b.e.h(false))), TuplesKt.to(5, new h(5, Integer.valueOf(this.f413790i), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f413786d = (c45.a) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413787e = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f413788f = (c45.a) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413789h = ((Integer) obj).intValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413790i = ((Integer) obj).intValue();
        }
    }

    public b(c45.a aVar, int i3, c45.a aVar2, int i16, int i17) {
        this.f413786d = aVar;
        this.f413787e = i3;
        this.f413788f = aVar2;
        this.f413789h = i16;
        this.f413790i = i17;
    }
}
