package l35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f413781d;

    /* renamed from: e, reason: collision with root package name */
    public int f413782e;

    /* renamed from: f, reason: collision with root package name */
    public int f413783f;

    /* renamed from: h, reason: collision with root package name */
    public int f413784h;

    /* renamed from: i, reason: collision with root package name */
    public int f413785i;

    public a() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(0, 0, 0, 0, 0, 31, null));
    }

    public /* synthetic */ a(int i3, int i16, int i17, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, 0, 0, 0);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f413781d), new b.e.h(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f413782e), new b.e.h(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f413783f), new b.e.h(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f413784h), new b.e.h(false))), TuplesKt.to(5, new h(5, Integer.valueOf(this.f413785i), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413781d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413782e = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413783f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413784h = ((Integer) obj).intValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413785i = ((Integer) obj).intValue();
        }
    }

    public a(int i3, int i16, int i17, int i18, int i19) {
        this.f413781d = i3;
        this.f413782e = i16;
        this.f413783f = i17;
        this.f413784h = i18;
        this.f413785i = i19;
    }
}
