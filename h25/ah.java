package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ah extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public h f404147d;

    /* renamed from: e, reason: collision with root package name */
    public ar f404148e;

    public ah() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ah(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ ah(h hVar, ar arVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public ah(h hVar, ar arVar) {
        this.f404147d = hVar;
        this.f404148e = arVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404147d, new b.d(new h(0L, false, 3, null)))), TuplesKt.to(2, new c45.h(2, this.f404148e, new b.d(new ar(0L, null, null, null, null, 31, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.CreatorSetting");
            this.f404147d = (h) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.UGCAssistantInfo");
            this.f404148e = (ar) obj;
        }
    }
}
