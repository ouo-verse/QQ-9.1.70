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
public final class h extends c45.j {
    public boolean C;

    /* renamed from: d, reason: collision with root package name */
    public s35.af f425173d;

    /* renamed from: e, reason: collision with root package name */
    public int f425174e;

    /* renamed from: f, reason: collision with root package name */
    public String f425175f;

    /* renamed from: h, reason: collision with root package name */
    public i f425176h;

    /* renamed from: i, reason: collision with root package name */
    public int f425177i;

    /* renamed from: m, reason: collision with root package name */
    public final List<ae> f425178m;

    public h() {
        this((s35.af) null, 0, (String) null, (i) null, 0, (List) null, 127);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h((s35.af) null, 0, (String) null, (i) null, 0, (List) null, 127));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo");
                this.f425173d = (s35.af) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425174e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425175f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.Content");
                this.f425176h = (i) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425177i = ((Integer) obj).intValue();
                return;
            case 6:
                List<ae> list = this.f425178m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.ReplyInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.C = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ h(s35.af afVar, int i3, String str, i iVar, int i16, List list, int i17) {
        this((i17 & 1) != 0 ? null : afVar, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? null : iVar, (i17 & 16) != 0 ? 0 : i16, (List<ae>) ((i17 & 32) != 0 ? new ArrayList() : list), false);
    }

    public h(s35.af afVar, int i3, String str, i iVar, int i16, List<ae> list, boolean z16) {
        this.f425173d = afVar;
        this.f425174e = i3;
        this.f425175f = str;
        this.f425176h = iVar;
        this.f425177i = i16;
        this.f425178m = list;
        this.C = z16;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425173d, new b.d(new s35.af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f425174e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f425175f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f425176h, new b.d(new i("")))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f425177i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, this.f425178m, new b.f(new b.d(new ae((s35.af) null, 0, (String) null, (i) (0 == true ? 1 : 0), (s35.af) (0 == true ? 1 : 0), 63)), false))), TuplesKt.to(7, new c45.h(7, Boolean.valueOf(this.C), new b.e.a(false))));
        return mapOf;
    }
}
