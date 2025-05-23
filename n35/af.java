package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class af extends c45.j {
    public c45.a C;
    public c45.a D;
    public c45.a E;

    /* renamed from: d, reason: collision with root package name */
    public long f418141d;

    /* renamed from: e, reason: collision with root package name */
    public int f418142e;

    /* renamed from: f, reason: collision with root package name */
    public int f418143f;

    /* renamed from: h, reason: collision with root package name */
    public int f418144h;

    /* renamed from: i, reason: collision with root package name */
    public c45.a f418145i;

    /* renamed from: m, reason: collision with root package name */
    public int f418146m;

    public af() {
        this(0L, 0, 0, 0, null, 0, null, null, null, 511, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new af(0L, 0, 0, 0, null, 0, null, null, null, 511, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f418141d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SceneType }");
                this.f418142e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.VoiceType }");
                this.f418143f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418144h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f418145i = (c45.a) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f418146m = ((Integer) obj).intValue();
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            default:
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.C = (c45.a) obj;
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.D = (c45.a) obj;
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.E = (c45.a) obj;
                return;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ af(long j3, int i3, int i16, int i17, c45.a aVar, int i18, c45.a aVar2, c45.a aVar3, c45.a aVar4, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, r4, r5, 0, r11, 0, r11, r11, r11);
        d.c.a aVar5 = d.c.f30317b;
        int value = aVar5.b().getValue();
        int value2 = aVar5.b().getValue();
        c45.a aVar6 = c45.a.f30290b;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f418141d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418142e), new b.a(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f418143f), new b.a(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f418144h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, this.f418145i, new b.e.C0167b(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f418146m), new b.e.h(false))), TuplesKt.to(11, new c45.h(11, this.C, new b.e.C0167b(false))), TuplesKt.to(12, new c45.h(12, this.D, new b.e.C0167b(false))), TuplesKt.to(13, new c45.h(13, this.E, new b.e.C0167b(false))));
        return mapOf;
    }

    public af(long j3, int i3, int i16, int i17, c45.a aVar, int i18, c45.a aVar2, c45.a aVar3, c45.a aVar4) {
        this.f418141d = j3;
        this.f418142e = i3;
        this.f418143f = i16;
        this.f418144h = i17;
        this.f418145i = aVar;
        this.f418146m = i18;
        this.C = aVar2;
        this.D = aVar3;
        this.E = aVar4;
    }
}
