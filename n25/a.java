package n25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import n35.w;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418043d;

    /* renamed from: e, reason: collision with root package name */
    public int f418044e;

    /* renamed from: f, reason: collision with root package name */
    public final List<j> f418045f;

    /* renamed from: h, reason: collision with root package name */
    public i f418046h;

    /* renamed from: i, reason: collision with root package name */
    public int f418047i;

    /* renamed from: m, reason: collision with root package name */
    public c45.a f418048m;

    public a() {
        this(null, 0, null, null, 0, null, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new a(null, 0, null, null, 0, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418043d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418044e = ((Integer) obj).intValue();
                return;
            case 3:
                List<j> list = this.f418045f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.StImage>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StGPSV2");
                this.f418046h = (i) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418047i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f418048m = (c45.a) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ a(String str, int i3, List list, i iVar, int i16, c45.a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, new ArrayList(), null, 0, c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418043d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418044e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f418045f, new b.f(new b.d(new j((w) null, (String) (0 == true ? 1 : 0), 7)), false))), TuplesKt.to(4, new c45.h(4, this.f418046h, new b.d(new i(0L, 0L, 15)))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f418047i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, this.f418048m, new b.e.C0167b(false))));
        return mapOf;
    }

    public a(String str, int i3, List<j> list, i iVar, int i16, c45.a aVar) {
        this.f418043d = str;
        this.f418044e = i3;
        this.f418045f = list;
        this.f418046h = iVar;
        this.f418047i = i16;
        this.f418048m = aVar;
    }
}
