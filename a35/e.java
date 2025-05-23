package a35;

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

/* compiled from: P */
/* loaded from: classes39.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public c45.a f25451d;

    /* renamed from: e, reason: collision with root package name */
    public String f25452e;

    /* renamed from: f, reason: collision with root package name */
    public int f25453f;

    public e() {
        this(null, null, 0, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new e(null, null, 0, 7, null));
    }

    public /* synthetic */ e(c45.a aVar, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(c45.a.f30290b, "", d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f25451d, new b.e.C0167b(false))), TuplesKt.to(2, new h(2, this.f25452e, new b.e.g(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f25453f), new b.a(false))));
        return mapOf;
    }

    public e(c45.a aVar, String str, int i3) {
        this.f25451d = aVar;
        this.f25452e = str;
        this.f25453f = i3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f25451d = (c45.a) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f25452e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.status_square_data.Status_square_dataKt.GenderType }");
            this.f25453f = ((Integer) obj).intValue();
        }
    }
}
