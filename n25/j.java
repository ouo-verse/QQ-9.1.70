package n25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n35.w;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public w f418083d;

    /* renamed from: e, reason: collision with root package name */
    public String f418084e;

    /* renamed from: f, reason: collision with root package name */
    public String f418085f;

    public j() {
        this((w) null, (String) (0 == true ? 1 : 0), 7);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j((w) null, (String) (0 == true ? 1 : 0), 7));
    }

    public /* synthetic */ j(w wVar, String str, int i3) {
        this((i3 & 1) != 0 ? null : wVar, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418083d, new b.d(new w(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(2, new c45.h(2, this.f418084e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f418085f, new b.e.g(false))));
        return mapOf;
    }

    public j(w wVar, String str, String str2) {
        this.f418083d = wVar;
        this.f418084e = str;
        this.f418085f = str2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo");
            this.f418083d = (w) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418084e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418085f = (String) obj;
        }
    }
}
