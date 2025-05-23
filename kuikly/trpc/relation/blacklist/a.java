package kuikly.trpc.relation.blacklist;

import c45.b;
import c45.d;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a implements c45.d {
    public static final C10686a C = new C10686a();

    /* renamed from: d, reason: collision with root package name */
    public final int f413265d;

    /* renamed from: e, reason: collision with root package name */
    public final c45.a f413266e;

    /* renamed from: f, reason: collision with root package name */
    public final long f413267f;

    /* renamed from: h, reason: collision with root package name */
    public final String f413268h;

    /* renamed from: i, reason: collision with root package name */
    public final String f413269i;

    /* renamed from: m, reason: collision with root package name */
    public final g f413270m;

    public a() {
        this(0, null, 127);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        C10686a c10686a = C;
        c45.b a16 = c10686a.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, Integer.valueOf(this.f413265d)) + 0;
        c45.b a18 = c10686a.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413266e) + a17;
        c45.b a26 = c10686a.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, Long.valueOf(this.f413267f)) + a19;
        c45.b a28 = c10686a.a(4);
        Intrinsics.checkNotNull(a28);
        int a29 = iVar.a(4, a28, this.f413268h) + a27;
        c45.b a36 = c10686a.a(5);
        Intrinsics.checkNotNull(a36);
        int a37 = iVar.a(5, a36, this.f413269i) + a29;
        c45.b a38 = c10686a.a(6);
        Intrinsics.checkNotNull(a38);
        return iVar.a(6, a38, this.f413270m) + a37;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        C10686a c10686a = C;
        c45.b a16 = c10686a.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, Integer.valueOf(this.f413265d));
        c45.b a17 = c10686a.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413266e);
        c45.b a18 = c10686a.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, Long.valueOf(this.f413267f));
        c45.b a19 = c10686a.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, this.f413268h);
        c45.b a26 = c10686a.a(5);
        Intrinsics.checkNotNull(a26);
        eVar.b(5, a26, this.f413269i);
        c45.b a27 = c10686a.a(6);
        Intrinsics.checkNotNull(a27);
        eVar.b(6, a27, this.f413270m);
    }

    public a(int i3, c45.a aVar, long j3, String str, String str2, g gVar) {
        this.f413265d = i3;
        this.f413266e = aVar;
        this.f413267f = j3;
        this.f413268h = str;
        this.f413269i = str2;
        this.f413270m = gVar;
    }

    /* compiled from: P */
    /* renamed from: kuikly.trpc.relation.blacklist.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10686a implements d.a<a> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [T, c45.a] */
        @Override // c45.d.a
        public final a b(c45.f fVar) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = c45.a.f30290b;
            final Ref.LongRef longRef = new Ref.LongRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = "";
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.trpc.relation.blacklist.Account$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v3, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v7, types: [T, kuikly.trpc.relation.blacklist.g] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    switch (num.intValue()) {
                        case 1:
                            Ref.IntRef intRef2 = Ref.IntRef.this;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.trpc.relation.blacklist.BlacklistKt.AccountType }");
                            intRef2.element = ((Integer) obj).intValue();
                            break;
                        case 2:
                            Ref.ObjectRef<c45.a> objectRef5 = objectRef;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                            objectRef5.element = (c45.a) obj;
                            break;
                        case 3:
                            Ref.LongRef longRef2 = longRef;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                            longRef2.element = ((Long) obj).longValue();
                            break;
                        case 4:
                            Ref.ObjectRef<String> objectRef6 = objectRef2;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef6.element = (String) obj;
                            break;
                        case 5:
                            Ref.ObjectRef<String> objectRef7 = objectRef3;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef7.element = (String) obj;
                            break;
                        case 6:
                            Ref.ObjectRef<g> objectRef8 = objectRef4;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.trpc.relation.blacklist.TinyidInfo");
                            objectRef8.element = (g) obj;
                            break;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new a(intRef.element, (c45.a) objectRef.element, longRef.element, (String) objectRef2.element, (String) objectRef3.element, (g) objectRef4.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            switch (i3) {
                case 1:
                    return new b.a(false);
                case 2:
                    return new b.e.C0167b(false);
                case 3:
                    return new b.e.i(false);
                case 4:
                    return new b.e.g(false);
                case 5:
                    return new b.e.g(false);
                case 6:
                    return new b.c(g.f413291f);
                default:
                    return null;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(int i3, g gVar, int i16) {
        this(r1, r2, 0L, r9, r6, r7);
        int value = (i16 & 1) != 0 ? d.c.f30317b.b().getValue() : i3;
        c45.a aVar = (i16 & 2) != 0 ? c45.a.f30290b : null;
        String str = (i16 & 8) != 0 ? "" : null;
        String str2 = (i16 & 16) != 0 ? "" : null;
        g gVar2 = (i16 & 32) != 0 ? null : gVar;
        if ((i16 & 64) != 0) {
            MapsKt__MapsKt.emptyMap();
        }
    }
}
