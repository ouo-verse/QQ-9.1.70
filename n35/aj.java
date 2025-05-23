package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aj extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f418161d;

    /* renamed from: e, reason: collision with root package name */
    public int f418162e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f418163f;

    public /* synthetic */ aj() {
        this(d.c.f30317b.b().getValue(), 0, c45.a.f30290b);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new aj());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418161d), new b.a(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418162e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f418163f, new b.e.C0167b(false))));
        return mapOf;
    }

    public aj(int i3, int i16, c45.a aVar) {
        this.f418161d = i3;
        this.f418162e = i16;
        this.f418163f = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SubFileType }");
            this.f418161d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f418162e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f418163f = (c45.a) obj;
        }
    }
}
