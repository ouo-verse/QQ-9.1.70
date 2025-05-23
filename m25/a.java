package m25;

import c45.b;
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
    public String f416049d;

    /* renamed from: e, reason: collision with root package name */
    public c45.a f416050e;

    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new a(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ a(String str, c45.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f416049d, new b.e.g(false))), TuplesKt.to(2, new h(2, this.f416050e, new b.e.C0167b(false))));
        return mapOf;
    }

    public a(String str, c45.a aVar) {
        this.f416049d = str;
        this.f416050e = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f416049d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f416050e = (c45.a) obj;
        }
    }
}
