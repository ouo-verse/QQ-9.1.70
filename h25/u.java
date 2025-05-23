package h25;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class u extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f404241d;

    /* renamed from: e, reason: collision with root package name */
    public String f404242e;

    /* renamed from: f, reason: collision with root package name */
    public String f404243f;

    /* renamed from: h, reason: collision with root package name */
    public String f404244h;

    public u() {
        this(0, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new u(0, null, null, null, 15, null));
    }

    public /* synthetic */ u(int i3, String str, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "", "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f404241d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f404242e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f404243f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f404244h, new b.e.g(false))));
        return mapOf;
    }

    public u(int i3, String str, String str2, String str3) {
        this.f404241d = i3;
        this.f404242e = str;
        this.f404243f = str2;
        this.f404244h = str3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.Mybot_createKt.Identity }");
            this.f404241d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404242e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404243f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404244h = (String) obj;
        }
    }
}
