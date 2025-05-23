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
public final class e extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public f25.d f401152d;

    /* renamed from: e, reason: collision with root package name */
    public f25.b f401153e;

    /* renamed from: f, reason: collision with root package name */
    public final List<f25.h> f401154f;

    public e() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, null, null, 7, null));
    }

    public /* synthetic */ e(f25.d dVar, f25.b bVar, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, new ArrayList());
    }

    public e(f25.d dVar, f25.b bVar, List<f25.h> list) {
        this.f401152d = dVar;
        this.f401153e = bVar;
        this.f401154f = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        Integer num = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f401152d, new b.d(new f25.d(null, null, null, num, null, null, 63, null)))), TuplesKt.to(2, new c45.h(2, this.f401153e, new b.d(new f25.b(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(3, new c45.h(3, this.f401154f, new b.f(new b.d(new f25.h(0 == true ? 1 : 0, null, num, 7, 0 == true ? 1 : 0)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.InputBox");
            this.f401152d = (f25.d) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.BotCardInfo");
            this.f401153e = (f25.b) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            List<f25.h> list = this.f401154f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.RobotMetaInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
