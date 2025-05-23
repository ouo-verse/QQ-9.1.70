package g25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public c45.a f401146d;

    /* renamed from: e, reason: collision with root package name */
    public String f401147e;

    /* renamed from: f, reason: collision with root package name */
    public String f401148f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f401149h;

    /* renamed from: i, reason: collision with root package name */
    public int f401150i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f401151m;

    public /* synthetic */ d(c45.a aVar, String str, String str2, boolean z16, int i3) {
        this((i3 & 1) != 0 ? c45.a.f30290b : aVar, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, false, 0, (i3 & 32) != 0 ? false : z16);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, null, null, false, 63));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f401146d = (c45.a) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401147e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401148f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f401149h = ((Boolean) obj).booleanValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f401150i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f401151m = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f401146d, new b.e.C0167b(false))), TuplesKt.to(2, new c45.h(2, this.f401147e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f401148f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Boolean.valueOf(this.f401149h), new b.e.a(false))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f401150i), new b.e.C0168e(false))), TuplesKt.to(6, new c45.h(6, Boolean.valueOf(this.f401151m), new b.e.a(false))));
        return mapOf;
    }

    public d(c45.a aVar, String str, String str2, boolean z16, int i3, boolean z17) {
        this.f401146d = aVar;
        this.f401147e = str;
        this.f401148f = str2;
        this.f401149h = z16;
        this.f401150i = i3;
        this.f401151m = z17;
    }
}
