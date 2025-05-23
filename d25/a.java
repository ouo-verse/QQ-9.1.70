package d25;

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
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f392710d;

    /* renamed from: e, reason: collision with root package name */
    public String f392711e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f392712f;

    public a() {
        this(null, 7);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, 7));
    }

    public /* synthetic */ a(String str, int i3) {
        this(0L, (i3 & 2) != 0 ? "" : str, null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f392710d), new b.e.i(true))), TuplesKt.to(2, new h(2, this.f392711e, new b.e.g(true))), TuplesKt.to(3, new h(3, this.f392712f, new b.e.C0167b(true))));
        return mapOf;
    }

    public a(long j3, String str, c45.a aVar) {
        this.f392710d = j3;
        this.f392711e = str;
        this.f392712f = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f392710d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f392711e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f392712f = (c45.a) obj;
        }
    }
}
