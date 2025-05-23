package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ai extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public f f418158d;

    /* renamed from: e, reason: collision with root package name */
    public am f418159e;

    /* renamed from: f, reason: collision with root package name */
    public d f418160f;

    public ai() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ai(null, null, null, 7, null));
    }

    public /* synthetic */ ai(f fVar, am amVar, d dVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null);
    }

    public ai(f fVar, am amVar, d dVar) {
        this.f418158d = fVar;
        this.f418159e = amVar;
        this.f418160f = dVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418158d, new b.d(new f(0L, 0, 3, null)))), TuplesKt.to(2, new c45.h(2, this.f418159e, new b.d(new am(0, 0, 0, 0, 511)))), TuplesKt.to(3, new c45.h(3, this.f418160f, new b.d(new d(0, 1, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.CommonHead");
            this.f418158d = (f) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.SceneInfo");
            this.f418159e = (am) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.ClientMeta");
            this.f418160f = (d) obj;
        }
    }
}
