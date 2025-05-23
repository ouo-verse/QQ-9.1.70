package j35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n35.w;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f409203d;

    /* renamed from: e, reason: collision with root package name */
    public w f409204e;

    public a() {
        this(0, 3);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new a(0, 3));
    }

    public /* synthetic */ a(int i3, int i16) {
        this((i16 & 1) != 0 ? 0 : i3, (w) null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f409203d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f409204e, new b.d(new w(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))));
        return mapOf;
    }

    public a(int i3, w wVar) {
        this.f409203d = i3;
        this.f409204e = wVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f409203d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo");
            this.f409204e = (w) obj;
        }
    }
}
