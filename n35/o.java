package n35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418246d;

    /* renamed from: e, reason: collision with root package name */
    public long f418247e;

    /* renamed from: f, reason: collision with root package name */
    public k f418248f;

    /* renamed from: h, reason: collision with root package name */
    public int f418249h;

    public o() {
        this(null, 0L, null, 0, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new o(null, 0L, null, 0, 15, null));
    }

    public /* synthetic */ o(String str, long j3, k kVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, null, 0);
    }

    public o(String str, long j3, k kVar, int i3) {
        this.f418246d = str;
        this.f418247e = j3;
        this.f418248f = kVar;
        this.f418249h = i3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418246d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f418247e), new b.e.f(false))), TuplesKt.to(3, new c45.h(3, this.f418248f, new b.d(new k(null, null, 0, null, null, null, null, 127, null)))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f418249h), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418246d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f418247e = ((Long) obj).longValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.DownloadInfo");
            this.f418248f = (k) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f418249h = ((Integer) obj).intValue();
        }
    }
}
