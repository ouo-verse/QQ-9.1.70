package l25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f413757d;

    /* renamed from: e, reason: collision with root package name */
    public String f413758e;

    /* renamed from: f, reason: collision with root package name */
    public int f413759f;

    /* renamed from: h, reason: collision with root package name */
    public int f413760h;

    /* renamed from: i, reason: collision with root package name */
    public c45.a f413761i;

    public f() {
        this(0, null, 0, 0, null, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(0, null, 0, 0, null, 31, null));
    }

    public /* synthetic */ f(int i3, String str, int i16, int i17, c45.a aVar, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", 0, 0, c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f413757d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f413758e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f413759f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f413760h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, this.f413761i, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413757d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f413758e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413759f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f413760h = ((Integer) obj).intValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f413761i = (c45.a) obj;
        }
    }

    public f(int i3, String str, int i16, int i17, c45.a aVar) {
        this.f413757d = i3;
        this.f413758e = str;
        this.f413759f = i16;
        this.f413760h = i17;
        this.f413761i = aVar;
    }
}
