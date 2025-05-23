package i35;

import c45.b;
import c45.d;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s35.af;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f407152d;

    /* renamed from: e, reason: collision with root package name */
    public String f407153e;

    /* renamed from: f, reason: collision with root package name */
    public String f407154f;

    /* renamed from: h, reason: collision with root package name */
    public af f407155h;

    /* renamed from: i, reason: collision with root package name */
    public int f407156i;

    public a() {
        this(null, null, null, null, 0, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, null, null, null, 0, 31, null));
    }

    public /* synthetic */ a(String str, String str2, String str3, af afVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", null, d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f407152d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f407153e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f407154f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo");
            this.f407155h = (af) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.follow.FollowKt.FollowStatus }");
            this.f407156i = ((Integer) obj).intValue();
        }
    }

    public a(String str, String str2, String str3, af afVar, int i3) {
        this.f407152d = str;
        this.f407153e = str2;
        this.f407154f = str3;
        this.f407155h = afVar;
        this.f407156i = i3;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f407152d, new b.e.g(false))), TuplesKt.to(2, new h(2, this.f407153e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f407154f, new b.e.g(false))), TuplesKt.to(4, new h(4, this.f407155h, new b.d(new af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255)))), TuplesKt.to(5, new h(5, Integer.valueOf(this.f407156i), new b.a(false))));
        return mapOf;
    }
}
