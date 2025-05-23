package j25;

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
    public long f409173d;

    /* renamed from: e, reason: collision with root package name */
    public String f409174e;

    public a() {
        this(0L, null, 3, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(0L, null, 3, null));
    }

    public /* synthetic */ a(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f409173d), new b.e.i(false))), TuplesKt.to(2, new h(2, this.f409174e, new b.e.g(false))));
        return mapOf;
    }

    public a(long j3, String str) {
        this.f409173d = j3;
        this.f409174e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f409173d = ((Long) obj).longValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f409174e = (String) obj;
        }
    }
}
