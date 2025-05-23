package p35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ad extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f425125d;

    /* renamed from: e, reason: collision with root package name */
    public String f425126e;

    /* renamed from: f, reason: collision with root package name */
    public int f425127f;

    /* renamed from: h, reason: collision with root package name */
    public String f425128h;

    public ad() {
        this(null, null, 0, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ad(null, null, 0, null, 15, null));
    }

    public /* synthetic */ ad(String str, String str2, int i3, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", d.c.f30317b.b().getValue(), "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f425125d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f425126e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f425127f), new b.a(false))), TuplesKt.to(4, new c45.h(4, this.f425128h, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425125d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425126e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.FeedKt.RecCommentType }");
            this.f425127f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f425128h = (String) obj;
        }
    }

    public ad(String str, String str2, int i3, String str3) {
        this.f425125d = str;
        this.f425126e = str2;
        this.f425127f = i3;
        this.f425128h = str3;
    }
}
