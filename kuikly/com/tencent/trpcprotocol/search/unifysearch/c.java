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
public final class c implements c45.d {

    /* renamed from: i, reason: collision with root package name */
    public static final a f413180i = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413181d;

    /* renamed from: e, reason: collision with root package name */
    public final int f413182e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f413183f;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f413184h;

    public c() {
        this(0, (boolean) (0 == true ? 1 : 0), (boolean) (0 == true ? 1 : 0), 31);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413180i;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413181d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, Integer.valueOf(this.f413182e)) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, Boolean.valueOf(this.f413183f)) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        return iVar.a(4, a28, Boolean.valueOf(this.f413184h)) + a27;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413180i;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413181d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, Integer.valueOf(this.f413182e));
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, Boolean.valueOf(this.f413183f));
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, Boolean.valueOf(this.f413184h));
    }

    public c(String str, int i3, boolean z16, boolean z17) {
        this.f413181d = str;
        this.f413182e = i3;
        this.f413183f = z16;
        this.f413184h = z17;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ c(int i3, boolean z16, boolean z17, int i16) {
        this(r0, i3, z16, z17);
        String str = (i16 & 1) != 0 ? "" : null;
        i3 = (i16 & 2) != 0 ? d.c.f30317b.b().getValue() : i3;
        z16 = (i16 & 4) != 0 ? false : z16;
        z17 = (i16 & 8) != 0 ? false : z17;
        if ((i16 & 16) != 0) {
            MapsKt__MapsKt.emptyMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<c> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final c b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.DeviceInfo$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef2.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.IntRef intRef2 = intRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.search.unifysearch.UnifysearchKt.PLATFORMTYPE }");
                        intRef2.element = ((Integer) obj).intValue();
                    } else if (intValue == 3) {
                        Ref.BooleanRef booleanRef3 = booleanRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                        booleanRef3.element = ((Boolean) obj).booleanValue();
                    } else if (intValue == 4) {
                        Ref.BooleanRef booleanRef4 = booleanRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                        booleanRef4.element = ((Boolean) obj).booleanValue();
                    }
                    return Unit.INSTANCE;
                }
            });
            return new c((String) objectRef.element, intRef.element, booleanRef.element, booleanRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(false);
            }
            if (i3 == 2) {
                return new b.a(false);
            }
            if (i3 == 3) {
                return new b.e.a(false);
            }
            if (i3 != 4) {
                return null;
            }
            return new b.e.a(false);
        }
    }
}
