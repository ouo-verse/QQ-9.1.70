package h25;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f404222d;

    /* renamed from: e, reason: collision with root package name */
    public ak f404223e;

    /* renamed from: f, reason: collision with root package name */
    public f25.j f404224f;

    public /* synthetic */ p(int i3, ak akVar, f25.j jVar, int i16) {
        this((i16 & 1) != 0 ? d.c.f30317b.b().getValue() : i3, (i16 & 2) != 0 ? null : akVar, (i16 & 4) != 0 ? null : jVar);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new p(0, null, 0 == true ? 1 : 0, 7));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f404222d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f404223e, new b.d(new ak(null, null, null, 7, null)))), TuplesKt.to(3, new c45.h(3, this.f404224f, new b.d(new f25.j(null, null, null, null, 15, null)))));
        return mapOf;
    }

    public p(int i3, ak akVar, f25.j jVar) {
        this.f404222d = i3;
        this.f404223e = akVar;
        this.f404224f = jVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.Mybot_createKt.UserTTSOpt }");
            this.f404222d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.ReadTextInfo");
            this.f404223e = (ak) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.TTSInfo");
            this.f404224f = (f25.j) obj;
        }
    }
}
