package kuikly.com.tencent.trpcprotocol.search.unifysearch;

import c45.b;
import c45.c;
import c45.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t implements c45.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f413255h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final u f413256d;

    /* renamed from: e, reason: collision with root package name */
    public final List<s> f413257e;

    /* renamed from: f, reason: collision with root package name */
    public final e f413258f;

    public t() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413255h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413256d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413257e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        return iVar.a(3, a26, this.f413258f) + a19;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413255h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413256d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413257e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413258f);
    }

    public t(u uVar, List list, e eVar) {
        this.f413256d = uVar;
        this.f413257e = list;
        this.f413258f = eVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ t(u uVar, List list, e eVar, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, r1, null);
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<t> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final t b(c45.f fVar) {
            c45.c cVar;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.TabContentResult$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v7 */
                /* JADX WARN: Type inference failed for: r0v8 */
                /* JADX WARN: Type inference failed for: r4v1, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.u] */
                /* JADX WARN: Type inference failed for: r4v3, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.e] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<u> objectRef4 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.TabInfo");
                        objectRef4.element = (u) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<c.a<s>> objectRef5 = objectRef2;
                        c.a<s> aVar = objectRef5.element;
                        ?? r06 = aVar;
                        if (aVar == null) {
                            r06 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.search.unifysearch.TabContent>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                        objectRef5.element = r06;
                    } else if (intValue == 3) {
                        Ref.ObjectRef<e> objectRef6 = objectRef3;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.EmptyPageExtraInfo");
                        objectRef6.element = (e) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            u uVar = (u) objectRef.element;
            c.a aVar = (c.a) objectRef2.element;
            if (aVar != null) {
                ArrayList<T> arrayList = aVar.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            return new t(uVar, cVar, (e) objectRef3.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.c(u.f413259f);
            }
            if (i3 == 2) {
                return new b.f(new b.c(s.D), false);
            }
            if (i3 != 3) {
                return null;
            }
            return new b.c(e.f413188i);
        }
    }
}
