package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f425149d;

    /* renamed from: e, reason: collision with root package name */
    public int f425150e;

    /* renamed from: f, reason: collision with root package name */
    public String f425151f;

    public b() {
        this(null, 0, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, 0, null, 7, null));
    }

    public /* synthetic */ b(m25.c cVar, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425149d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f425150e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f425151f, new b.e.g(false))));
        return mapOf;
    }

    public b(m25.c cVar, int i3, String str) {
        this.f425149d = cVar;
        this.f425150e = i3;
        this.f425151f = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425149d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425150e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425151f = (String) obj;
        }
    }
}
