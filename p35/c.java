package p35;

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

/* compiled from: P */
/* loaded from: classes33.dex */
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f425152d;

    /* renamed from: e, reason: collision with root package name */
    public int f425153e;

    /* renamed from: f, reason: collision with root package name */
    public final List<ag> f425154f;

    /* renamed from: h, reason: collision with root package name */
    public af f425155h;

    /* renamed from: i, reason: collision with root package name */
    public int f425156i;

    /* renamed from: m, reason: collision with root package name */
    public c45.a f425157m;

    public c() {
        this(null, 0, null, null, 0, null, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, 0, null, null, 0, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425152d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425153e = ((Integer) obj).intValue();
                return;
            case 3:
                List<ag> list = this.f425154f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StImage>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StGPSV2");
                this.f425155h = (af) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425156i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f425157m = (c45.a) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ c(String str, int i3, List list, af afVar, int i16, c45.a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, new ArrayList(), null, 0, c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425152d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f425153e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f425154f, new b.f(new b.d(new ag(null, 15)), false))), TuplesKt.to(4, new c45.h(4, this.f425155h, new b.d(new af(0L, 0L, 0L, 0L, 15, null)))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f425156i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, this.f425157m, new b.e.C0167b(false))));
        return mapOf;
    }

    public c(String str, int i3, List<ag> list, af afVar, int i16, c45.a aVar) {
        this.f425152d = str;
        this.f425153e = i3;
        this.f425154f = list;
        this.f425155h = afVar;
        this.f425156i = i16;
        this.f425157m = aVar;
    }
}
