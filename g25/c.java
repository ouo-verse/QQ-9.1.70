package g25;

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
public final class c extends c45.j {
    public boolean C;
    public String D;
    public long E;
    public boolean F;

    /* renamed from: d, reason: collision with root package name */
    public final List<k> f401140d;

    /* renamed from: e, reason: collision with root package name */
    public j f401141e;

    /* renamed from: f, reason: collision with root package name */
    public final List<b> f401142f;

    /* renamed from: h, reason: collision with root package name */
    public h f401143h;

    /* renamed from: i, reason: collision with root package name */
    public final List<g> f401144i;

    /* renamed from: m, reason: collision with root package name */
    public c45.a f401145m;

    public c() {
        this(null, null, null, null, null, null, false, null, 0L, false, 1023, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, null, null, null, null, null, false, null, 0L, false, 1023, null));
    }

    public /* synthetic */ c(List list, j jVar, List list2, h hVar, List list3, c45.a aVar, boolean z16, String str, long j3, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), null, new ArrayList(), null, new ArrayList(), c45.a.f30290b, false, "", 0L, false);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f401140d, new b.f(new b.d(new k(0L, null, null, null, 0, null, 0, 0L, false, null, null, null, null, null, 0, 0, 0L, null, 0L, null, false, 0, 0, 0L, null, null, 0L, null, null, false, null, null, 0, null, null, -1, 7, null)), false))), TuplesKt.to(2, new c45.h(2, this.f401141e, new b.d(new j(null, 1, 0 == true ? 1 : 0)))), TuplesKt.to(3, new c45.h(3, this.f401142f, new b.f(new b.d(new b(0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)), false))), TuplesKt.to(4, new c45.h(4, this.f401143h, new b.d(new h(null, null, 3, null)))), TuplesKt.to(5, new c45.h(5, this.f401144i, new b.f(new b.d(new g(null, null, null, null, null, null, null, 127, null)), false))), TuplesKt.to(10, new c45.h(10, this.f401145m, new b.e.C0167b(false))), TuplesKt.to(11, new c45.h(11, Boolean.valueOf(this.C), new b.e.a(false))), TuplesKt.to(12, new c45.h(12, this.D, new b.e.g(false))), TuplesKt.to(13, new c45.h(13, Long.valueOf(this.E), new b.e.i(false))), TuplesKt.to(14, new c45.h(14, Boolean.valueOf(this.F), new b.e.a(false))));
        return mapOf;
    }

    public c(List<k> list, j jVar, List<b> list2, h hVar, List<g> list3, c45.a aVar, boolean z16, String str, long j3, boolean z17) {
        this.f401140d = list;
        this.f401141e = jVar;
        this.f401142f = list2;
        this.f401143h = hVar;
        this.f401144i = list3;
        this.f401145m = aVar;
        this.C = z16;
        this.D = str;
        this.E = j3;
        this.F = z17;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<k> list = this.f401140d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.RobotInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.RecommendInfo");
            this.f401141e = (j) obj;
            return;
        }
        if (i3 == 3) {
            List<b> list2 = this.f401142f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.AdelieCardInfos>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
            return;
        }
        if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.ListNode");
            this.f401143h = (h) obj;
            return;
        }
        if (i3 != 5) {
            switch (i3) {
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                    this.f401145m = (c45.a) obj;
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.C = ((Boolean) obj).booleanValue();
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.D = (String) obj;
                    return;
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.E = ((Long) obj).longValue();
                    return;
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.F = ((Boolean) obj).booleanValue();
                    return;
                default:
                    return;
            }
        }
        List<g> list3 = this.f401144i;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.GuideInfo>");
        CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
    }
}
