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
public final class s extends c45.j {
    public int C;
    public ak D;

    /* renamed from: d, reason: collision with root package name */
    public f25.i f404232d;

    /* renamed from: e, reason: collision with root package name */
    public final List<aa> f404233e;

    /* renamed from: f, reason: collision with root package name */
    public int f404234f;

    /* renamed from: h, reason: collision with root package name */
    public as f404235h;

    /* renamed from: i, reason: collision with root package name */
    public at f404236i;

    /* renamed from: m, reason: collision with root package name */
    public final List<i> f404237m;

    public s() {
        this(null, null, 0, null, null, null, 0, null, 255, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new s(null, null, 0, null, null, null, 0, null, 255, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.RobotTTSList");
                this.f404232d = (f25.i) obj;
                return;
            case 2:
                List<aa> list = this.f404233e;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.PromptLabel>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f404234f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.UGCConversationSetting");
                this.f404235h = (as) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.UGCRecycleSetting");
                this.f404236i = (at) obj;
                return;
            case 6:
                List<i> list2 = this.f404237m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.CreatorTTSInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.C = ((Integer) obj).intValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.ReadTextInfo");
                this.D = (ak) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ s(f25.i iVar, List list, int i3, as asVar, at atVar, List list2, int i16, ak akVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), 0, null, null, new ArrayList(), 0, null);
    }

    public s(f25.i iVar, List<aa> list, int i3, as asVar, at atVar, List<i> list2, int i16, ak akVar) {
        this.f404232d = iVar;
        this.f404233e = list;
        this.f404234f = i3;
        this.f404235h = asVar;
        this.f404236i = atVar;
        this.f404237m = list2;
        this.C = i16;
        this.D = akVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 3;
        int i16 = 0;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404232d, new b.d(new f25.i(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(2, new c45.h(2, this.f404233e, new b.f(new b.d(new aa(0, "")), false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f404234f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f404235h, new b.d(new as(i16, i16, i3, 0 == true ? 1 : 0)))), TuplesKt.to(5, new c45.h(5, this.f404236i, new b.d(new at("")))), TuplesKt.to(6, new c45.h(6, this.f404237m, new b.f(new b.d(new i(null, 0, null, 0, 15, null)), false))), TuplesKt.to(7, new c45.h(7, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.d(new ak(null, null, null, 7, null)))));
        return mapOf;
    }
}
