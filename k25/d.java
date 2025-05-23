package k25;

import c45.b;
import c45.d;
import c45.f;
import c45.h;
import c45.j;
import c45.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pbandk.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends j {
    public String C;

    /* renamed from: d, reason: collision with root package name */
    public String f411450d;

    /* renamed from: e, reason: collision with root package name */
    public String f411451e;

    /* renamed from: f, reason: collision with root package name */
    public String f411452f;

    /* renamed from: h, reason: collision with root package name */
    public int f411453h;

    /* renamed from: i, reason: collision with root package name */
    public final Map<String, String> f411454i;

    /* renamed from: m, reason: collision with root package name */
    public String f411455m;

    public d() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new d(null, null, null, 0, null, null, null, 127, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f411450d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f411451e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f411452f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.attendance_svr.attendancedb.AttendancedbKt.CardType }");
                this.f411453h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.MessageMap.Entry<kotlin.String, kotlin.String>");
                k.a((a.c) obj, this.f411454i);
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f411455m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ d(String str, String str2, String str3, int i3, Map map, String str4, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", d.c.f30317b.b().getValue(), new LinkedHashMap(), "", "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f411450d, new b.e.g(false))), TuplesKt.to(2, new h(2, this.f411451e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f411452f, new b.e.g(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f411453h), new b.a(false))), TuplesKt.to(5, new h(5, this.f411454i, new b.C0166b(new b.e.g(false), new b.e.g(false)))), TuplesKt.to(6, new h(6, this.f411455m, new b.e.g(false))), TuplesKt.to(7, new h(7, this.C, new b.e.g(false))));
        return mapOf;
    }

    public d(String str, String str2, String str3, int i3, Map<String, String> map, String str4, String str5) {
        this.f411450d = str;
        this.f411451e = str2;
        this.f411452f = str3;
        this.f411453h = i3;
        this.f411454i = map;
        this.f411455m = str4;
        this.C = str5;
    }
}
