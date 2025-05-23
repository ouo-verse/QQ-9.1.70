package l25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f413768d;

    /* renamed from: e, reason: collision with root package name */
    public String f413769e;

    /* renamed from: f, reason: collision with root package name */
    public d f413770f;

    public j() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j(null, null, null, 7, null));
    }

    public /* synthetic */ j(String str, String str2, d dVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f413768d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f413769e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f413770f, new b.d(new d("")))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f413768d = (String) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f413769e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChIconInfo");
            this.f413770f = (d) obj;
        }
    }

    public j(String str, String str2, d dVar) {
        this.f413768d = str;
        this.f413769e = str2;
        this.f413770f = dVar;
    }
}
