package o35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f421880d;

    /* renamed from: e, reason: collision with root package name */
    public e f421881e;

    /* renamed from: f, reason: collision with root package name */
    public String f421882f;

    /* renamed from: h, reason: collision with root package name */
    public String f421883h;

    /* renamed from: i, reason: collision with root package name */
    public String f421884i;

    /* renamed from: m, reason: collision with root package name */
    public String f421885m;

    public b() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, null, null, null, null, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421880d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.card.Image");
                this.f421881e = (e) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421882f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421883h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421884i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f421885m = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ b(String str, e eVar, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, "", "", "", "");
    }

    public b(String str, e eVar, String str2, String str3, String str4, String str5) {
        this.f421880d = str;
        this.f421881e = eVar;
        this.f421882f = str2;
        this.f421883h = str3;
        this.f421884i = str4;
        this.f421885m = str5;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f421880d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f421881e, new b.d(new e(null, 0, 0, 7, null)))), TuplesKt.to(3, new c45.h(3, this.f421882f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f421883h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f421884i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f421885m, new b.e.g(false))));
        return mapOf;
    }
}
