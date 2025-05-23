package p35;

import c45.b;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ae extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public s35.af f425129d;

    /* renamed from: e, reason: collision with root package name */
    public int f425130e;

    /* renamed from: f, reason: collision with root package name */
    public String f425131f;

    /* renamed from: h, reason: collision with root package name */
    public i f425132h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f425133i;

    /* renamed from: m, reason: collision with root package name */
    public s35.af f425134m;

    public ae() {
        this((s35.af) null, 0, (String) null, (i) null, (s35.af) null, 63);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ae((s35.af) null, 0, (String) null, (i) null, (s35.af) null, 63));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo");
                this.f425129d = (s35.af) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f425130e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f425131f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.Content");
                this.f425132h = (i) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f425133i = ((Boolean) obj).booleanValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo");
                this.f425134m = (s35.af) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ ae(s35.af afVar, int i3, String str, i iVar, s35.af afVar2, int i16) {
        this((i16 & 1) != 0 ? null : afVar, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? "" : str, (i16 & 8) != 0 ? null : iVar, false, (i16 & 32) != 0 ? null : afVar2);
    }

    public ae(s35.af afVar, int i3, String str, i iVar, boolean z16, s35.af afVar2) {
        this.f425129d = afVar;
        this.f425130e = i3;
        this.f425131f = str;
        this.f425132h = iVar;
        this.f425133i = z16;
        this.f425134m = afVar2;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        String str = null;
        String str2 = null;
        List list = null;
        List list2 = null;
        int i3 = 0;
        List list3 = null;
        int i16 = 0;
        int i17 = 0;
        List list4 = null;
        List list5 = null;
        boolean z16 = false;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425129d, new b.d(new s35.af(null, 0L, null, 0, null, 0, null, str, str2, null, null, null, list, null, 0, false, null, list2, null, i3, 0, list3, null, i16, i17, 0, null, null, null, null, 0, null, null, null, list4, list5, null, z16, false, -1, 255)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f425130e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f425131f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f425132h, new b.d(new i("")))), TuplesKt.to(5, new c45.h(5, Boolean.valueOf(this.f425133i), new b.e.a(false))), TuplesKt.to(6, new c45.h(6, this.f425134m, new b.d(new s35.af(null, 0L, null, 0, null, 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, str, str2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, list, 0, 0 == true ? 1 : 0, null, 0 == true ? 1 : 0, list2, 0, i3, null, list3, 0, i16, i17, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, list4, list5, false, z16, -1, 255)))));
        return mapOf;
    }
}
