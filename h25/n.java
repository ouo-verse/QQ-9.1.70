package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f404218d;

    /* renamed from: e, reason: collision with root package name */
    public String f404219e;

    /* renamed from: f, reason: collision with root package name */
    public aq f404220f;

    public /* synthetic */ n() {
        this(0, "", null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new n());
    }

    public n(int i3, String str, aq aqVar) {
        this.f404218d = i3;
        this.f404219e = str;
        this.f404220f = aqVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f404218d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f404219e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f404220f, new b.d(new aq(0)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404218d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404219e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.SwitchSetting");
            this.f404220f = (aq) obj;
        }
    }
}
