package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class al extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public f f418170d;

    /* renamed from: e, reason: collision with root package name */
    public int f418171e;

    /* renamed from: f, reason: collision with root package name */
    public String f418172f;

    public al() {
        this(null, 0, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new al(null, 0, null, 7, null));
    }

    public /* synthetic */ al(f fVar, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418170d, new b.d(new f(0L, 0, 3, null)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418171e), new b.e.C0168e(false))), TuplesKt.to(3, new c45.h(3, this.f418172f, new b.e.g(false))));
        return mapOf;
    }

    public al(f fVar, int i3, String str) {
        this.f418170d = fVar;
        this.f418171e = i3;
        this.f418172f = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.CommonHead");
            this.f418170d = (f) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f418171e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418172f = (String) obj;
        }
    }
}
