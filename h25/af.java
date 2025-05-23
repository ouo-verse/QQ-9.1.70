package h25;

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
public final class af extends c45.j {
    public boolean C;
    public d D;
    public at E;

    /* renamed from: d, reason: collision with root package name */
    public final List<al> f404141d;

    /* renamed from: e, reason: collision with root package name */
    public y f404142e;

    /* renamed from: f, reason: collision with root package name */
    public final List<u> f404143f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f404144h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f404145i;

    /* renamed from: m, reason: collision with root package name */
    public String f404146m;

    public af() {
        this(null, null, null, null, false, null, false, null, null, 511, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new af(null, null, null, null, false, null, false, null, null, 511, null));
    }

    public /* synthetic */ af(List list, y yVar, List list2, c45.a aVar, boolean z16, String str, boolean z17, d dVar, at atVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), null, new ArrayList(), c45.a.f30290b, false, "", false, null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        long j3 = 0;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404141d, new b.f(new b.d(new al(j3, null, null, null, null, null, null, null, null, null, null, 2047, null)), false))), TuplesKt.to(2, new c45.h(2, this.f404142e, new b.d(new y(j3, 0L, 0L, 7, null)))), TuplesKt.to(3, new c45.h(3, this.f404143f, new b.f(new b.d(new u(0, null, null, null, 15, null)), false))), TuplesKt.to(10, new c45.h(10, this.f404144h, new b.e.C0167b(false))), TuplesKt.to(11, new c45.h(11, Boolean.valueOf(this.f404145i), new b.e.a(false))), TuplesKt.to(12, new c45.h(12, this.f404146m, new b.e.g(false))), TuplesKt.to(13, new c45.h(13, Boolean.valueOf(this.C), new b.e.a(false))), TuplesKt.to(14, new c45.h(14, this.D, new b.d(new d(null, null, null, null, null, 0L, 0L, null, 0, null, null, null, null, null, null, null, null, 131071, null)))), TuplesKt.to(15, new c45.h(15, this.E, new b.d(new at("")))));
        return mapOf;
    }

    public af(List<al> list, y yVar, List<u> list2, c45.a aVar, boolean z16, String str, boolean z17, d dVar, at atVar) {
        this.f404141d = list;
        this.f404142e = yVar;
        this.f404143f = list2;
        this.f404144h = aVar;
        this.f404145i = z16;
        this.f404146m = str;
        this.C = z17;
        this.D = dVar;
        this.E = atVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<al> list = this.f404141d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.RobotInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.MyRobotMetric");
            this.f404142e = (y) obj;
            return;
        }
        if (i3 != 3) {
            switch (i3) {
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                    this.f404144h = (c45.a) obj;
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.f404145i = ((Boolean) obj).booleanValue();
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f404146m = (String) obj;
                    return;
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.C = ((Boolean) obj).booleanValue();
                    return;
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.Activity");
                    this.D = (d) obj;
                    return;
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.UGCRecycleSetting");
                    this.E = (at) obj;
                    return;
                default:
                    return;
            }
        }
        List<u> list2 = this.f404143f;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.IdentityInfo>");
        CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
    }
}
