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
public final class l implements c45.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f413219h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413220d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413221e;

    /* renamed from: f, reason: collision with root package name */
    public final String f413222f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l() {
        this(r0, r0, r0, 15);
        String str = null;
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413219h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413220d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413221e) + a17;
        c45.b a26 = aVar.a(100);
        Intrinsics.checkNotNull(a26);
        return iVar.a(100, a26, this.f413222f) + a19;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413219h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413220d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413221e);
        c45.b a18 = aVar.a(100);
        Intrinsics.checkNotNull(a18);
        eVar.b(100, a18, this.f413222f);
    }

    public l(String str, String str2, String str3) {
        this.f413220d = str;
        this.f413221e = str2;
        this.f413222f = str3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ l(String str, String str2, String str3, int i3) {
        this(str, str2, str3);
        str = (i3 & 1) != 0 ? "" : str;
        str2 = (i3 & 2) != 0 ? "" : str2;
        str3 = (i3 & 4) != 0 ? "" : str3;
        if ((i3 & 8) != 0) {
            MapsKt__MapsKt.emptyMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<l> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final l b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = "";
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.NetSugInfo$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef4 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef4.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<String> objectRef5 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef5.element = (String) obj;
                    } else if (intValue == 100) {
                        Ref.ObjectRef<String> objectRef6 = objectRef3;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef6.element = (String) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new l((String) objectRef.element, (String) objectRef2.element, (String) objectRef3.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(false);
            }
            if (i3 == 2) {
                return new b.e.g(false);
            }
            if (i3 != 100) {
                return null;
            }
            return new b.e.g(false);
        }
    }
}
