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
public final class g extends c45.j {
    public final List<String> C;

    /* renamed from: d, reason: collision with root package name */
    public String f401157d;

    /* renamed from: e, reason: collision with root package name */
    public String f401158e;

    /* renamed from: f, reason: collision with root package name */
    public String f401159f;

    /* renamed from: h, reason: collision with root package name */
    public String f401160h;

    /* renamed from: i, reason: collision with root package name */
    public String f401161i;

    /* renamed from: m, reason: collision with root package name */
    public k f401162m;

    public g() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, null, null, null, null, null, null, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401157d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401158e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401159f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401160h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401161i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.RobotInfo");
                this.f401162m = (k) obj;
                return;
            case 7:
                List<String> list = this.C;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ g(String str, String str2, String str3, String str4, String str5, k kVar, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", null, new ArrayList());
    }

    public g(String str, String str2, String str3, String str4, String str5, k kVar, List<String> list) {
        this.f401157d = str;
        this.f401158e = str2;
        this.f401159f = str3;
        this.f401160h = str4;
        this.f401161i = str5;
        this.f401162m = kVar;
        this.C = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f401157d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f401158e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f401159f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f401160h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f401161i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f401162m, new b.d(new k(0L, null, null, null, 0, null, 0, 0L, false, null, null, null, null, null, 0, 0, 0L, null, 0L, null, false, 0, 0, 0L, null, null, 0L, null, null, false, null, null, 0, null, null, -1, 7, null)))), TuplesKt.to(7, new c45.h(7, this.C, new b.f(new b.e.g(false), false))));
        return mapOf;
    }
}
