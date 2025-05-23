package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aj extends c45.j {
    public boolean C;
    public String D;
    public a E;

    /* renamed from: d, reason: collision with root package name */
    public int f395459d;

    /* renamed from: e, reason: collision with root package name */
    public int f395460e;

    /* renamed from: f, reason: collision with root package name */
    public String f395461f;

    /* renamed from: h, reason: collision with root package name */
    public long f395462h;

    /* renamed from: i, reason: collision with root package name */
    public long f395463i;

    /* renamed from: m, reason: collision with root package name */
    public String f395464m;

    public aj() {
        this(0, 0, null, 0L, 0L, null, false, null, null, 511, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new aj(0, 0, null, 0L, 0L, null, false, null, null, 511, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f395459d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f395460e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395461f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395462h = ((Long) obj).longValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395463i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395464m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.C = ((Boolean) obj).booleanValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.D = (String) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.BubbleTips");
                this.E = (a) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ aj(int i3, int i16, String str, long j3, long j16, String str2, boolean z16, String str3, a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, "", 0L, 0L, "", false, "", null);
    }

    public aj(int i3, int i16, String str, long j3, long j16, String str2, boolean z16, String str3, a aVar) {
        this.f395459d = i3;
        this.f395460e = i16;
        this.f395461f = str;
        this.f395462h = j3;
        this.f395463i = j16;
        this.f395464m = str2;
        this.C = z16;
        this.D = str3;
        this.E = aVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f395459d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f395460e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f395461f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f395462h), new b.e.i(false))), TuplesKt.to(5, new c45.h(5, Long.valueOf(this.f395463i), new b.e.i(false))), TuplesKt.to(6, new c45.h(6, this.f395464m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, Boolean.valueOf(this.C), new b.e.a(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.d(new a(0, null, null, null, 15, null)))));
        return mapOf;
    }
}
