package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public v f418244d;

    /* renamed from: e, reason: collision with root package name */
    public j f418245e;

    public n() {
        this((v) null, 3);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new n((v) null, 3));
    }

    public /* synthetic */ n(v vVar, int i3) {
        this((i3 & 1) != 0 ? null : vVar, (j) null);
    }

    public n(v vVar, j jVar) {
        this.f418244d = vVar;
        this.f418245e = jVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418244d, new b.d(new v(null, null, 0, 0L, 0L, 0, 0, 127, null)))), TuplesKt.to(2, new c45.h(2, this.f418245e, new b.d(new j(null, null, null, 7, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.IndexNode");
            this.f418244d = (v) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DownloadExt");
            this.f418245e = (j) obj;
        }
    }
}
