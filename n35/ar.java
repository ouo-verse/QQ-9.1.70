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
public final class ar extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f418191d;

    /* renamed from: e, reason: collision with root package name */
    public int f418192e;

    public ar() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ar(null, 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ ar(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418191d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418192e), new b.a(false))));
        return mapOf;
    }

    public ar(String str, int i3) {
        this.f418191d = str;
        this.f418192e = i3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f418191d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SubFileType }");
            this.f418192e = ((Integer) obj).intValue();
        }
    }
}
