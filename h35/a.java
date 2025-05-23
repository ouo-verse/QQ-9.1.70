package h35;

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
    public String f404268d;

    /* renamed from: e, reason: collision with root package name */
    public long f404269e;

    /* renamed from: f, reason: collision with root package name */
    public String f404270f;

    /* renamed from: h, reason: collision with root package name */
    public long f404271h;

    /* renamed from: i, reason: collision with root package name */
    public long f404272i;

    public a() {
        this(null, 0L, null, 0L, 0L, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, 0L, null, 0L, 0L, 31, null));
    }

    public /* synthetic */ a(String str, long j3, String str2, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, "", 0L, 0L);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f404268d, new b.e.g(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f404269e), new b.e.i(false))), TuplesKt.to(3, new h(3, this.f404270f, new b.e.g(false))), TuplesKt.to(4, new h(4, Long.valueOf(this.f404271h), new b.e.i(false))), TuplesKt.to(5, new h(5, Long.valueOf(this.f404272i), new b.e.f(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404268d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404269e = ((Long) obj).longValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404270f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404271h = ((Long) obj).longValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404272i = ((Long) obj).longValue();
        }
    }

    public a(String str, long j3, String str2, long j16, long j17) {
        this.f404268d = str;
        this.f404269e = j3;
        this.f404270f = str2;
        this.f404271h = j16;
        this.f404272i = j17;
    }
}
