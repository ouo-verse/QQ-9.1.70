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
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f421835d;

    /* renamed from: e, reason: collision with root package name */
    public h f421836e;

    /* renamed from: f, reason: collision with root package name */
    public String f421837f;

    public b() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, null, null, 7, null));
    }

    public /* synthetic */ b(String str, h hVar, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 0;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421835d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f421836e, new b.d(new h(i3, i3, 3, null)))), TuplesKt.to(3, new c45.h(3, this.f421837f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421835d = (String) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.PixelCoordinate");
            this.f421836e = (h) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f421837f = (String) obj;
        }
    }

    public b(String str, h hVar, String str2) {
        this.f421835d = str;
        this.f421836e = hVar;
        this.f421837f = str2;
    }
}
