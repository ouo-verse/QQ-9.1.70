package i35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f407163d;

    /* renamed from: e, reason: collision with root package name */
    public String f407164e;

    /* renamed from: f, reason: collision with root package name */
    public String f407165f;

    /* renamed from: h, reason: collision with root package name */
    public String f407166h;

    /* renamed from: i, reason: collision with root package name */
    public final List<String> f407167i;

    public c() {
        this(0, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(0, null, null, null, null, 31, null));
    }

    public /* synthetic */ c(int i3, String str, String str2, String str3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", "", new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f407163d), new b.e.h(false))), TuplesKt.to(2, new h(2, this.f407164e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f407165f, new b.e.g(false))), TuplesKt.to(4, new h(4, this.f407166h, new b.e.g(false))), TuplesKt.to(5, new h(5, this.f407167i, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    public c(int i3, String str, String str2, String str3, List<String> list) {
        this.f407163d = i3;
        this.f407164e = str;
        this.f407165f = str2;
        this.f407166h = str3;
        this.f407167i = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f407163d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f407164e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f407165f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f407166h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            List<String> list = this.f407167i;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
