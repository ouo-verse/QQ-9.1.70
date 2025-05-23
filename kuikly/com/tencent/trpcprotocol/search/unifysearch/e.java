package kuikly.com.tencent.trpcprotocol.search.unifysearch;

import c45.b;
import c45.d;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e implements c45.d {

    /* renamed from: i, reason: collision with root package name */
    public static final a f413188i = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413189d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413190e;

    /* renamed from: f, reason: collision with root package name */
    public final q f413191f;

    /* renamed from: h, reason: collision with root package name */
    public final String f413192h;

    public e() {
        this(null, null, null, null, 31);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413188i;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413189d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413190e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, this.f413191f) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        return iVar.a(4, a28, this.f413192h) + a27;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413188i;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413189d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413190e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413191f);
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, this.f413192h);
    }

    public e(String str, String str2, q qVar, String str3) {
        this.f413189d = str;
        this.f413190e = str2;
        this.f413191f = qVar;
        this.f413192h = str3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ e(String str, String str2, q qVar, String str3, int i3) {
        this(str, str2, qVar, str3);
        str = (i3 & 1) != 0 ? "" : str;
        str2 = (i3 & 2) != 0 ? "" : str2;
        qVar = (i3 & 4) != 0 ? null : qVar;
        str3 = (i3 & 8) != 0 ? "" : str3;
        if ((i3 & 16) != 0) {
            MapsKt__MapsKt.emptyMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<e> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final e b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = "";
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.EmptyPageExtraInfo$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v3, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.q] */
                /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef5 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef5.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<String> objectRef6 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef6.element = (String) obj;
                    } else if (intValue == 3) {
                        Ref.ObjectRef<q> objectRef7 = objectRef3;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.RichText");
                        objectRef7.element = (q) obj;
                    } else if (intValue == 4) {
                        Ref.ObjectRef<String> objectRef8 = objectRef4;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef8.element = (String) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new e((String) objectRef.element, (String) objectRef2.element, (q) objectRef3.element, (String) objectRef4.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(false);
            }
            if (i3 == 2) {
                return new b.e.g(false);
            }
            if (i3 == 3) {
                return new b.c(q.f413241e);
            }
            if (i3 != 4) {
                return null;
            }
            return new b.e.g(false);
        }
    }
}
