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
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c implements c45.d {
    public static final a G = new a();
    public final String C;
    public final kuikly.NS_QWEB_PROTOCAL.a D;
    public final b E;
    public final List<kuikly.NS_COMM.a> F;

    /* renamed from: d, reason: collision with root package name */
    public final Long f413147d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413148e;

    /* renamed from: f, reason: collision with root package name */
    public final String f413149f;

    /* renamed from: h, reason: collision with root package name */
    public final c45.a f413150h;

    /* renamed from: i, reason: collision with root package name */
    public final String f413151i;

    /* renamed from: m, reason: collision with root package name */
    public final String f413152m;

    public c(Long l3, String str, String str2, c45.a aVar, String str3, String str4, String str5, kuikly.NS_QWEB_PROTOCAL.a aVar2, b bVar, List list) {
        this.f413147d = l3;
        this.f413148e = str;
        this.f413149f = str2;
        this.f413150h = aVar;
        this.f413151i = str3;
        this.f413152m = str4;
        this.C = str5;
        this.D = aVar2;
        this.E = bVar;
        this.F = list;
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        a aVar = G;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413147d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413148e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, this.f413149f) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        int a29 = iVar.a(4, a28, this.f413150h) + a27;
        c45.b a36 = aVar.a(5);
        Intrinsics.checkNotNull(a36);
        int a37 = iVar.a(5, a36, this.f413151i) + a29;
        c45.b a38 = aVar.a(6);
        Intrinsics.checkNotNull(a38);
        int a39 = iVar.a(6, a38, this.f413152m) + a37;
        c45.b a46 = aVar.a(7);
        Intrinsics.checkNotNull(a46);
        int a47 = iVar.a(7, a46, this.C) + a39;
        c45.b a48 = aVar.a(8);
        Intrinsics.checkNotNull(a48);
        int a49 = iVar.a(8, a48, this.D) + a47;
        c45.b a56 = aVar.a(9);
        Intrinsics.checkNotNull(a56);
        int a57 = iVar.a(9, a56, this.E) + a49;
        c45.b a58 = aVar.a(10);
        Intrinsics.checkNotNull(a58);
        return iVar.a(10, a58, this.F) + a57;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = G;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413147d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413148e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413149f);
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, this.f413150h);
        c45.b a26 = aVar.a(5);
        Intrinsics.checkNotNull(a26);
        eVar.b(5, a26, this.f413151i);
        c45.b a27 = aVar.a(6);
        Intrinsics.checkNotNull(a27);
        eVar.b(6, a27, this.f413152m);
        c45.b a28 = aVar.a(7);
        Intrinsics.checkNotNull(a28);
        eVar.b(7, a28, this.C);
        c45.b a29 = aVar.a(8);
        Intrinsics.checkNotNull(a29);
        eVar.b(8, a29, this.D);
        c45.b a36 = aVar.a(9);
        Intrinsics.checkNotNull(a36);
        eVar.b(9, a36, this.E);
        c45.b a37 = aVar.a(10);
        Intrinsics.checkNotNull(a37);
        eVar.b(10, a37, this.F);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<c> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final c b(f fVar) {
            c45.c cVar;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.NS_QWEB_PROTOCAL.StQWebReq$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v10 */
                /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v9 */
                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Long] */
                /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v4, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v8, types: [T, kuikly.NS_QWEB_PROTOCAL.a] */
                /* JADX WARN: Type inference failed for: r4v9, types: [T, kuikly.NS_QWEB_PROTOCAL.b] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    switch (num.intValue()) {
                        case 1:
                            Ref.ObjectRef<Long> objectRef11 = objectRef;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                            objectRef11.element = (Long) obj;
                            break;
                        case 2:
                            Ref.ObjectRef<String> objectRef12 = objectRef2;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef12.element = (String) obj;
                            break;
                        case 3:
                            Ref.ObjectRef<String> objectRef13 = objectRef3;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef13.element = (String) obj;
                            break;
                        case 4:
                            Ref.ObjectRef<c45.a> objectRef14 = objectRef4;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                            objectRef14.element = (c45.a) obj;
                            break;
                        case 5:
                            Ref.ObjectRef<String> objectRef15 = objectRef5;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef15.element = (String) obj;
                            break;
                        case 6:
                            Ref.ObjectRef<String> objectRef16 = objectRef6;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef16.element = (String) obj;
                            break;
                        case 7:
                            Ref.ObjectRef<String> objectRef17 = objectRef7;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef17.element = (String) obj;
                            break;
                        case 8:
                            Ref.ObjectRef<a> objectRef18 = objectRef8;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.NS_QWEB_PROTOCAL.StAuthInfo");
                            objectRef18.element = (a) obj;
                            break;
                        case 9:
                            Ref.ObjectRef<b> objectRef19 = objectRef9;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.NS_QWEB_PROTOCAL.StEncryption");
                            objectRef19.element = (b) obj;
                            break;
                        case 10:
                            Ref.ObjectRef<c.a<kuikly.NS_COMM.a>> objectRef20 = objectRef10;
                            c.a<kuikly.NS_COMM.a> aVar = objectRef20.element;
                            ?? r06 = aVar;
                            if (aVar == null) {
                                r06 = new c.a();
                            }
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.NS_COMM.Entry>");
                            CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                            objectRef20.element = r06;
                            break;
                    }
                    return Unit.INSTANCE;
                }
            });
            Long l3 = (Long) objectRef.element;
            String str = (String) objectRef2.element;
            String str2 = (String) objectRef3.element;
            c45.a aVar = (c45.a) objectRef4.element;
            String str3 = (String) objectRef5.element;
            String str4 = (String) objectRef6.element;
            String str5 = (String) objectRef7.element;
            kuikly.NS_QWEB_PROTOCAL.a aVar2 = (kuikly.NS_QWEB_PROTOCAL.a) objectRef8.element;
            b bVar = (b) objectRef9.element;
            c.a aVar3 = (c.a) objectRef10.element;
            if (aVar3 != null) {
                ArrayList<T> arrayList = aVar3.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            return new c(l3, str, str2, aVar, str3, str4, str5, aVar2, bVar, cVar);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            switch (i3) {
                case 1:
                    return new b.e.i(true);
                case 2:
                    return new b.e.g(true);
                case 3:
                    return new b.e.g(true);
                case 4:
                    return new b.e.C0167b(true);
                case 5:
                    return new b.e.g(true);
                case 6:
                    return new b.e.g(true);
                case 7:
                    return new b.e.g(true);
                case 8:
                    return new b.c(kuikly.NS_QWEB_PROTOCAL.a.E);
                case 9:
                    return new b.c(b.f413144f);
                case 10:
                    return new b.f(new b.c(kuikly.NS_COMM.a.f413135f), false);
                default:
                    return null;
            }
        }
    }
}
