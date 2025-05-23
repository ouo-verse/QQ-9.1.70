package kuikly.com.tencent.trpcprotocol.search.unifysearch;

import c45.b;
import c45.c;
import c45.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g implements c45.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f413198h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final int f413199d;

    /* renamed from: e, reason: collision with root package name */
    public final List<String> f413200e;

    /* renamed from: f, reason: collision with root package name */
    public final f f413201f;

    public g() {
        this(0, null, 0 == true ? 1 : 0, 15);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413198h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, Integer.valueOf(this.f413199d)) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413200e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        return iVar.a(3, a26, this.f413201f) + a19;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413198h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, Integer.valueOf(this.f413199d));
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413200e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413201f);
    }

    public g(int i3, List list, f fVar) {
        this.f413199d = i3;
        this.f413200e = list;
        this.f413201f = fVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g(int i3, List list, f fVar, int i16) {
        this(i3, list, fVar);
        i3 = (i16 & 1) != 0 ? d.c.f30317b.b().getValue() : i3;
        list = (i16 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        fVar = (i16 & 4) != 0 ? null : fVar;
        if ((i16 & 8) != 0) {
            MapsKt__MapsKt.emptyMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<g> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final g b(c45.f fVar) {
            c45.c cVar;
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.GroupConditonFilter$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v7 */
                /* JADX WARN: Type inference failed for: r0v8 */
                /* JADX WARN: Type inference failed for: r4v4, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.f] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.IntRef intRef2 = Ref.IntRef.this;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.search.unifysearch.UnifysearchKt.GROUPRANKTYPE }");
                        intRef2.element = ((Integer) obj).intValue();
                    } else if (intValue == 2) {
                        Ref.ObjectRef<c.a<String>> objectRef3 = objectRef;
                        c.a<String> aVar = objectRef3.element;
                        ?? r06 = aVar;
                        if (aVar == null) {
                            r06 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                        objectRef3.element = r06;
                    } else if (intValue == 3) {
                        Ref.ObjectRef<f> objectRef4 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.GeoInfo");
                        objectRef4.element = (f) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            int i3 = intRef.element;
            c.a aVar = (c.a) objectRef.element;
            if (aVar != null) {
                ArrayList<T> arrayList = aVar.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            return new g(i3, cVar, (f) objectRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.a(false);
            }
            if (i3 == 2) {
                return new b.f(new b.e.g(false), false);
            }
            if (i3 != 3) {
                return null;
            }
            return new b.c(f.f413193i);
        }
    }
}
