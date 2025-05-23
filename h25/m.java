package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public h f404217d;

    public m() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new m(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ m(h hVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404217d, new b.d(new h(0L, false, 3, null)))));
        return mapOf;
    }

    public m(h hVar) {
        this.f404217d = hVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.CreatorSetting");
            this.f404217d = (h) obj;
        }
    }
}
