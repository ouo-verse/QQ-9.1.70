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
public final class i implements c45.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f413205h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final List<String> f413206d;

    /* renamed from: e, reason: collision with root package name */
    public final List<o> f413207e;

    /* renamed from: f, reason: collision with root package name */
    public final List<h> f413208f;

    public i() {
        this(null, null, null, null, 15, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413205h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413206d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413207e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        return iVar.a(3, a26, this.f413208f) + a19;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413205h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413206d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413207e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413208f);
    }

    public i(List list, List list2, List list3) {
        this.f413206d = list;
        this.f413207e = list2;
        this.f413208f = list3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ i(List list, List list2, List list3, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3);
        List emptyList;
        List emptyList2;
        List emptyList3;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<i> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final i b(c45.f fVar) {
            c45.c cVar;
            c45.c cVar2;
            c45.c cVar3;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.GroupSearchFilterCondition$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v13, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v15 */
                /* JADX WARN: Type inference failed for: r0v16 */
                /* JADX WARN: Type inference failed for: r0v17 */
                /* JADX WARN: Type inference failed for: r0v18 */
                /* JADX WARN: Type inference failed for: r0v19 */
                /* JADX WARN: Type inference failed for: r0v20 */
                /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v8, types: [T, java.util.Collection] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<c.a<String>> objectRef4 = objectRef;
                        c.a<String> aVar = objectRef4.element;
                        ?? r06 = aVar;
                        if (aVar == null) {
                            r06 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                        objectRef4.element = r06;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<c.a<o>> objectRef5 = objectRef2;
                        c.a<o> aVar2 = objectRef5.element;
                        ?? r07 = aVar2;
                        if (aVar2 == null) {
                            r07 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.search.unifysearch.Province>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r07, (Sequence) obj);
                        objectRef5.element = r07;
                    } else if (intValue == 3) {
                        Ref.ObjectRef<c.a<h>> objectRef6 = objectRef3;
                        c.a<h> aVar3 = objectRef6.element;
                        ?? r08 = aVar3;
                        if (aVar3 == null) {
                            r08 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.search.unifysearch.GroupContentRankType>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r08, (Sequence) obj);
                        objectRef6.element = r08;
                    }
                    return Unit.INSTANCE;
                }
            });
            c.a aVar = (c.a) objectRef.element;
            if (aVar != null) {
                ArrayList<T> arrayList = aVar.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            c.a aVar2 = (c.a) objectRef2.element;
            if (aVar2 != null) {
                ArrayList<T> arrayList2 = aVar2.f30316d;
                arrayList2.trimToSize();
                cVar2 = new c45.c(arrayList2, null);
            } else {
                cVar2 = c45.c.f30313h;
            }
            c.a aVar3 = (c.a) objectRef3.element;
            if (aVar3 != null) {
                ArrayList<T> arrayList3 = aVar3.f30316d;
                arrayList3.trimToSize();
                cVar3 = new c45.c(arrayList3, null);
            } else {
                cVar3 = c45.c.f30313h;
            }
            return new i(cVar, cVar2, cVar3);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.f(new b.e.g(false), false);
            }
            if (i3 == 2) {
                return new b.f(new b.c(o.f413231h), false);
            }
            if (i3 != 3) {
                return null;
            }
            return new b.f(new b.c(h.f413202f), false);
        }
    }
}
