package g25;

import c45.b;
import c45.d;
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
public final class a extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f401132d;

    /* renamed from: e, reason: collision with root package name */
    public String f401133e;

    /* renamed from: f, reason: collision with root package name */
    public String f401134f;

    /* renamed from: h, reason: collision with root package name */
    public String f401135h;

    /* renamed from: i, reason: collision with root package name */
    public final List<k> f401136i;

    /* renamed from: m, reason: collision with root package name */
    public int f401137m;

    public a() {
        this(null, null, null, null, null, 0, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new a(null, null, null, null, null, 0, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401132d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401133e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401134f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f401135h = (String) obj;
                return;
            case 5:
                List<k> list = this.f401136i;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.RobotInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.groupProRobot.list.list.ListKt.AdelieCardDataType }");
                this.f401137m = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", new ArrayList(), d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        String str = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f401132d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f401133e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f401134f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f401135h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f401136i, new b.f(new b.d(new k(0L, null, str, str, 0, null, 0, 0L, false, null, null, null, null, null, 0, 0, 0L, null, 0L, null, false, 0, 0, 0L, null, null, 0L, null, null, false, null, null, 0, null, null, -1, 7, null)), false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f401137m), new b.a(false))));
        return mapOf;
    }

    public a(String str, String str2, String str3, String str4, List<k> list, int i3) {
        this.f401132d = str;
        this.f401133e = str2;
        this.f401134f = str3;
        this.f401135h = str4;
        this.f401136i = list;
        this.f401137m = i3;
    }
}
