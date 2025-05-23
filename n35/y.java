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
public final class y extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f418277d;

    /* renamed from: e, reason: collision with root package name */
    public c45.a f418278e;

    /* renamed from: f, reason: collision with root package name */
    public long f418279f;

    public y() {
        this(0, null, 0L, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new y(0, null, 0L, 7, null));
    }

    public /* synthetic */ y(int i3, c45.a aVar, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), c45.a.f30290b, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418277d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f418278e, new b.e.C0167b(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f418279f), new b.e.f(false))));
        return mapOf;
    }

    public y(int i3, c45.a aVar, long j3) {
        this.f418277d = i3;
        this.f418278e = aVar;
        this.f418279f = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.AuthCode }");
            this.f418277d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f418278e = (c45.a) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418279f = ((Long) obj).longValue();
        }
    }
}
