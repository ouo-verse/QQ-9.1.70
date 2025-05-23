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
public final class ab extends c45.j {
    public int C;

    /* renamed from: d, reason: collision with root package name */
    public int f418129d;

    /* renamed from: e, reason: collision with root package name */
    public String f418130e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f418131f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f418132h;

    /* renamed from: i, reason: collision with root package name */
    public int f418133i;

    /* renamed from: m, reason: collision with root package name */
    public int f418134m;

    public ab() {
        this(0, null, null, null, 0, 0, 0, 127, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ab(0, null, null, null, 0, 0, 0, 127, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ab(int i3, String str, c45.a aVar, c45.a aVar2, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", r5, r5, r1.b().getValue(), r1.b().getValue(), 0);
        c45.a aVar3 = c45.a.f30290b;
        d.c.a aVar4 = d.c.f30317b;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f418129d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f418130e, new b.e.g(false))), TuplesKt.to(11, new c45.h(11, this.f418131f, new b.e.C0167b(false))), TuplesKt.to(12, new c45.h(12, this.f418132h, new b.e.C0167b(false))), TuplesKt.to(1001, new c45.h(1001, Integer.valueOf(this.f418133i), new b.a(false))), TuplesKt.to(1002, new c45.h(1002, Integer.valueOf(this.f418134m), new b.a(false))), TuplesKt.to(1003, new c45.h(1003, Integer.valueOf(this.C), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f418129d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418130e = (String) obj;
            return;
        }
        if (i3 == 11) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f418131f = (c45.a) obj;
            return;
        }
        if (i3 != 12) {
            switch (i3) {
                case 1001:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SceneType }");
                    this.f418133i = ((Integer) obj).intValue();
                    return;
                case 1002:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SceneType }");
                    this.f418134m = ((Integer) obj).intValue();
                    return;
                case 1003:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.C = ((Integer) obj).intValue();
                    return;
                default:
                    return;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
        this.f418132h = (c45.a) obj;
    }

    public ab(int i3, String str, c45.a aVar, c45.a aVar2, int i16, int i17, int i18) {
        this.f418129d = i3;
        this.f418130e = str;
        this.f418131f = aVar;
        this.f418132h = aVar2;
        this.f418133i = i16;
        this.f418134m = i17;
        this.C = i18;
    }
}
