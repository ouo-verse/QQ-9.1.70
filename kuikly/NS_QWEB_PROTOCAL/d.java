package kuikly.NS_QWEB_PROTOCAL;

import c45.b;
import c45.c;
import c45.d;
import c45.f;
import c45.g;
import e45.e;
import e45.i;
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
public final class d implements c45.d {

    /* renamed from: m, reason: collision with root package name */
    public static final a f413153m = new a();

    /* renamed from: d, reason: collision with root package name */
    public final Long f413154d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f413155e;

    /* renamed from: f, reason: collision with root package name */
    public final c45.a f413156f;

    /* renamed from: h, reason: collision with root package name */
    public final c45.a f413157h;

    /* renamed from: i, reason: collision with root package name */
    public final List<kuikly.NS_COMM.a> f413158i;

    public d() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        a aVar = f413153m;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413154d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413155e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, this.f413156f) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        int a29 = iVar.a(4, a28, this.f413157h) + a27;
        c45.b a36 = aVar.a(5);
        Intrinsics.checkNotNull(a36);
        return iVar.a(5, a36, this.f413158i) + a29;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413153m;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413154d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413155e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413156f);
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, this.f413157h);
        c45.b a26 = aVar.a(5);
        Intrinsics.checkNotNull(a26);
        eVar.b(5, a26, this.f413158i);
    }

    public d(Long l3, Long l16, c45.a aVar, c45.a aVar2, List list) {
        this.f413154d = l3;
        this.f413155e = l16;
        this.f413156f = aVar;
        this.f413157h = aVar2;
        this.f413158i = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ d(Long l3, Long l16, c45.a aVar, c45.a aVar2, List list, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, r6);
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<d> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final d b(f fVar) {
            c45.c cVar;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.NS_QWEB_PROTOCAL.StQWebRsp$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v10 */
                /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v9 */
                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Long] */
                /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.Long] */
                /* JADX WARN: Type inference failed for: r4v3, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r4v4, types: [T, c45.a] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<Long> objectRef6 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                        objectRef6.element = (Long) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<Long> objectRef7 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                        objectRef7.element = (Long) obj;
                    } else if (intValue == 3) {
                        Ref.ObjectRef<c45.a> objectRef8 = objectRef3;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                        objectRef8.element = (c45.a) obj;
                    } else if (intValue == 4) {
                        Ref.ObjectRef<c45.a> objectRef9 = objectRef4;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                        objectRef9.element = (c45.a) obj;
                    } else if (intValue == 5) {
                        Ref.ObjectRef<c.a<kuikly.NS_COMM.a>> objectRef10 = objectRef5;
                        c.a<kuikly.NS_COMM.a> aVar = objectRef10.element;
                        ?? r06 = aVar;
                        if (aVar == null) {
                            r06 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.NS_COMM.Entry>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                        objectRef10.element = r06;
                    }
                    return Unit.INSTANCE;
                }
            });
            Long l3 = (Long) objectRef.element;
            Long l16 = (Long) objectRef2.element;
            c45.a aVar = (c45.a) objectRef3.element;
            c45.a aVar2 = (c45.a) objectRef4.element;
            c.a aVar3 = (c.a) objectRef5.element;
            if (aVar3 != null) {
                ArrayList<T> arrayList = aVar3.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            return new d(l3, l16, aVar, aVar2, cVar);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.i(true);
            }
            if (i3 == 2) {
                return new b.e.f(true);
            }
            if (i3 == 3) {
                return new b.e.C0167b(true);
            }
            if (i3 == 4) {
                return new b.e.C0167b(true);
            }
            if (i3 != 5) {
                return null;
            }
            return new b.f(new b.c(kuikly.NS_COMM.a.f413135f), false);
        }
    }
}
