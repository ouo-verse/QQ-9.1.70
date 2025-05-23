package n25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418098d;

    /* renamed from: e, reason: collision with root package name */
    public String f418099e;

    /* renamed from: f, reason: collision with root package name */
    public String f418100f;

    /* renamed from: h, reason: collision with root package name */
    public String f418101h;

    public m() {
        this(null, 15);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new m(null, 15));
    }

    public /* synthetic */ m(String str, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : null, (i3 & 4) != 0 ? "" : null, (i3 & 8) == 0 ? null : "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418098d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f418099e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f418100f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f418101h, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418098d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418099e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418100f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418101h = (String) obj;
        }
    }

    public m(String str, String str2, String str3, String str4) {
        this.f418098d = str;
        this.f418099e = str2;
        this.f418100f = str3;
        this.f418101h = str4;
    }
}
