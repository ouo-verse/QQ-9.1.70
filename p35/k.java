package p35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class k extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f425182d;

    /* renamed from: e, reason: collision with root package name */
    public String f425183e;

    /* renamed from: f, reason: collision with root package name */
    public m25.c f425184f;

    public k() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(0, null, null, 7, null));
    }

    public /* synthetic */ k(int i3, String str, m25.c cVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f425182d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f425183e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f425184f, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    public k(int i3, String str, m25.c cVar) {
        this.f425182d = i3;
        this.f425183e = str;
        this.f425184f = cVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f425182d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425183e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f425184f = (m25.c) obj;
        }
    }
}
