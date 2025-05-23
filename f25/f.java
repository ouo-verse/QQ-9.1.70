package f25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public Integer f397744d;

    /* renamed from: e, reason: collision with root package name */
    public String f397745e;

    /* renamed from: f, reason: collision with root package name */
    public String f397746f;

    /* renamed from: h, reason: collision with root package name */
    public String f397747h;

    public /* synthetic */ f() {
        this(null, null, null, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f());
    }

    public f(Integer num, String str, String str2, String str3) {
        this.f397744d = num;
        this.f397745e = str;
        this.f397746f = str2;
        this.f397747h = str3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f397744d, new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f397745e, new b.e.g(true))), TuplesKt.to(3, new c45.h(3, this.f397746f, new b.e.g(true))), TuplesKt.to(4, new c45.h(4, this.f397747h, new b.e.g(true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.ConfigKt.OptID }");
            this.f397744d = (Integer) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397745e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397746f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397747h = (String) obj;
        }
    }
}
