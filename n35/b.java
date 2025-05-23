package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f418215d;

    /* renamed from: e, reason: collision with root package name */
    public String f418216e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f418217f;

    public b() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(0, null, null, 7, null));
    }

    public /* synthetic */ b(int i3, String str, c45.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "", c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418215d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f418216e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f418217f, new b.e.C0167b(false))));
        return mapOf;
    }

    public b(int i3, String str, c45.a aVar) {
        this.f418215d = i3;
        this.f418216e = str;
        this.f418217f = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.AccountType }");
            this.f418215d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418216e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f418217f = (c45.a) obj;
        }
    }
}
