package i25;

import c45.b;
import c45.f;
import c45.h;
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
    public c f407127d;

    /* renamed from: e, reason: collision with root package name */
    public String f407128e;

    public b() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ b(c cVar, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f407127d, new b.d(new c(0, null, 3, 0 == true ? 1 : 0)))), TuplesKt.to(2, new h(2, this.f407128e, new b.e.g(false))));
        return mapOf;
    }

    public b(c cVar, String str) {
        this.f407127d = cVar;
        this.f407128e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.kuolie.assisted_chat.assisted_chat.RspHead");
            this.f407127d = (c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f407128e = (String) obj;
        }
    }
}
