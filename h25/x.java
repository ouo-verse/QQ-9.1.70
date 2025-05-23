package h25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class x extends c45.j {
    public String C;
    public int D;
    public f25.e E;
    public String F;
    public String G;
    public c45.a H;
    public String I;
    public String J;
    public final List<e> K;
    public final List<f25.c> L;

    /* renamed from: d, reason: collision with root package name */
    public String f404251d;

    /* renamed from: e, reason: collision with root package name */
    public long f404252e;

    /* renamed from: f, reason: collision with root package name */
    public String f404253f;

    /* renamed from: h, reason: collision with root package name */
    public String f404254h;

    /* renamed from: i, reason: collision with root package name */
    public String f404255i;

    /* renamed from: m, reason: collision with root package name */
    public String f404256m;

    public x() {
        this(null, null, null, null, null, 0, null, 65535);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new x(null, null, null, null, null, 0, null, 65535));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404251d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f404252e = ((Long) obj).longValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404253f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404254h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404255i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f404256m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.D = ((Integer) obj).intValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.MsgBackground");
                this.E = (f25.e) obj;
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.F = (String) obj;
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.G = (String) obj;
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.H = (c45.a) obj;
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.I = (String) obj;
                return;
            case 14:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.J = (String) obj;
                return;
            case 15:
                List<e> list = this.K;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.ActivityLabel>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 16:
                List<f25.c> list2 = this.L;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.BotPromptConversation>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ x(String str, String str2, String str3, String str4, String str5, int i3, String str6, int i16) {
        this((i16 & 1) != 0 ? "" : str, 0L, (i16 & 4) != 0 ? "" : null, (i16 & 8) != 0 ? "" : str2, (i16 & 16) != 0 ? "" : str3, (i16 & 32) != 0 ? "" : str4, (i16 & 64) != 0 ? "" : str5, (i16 & 128) != 0 ? 0 : i3, null, (i16 & 512) != 0 ? "" : null, (i16 & 1024) != 0 ? "" : str6, (i16 & 2048) != 0 ? c45.a.f30290b : null, (i16 & 4096) != 0 ? "" : null, (i16 & 8192) != 0 ? "" : null, (i16 & 16384) != 0 ? new ArrayList() : null, (i16 & 32768) != 0 ? new ArrayList() : null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        String str = null;
        String str2 = null;
        String str3 = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404251d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f404252e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, this.f404253f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f404254h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f404255i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f404256m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, Integer.valueOf(this.D), new b.e.h(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.d(new f25.e(str, str2, str3, null, null, null, 63, null)))), TuplesKt.to(10, new c45.h(10, this.F, new b.e.g(false))), TuplesKt.to(11, new c45.h(11, this.G, new b.e.g(false))), TuplesKt.to(12, new c45.h(12, this.H, new b.e.C0167b(false))), TuplesKt.to(13, new c45.h(13, this.I, new b.e.g(false))), TuplesKt.to(14, new c45.h(14, this.J, new b.e.g(false))), TuplesKt.to(15, new c45.h(15, this.K, new b.f(new b.d(new e(str, str2, str3, false, 15, null)), false))), TuplesKt.to(16, new c45.h(16, this.L, new b.f(new b.d(new f25.c(null, null)), false))));
        return mapOf;
    }

    public x(String str, long j3, String str2, String str3, String str4, String str5, String str6, int i3, f25.e eVar, String str7, String str8, c45.a aVar, String str9, String str10, List<e> list, List<f25.c> list2) {
        this.f404251d = str;
        this.f404252e = j3;
        this.f404253f = str2;
        this.f404254h = str3;
        this.f404255i = str4;
        this.f404256m = str5;
        this.C = str6;
        this.D = i3;
        this.E = eVar;
        this.F = str7;
        this.G = str8;
        this.H = aVar;
        this.I = str9;
        this.J = str10;
        this.K = list;
        this.L = list2;
    }
}
