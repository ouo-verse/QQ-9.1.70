package o25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends j {

    /* renamed from: d, reason: collision with root package name */
    public e f421855d;

    /* renamed from: e, reason: collision with root package name */
    public int f421856e;

    /* renamed from: f, reason: collision with root package name */
    public int f421857f;

    /* renamed from: h, reason: collision with root package name */
    public String f421858h;

    /* renamed from: i, reason: collision with root package name */
    public String f421859i;

    public g() {
        this(null, 0, 0, null, null, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, 0, 0, null, null, 31, null));
    }

    public /* synthetic */ g(e eVar, int i3, int i16, String str, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0, 0, "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        float f16 = 0.0f;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421855d, new b.d(new e(f16, f16, 7)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f421856e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f421857f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f421858h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f421859i, new b.e.g(false))));
        return mapOf;
    }

    public g(e eVar, int i3, int i16, String str, String str2) {
        this.f421855d = eVar;
        this.f421856e = i3;
        this.f421857f = i16;
        this.f421858h = str;
        this.f421859i = str2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f421855d = (e) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f421856e = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f421857f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421858h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421859i = (String) obj;
        }
    }
}
