package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class z extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f395518d;

    /* renamed from: e, reason: collision with root package name */
    public long f395519e;

    /* renamed from: f, reason: collision with root package name */
    public String f395520f;

    /* renamed from: h, reason: collision with root package name */
    public String f395521h;

    public z() {
        this(null, 0L, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new z(null, 0L, null, null, 15, null));
    }

    public /* synthetic */ z(String str, long j3, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f395518d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f395519e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, this.f395520f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f395521h, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395518d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f395519e = ((Long) obj).longValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395520f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395521h = (String) obj;
        }
    }

    public z(String str, long j3, String str2, String str3) {
        this.f395518d = str;
        this.f395519e = j3;
        this.f395520f = str2;
        this.f395521h = str3;
    }
}
