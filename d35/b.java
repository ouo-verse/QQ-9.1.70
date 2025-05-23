package d35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m25.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public c f392768d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f392769e;

    /* renamed from: f, reason: collision with root package name */
    public String f392770f;

    /* renamed from: h, reason: collision with root package name */
    public long f392771h;

    public b() {
        this(null, false, null, 0L, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(null, false, null, 0L, 15, null));
    }

    public /* synthetic */ b(c cVar, boolean z16, String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, false, "", 0L);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f392768d, new b.d(new c(null, null, 15)))), TuplesKt.to(2, new h(2, Boolean.valueOf(this.f392769e), new b.e.a(false))), TuplesKt.to(3, new h(3, this.f392770f, new b.e.g(false))), TuplesKt.to(4, new h(4, Long.valueOf(this.f392771h), new b.e.f(false))));
        return mapOf;
    }

    public b(c cVar, boolean z16, String str, long j3) {
        this.f392768d = cVar;
        this.f392769e = z16;
        this.f392770f = str;
        this.f392771h = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f392768d = (c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f392769e = ((Boolean) obj).booleanValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f392770f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f392771h = ((Long) obj).longValue();
        }
    }
}
