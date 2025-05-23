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
public final class k implements c45.d {

    /* renamed from: m, reason: collision with root package name */
    public static final a f413213m = new a();

    /* renamed from: d, reason: collision with root package name */
    public final int f413214d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413215e;

    /* renamed from: f, reason: collision with root package name */
    public final List<u> f413216f;

    /* renamed from: h, reason: collision with root package name */
    public final i f413217h;

    /* renamed from: i, reason: collision with root package name */
    public final int f413218i;

    public k() {
        this(0, null, null, null, 0, null, 63, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413213m;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, Integer.valueOf(this.f413214d)) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413215e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, this.f413216f) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        int a29 = iVar.a(4, a28, this.f413217h) + a27;
        c45.b a36 = aVar.a(5);
        Intrinsics.checkNotNull(a36);
        return iVar.a(5, a36, Integer.valueOf(this.f413218i)) + a29;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413213m;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, Integer.valueOf(this.f413214d));
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413215e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413216f);
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, this.f413217h);
        c45.b a26 = aVar.a(5);
        Intrinsics.checkNotNull(a26);
        eVar.b(5, a26, Integer.valueOf(this.f413218i));
    }

    public k(int i3, String str, List list, i iVar, int i16) {
        this.f413214d = i3;
        this.f413215e = str;
        this.f413216f = list;
        this.f413217h = iVar;
        this.f413218i = i16;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ k(int i3, String str, List list, i iVar, int i16, Map map, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", r4, null, 0);
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<k> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final k b(c45.f fVar) {
            c45.c cVar;
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            final Ref.IntRef intRef2 = new Ref.IntRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.NetResultTabsRsp$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v6, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v8 */
                /* JADX WARN: Type inference failed for: r0v9 */
                /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v5, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.i] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.IntRef intRef3 = Ref.IntRef.this;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        intRef3.element = ((Integer) obj).intValue();
                    } else if (intValue == 2) {
                        Ref.ObjectRef<String> objectRef4 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef4.element = (String) obj;
                    } else if (intValue == 3) {
                        Ref.ObjectRef<c.a<u>> objectRef5 = objectRef2;
                        c.a<u> aVar = objectRef5.element;
                        ?? r06 = aVar;
                        if (aVar == null) {
                            r06 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.search.unifysearch.TabInfo>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                        objectRef5.element = r06;
                    } else if (intValue == 4) {
                        Ref.ObjectRef<i> objectRef6 = objectRef3;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.GroupSearchFilterCondition");
                        objectRef6.element = (i) obj;
                    } else if (intValue == 5) {
                        Ref.IntRef intRef4 = intRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        intRef4.element = ((Integer) obj).intValue();
                    }
                    return Unit.INSTANCE;
                }
            });
            int i3 = intRef.element;
            String str = (String) objectRef.element;
            c.a aVar = (c.a) objectRef2.element;
            if (aVar != null) {
                ArrayList<T> arrayList = aVar.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            return new k(i3, str, cVar, (i) objectRef3.element, intRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.h(false);
            }
            if (i3 == 2) {
                return new b.e.g(false);
            }
            if (i3 == 3) {
                return new b.f(new b.c(u.f413259f), false);
            }
            if (i3 == 4) {
                return new b.c(i.f413205h);
            }
            if (i3 != 5) {
                return null;
            }
            return new b.e.h(false);
        }
    }
}
