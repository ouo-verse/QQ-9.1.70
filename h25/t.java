package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f404238d;

    /* renamed from: e, reason: collision with root package name */
    public c45.a f404239e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f404240f;

    public t() {
        this(0L, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new t(0L, null, null, 7, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ t(long j3, c45.a aVar, c45.a aVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, r3, r3);
        c45.a aVar3 = c45.a.f30290b;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f404238d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f404239e, new b.e.C0167b(false))), TuplesKt.to(3, new c45.h(3, this.f404240f, new b.e.C0167b(false))));
        return mapOf;
    }

    public t(long j3, c45.a aVar, c45.a aVar2) {
        this.f404238d = j3;
        this.f404239e = aVar;
        this.f404240f = aVar2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404238d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f404239e = (c45.a) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f404240f = (c45.a) obj;
        }
    }
}
