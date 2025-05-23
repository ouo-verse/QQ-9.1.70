package h25;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f404183d;

    /* renamed from: e, reason: collision with root package name */
    public String f404184e;

    /* renamed from: f, reason: collision with root package name */
    public int f404185f;

    /* renamed from: h, reason: collision with root package name */
    public String f404186h;

    /* renamed from: i, reason: collision with root package name */
    public x f404187i;

    public /* synthetic */ b(int i3, x xVar, int i16) {
        this((i16 & 1) != 0 ? "" : null, (i16 & 2) != 0 ? "" : null, (i16 & 4) != 0 ? d.c.f30317b.b().getValue() : i3, (i16 & 8) != 0 ? "" : null, (i16 & 16) != 0 ? null : xVar);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(0, null, 31));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404183d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404184e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.Mybot_createKt.GenOpt }");
            this.f404185f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404186h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.mybot_create.MyBotInfo");
            this.f404187i = (x) obj;
        }
    }

    public b(String str, String str2, int i3, String str3, x xVar) {
        this.f404183d = str;
        this.f404184e = str2;
        this.f404185f = i3;
        this.f404186h = str3;
        this.f404187i = xVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f404183d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f404184e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f404185f), new b.a(false))), TuplesKt.to(4, new c45.h(4, this.f404186h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f404187i, new b.d(new x(null, null, null, null, null, 0, null, 65535)))));
        return mapOf;
    }
}
