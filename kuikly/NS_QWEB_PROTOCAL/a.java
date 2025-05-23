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
public final class a implements c45.d {
    public static final C10681a E = new C10681a();
    public final c45.a C;
    public final List<kuikly.NS_COMM.a> D;

    /* renamed from: d, reason: collision with root package name */
    public final String f413138d;

    /* renamed from: e, reason: collision with root package name */
    public final c45.a f413139e;

    /* renamed from: f, reason: collision with root package name */
    public final String f413140f;

    /* renamed from: h, reason: collision with root package name */
    public final Integer f413141h;

    /* renamed from: i, reason: collision with root package name */
    public final String f413142i;

    /* renamed from: m, reason: collision with root package name */
    public final String f413143m;

    public a() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        C10681a c10681a = E;
        c45.b a16 = c10681a.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413138d) + 0;
        c45.b a18 = c10681a.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413139e) + a17;
        c45.b a26 = c10681a.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, this.f413140f) + a19;
        c45.b a28 = c10681a.a(4);
        Intrinsics.checkNotNull(a28);
        int a29 = iVar.a(4, a28, this.f413141h) + a27;
        c45.b a36 = c10681a.a(5);
        Intrinsics.checkNotNull(a36);
        int a37 = iVar.a(5, a36, this.f413142i) + a29;
        c45.b a38 = c10681a.a(6);
        Intrinsics.checkNotNull(a38);
        int a39 = iVar.a(6, a38, this.f413143m) + a37;
        c45.b a46 = c10681a.a(7);
        Intrinsics.checkNotNull(a46);
        int a47 = iVar.a(7, a46, this.C) + a39;
        c45.b a48 = c10681a.a(8);
        Intrinsics.checkNotNull(a48);
        return iVar.a(8, a48, this.D) + a47;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        C10681a c10681a = E;
        c45.b a16 = c10681a.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413138d);
        c45.b a17 = c10681a.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413139e);
        c45.b a18 = c10681a.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413140f);
        c45.b a19 = c10681a.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, this.f413141h);
        c45.b a26 = c10681a.a(5);
        Intrinsics.checkNotNull(a26);
        eVar.b(5, a26, this.f413142i);
        c45.b a27 = c10681a.a(6);
        Intrinsics.checkNotNull(a27);
        eVar.b(6, a27, this.f413143m);
        c45.b a28 = c10681a.a(7);
        Intrinsics.checkNotNull(a28);
        eVar.b(7, a28, this.C);
        c45.b a29 = c10681a.a(8);
        Intrinsics.checkNotNull(a29);
        eVar.b(8, a29, this.D);
    }

    public a(String str, c45.a aVar, String str2, Integer num, String str3, String str4, c45.a aVar2, List list) {
        this.f413138d = str;
        this.f413139e = aVar;
        this.f413140f = str2;
        this.f413141h = num;
        this.f413142i = str3;
        this.f413143m = str4;
        this.C = aVar2;
        this.D = list;
    }

    /* compiled from: P */
    /* renamed from: kuikly.NS_QWEB_PROTOCAL.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10681a implements d.a<a> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final a b(f fVar) {
            c45.c cVar;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.NS_QWEB_PROTOCAL.StAuthInfo$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v4, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v6 */
                /* JADX WARN: Type inference failed for: r0v7 */
                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v2, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Integer] */
                /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v7, types: [T, c45.a] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    switch (num.intValue()) {
                        case 1:
                            Ref.ObjectRef<String> objectRef9 = objectRef;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef9.element = (String) obj;
                            break;
                        case 2:
                            Ref.ObjectRef<c45.a> objectRef10 = objectRef2;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                            objectRef10.element = (c45.a) obj;
                            break;
                        case 3:
                            Ref.ObjectRef<String> objectRef11 = objectRef3;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef11.element = (String) obj;
                            break;
                        case 4:
                            Ref.ObjectRef<Integer> objectRef12 = objectRef4;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            objectRef12.element = (Integer) obj;
                            break;
                        case 5:
                            Ref.ObjectRef<String> objectRef13 = objectRef5;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef13.element = (String) obj;
                            break;
                        case 6:
                            Ref.ObjectRef<String> objectRef14 = objectRef6;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef14.element = (String) obj;
                            break;
                        case 7:
                            Ref.ObjectRef<c45.a> objectRef15 = objectRef7;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                            objectRef15.element = (c45.a) obj;
                            break;
                        case 8:
                            Ref.ObjectRef<c.a<kuikly.NS_COMM.a>> objectRef16 = objectRef8;
                            c.a<kuikly.NS_COMM.a> aVar = objectRef16.element;
                            ?? r06 = aVar;
                            if (aVar == null) {
                                r06 = new c.a();
                            }
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.NS_COMM.Entry>");
                            CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                            objectRef16.element = r06;
                            break;
                    }
                    return Unit.INSTANCE;
                }
            });
            String str = (String) objectRef.element;
            c45.a aVar = (c45.a) objectRef2.element;
            String str2 = (String) objectRef3.element;
            Integer num = (Integer) objectRef4.element;
            String str3 = (String) objectRef5.element;
            String str4 = (String) objectRef6.element;
            c45.a aVar2 = (c45.a) objectRef7.element;
            c.a aVar3 = (c.a) objectRef8.element;
            if (aVar3 != null) {
                ArrayList<T> arrayList = aVar3.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            return new a(str, aVar, str2, num, str3, str4, aVar2, cVar);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            switch (i3) {
                case 1:
                    return new b.e.g(true);
                case 2:
                    return new b.e.C0167b(true);
                case 3:
                    return new b.e.g(true);
                case 4:
                    return new b.e.h(true);
                case 5:
                    return new b.e.g(true);
                case 6:
                    return new b.e.g(true);
                case 7:
                    return new b.e.C0167b(true);
                case 8:
                    return new b.f(new b.c(kuikly.NS_COMM.a.f413135f), false);
                default:
                    return null;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(String str, c45.a aVar, String str2, Integer num, String str3, String str4, c45.a aVar2, List list, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, null, null, r9);
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MapsKt__MapsKt.emptyMap();
    }
}
