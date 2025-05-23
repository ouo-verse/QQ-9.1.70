package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ai extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f395456d;

    /* renamed from: e, reason: collision with root package name */
    public long f395457e;

    /* renamed from: f, reason: collision with root package name */
    public a f395458f;

    public ai() {
        this(0L, 0L, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ai(0L, 0L, null, 7, null));
    }

    public /* synthetic */ ai(long j3, long j16, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f395456d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f395457e), new b.e.i(false))), TuplesKt.to(4, new c45.h(4, this.f395458f, new b.d(new a(0, null, null, null, 15, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395456d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395457e = ((Long) obj).longValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.BubbleTips");
            this.f395458f = (a) obj;
        }
    }

    public ai(long j3, long j16, a aVar) {
        this.f395456d = j3;
        this.f395457e = j16;
        this.f395458f = aVar;
    }
}
