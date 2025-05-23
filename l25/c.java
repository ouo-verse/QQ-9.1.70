package l25;

import c45.b;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f413744d;

    /* renamed from: e, reason: collision with root package name */
    public g f413745e;

    /* renamed from: f, reason: collision with root package name */
    public g f413746f;

    /* renamed from: h, reason: collision with root package name */
    public j f413747h;

    /* renamed from: i, reason: collision with root package name */
    public final List<e> f413748i;

    /* renamed from: m, reason: collision with root package name */
    public a f413749m;

    public c() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, null, null, null, null, null, 63, null));
    }

    public /* synthetic */ c(String str, g gVar, g gVar2, j jVar, List list, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, null, null, new ArrayList(), null);
    }

    public c(String str, g gVar, g gVar2, j jVar, List<e> list, a aVar) {
        this.f413744d = str;
        this.f413745e = gVar;
        this.f413746f = gVar2;
        this.f413747h = jVar;
        this.f413748i = list;
        this.f413749m = aVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 3;
        String str = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f413744d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f413745e, new b.d(new g(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(3, new c45.h(3, this.f413746f, new b.d(new g(0 == true ? 1 : 0, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(4, new c45.h(4, this.f413747h, new b.d(new j(null, str, null, 7, null)))), TuplesKt.to(13, new c45.h(13, this.f413748i, new b.f(new b.d(new e(0, 0, str, null, 0 == true ? 1 : 0, null, null, null, null, 0, 0, false, false, InitSkin.DRAWABLE_COUNT, null)), false))), TuplesKt.to(21, new c45.h(21, this.f413749m, new b.d(new a(null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 13) {
            List<e> list = this.f413748i;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChImage>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 21) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChChannelInfo");
            this.f413749m = (a) obj;
            return;
        }
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f413744d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChRichText");
            this.f413745e = (g) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChRichText");
            this.f413746f = (g) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChUser");
            this.f413747h = (j) obj;
        }
    }
}
