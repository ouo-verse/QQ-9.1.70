package n35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aq extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public s f418189d;

    /* renamed from: e, reason: collision with root package name */
    public int f418190e;

    public /* synthetic */ aq() {
        this(null, d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new aq());
    }

    public aq(s sVar, int i3) {
        this.f418189d = sVar;
        this.f418190e = i3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f418189d, new b.d(new s(0L, null, null, null, null, 0, 0, 0, false, 511, null)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f418190e), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.FileInfo");
            this.f418189d = (s) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.RichmediaKt.SubFileType }");
            this.f418190e = ((Integer) obj).intValue();
        }
    }
}
