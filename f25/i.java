package f25;

import c45.b;
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
public final class i extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f397753d;

    /* renamed from: e, reason: collision with root package name */
    public final List<j> f397754e;

    public i() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new i(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ i(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList());
    }

    public i(String str, List<j> list) {
        this.f397753d = str;
        this.f397754e = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f397753d, new b.e.g(true))), TuplesKt.to(2, new c45.h(2, this.f397754e, new b.f(new b.d(new j(null, null, null, null, 15, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f397753d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            List<j> list = this.f397754e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.groupProRobot.common.config.TTSInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
