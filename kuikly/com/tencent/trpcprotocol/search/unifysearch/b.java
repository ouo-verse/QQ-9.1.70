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
public final class b implements c45.d {

    /* renamed from: i, reason: collision with root package name */
    public static final a f413175i = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413176d;

    /* renamed from: e, reason: collision with root package name */
    public final List<String> f413177e;

    /* renamed from: f, reason: collision with root package name */
    public final List<d> f413178f;

    /* renamed from: h, reason: collision with root package name */
    public final int f413179h;

    public b() {
        this(null, null, null, 0, null, 31, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413175i;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413176d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413177e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, this.f413178f) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        return iVar.a(4, a28, Integer.valueOf(this.f413179h)) + a27;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413175i;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413176d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413177e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413178f);
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, Integer.valueOf(this.f413179h));
    }

    public b(String str, List list, List list2, int i3) {
        this.f413176d = str;
        this.f413177e = list;
        this.f413178f = list2;
        this.f413179h = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ b(String str, List list, List list2, int i3, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", r1, r2, 0);
        List emptyList;
        List emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<b> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final b b(c45.f fVar) {
            c45.c cVar;
            c45.c cVar2;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            final Ref.IntRef intRef = new Ref.IntRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.City$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v10, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v12 */
                /* JADX WARN: Type inference failed for: r0v13 */
                /* JADX WARN: Type inference failed for: r0v14 */
                /* JADX WARN: Type inference failed for: r0v15 */
                /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef4 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef4.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<c.a<String>> objectRef5 = objectRef2;
                        c.a<String> aVar = objectRef5.element;
                        ?? r06 = aVar;
                        if (aVar == null) {
                            r06 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                        objectRef5.element = r06;
                    } else if (intValue == 3) {
                        Ref.ObjectRef<c.a<d>> objectRef6 = objectRef3;
                        c.a<d> aVar2 = objectRef6.element;
                        ?? r07 = aVar2;
                        if (aVar2 == null) {
                            r07 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.search.unifysearch.District>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r07, (Sequence) obj);
                        objectRef6.element = r07;
                    } else if (intValue == 4) {
                        Ref.IntRef intRef2 = intRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        intRef2.element = ((Integer) obj).intValue();
                    }
                    return Unit.INSTANCE;
                }
            });
            String str = (String) objectRef.element;
            c.a aVar = (c.a) objectRef2.element;
            if (aVar != null) {
                ArrayList<T> arrayList = aVar.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            c.a aVar2 = (c.a) objectRef3.element;
            if (aVar2 != null) {
                ArrayList<T> arrayList2 = aVar2.f30316d;
                arrayList2.trimToSize();
                cVar2 = new c45.c(arrayList2, null);
            } else {
                cVar2 = c45.c.f30313h;
            }
            return new b(str, cVar, cVar2, intRef.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(false);
            }
            if (i3 == 2) {
                return new b.f(new b.e.g(false), false);
            }
            if (i3 == 3) {
                return new b.f(new b.c(d.f413185f), false);
            }
            if (i3 != 4) {
                return null;
            }
            return new b.e.h(false);
        }
    }
}
