package j25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f409181d;

    /* renamed from: e, reason: collision with root package name */
    public String f409182e;

    /* renamed from: f, reason: collision with root package name */
    public a f409183f;

    /* renamed from: h, reason: collision with root package name */
    public long f409184h;

    /* renamed from: i, reason: collision with root package name */
    public long f409185i;

    /* renamed from: m, reason: collision with root package name */
    public b f409186m;

    public c() {
        this(0L, null, null, 0L, 0L, null, 63, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(0L, null, null, 0L, 0L, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f409181d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f409182e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.kuolie.common.signal.PartnerAdjective");
                this.f409183f = (a) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f409184h = ((Long) obj).longValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f409185i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.kuolie.common.signal.SignalConfig");
                this.f409186m = (b) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ c(long j3, String str, a aVar, long j16, long j17, b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", null, 0L, 0L, null);
    }

    public c(long j3, String str, a aVar, long j16, long j17, b bVar) {
        this.f409181d = j3;
        this.f409182e = str;
        this.f409183f = aVar;
        this.f409184h = j16;
        this.f409185i = j17;
        this.f409186m = bVar;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f409181d), new b.e.i(false))), TuplesKt.to(2, new h(2, this.f409182e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f409183f, new b.d(new a(0L, null, 3, null)))), TuplesKt.to(4, new h(4, Long.valueOf(this.f409184h), new b.e.i(false))), TuplesKt.to(5, new h(5, Long.valueOf(this.f409185i), new b.e.i(false))), TuplesKt.to(6, new h(6, this.f409186m, new b.d(new b(0L, null, null, null, null, null, null, 127, null)))));
        return mapOf;
    }
}
