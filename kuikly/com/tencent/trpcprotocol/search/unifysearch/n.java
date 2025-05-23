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
public final class n implements c45.d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f413228f = new a();

    /* renamed from: d, reason: collision with root package name */
    public final List<l> f413229d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413230e;

    public n() {
        this(null, null, null, 7, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413228f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413229d) + 0;
        c45.b a18 = aVar.a(100);
        Intrinsics.checkNotNull(a18);
        return iVar.a(100, a18, this.f413230e) + a17;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413228f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413229d);
        c45.b a17 = aVar.a(100);
        Intrinsics.checkNotNull(a17);
        eVar.b(100, a17, this.f413230e);
    }

    public n(List list, String str) {
        this.f413229d = list;
        this.f413230e = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ n(List list, String str, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, "");
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<n> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final n b(c45.f fVar) {
            c45.c cVar;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.NetSugWordsRsp$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v5 */
                /* JADX WARN: Type inference failed for: r0v6 */
                /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<c.a<l>> objectRef3 = objectRef;
                        c.a<l> aVar = objectRef3.element;
                        ?? r06 = aVar;
                        if (aVar == null) {
                            r06 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.search.unifysearch.NetSugInfo>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                        objectRef3.element = r06;
                    } else if (intValue == 100) {
                        Ref.ObjectRef<String> objectRef4 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef4.element = (String) obj;
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
            return new n(cVar, (String) objectRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.f(new b.c(l.f413219h), false);
            }
            if (i3 != 100) {
                return null;
            }
            return new b.e.g(false);
        }
    }
}
