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
public final class al extends c45.j {
    public final List<e> C;
    public final List<t> D;
    public an E;
    public ab F;
    public g G;

    /* renamed from: d, reason: collision with root package name */
    public long f404159d;

    /* renamed from: e, reason: collision with root package name */
    public String f404160e;

    /* renamed from: f, reason: collision with root package name */
    public String f404161f;

    /* renamed from: h, reason: collision with root package name */
    public String f404162h;

    /* renamed from: i, reason: collision with root package name */
    public String f404163i;

    /* renamed from: m, reason: collision with root package name */
    public am f404164m;

    public al() {
        this(0L, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new al(0L, null, null, null, null, null, null, null, null, null, null, 2047, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f404159d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404160e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404161f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404162h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404163i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.RobotMetric");
                this.f404164m = (am) obj;
                return;
            case 7:
                List<e> list = this.C;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.ActivityLabel>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 8:
                List<t> list2 = this.D;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.GroupInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.RobotRecycleInfo");
                this.E = (an) obj;
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.QZoneInfo");
                this.F = (ab) obj;
                return;
            case 11:
            default:
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.ControlInfo");
                this.G = (g) obj;
                return;
        }
    }

    public /* synthetic */ al(long j3, String str, String str2, String str3, String str4, am amVar, List list, List list2, an anVar, ab abVar, g gVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", "", "", null, new ArrayList(), new ArrayList(), null, null, null);
    }

    public al(long j3, String str, String str2, String str3, String str4, am amVar, List<e> list, List<t> list2, an anVar, ab abVar, g gVar) {
        this.f404159d = j3;
        this.f404160e = str;
        this.f404161f = str2;
        this.f404162h = str3;
        this.f404163i = str4;
        this.f404164m = amVar;
        this.C = list;
        this.D = list2;
        this.E = anVar;
        this.F = abVar;
        this.G = gVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = 0;
        String str = null;
        String str2 = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f404159d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f404160e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f404161f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f404162h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f404163i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f404164m, new b.d(new am(null, null, null, 7, null)))), TuplesKt.to(7, new c45.h(7, this.C, new b.f(new b.d(new e(0 == true ? 1 : 0, 0 == true ? 1 : 0, null, false, 15, defaultConstructorMarker)), false))), TuplesKt.to(8, new c45.h(8, this.D, new b.f(new b.d(new t(0L, 0 == true ? 1 : 0, null, 7, defaultConstructorMarker)), false))), TuplesKt.to(9, new c45.h(9, this.E, new b.d(new an(i3, str, str2, null, 15, 0 == true ? 1 : 0)))), TuplesKt.to(10, new c45.h(10, this.F, new b.d(new ab(i3, str, str2, 0, 0, 31, null)))), TuplesKt.to(12, new c45.h(12, this.G, new b.d(new g(i3, 0, str2, 7, null)))));
        return mapOf;
    }
}
