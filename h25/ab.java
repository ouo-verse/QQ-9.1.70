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
public final class ab extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f404130d;

    /* renamed from: e, reason: collision with root package name */
    public String f404131e;

    /* renamed from: f, reason: collision with root package name */
    public String f404132f;

    /* renamed from: h, reason: collision with root package name */
    public int f404133h;

    /* renamed from: i, reason: collision with root package name */
    public int f404134i;

    public ab() {
        this(0, null, null, 0, 0, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ab(0, null, null, 0, 0, 31, null));
    }

    public /* synthetic */ ab(int i3, String str, String str2, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "", "", 0, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f404130d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f404131e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f404132f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f404133h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f404134i), new b.e.h(false))));
        return mapOf;
    }

    public ab(int i3, String str, String str2, int i16, int i17) {
        this.f404130d = i3;
        this.f404131e = str;
        this.f404132f = str2;
        this.f404133h = i16;
        this.f404134i = i17;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.Mybot_createKt.QZoneStatus }");
            this.f404130d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404131e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404132f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404133h = ((Integer) obj).intValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f404134i = ((Integer) obj).intValue();
        }
    }
}
