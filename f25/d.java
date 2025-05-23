package f25;

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
/* loaded from: classes38.dex */
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Integer f397732d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f397733e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f397734f;

    /* renamed from: h, reason: collision with root package name */
    public Integer f397735h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f397736i;

    /* renamed from: m, reason: collision with root package name */
    public final List<f> f397737m;

    public d() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, null, null, null, null, null, 63, null));
    }

    public /* synthetic */ d(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f397732d, new b.e.C0168e(true))), TuplesKt.to(2, new c45.h(2, this.f397733e, new b.e.C0168e(true))), TuplesKt.to(3, new c45.h(3, this.f397734f, new b.e.C0168e(true))), TuplesKt.to(4, new c45.h(4, this.f397735h, new b.e.C0168e(true))), TuplesKt.to(5, new c45.h(5, this.f397736i, new b.e.C0168e(true))), TuplesKt.to(100, new c45.h(100, this.f397737m, new b.f(new b.d(new f()), false))));
        return mapOf;
    }

    public d(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, List<f> list) {
        this.f397732d = num;
        this.f397733e = num2;
        this.f397734f = num3;
        this.f397735h = num4;
        this.f397736i = num5;
        this.f397737m = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 100) {
            List<f> list = this.f397737m;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.OptButton>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f397732d = (Integer) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f397733e = (Integer) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f397734f = (Integer) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f397735h = (Integer) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f397736i = (Integer) obj;
        }
    }
}
