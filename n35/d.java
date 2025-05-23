package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f418221d;

    public d() {
        this(0, 1, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(0, 1, null));
    }

    public /* synthetic */ d(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418221d), new b.a(false))));
        return mapOf;
    }

    public d(int i3) {
        this.f418221d = i3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.AgentType }");
            this.f418221d = ((Integer) obj).intValue();
        }
    }
}
