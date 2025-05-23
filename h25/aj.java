package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aj extends c45.j {
    public int C;
    public int D;

    /* renamed from: d, reason: collision with root package name */
    public int f404150d;

    /* renamed from: e, reason: collision with root package name */
    public int f404151e;

    /* renamed from: f, reason: collision with root package name */
    public String f404152f;

    /* renamed from: h, reason: collision with root package name */
    public x f404153h;

    /* renamed from: i, reason: collision with root package name */
    public a f404154i;

    /* renamed from: m, reason: collision with root package name */
    public i f404155m;

    public aj() {
        this(0, 0, null, null, null, null, 0, 0, 255, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new aj(0, 0, null, null, null, null, 0, 0, 255, null));
    }

    public /* synthetic */ aj(int i3, int i16, String str, x xVar, a aVar, i iVar, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, "", null, null, null, 0, 0);
    }

    public aj(int i3, int i16, String str, x xVar, a aVar, i iVar, int i17, int i18) {
        this.f404150d = i3;
        this.f404151e = i16;
        this.f404152f = str;
        this.f404153h = xVar;
        this.f404154i = aVar;
        this.f404155m = iVar;
        this.C = i17;
        this.D = i18;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 100) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.C = ((Integer) obj).intValue();
            return;
        }
        if (i3 != 101) {
            switch (i3) {
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f404150d = ((Integer) obj).intValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f404151e = ((Integer) obj).intValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f404152f = (String) obj;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.MyBotInfo");
                    this.f404153h = (x) obj;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.AIAvatarInfo");
                    this.f404154i = (a) obj;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.CreatorTTSInfo");
                    this.f404155m = (i) obj;
                    return;
                default:
                    return;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        this.D = ((Integer) obj).intValue();
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f404150d), new b.e.C0168e(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f404151e), new b.e.C0168e(false))), TuplesKt.to(3, new c45.h(3, this.f404152f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f404153h, new b.d(new x(null, null, null, null, null, 0, null, 65535)))), TuplesKt.to(5, new c45.h(5, this.f404154i, new b.d(new a(null, 1, 0 == true ? 1 : 0)))), TuplesKt.to(6, new c45.h(6, this.f404155m, new b.d(new i(null, 0, null, 0, 15, null)))), TuplesKt.to(100, new c45.h(100, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(101, new c45.h(101, Integer.valueOf(this.D), new b.e.h(false))));
        return mapOf;
    }
}
