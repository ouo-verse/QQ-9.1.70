package p35;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ac extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f425119d;

    /* renamed from: e, reason: collision with root package name */
    public int f425120e;

    /* renamed from: f, reason: collision with root package name */
    public final List<s35.af> f425121f;

    /* renamed from: h, reason: collision with root package name */
    public int f425122h;

    /* renamed from: i, reason: collision with root package name */
    public String f425123i;

    /* renamed from: m, reason: collision with root package name */
    public int f425124m;

    public ac() {
        this(null, 0, null, 0, 63);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ac(null, 0, null, 0, 63));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425119d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425120e = ((Integer) obj).intValue();
                return;
            case 3:
                List<s35.af> list = this.f425121f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425122h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425123i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425124m = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ ac(String str, int i3, List list, int i16, int i17) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? new ArrayList() : list, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) == 0 ? null : "", 0);
    }

    public ac(String str, int i3, List<s35.af> list, int i16, String str2, int i17) {
        this.f425119d = str;
        this.f425120e = i3;
        this.f425121f = list;
        this.f425122h = i16;
        this.f425123i = str2;
        this.f425124m = i17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425119d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f425120e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f425121f, new b.f(new b.d(new s35.af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255)), false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f425122h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, this.f425123i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f425124m), new b.e.C0168e(false))));
        return mapOf;
    }
}
