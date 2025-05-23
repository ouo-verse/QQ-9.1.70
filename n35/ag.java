package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ag extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418147d;

    /* renamed from: e, reason: collision with root package name */
    public long f418148e;

    /* renamed from: f, reason: collision with root package name */
    public int f418149f;

    /* renamed from: h, reason: collision with root package name */
    public int f418150h;

    /* renamed from: i, reason: collision with root package name */
    public int f418151i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ag() {
        this("", 0L, r0.b().getValue(), 0, r0.b().getValue());
        d.c.a aVar = d.c.f30317b;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ag());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418147d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f418148e), new b.e.f(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f418149f), new b.a(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f418150h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f418151i), new b.a(false))));
        return mapOf;
    }

    public ag(String str, long j3, int i3, int i16, int i17) {
        this.f418147d = str;
        this.f418148e = j3;
        this.f418149f = i3;
        this.f418150h = i16;
        this.f418151i = i17;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418147d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418148e = ((Long) obj).longValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.StoreID }");
            this.f418149f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f418150h = ((Integer) obj).intValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.MsgBusType }");
            this.f418151i = ((Integer) obj).intValue();
        }
    }
}
