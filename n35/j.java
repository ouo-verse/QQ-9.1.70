package n35;

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
    public aa f418233d;

    /* renamed from: e, reason: collision with root package name */
    public av f418234e;

    /* renamed from: f, reason: collision with root package name */
    public ae f418235f;

    public j() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j(null, null, null, 7, null));
    }

    public /* synthetic */ j(aa aaVar, av avVar, ae aeVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null);
    }

    public j(aa aaVar, av avVar, ae aeVar) {
        this.f418233d = aaVar;
        this.f418234e = avVar;
        this.f418235f = aeVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418233d, new b.d(new aa()))), TuplesKt.to(2, new c45.h(2, this.f418234e, new b.d(new av(0, 0, 0, null, 15, null)))), TuplesKt.to(3, new c45.h(3, this.f418235f, new b.d(new ae()))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.PicDownloadExt");
            this.f418233d = (aa) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.VideoDownloadExt");
            this.f418234e = (av) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.PttDownloadExt");
            this.f418235f = (ae) obj;
        }
    }
}
