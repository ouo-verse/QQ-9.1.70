package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ao extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public boolean f418184d;

    /* renamed from: e, reason: collision with root package name */
    public long f418185e;

    /* renamed from: f, reason: collision with root package name */
    public w f418186f;

    /* renamed from: h, reason: collision with root package name */
    public int f418187h;

    public ao() {
        this(false, 0L, null, 0, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ao(false, 0L, null, 0, 15, null));
    }

    public /* synthetic */ ao(boolean z16, long j3, w wVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, 0L, null, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Boolean.valueOf(this.f418184d), new b.e.a(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f418185e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, this.f418186f, new b.d(new w(null, null, 3, null)))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f418187h), new b.e.h(false))));
        return mapOf;
    }

    public ao(boolean z16, long j3, w wVar, int i3) {
        this.f418184d = z16;
        this.f418185e = j3;
        this.f418186f = wVar;
        this.f418187h = i3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f418184d = ((Boolean) obj).booleanValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418185e = ((Long) obj).longValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo");
            this.f418186f = (w) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f418187h = ((Integer) obj).intValue();
        }
    }
}
