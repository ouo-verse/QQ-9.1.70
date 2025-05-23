package m25;

import c45.b;
import c45.d;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f416062d;

    /* renamed from: e, reason: collision with root package name */
    public String f416063e;

    public f() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new f(0, null, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ f(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f416062d), new b.a(false))), TuplesKt.to(2, new h(2, this.f416063e, new b.e.g(false))));
        return mapOf;
    }

    public f(int i3, String str) {
        this.f416062d = i3;
        this.f416063e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonKt.ResponseCode }");
            this.f416062d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f416063e = (String) obj;
        }
    }
}
