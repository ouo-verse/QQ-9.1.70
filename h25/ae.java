package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ae extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public c45.a f404138d;

    /* renamed from: e, reason: collision with root package name */
    public String f404139e;

    /* renamed from: f, reason: collision with root package name */
    public int f404140f;

    public /* synthetic */ ae(c45.a aVar, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? c45.a.f30290b : aVar, (i16 & 2) != 0 ? "" : str, 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ae(null, null, 0, 7, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404138d, new b.e.C0167b(false))), TuplesKt.to(2, new c45.h(2, this.f404139e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f404140f), new b.e.C0168e(false))));
        return mapOf;
    }

    public ae(c45.a aVar, String str, int i3) {
        this.f404138d = aVar;
        this.f404139e = str;
        this.f404140f = i3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f404138d = (c45.a) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404139e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404140f = ((Integer) obj).intValue();
        }
    }
}
