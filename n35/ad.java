package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ad extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418138d;

    /* renamed from: e, reason: collision with root package name */
    public ac f418139e;

    /* renamed from: f, reason: collision with root package name */
    public String f418140f;

    public ad() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ad(null, null, null, 7, null));
    }

    public /* synthetic */ ad(String str, ac acVar, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, "");
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418138d = (String) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.PicUrlExtInfo");
            this.f418139e = (ac) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418140f = (String) obj;
        }
    }

    public ad(String str, ac acVar, String str2) {
        this.f418138d = str;
        this.f418139e = acVar;
        this.f418140f = str2;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418138d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f418139e, new b.d(new ac(null, null, null, 7, null)))), TuplesKt.to(3, new c45.h(3, this.f418140f, new b.e.g(false))));
        return mapOf;
    }
}
