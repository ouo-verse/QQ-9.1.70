package n25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends c45.j {
    public String C;
    public e D;
    public int E;
    public l F;

    /* renamed from: d, reason: collision with root package name */
    public String f418067d;

    /* renamed from: e, reason: collision with root package name */
    public String f418068e;

    /* renamed from: f, reason: collision with root package name */
    public int f418069f;

    /* renamed from: h, reason: collision with root package name */
    public r25.e f418070h;

    /* renamed from: i, reason: collision with root package name */
    public r25.e f418071i;

    /* renamed from: m, reason: collision with root package name */
    public String f418072m;

    public g() {
        this(null, null, 0, null, null, null, null, null, 0, null, 1023, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, null, 0, null, null, null, null, null, 0, null, 1023, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418067d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418068e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418069f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.User");
                this.f418070h = (r25.e) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.User");
                this.f418071i = (r25.e) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f418072m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.Content");
                this.D = (e) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.E = ((Integer) obj).intValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StatusFeed");
                this.F = (l) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ g(String str, String str2, int i3, r25.e eVar, r25.e eVar2, String str3, String str4, e eVar3, int i16, l lVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", 0, null, null, "", "", null, 0, null);
    }

    public g(String str, String str2, int i3, r25.e eVar, r25.e eVar2, String str3, String str4, e eVar3, int i16, l lVar) {
        this.f418067d = str;
        this.f418068e = str2;
        this.f418069f = i3;
        this.f418070h = eVar;
        this.f418071i = eVar2;
        this.f418072m = str3;
        this.C = str4;
        this.D = eVar3;
        this.E = i16;
        this.F = lVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418067d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f418068e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f418069f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f418070h, new b.d(new r25.e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)))), TuplesKt.to(5, new c45.h(5, this.f418071i, new b.d(new r25.e(0L, null, 0 == true ? 1 : 0, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)))), TuplesKt.to(6, new c45.h(6, this.f418072m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.d(new e("")))), TuplesKt.to(9, new c45.h(9, Integer.valueOf(this.E), new b.e.h(false))), TuplesKt.to(10, new c45.h(10, this.F, new b.d(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151)))));
        return mapOf;
    }
}
