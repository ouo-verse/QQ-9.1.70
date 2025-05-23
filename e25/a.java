package e25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f395422d;

    /* renamed from: e, reason: collision with root package name */
    public String f395423e;

    /* renamed from: f, reason: collision with root package name */
    public String f395424f;

    /* renamed from: h, reason: collision with root package name */
    public b f395425h;

    public a() {
        this(0, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new a(0, null, null, null, 15, null));
    }

    public /* synthetic */ a(int i3, String str, String str2, b bVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f395422d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f395423e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f395424f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f395425h, new b.d(new b(null, null, null, 7, null)))));
        return mapOf;
    }

    public a(int i3, String str, String str2, b bVar) {
        this.f395422d = i3;
        this.f395423e = str;
        this.f395424f = str2;
        this.f395425h = bVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f395422d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395423e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f395424f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.intimate_space.social_tree.Button");
            this.f395425h = (b) obj;
        }
    }
}
